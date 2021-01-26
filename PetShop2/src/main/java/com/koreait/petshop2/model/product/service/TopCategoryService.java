package com.koreait.petshop2.model.product.service;

import java.util.List;

import com.koreait.petshop2.model.domain.TopCategory;


public interface TopCategoryService {
	public List selectAll();//��� ������������
	public TopCategory select(int topcategory_id);//�������ڵ� �ϳ� ��������
	public void insert(TopCategory topcategory);
	public void update(TopCategory topcategory);
	public void delete(int topcategory_id);
	
}