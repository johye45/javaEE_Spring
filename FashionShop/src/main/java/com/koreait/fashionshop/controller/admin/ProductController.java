package com.koreait.fashionshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//admin product 관리

@Controller
public class ProductController {
	
	
	//상위 카테고리 가져오기
	
	//하위 카테고리 가졍괴
	
	//상품 목록
	@RequestMapping(value="/admin/product/list", method=RequestMethod.GET)
	public ModelAndView getProductList() {//보여줄 페이지가 있으므로
		ModelAndView mav =new ModelAndView("admin/product/product_list");
		
		return mav;
		
	}
	
	
	//상품 상세
	
	
	//상품 등록
	
	
	//상품 수정
	
	
	//상품 삭제
	
	
}
