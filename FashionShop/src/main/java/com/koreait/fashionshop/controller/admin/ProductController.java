package com.koreait.fashionshop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.model.product.service.TopCategoryService;

//admin product ����

@Controller
public class ProductController {
	
	//�������̽� ����
	@Autowired
	private TopCategoryService topCategoryService;
	
	//����ī�װ� �������� 
	@RequestMapping(value="/admin/product/registform", method=RequestMethod.GET)
	public ModelAndView getTopList() {
		//3�ܰ�: ���� ��ü�� �Ͻ�Ų��
		List topList = topCategoryService.selectAll();
		
		//4�ܰ�: ���� 
		ModelAndView mav = new ModelAndView();
		mav.addObject("topList", topList);
		mav.setViewName("admin/product/regist_form");
		
		return mav;
	}
	
	//���� ī�װ� ������
	
	//��ǰ ���
	@RequestMapping(value="/admin/product/list", method=RequestMethod.GET)
	public ModelAndView getProductList() {//������ �������� �����Ƿ�
		ModelAndView mav =new ModelAndView("admin/product/product_list");
		
		return mav;
		
	}
	
	//��ǰ ��� ��
	@RequestMapping(value="/admin/product/registform")
	public String registForm() {//������ �������� �����Ƿ�
		
		return "admin/product/regist_form";
		
	}
	
	
	//��ǰ ��
	
	
	//��ǰ ���
	
	
	//��ǰ ����
	
	
	//��ǰ ����
	
	
}
