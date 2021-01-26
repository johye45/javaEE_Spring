package com.koreait.petshop.model.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	private int product_id;
	private SubCategory subCategory;
	private int subcategory_id; 
	private String product_name; 
	private int price;
	private String detail; 
	private String filename;
	
	private MultipartFile repImg; //��ǥ �̹���
	private MultipartFile[] addImg; //�߰� �̹����� ���û����̸�, ���ÿ� �迭
	
	private List<Image> imageList;
	private List<Score> score;
	private List<Color> colorList;	//���󰪵�
	private List<Psize> psizeList;//������
	
	
	private Color[] colors;	//����
	private Psize[] psize;	//������
	private String delRep;//���� ���� ���ϸ� ��� ����Ʈ
	private List delAdd;//
	private int[] editAdd;//������ ������ ���ϸ�
}