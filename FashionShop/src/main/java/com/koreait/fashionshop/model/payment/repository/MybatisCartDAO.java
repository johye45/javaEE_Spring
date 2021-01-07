package com.koreait.fashionshop.model.payment.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.exception.CartException;
import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.payment.service.PaymentService;

@Repository
public class MybatisCartDAO implements CartDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	//��ٱ��Ͽ� ��ϵ� ȸ���� ��ٱ��� ����Ʈ ��������
	@Override
	public List selectAll(int member_id) {
		
		return sqlSessionTemplate.selectList("Cart.selectAll", member_id);
	}

	@Override
	public Cart select(int cart_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cart cart) {
		int result = sqlSessionTemplate.update("Cart.update",cart);
		if(result==0) {
			throw new CartException("��ٱ��� ���� ����");
		}
		
	}

	//��ٱ��� �ߺ���ǰ üũ
	@Override
	public void deulicateCheck(Cart cart) throws CartException{
		List list = sqlSessionTemplate.selectList("Cart.deulicateCheck", cart);
		if(list.size()>0) {//�̹� ����� ��ǰ�̶��
			throw new CartException("��ٱ��Ͽ� �̹� ��ǰ�� ����� �ֽ��ϴ�");
		}
	}

	@Override
	public void insert(Cart cart) throws CartException{
		// TODO Auto-generated method stub
		int result = sqlSessionTemplate.insert("Cart.insert", cart);
		if(result==0) {
			throw new CartException("��ٱ��Ͽ� ���� ���߽��ϴ�.");
		}
		
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	//��ٱ��� ��������
	@Override
	public void delete(Member member) throws CartException{
		// TODO Auto-generated method stub
		int result = sqlSessionTemplate.delete("Cart.delete", member.getMember_id());
		if(result==0) {
			throw new CartException("��ٱ��� ���� ����");
		}
		
	}


	
}
