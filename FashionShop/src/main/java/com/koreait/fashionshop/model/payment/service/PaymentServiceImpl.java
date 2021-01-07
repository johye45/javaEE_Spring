package com.koreait.fashionshop.model.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.exception.CartException;
import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.payment.repository.CartDAO;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private CartDAO cartDAO;
	
	//��ٱ���
	@Override
	public List selectCartList() {

		return null;
	}

	//��ٱ��ϸ���Ʈ �������� member_id�� ��ϵ�
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
		//��ǰ ������ŭ ���� ��û 
		for(Cart cart : cartList) {
			cartDAO.update(cart);
		}
	}

	@Override
	public void insert(Cart cart) throws CartException{
		
		cartDAO.deulicateCheck(cart);//��ٱ��� �׸� üũ
		
		cartDAO.insert(cart);
	}

	@Override
	public void delete(Cart cart) {
		
	}

	//��ٱ��Ͽ��� ��ü ����
	@Override
	public void delete(Member member) throws CartException {
		cartDAO.delete(member);
	}
	
	
	//����

}
