package com.koreait.fashionshop.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.model.domain.TopCategory;

@Repository //componet-scan�� ����� �� �� ��������
public class MybatisTopCategoryDAO implements TopCategoryDAO{
	
	//JDBC
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	

	public List selectAll() {
		return sessionTemplate.selectList("TopCategory.selectAll");
	}

	public TopCategory select(int topcategory_id) {
		return null;
	}

	public void insert(TopCategory topcategory) {
		
	}

	public void update(TopCategory topcategory) {
		
	}

	public void delete(int topcategory_id) {
		
	}

}
