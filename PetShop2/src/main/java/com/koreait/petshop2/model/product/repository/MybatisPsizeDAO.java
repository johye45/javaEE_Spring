package com.koreait.petshop2.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.petshop2.exception.ProductRegistException;
import com.koreait.petshop2.model.domain.Psize;

@Repository
public class MybatisPsizeDAO implements PsizeDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List selectAll() {
		
		return null;
	}

	
	public List selectById(int product_id) {
	
		return null;
	}

	
	public Psize select(int psize_id) {
	
		return null;
	}

	
	public void insert(Psize psize) throws ProductRegistException{
		int result=sqlSessionTemplate.insert("Psize.insert", psize);
		if(result==0) {
			throw new ProductRegistException("������ ��Ͽ� �����߽��ϴ�.");
		}
	}

	
	public void update(Psize psize) throws ProductRegistException{
	
		
	}

	
	public void delete(int psize_id) throws ProductRegistException{
	
		
	}


}