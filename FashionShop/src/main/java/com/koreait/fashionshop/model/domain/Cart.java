package com.koreait.fashionshop.model.domain;

import lombok.Data;

//��ٱ��Ͽ� ��ǰ�� ������� ��ǰ�� ��ӹ޴´�
@Data
public class Cart extends Product{
	private int cart_id;
	private int quantity;
	private int member_id;
}
