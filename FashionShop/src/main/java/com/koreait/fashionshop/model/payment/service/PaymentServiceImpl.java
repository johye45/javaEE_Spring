package com.koreait.fashionshop.model.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.exception.CartException;
import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.domain.OrderDetail;
import com.koreait.fashionshop.model.domain.OrderSummary;
import com.koreait.fashionshop.model.domain.Receiver;
import com.koreait.fashionshop.model.payment.repository.CartDAO;
import com.koreait.fashionshop.model.payment.repository.OrderDetailDAO;
import com.koreait.fashionshop.model.payment.repository.OrderSummaryDAO;
import com.koreait.fashionshop.model.payment.repository.PaymethodDAO;
import com.koreait.fashionshop.model.payment.repository.ReceiverDAO;

@Service
public  class PaymentServiceImpl implements PaymentService{

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private PaymethodDAO paymethodDAO;
	
	//주문관련 3가지DAO
	@Autowired
	private OrderSummaryDAO orderSummaryDAO;
	@Autowired
	private ReceiverDAO receiverDAO;
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	//장바구니
	@Override
	public List selectCartList() {

		return null;
	}

	//장바구니리스트 가져오기 member_id가 등록된
	@Override
	public List selectCartList(int member_id) {
		
		return cartDAO.selectAll(member_id);
	}

	@Override
	public Cart selectCart(int cart_id) {
		
		return null;
	}

	@Override
	public void update(List<Cart> cartList) throws CartException{
		//상품 갯수만큼 수정 요청 
		for(Cart cart : cartList) {
			cartDAO.update(cart);
		}
	}

	@Override
	public void insert(Cart cart) throws CartException{
		
		cartDAO.deulicateCheck(cart);//장바구니 항목 체크
		
		cartDAO.insert(cart);
	}

	@Override
	public void delete(Cart cart) {
		
	}

	//장바구니에서 전체 삭제
	@Override
	public void delete(Member member) throws CartException {
		cartDAO.delete(member);
	}

	//결제
	public List selectPaymethodList() {
		return paymethodDAO.selectAll();
	}
	
	@Override
	public void registOrder(OrderSummary orderSummary, Receiver receiver) {

		//주문요약 등록
		orderSummaryDAO.insert(orderSummary);
		
		//주문 요약이 등록된 이후 , orderSummary VO에는 mybatis의 selectKey에 의해 order_summary_id 가 채워져있다
		//따라서 취득한 주문번호를 받는사람, 상세에 담아주자
		receiver.setOrder_summary_id(orderSummary.getOrder_summary_id());//주문번호 전달
		//받는사람 정보 등
		receiverDAO.insert(receiver);
		
		//주문상세등록
		//장바구니를 조회하여 OrderDetail VO처리
		
	}
	
}
