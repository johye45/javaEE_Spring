package com.koreait.fashionshop.model.payment.service;

import java.util.List;

import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.domain.Member;


public interface PaymentService {
	//장바구니관련 업무
	public List selectCartList();//회원 구분없이 모든 데이터 가져오기
	public List selectCartList(int member_id);//특정회원의 장바구니 내역
	public Cart selectCart(int cart_id);
	public void insert(Cart cart);
	public void update(List<Cart> cartList);//일괄수정
	public void delete(Cart cart);//회원id에 속한 데이터 삭제할 예정, 장바구니 선택 비울때
	public void delete(Member member);//장바구니 전체 비울때

	
	//결제 업무 수행
}
