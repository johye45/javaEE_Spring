package com.koreait.fashionshop.model.domain;

import lombok.Data;

//image vo����
@Data
public class Image {
	private int image_id;
	private int product_id;
	private String filename;
}
