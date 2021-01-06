package com.koreait.fashionshop.model.member.service;

import java.util.List;

import com.koreait.fashionshop.model.domain.Member;

public interface MemberService {

	public List selectAll();//��� ȸ�� ��������
	public Member select();//ȸ�� 1�� ��������
	public void regist(Member member);//ȸ�� ��� �� ��Ÿ �ʿ���� ó��
	public void update(Member member);//ȸ������
	public void delete(Member member);//ȸ������, ��ٷӰ� �����ϱ� ���ؼ�

}
