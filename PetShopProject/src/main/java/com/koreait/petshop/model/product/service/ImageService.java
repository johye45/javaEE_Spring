package com.koreait.petshop.model.product.service;

import java.util.List;

import com.koreait.petshop.model.common.FileManager;
import com.koreait.petshop.model.domain.Image;
import com.koreait.petshop.model.domain.Product;

public interface ImageService {
	public List selectAll();//�׳� ��� �̹���
	public List selectById(int product_id);//fk�� �Ҽӵ� ��� �̹���
	public Image select(int image_id);
	public void insert(Image image);
	public void update(FileManager fileManager,int image_id);
	public void delete(FileManager fileManager,Product product);
}