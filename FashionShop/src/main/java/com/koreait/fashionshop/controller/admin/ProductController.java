package com.koreait.fashionshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//admin product ����

@Controller
public class ProductController {
	
	
	//���� ī�װ� ��������
	
	//���� ī�װ� ������
	
	//��ǰ ���
	@RequestMapping(value="/admin/product/list", method=RequestMethod.GET)
	public ModelAndView getProductList() {//������ �������� �����Ƿ�
		ModelAndView mav =new ModelAndView("admin/product/product_list");
		
		return mav;
		
	}
	
	
	//��ǰ ��
	
	
	//��ǰ ���
	
	
	//��ǰ ����
	
	
	//��ǰ ����
	
	
}
