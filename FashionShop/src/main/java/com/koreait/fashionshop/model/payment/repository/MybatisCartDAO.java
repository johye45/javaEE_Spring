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

	//장바구니에 등록된 회원의 장바구니 리스트 가져오기
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
			throw new CartException("장바구니 수정 실패");
		}
		
	}

	//장바구니 중복상품 체크
	@Override
	public void deulicateCheck(Cart cart) throws CartException{
		List list = sqlSessionTemplate.selectList("Cart.deulicateCheck", cart);
		if(list.size()>0) {//이미 담겨진 상품이라면
			throw new CartException("장바구니에 이미 상품이 담겨져 있습니다");
		}
	}

	@Override
	public void insert(Cart cart) throws CartException{
		// TODO Auto-generated method stub
		int result = sqlSessionTemplate.insert("Cart.insert", cart);
		if(result==0) {
			throw new CartException("장바구니에 담지 못했습니다.");
		}
		
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	//장바구니 모두지우기
	@Override
	public void delete(Member member) throws CartException{
		// TODO Auto-generated method stub
		int result = sqlSessionTemplate.delete("Cart.delete", member.getMember_id());
		if(result==0) {
			throw new CartException("장바구니 삭제 실패");
		}
		
	}


	
}
