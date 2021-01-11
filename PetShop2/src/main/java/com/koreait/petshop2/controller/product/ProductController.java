package com.koreait.petshop2.controller.product;

import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop2.model.common.FileManager;
import com.koreait.petshop2.model.domain.Product;
import com.koreait.petshop2.model.domain.SubCategory;
import com.koreait.petshop2.model.product.service.ProductService;
import com.koreait.petshop2.model.product.service.SubCategoryService;
import com.koreait.petshop2.model.product.service.TopCategoryService;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private ProductService productService;
	

	//��� ��
	//��ϵ� ��ǰ��� ����Ʈ
	//@GetMapping("/admin/product/list")
	@RequestMapping(value="/admin/product/list", method=RequestMethod.GET )
	public ModelAndView getProductList() {
		ModelAndView mav = new ModelAndView("admin/product/product_list");
		
		List productList = productService.selectAll();	
		mav.addObject("productList", productList);
	
		logger.debug("productList.size()"+productList.size());

	
		return mav;
	}
	
	//��ǰ �󼼺���
	@RequestMapping(value="/admin/product/detail", method=RequestMethod.GET )
	public ModelAndView getProductDetail(int product_id) {
	List topList = topCategoryService.selectAll();//��ǰī�װ� ���
		
		Product product = productService.select(product_id);//��ǰ �Ѱ� ��������
		
		ModelAndView mav = new ModelAndView("admin/product/detail");
	
		mav.addObject("product",product);
		
		return mav;
	}
	
	//��� ��
		@RequestMapping(value="/admin/product/registform")
		public ModelAndView registForm() {
			List topList=topCategoryService.selectAll();
			ModelAndView mav = new ModelAndView("admin/product/regist_form");
			mav.addObject("topList", topList);
			
			return mav;
		}
		
		//���� ī�װ� ��������
		@GetMapping("/admin/product/sublist")
		@ResponseBody
		public List getSubList(int topcategory_id) {
			List<SubCategory> subList=subCategoryService.selectAllById(topcategory_id);
			return subList;
		}
		
		
		/**************************************
		 * shop������ �����ϱ�
		 * **************************************/
		//��ǰ ��� �����ֱ�
		@RequestMapping(value="/shop/product/list", method=RequestMethod.GET)
		public ModelAndView getShopProductList(int subcategory_id) {
			List topList = topCategoryService.selectAll();//��ǰ ī�װ� ��������
			List productList = productService.selectById(subcategory_id);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("topList", topList);
			mav.addObject("productList", productList);
			mav.setViewName("shop/product/list");
			
			logger.debug("product.size() "+productList.size());
			return mav;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	 
}
