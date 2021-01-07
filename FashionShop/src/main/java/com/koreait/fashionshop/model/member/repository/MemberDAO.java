package com.koreait.fashionshop.model.member.repository;

import java.util.List;

import com.koreait.fashionshop.model.domain.Member;

public interface MemberDAO {

	public List selectAll();//모든 회원 가져오기
	public Member select(Member member);//회원 1명 가져오기, 로그인용
	public void insert(Member member);//회원 등록
	public void update(Member member);//회원수정
	public void delete(Member member);//회원삭제, 까다롭게 삭제하기 위해서
}
