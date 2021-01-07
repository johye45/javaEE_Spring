package com.koreait.fashionshop.model.domain;

import lombok.Data;

//장바구니에 상품을 담기위해 상품을 상속받는다
@Data
public class Cart extends Product{
	private int cart_id;
	private int quantity;
	private int member_id;
}
