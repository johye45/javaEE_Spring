package com.koreait.petshop.model.product.repository;

import java.util.List;

import com.koreait.petshop.model.domain.TopCategory;

public interface TopCategoryDAO {
	public List selectAll();//��ü ������
	public TopCategory select(int topcategory_id);//�Ѱ� ��������
	public void insert(TopCategory topcategory);
	public void update(TopCategory topcategory);
	public void delete(int topcategory_id);
}
