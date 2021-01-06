package com.koreait.fashionshop.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.exception.ProductRegistException;
import com.koreait.fashionshop.model.domain.Product;

@Repository
public class MybatisProductDAO implements ProductDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		
		return sqlSessionTemplate.selectList("Product.selectAll");
	}

	//하위 카테고리
	@Override
	public List selectById(int subcategory_id) {
		return sqlSessionTemplate.selectList("Product.selectBySubCategoryId", subcategory_id);
	}

	//상품 한 건
	@Override
	public Product select(int product_id) {
		return sqlSessionTemplate.selectOne("Product.select", product_id);
	}

	@Override
	public void insert(Product product) throws  ProductRegistException{
		int result = sqlSessionTemplate.insert("Product.insert", product);
		if(result==0) {
			throw new ProductRegistException("상품 테이블에 입력 실패");
		}
	}

	@Override
	public void update(Product product) throws  ProductRegistException{
		
	}

	@Override
	public void delete(int product_id) throws  ProductRegistException{
		
	}

}
