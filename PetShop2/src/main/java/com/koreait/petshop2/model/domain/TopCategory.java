package com.koreait.petshop2.model.domain;

import java.util.List;

import lombok.Data;

@Data
public class TopCategory {
	private int topcategory_id;           
	private String name;                               
	private int rank;
	private List<SubCategory> subCategory;//����ī�װ� ����Ʈ�� �����ϱ�
}
