package com.koreait.fashionshop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.model.product.service.TopCategoryService;

//admin product 관리

@Controller
public class ProductController {
	
	//인터페이스 보유
	@Autowired
	private TopCategoryService topCategoryService;
	
	//상위카테고리 가져오기 
	@RequestMapping(value="/admin/product/registform", method=RequestMethod.GET)
	public ModelAndView getTopList() {
		//3단계: 로직 객체에 일시킨다
		List topList = topCategoryService.selectAll();
		
		//4단계: 저장 
		ModelAndView mav = new ModelAndView();
		mav.addObject("topList", topList);
		mav.setViewName("admin/product/regist_form");
		
		return mav;
	}
	
	//하위 카테고리 가졍괴
	
	//상품 목록
	@RequestMapping(value="/admin/product/list", method=RequestMethod.GET)
	public ModelAndView getProductList() {//보여줄 페이지가 있으므로
		ModelAndView mav =new ModelAndView("admin/product/product_list");
		
		return mav;
		
	}
	
	//상품 등록 폼
	@RequestMapping(value="/admin/product/registform")
	public String registForm() {//보여줄 페이지가 있으므로
		
		return "admin/product/regist_form";
		
	}
	
	
	//상품 상세
	
	
	//상품 등록
	
	
	//상품 수정
	
	
	//상품 삭제
	
	
}
