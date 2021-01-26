package com.koreait.petshop.model.product.service;

import java.util.List;

import com.koreait.petshop.model.domain.SubCategory;

public interface SubCategoryService {

	public List selectAll();
	public List selectAllById(int topcategory_id);//�������ڵ忡 �����ִ� �������ڵ� ����
	public SubCategory select(int subcategory_id);//�������ڵ� �Ѱ�
	public void insert(SubCategory subCategory);
	public void update(SubCategory subCategory);
	public void delete(int SubCategory_id);
}
