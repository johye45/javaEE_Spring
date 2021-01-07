package com.koreait.fashionshop.model.payment.service;

import java.util.List;

import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.domain.Member;


public interface PaymentService {
	//��ٱ��ϰ��� ����
	public List selectCartList();//ȸ�� ���о��� ��� ������ ��������
	public List selectCartList(int member_id);//Ư��ȸ���� ��ٱ��� ����
	public Cart selectCart(int cart_id);
	public void insert(Cart cart);
	public void update(List<Cart> cartList);//�ϰ�����
	public void delete(Cart cart);//ȸ��id�� ���� ������ ������ ����, ��ٱ��� ���� ��ﶧ
	public void delete(Member member);//��ٱ��� ��ü ��ﶧ

	
	//���� ���� ����
}
