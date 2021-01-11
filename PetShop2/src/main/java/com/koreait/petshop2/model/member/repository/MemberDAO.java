package com.koreait.petshop2.model.member.repository;

import java.util.List;

import com.koreait.petshop2.model.domain.Member;

public interface MemberDAO {
	public List selectAll(); //��� ȸ����������
	public Member select();//ȸ�� 1�� ��������
	public void insert(Member member); //ȸ�����
	public void update(Member member); //ȸ������
	public void delete(Member member); //ȸ������
	
	public int duplicateCheck(String user_id); //�ߺ����� üũ
}