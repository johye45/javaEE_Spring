package com.koreait.petshop.model.product.repository;

import java.util.List;

import com.koreait.petshop.model.domain.SubCategory;

public interface SubCategoryDAO {
	public List selectAll();//���� ��ΰ�������
	public List selectAllById(int topcategory_id);//������ �Ҽӵ� �������� ��������
	public SubCategory select(int subcategory_id);//�����Ѱǰ�������
	public void insert(SubCategory subCategory);
	public void update(SubCategory subCategory);
	public void delete(int subCategory_id );
}
