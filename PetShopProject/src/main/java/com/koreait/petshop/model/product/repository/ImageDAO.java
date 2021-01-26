package com.koreait.petshop.model.product.repository;

import java.util.List;

import com.koreait.petshop.model.domain.Image;

public interface ImageDAO {
	public List selectAll();//�׳� ��� �̹���
	public List selectById(int product_id);//fk�� �Ҽӵ� ��� �̹���
	public Image select(int image_id);
	public void insert(Image image);
	public void update(int image_id);
	public void delete(int product_id);
}
