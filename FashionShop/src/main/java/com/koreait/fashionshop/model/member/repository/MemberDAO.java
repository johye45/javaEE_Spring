package com.koreait.fashionshop.model.member.repository;

import java.util.List;

import com.koreait.fashionshop.model.domain.Member;

public interface MemberDAO {

	public List selectAll();//��� ȸ�� ��������
	public Member select(Member member);//ȸ�� 1�� ��������, �α��ο�
	public void insert(Member member);//ȸ�� ���
	public void update(Member member);//ȸ������
	public void delete(Member member);//ȸ������, ��ٷӰ� �����ϱ� ���ؼ�
}
