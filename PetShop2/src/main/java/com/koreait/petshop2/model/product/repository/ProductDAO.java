package com.koreait.petshop2.model.product.repository;

import java.util.List;
import java.util.Map;

import com.koreait.petshop2.model.domain.Product;

public interface ProductDAO {
	public List selectAll();//��� ��ǰ
	public List selectById(int subcategory_id);//subcategory�� ��ϵ� ��ǰ
	public Product select(int product_id);//��ǰ �Ѱ�
	public void regist(Product product);
	public void update(Product product);
	public void delete(int product_id);
}
