package com.koreait.fashionshop.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.common.FileManager;
import com.koreait.fashionshop.exception.ProductRegistException;
import com.koreait.fashionshop.model.domain.Product;
import com.koreait.fashionshop.model.domain.Psize;
import com.koreait.fashionshop.model.domain.SubCategory;
import com.koreait.fashionshop.model.product.service.ProductService;
import com.koreait.fashionshop.model.product.service.SubCategoryService;
import com.koreait.fashionshop.model.product.service.TopCategoryService;

//admin product 관리

@Controller
public class ProductController implements ServletContextAware{
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	//인터페이스 보유, 주입
	@Autowired
	private TopCategoryService topCategoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FileManager fileManager;

	//우리가 왜 ServletContext를 써야 하는가? getRealPath()사용하려고
	private ServletContext servletContext;
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		//이 타이밍을 놓치지말고, 실제 물리적 경로를 FileManager에 대입해놓자
		fileManager.setSaveBasicDir(servletContext.getRealPath(fileManager.getSaveBasicDir()));
		fileManager.setSaveAddonDir(servletContext.getRealPath(fileManager.getSaveAddonDir()));
		
		logger.debug(fileManager.getSaveBasicDir());
		//logger.debug(fileManager.getSaveAddonDir());
	
	}
	//상위카테고리 가져오기 (관리자 용)
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
	
	//하위 카테고리 가져오기, 페이지를 전송하지 않고 데이터만 보내는 것
	//스프링에서는 java객체와 json간 변환을 자동으로 해주는 라이브러리를 지원 
	@RequestMapping(value="/admin/product/sublist", method=RequestMethod.GET)
	@ResponseBody
	public List getSubList(int topcategory_id) {
		List<SubCategory> subList = subCategoryService.selectAllById(topcategory_id);
		return  subList;
	}
	
	/*
	@RequestMapping(value="/admin/product/sublist", method=RequestMethod.GET, produces = "text/html;charset=utf-8")
	@ResponseBody //jsp와 같은 뷰페이지가 아닌, 단순 데이터만 전송시
	public String getSubList(int topcategory_id) {
		logger.debug("tocategory_id : "+topcategory_id);
		
		List<SubCategory> subList = subCategoryService.selectAllById(topcategory_id);
		
		// 리스트를 json으로 변형하여 보내줘야함..
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"subList\" : [");
		for(int i=0;i<subList.size();i++) {
			SubCategory subCategory = subList.get(i);
			sb.append("{");
			sb.append("\"subcategory_id\":"+subCategory.getSubcategory_id()+" ,");
			sb.append("\"topcategory_id\":"+subCategory.getTopcategory_id()+",");
			sb.append("\"name\":\""+subCategory.getName()+"\"");
			if(i<subList.size()-1) {
				sb.append("},");
			}else {
				sb.append("}");
			}
		}
		sb.append("]");
		sb.append("}");		
		
		return sb.toString();
	}
	*/

	
	
		//상품목록
		@RequestMapping(value="/admin/product/list", method=RequestMethod.GET )
		public ModelAndView getProductList() {
			ModelAndView mav = new ModelAndView("admin/product/product_list");
			
			List productList = productService.selectAll();
			mav.addObject("productList", productList);
			
			return mav;
		}
		
		//상품등록 폼 
		@RequestMapping(value="/admin/product/registform")
		public String registForm() {	
			return "admin/product/regist_form";
		}
		
		
		//상품 상세 
		
		//상품 등록 
		@RequestMapping(value="/admin/product/regist", method=RequestMethod.POST,  produces = "text/html;charset=utf-8")
		@ResponseBody //페이지 응답이 아닌 텍스트 응답
		public String registProduct(Product product) {
			logger.debug("하위카테고리 "+product.getSubCategory().getSubcategory_id());
			logger.debug("상품명 "+product.getProduct_name());
			logger.debug("가격 "+product.getPrice());
			logger.debug("브랜드 "+product.getBrand());
			logger.debug("상세내용 "+product.getDetail());

			/*
			logger.debug("대표이미지 "+product.getRepImg().getOriginalFilename());
			for(int i=0;i<product.getAddImg().length;i++) {
				logger.debug("추가이미지"+product.getAddImg()[i].getOriginalFilename());				
			}
			
			for(int i=0;i<product.getPsize().length;i++) {
				logger.debug("지원사이즈()[i]);				
			}
			*/
			for(Psize psize:product.getPsize()) {
				logger.debug("지원 사이즈는:"+psize.getFit());
			}
		
			logger.debug("insert하기 전 상품의 product_id :"+product.getProduct_id());
			productService.regist(fileManager,product);//상품 등록, 대표이미지와, 추가이미지 모두 등록되는것임
			logger.debug("방금 insert된 상품의 product_id :"+product.getProduct_id());//데표 이미지 파일명에 사용될 것
		
			
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			sb.append("\"result\":1,");
			sb.append("\"msg\":\"상품 등록 성공\"");
			sb.append("}");
			
			return sb.toString();
		}

		

	
	
	//상품 수정
	
	
	//상품 삭제
		
	//예외처리
	//위의 메서드 중 하나라도 예외가 발생하면, 아래의 핸들러가 동작
	@ExceptionHandler(ProductRegistException.class) //예외처리를 하기 위해서
	@ResponseBody//페이지 응답이 아닌 텍스트 응답
	public String handleException(ProductRegistException e) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"result\":0,");
		sb.append("\"msg\":\""+e.getMessage()+"\"");
		sb.append("}");
		
		return sb.toString();
	}
	
	
	/****************************************************
	 * 쇼핑몰의 프론트 요청 처리
	 * ***************************************************/
	
	//상품 목록 요청 처리
	@RequestMapping(value="/shop/product/list", method=RequestMethod.GET)
	public ModelAndView getShopProductList(int subcategory_id) {//하위카테고리의 id
		List topList = topCategoryService.selectAll();//상품 카테고리 목록
		
		List productList = productService.selectById(subcategory_id);//상품 목록

		ModelAndView mav = new ModelAndView();
		mav.addObject("topList", topList);
		mav.addObject("productList", productList);
		mav.setViewName("shop/product/list");
		return mav;
	}
	
	//상품상세 보기 요청 
	@RequestMapping(value="/shop/product/detail", method=RequestMethod.GET)
	public ModelAndView getShopProductDetail(int product_id) {
		//게시물 한건 select * from product where product_id=?
		List topList = topCategoryService.selectAll();//상품카테고리 목록
		
		Product product = productService.select(product_id);//상품 한건 가져오기
		
		ModelAndView mav = new ModelAndView("shop/product/detail");
		mav.addObject("topList", topList);
		mav.addObject("product",product);
		
		return mav;
	}
	
}
