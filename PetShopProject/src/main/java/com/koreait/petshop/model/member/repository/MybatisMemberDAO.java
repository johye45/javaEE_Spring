package com.koreait.petshop.model.member.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.petshop.exception.MemberDeleteException;
import com.koreait.petshop.exception.MemberEditException;
import com.koreait.petshop.exception.MemberNotFoundException;
import com.koreait.petshop.exception.MemberPasswordFailException;
import com.koreait.petshop.exception.MemberRegistException;
import com.koreait.petshop.model.domain.Member;

@Repository
public class MybatisMemberDAO implements MemberDAO{
	private static final Logger logger=LoggerFactory.getLogger(MybatisMemberDAO.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
/****************************************************************************
 	Shop���� ����
 *****************************************************************************/
	//���̵� �ߺ� üũ
	public int duplicateCheck(String user_id) {
		int result = sqlSessionTemplate.selectOne("Member.duplicateCheck", user_id);
		return result;
	}
	
	//ȸ�� ����
	public void insert(Member member) throws MemberRegistException{
		int result = sqlSessionTemplate.insert("Member.insert", member);
		if(result==0) {
			throw new MemberRegistException("ȸ�����Կ� �����Ͽ����ϴ�.");
		} 
	}
	
	//�α��� ����
	public Member select(Member member) throws MemberNotFoundException{
		Member obj = sqlSessionTemplate.selectOne("Member.select", member);
		if(obj == null) {//�ùٸ������� ������ �α���
			throw new MemberNotFoundException("�α��� ������ �ùٸ��� �ʽ��ϴ�");
		}
		return obj;
	}
	
	//ȸ�����̵� ã��
	public List forgot_id(Member member) {
		logger.debug("forgot_id DAO ����");
		logger.debug(member.toString());
		return sqlSessionTemplate.selectList("Member.forgot_id" , member);
	}
	
	//ȸ����й�ȣ ã��
	public void forgot_pwd(Member member) throws MemberNotFoundException{
		logger.debug("forgot_pwd DAO ����");
		int result =  sqlSessionTemplate.update("Member.forgot_pwd", member);
	}
		
	
	//ȸ������
	public void update(Member member) throws MemberEditException{
		int result = sqlSessionTemplate.update("Member.update", member);
	}
		
	//ȸ��Ż��
	public void delete(Member member) throws MemberDeleteException{
		int result = sqlSessionTemplate.delete("Member.delete", member);
		
	}
	

/****************************************************************************
 	Admin ���� ����
 *****************************************************************************/
	//ȸ�� ��� ��������
	public List selectAll() {
		return sqlSessionTemplate.selectList("Member.selectAll");
	}


}