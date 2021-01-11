package com.koreait.petshop2.model.product.service;

import java.util.List;
import java.util.Map;

import com.koreait.petshop2.model.common.FileManager;
import com.koreait.petshop2.model.domain.Product;


public interface ProductService {
	public List selectAll();//��� ��ǰ
	public List selectById(int subcategory_id);//subcategory�� ��ϵ� ��ǰ
	public Product select(int product_id);//��ǰ �Ѱ�
	public void regist(FileManager fileManager, Product product);//insert�Ӹ� �ƴ϶� ���� ���ε� ó�� 
	public void update(Product product);
	public void delete(int product_id);
}
