package com.koreait.petshop.model.payment.service;
import java.util.List;

import com.koreait.petshop.model.domain.Cart;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.domain.OrderDetail;
import com.koreait.petshop.model.domain.OrderSummary;
import com.koreait.petshop.model.domain.Product;
import com.koreait.petshop.model.domain.Receiver;
import com.koreait.petshop.model.domain.SubCategory;

//��ٱ��� ���� ���� 
public interface PaymentService {
	//��ٱ��� ���� ����
	public List selectCartList();// ���īƮ 
	public List selectCartList(int member_id);//Ư�� ȸ�� ��ٱ��� ���� ��ȸ
	public Cart selectCart(int cart_id);
	public void insert(Cart cart); // īƮ ���� 
	public void update(List<Cart> cartList); //�ϰ� ����
	public void delete(Cart cart); //pk�� ���� ������ �����ҿ���
	public void delete(Member member); //ȸ���� ���� ������ �����ҿ���
	
	//���� ����
	public List selectPaymethodList();
	public void registOrder(OrderSummary orderSummary, Receiver receiver,OrderDetail orderDetail,Product product);//Ʈ����� ó��
	//���������ȸ�ϱ�
}
