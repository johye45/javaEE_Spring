package com.koreait.petshop2.model.domain;

import lombok.Data;

@Data
public class Color {
	private int color_id;
	private int product_id;
	private String picker;
}