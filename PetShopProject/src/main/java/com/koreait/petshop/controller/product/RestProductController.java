package com.koreait.petshop.controller.product;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import com.koreait.petshop.model.common.FileManager;
import com.koreait.petshop.model.common.MessageData;
import com.koreait.petshop.model.domain.Color;
import com.koreait.petshop.model.domain.Image;
import com.koreait.petshop.model.domain.Product;
import com.koreait.petshop.model.domain.Psize;
import com.koreait.petshop.model.product.service.ImageService;
import com.koreait.petshop.model.product.service.ProductService;
import com.koreait.petshop.model.product.service.SubCategoryService;
import com.koreait.petshop.model.product.service.TopCategoryService;

@Controller
@RequestMapping("/async")
public class RestProductController implements ServletContextAware{
	private static final Logger logger = LoggerFactory.getLogger(RestProductController.class);
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private ImageService imageService;  
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FileManager fileManager;
	
	private ServletContext servletContext;
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		//�� Ÿ�̹��� ��ġ������ ���� ������ ��θ� FileManager�� �����س���!!
		fileManager.setSaveBasicDir(servletContext.getRealPath(fileManager.getSaveBasicDir()));
		fileManager.setSaveAddonDir(servletContext.getRealPath(fileManager.getSaveAddonDir()));
		
		logger.debug("���� ��� "+this.servletContext.getRealPath(fileManager.getSaveBasicDir()));
		logger.debug(fileManager.getSaveBasicDir());
	}
	
	//���
	@RequestMapping(value="/admin/product/regist", method=RequestMethod.POST)
	@ResponseBody
	public MessageData getProductRegist(Product product) {
		logger.debug("����ī�װ� "+product.getSubcategory_id());
		logger.debug("��ǰ�� "+product.getProduct_name());
		logger.debug("���� "+product.getPrice());
		logger.debug("�󼼳��� "+product.getDetail());
		
		
		
		for(Color color : product.getColors() ) {
			logger.debug("����  "+color.getPicker());
		}
		for(Psize psize : product.getPsize() ) {
			logger.debug("������  "+psize.getPetfit());
		}
		
		productService.regist(fileManager, product);
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("��ϼ���.");
		messageData.setUrl("/admin/product/list");
		
		return messageData;
	}
	
	//����
	@PostMapping(value="/admin/product/update")
	@ResponseBody
	public MessageData getProductEdit(Product product) {
		
		if(product.getEditAdd()!=null) {			
			for(int i=0; i<product.getEditAdd().length;i++) {			
				logger.info("�̹��� ���̵� : "+product.getEditAdd()[i]);
				imageService.update(fileManager,product.getEditAdd()[i]);
			}
		}
		productService.update(fileManager,product);
		
		MessageData messageData= new MessageData();
		messageData.setMsg("��������");
		messageData.setUrl("redirect:/admin/product/detail?product_id="+product.getProduct_id());
		/*
		 * logger.info("����ī�װ� "+product.getSubcategory_id());
		 * logger.info("��ǰ�� "+product.getProduct_name());
		 * logger.info("���� "+product.getPrice());
		 * logger.info("�󼼳��� "+product.getDetail());
		 * 
		 * for(Color color : product.getColors()) { logger.info(""+color.getPicker()); }
		 * for(Psize psize : product.getPsize()) { logger.info(""+psize.getPetfit()); }
		 */
		
		return messageData;
	}
	
	//����
	//������û
	@PostMapping("/admin/product/del")
	@ResponseBody
	public MessageData getDelete(Product product) {
		//�̹���,���� ����
		imageService.delete(fileManager,product);
		
		//��ǰ ����
		productService.delete(product);
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("�����Ϸ�");
		messageData.setUrl("/admin/product/list");
		
		return messageData;
	}
	
	
}