package com.koreait.petshop2.model.product.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.petshop2.model.domain.Product;

@Repository
public class MybatisProductDAO implements ProductDAO{
	
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//��ϸ���Ʈ ��������
	@Override
	public List selectAll(){
		return sqlSessionTemplate.selectList("Product.selectAll");
		 
	}

	@Override
	public List selectById(int subcategory_id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("Product.selectBySubCategoryId", subcategory_id);
	}

	//��� ��ǰ �Ѱ� ��������->�󼼺���
	@Override
	public Product select(int product_id) {
		return sqlSessionTemplate.selectOne("Product.select", product_id);
	}

	@Override
	public void regist(Product product) {
		sqlSessionTemplate.insert("Product.insert", product);
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int product_id) {
		// TODO Auto-generated method stub
		
	}

}
