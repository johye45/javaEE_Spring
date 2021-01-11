package com.koreait.petshop2.model.member.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.petshop2.exception.MailSendException;
import com.koreait.petshop2.exception.MemberRegistException;
import com.koreait.petshop2.model.common.MailSender;
import com.koreait.petshop2.model.common.SecureManager;
import com.koreait.petshop2.model.domain.Member;
import com.koreait.petshop2.model.member.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;
	
	//�̸��� �߼� ��ü
	@Autowired
	private MailSender mailSender;
	
	//��ȣȭ ��ü 
	@Autowired
	private SecureManager secureManager;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member select() {
		// TODO Auto-generated method stub
		return null;
	}

	//ȸ����� �� ��Ÿ�ʿ���� ó��
	public void regist(Member member) throws MemberRegistException, MailSendException{
		//���̵� �ߺ��˻�
		
		
		
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

	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int duplicateCheck(String user_id) {
		int result = memberDAO.duplicateCheck(user_id);
		if(result == 0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	

}