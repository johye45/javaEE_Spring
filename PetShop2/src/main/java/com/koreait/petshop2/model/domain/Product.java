package com.koreait.petshop2.model.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	private int product_id;
	private SubCategory subCategory;
	private String product_name;
	private int price;
	private String detail;
	private String filename;
	

	private MultipartFile repImg;	//��ǥ �̹���
	private MultipartFile[] addImg; //�߰� �̹����� ���û����̸�, ���ÿ� �迭
	
	private List<Image> imageList;
	
	private List<Color> color;	//���󰪵�
	private List<Psize> psize;	//������

	
}
