package com.koreait.petshop.model.member.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.petshop.exception.MailSendException;
import com.koreait.petshop.exception.MemberDeleteException;
import com.koreait.petshop.exception.MemberEditException;
import com.koreait.petshop.exception.MemberNotFoundException;
import com.koreait.petshop.exception.MemberRegistException;
import com.koreait.petshop.model.common.MailSender;
import com.koreait.petshop.model.common.RandomNumber;
import com.koreait.petshop.model.common.SecureManager;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.member.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	private static final Logger logger=LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private MemberDAO memberDAO;
	
	//�̸��� �߼� ��ü
	@Autowired
	private MailSender mailSender;
	
	//���� ������ ��ü
	@Autowired
	private RandomNumber randomNumber;
	
	//��ȣȭ ��ü 
	@Autowired
	private SecureManager secureManager;
	
/****************************************************************************
 	Shop���� ����
 *****************************************************************************/
	//���̵� �ߺ��˻�
	public int duplicateCheck(String user_id) {
		int result = memberDAO.duplicateCheck(user_id);
		if(result == 0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	//ȸ����� �� ��Ÿ�ʿ���� ó��
	public void regist(Member member) throws MemberRegistException, MailSendException{
		//��й�ȣ ��ȣȭ ó�� 
		String secureData = secureManager.getSecureData(member.getPassword());
		member.setPassword(secureData); //��ȯ���� �ٽ� VO �� ����
		
		memberDAO.insert(member);
		
		String email =member.getEmail_id()+"@"+member.getEmail_server();
		String name=member.getName();
		String user_id= member.getUser_id();
		
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd��");
	
		mailSender.send(email, name+"��, [pet shop] �������ϵ����", 
				format.format(today)+"<br> ID : "+user_id+"�� �����ϼ̽��ϴ�. <br> �����մϴ�");
	}
	
	//ȸ�� �α���
	public Member select(Member member) throws MemberNotFoundException{
		//��� �ؽð����� ��ȯ�Ͽ� �޼���ȣ��
		String hash =secureManager.getSecureData(member.getPassword());
		member.setPassword(hash); //VO�� �ؽð� ����
		Member obj = memberDAO.select(member);
		return obj;
	}

	//ȸ�����̵�ã��
	public ArrayList<String> forgot_id(Member member) throws MemberNotFoundException{
		logger.info("forgot_id ���� ����");
		List<Member> list = memberDAO.forgot_id(member);
		ArrayList<String> forgot_id = new ArrayList<String>();  
		for(int i =0; i <list.size(); i ++) {
			String user_id = list.get(i).getUser_id();
			forgot_id.add(user_id);
		}
		return forgot_id;
	}
	
	// ȸ����й�ȣ ã���̸��� �߼�
	public void forgot_pwd(Member member) throws MemberNotFoundException{
		// ��й�ȣ�� 6�ڸ��� ������ �����ͺ��̽� ��й�ȣ�� �ٲ��ش�
		String key = randomNumber.getKey(false, 6);
		
		String user_id = member.getUser_id();
		String email =member.getEmail_id()+"@"+member.getEmail_server();
		String htmlStr = "<h2>�ȳ��ϼ��� '"+ user_id +"' ��</h2><br><br>" 
				+ "<p>�ӽ÷� �߱� �帰 ��й�ȣ�� <span style='color : blue; font-size:15px'>[" + key +"]</span>�̸�, �α��� �� �������������� ��й�ȣ�� �������ֽø� �˴ϴ�.</p><br>"
				+ "<h4><a href='http://localhost:8888/shop/member/loginForm'> �α��������� �ٷΰ���</a></h4><br><br>";
	
		 mailSender.send(email, user_id+"��, �ӽú�й�ȣ �߱��̸����Դϴ�", htmlStr);
		 logger.debug("key����?" +key);
		// ��й�ȣ ��ȣȭ���ִ� �޼���
		 String password = secureManager.getSecureData(key);
		logger.debug("��ȣȭ�Ȱ���?"+password);

		member.setPassword(password);
		// ������ ���̽� ���� ��ȣ�� ������ �����Ų��.
		memberDAO.forgot_pwd(member);
		}
	
	//ȸ�� ��������
	public void update(Member member) throws MemberEditException{
		String hash =secureManager.getSecureData(member.getPassword());
		member.setPassword(hash); //VO�� �ؽð� ����
		memberDAO.update(member);
	}
	

	//ȸ��Ż��
	public void delete(Member member) throws MemberDeleteException{
		String hash =secureManager.getSecureData(member.getPassword());
		member.setPassword(hash); //VO�� �ؽð� ����
		memberDAO.delete(member);
	}
	
/****************************************************************************
 	Admin ���� ����
 *****************************************************************************/
	//ȸ�� ��� 
	public List selectAll() {
		return memberDAO.selectAll();
	}

}