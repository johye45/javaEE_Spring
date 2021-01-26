package com.koreait.petshop.model.product.service;

import java.util.List;

import com.koreait.petshop.model.common.FileManager;
import com.koreait.petshop.model.domain.Product;

public interface ProductService {
	public List selectAll(); //��� ��ǰ 
	public List selectById(int subcategory_id); //���� ī�װ��� �Ҽӵ� ��� ��ǰ
	public Product select(int product_id);
	public void regist(FileManager fileManager,Product product); //insert�ϴ°� �ƴϱ� ����..
	public void update(FileManager fileManager,Product product);
	public void delete(Product product);

}