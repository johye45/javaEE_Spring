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
	
	//이메일 발송 객체
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
		//DB에 넣기 + 이메일 보내기 + 문자발송..
		
		//비밀번호 암호화
		String secureData = secureManager.getSecureData(member.getPassword());
		member.setPassword(secureData);//변환시켜 다시 VO대입
		
		memberDAO.insert(member);
		String name= member.getName();
		String email = member.getEmail_id()+"@"+member.getEmail_server();
		mailSender.send(email,"안녕하세요 "+name+"님","회원가입을 축하드립니다.");
		
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
