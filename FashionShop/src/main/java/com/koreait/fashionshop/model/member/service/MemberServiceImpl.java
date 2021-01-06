package com.koreait.fashionshop.model.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.common.MailSender;
import com.koreait.fashionshop.common.SecureManager;
import com.koreait.fashionshop.exception.MailSendException;
import com.koreait.fashionshop.exception.MemberRegistException;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.member.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	//�̸��� �߼� ��ü
	@Autowired
	private MailSender mailSender;
	
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

	@Override
	public void regist(Member member) throws MemberRegistException, MailSendException{
		//DB�� �ֱ� + �̸��� ������ + ���ڹ߼�..
		
		//��й�ȣ ��ȣȭ
		String secureData = secureManager.getSecureData(member.getPassword());
		member.setPassword(secureData);//��ȯ���� �ٽ� VO����
		
		memberDAO.insert(member);
		String name= member.getName();
		String email = member.getEmail_id()+"@"+member.getEmail_server();
		mailSender.send(email,"�ȳ��ϼ��� "+name+"��","ȸ�������� ���ϵ帳�ϴ�.");
		
	}

	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Member member) {
		// TODO Auto-generated method stub
		
	}

}
