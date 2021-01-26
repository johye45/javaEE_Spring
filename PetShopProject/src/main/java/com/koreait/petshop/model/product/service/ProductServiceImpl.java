package com.koreait.petshop.model.product.service;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.petshop.model.common.FileManager;
import com.koreait.petshop.model.domain.Color;
import com.koreait.petshop.model.domain.Image;
import com.koreait.petshop.model.domain.Product;
import com.koreait.petshop.model.domain.Psize;
import com.koreait.petshop.model.product.repository.ColorDAO;
import com.koreait.petshop.model.product.repository.ImageDAO;
import com.koreait.petshop.model.product.repository.ProductDAO;
import com.koreait.petshop.model.product.repository.PsizeDAO;

@Service
public class ProductServiceImpl implements ProductService{
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ImageDAO imageDAO;
	@Autowired
	private PsizeDAO psizeDAO;
	@Autowired
	private ColorDAO colorDAO;

	@Override
	public List selectAll() {
		return productDAO.selectAll();
	}
	
	@Override
	public List selectById(int subcategory_id) {
		return productDAO.selectById(subcategory_id);
	}
	
	@Override
	public Product select(int product_id) {
		return productDAO.select(product_id);
	}
	
	//���
	public void regist(FileManager fileManager, Product product) {
		String ext=fileManager.getExtend(product.getRepImg().getOriginalFilename());
		product.setFilename(ext);
		productDAO.regist(product);
		
		String basicImg = product.getProduct_id()+"."+fileManager.getExtend(product.getRepImg().getOriginalFilename());
		fileManager.saveFile(fileManager.getSaveBasicDir()+File.separator+basicImg, product.getRepImg());
		
		//�߰��̹��� ���ε�
		for(int i=0; i<product.getAddImg().length; i++) {
			
			MultipartFile file=product.getAddImg()[i];
			ext=fileManager.getExtend(file.getOriginalFilename());
			
			Image image = new Image();
			image.setProduct_id(product.getProduct_id()); //fk
			image.setFilename(ext); //Ȯ���� �ֱ�
			imageDAO.insert(image);
			
			String addImg = image.getImage_id()+"."+fileManager.getExtend(file.getOriginalFilename());
			fileManager.saveFile(fileManager.getSaveAddonDir()+File.separator+addImg, file);
			logger.debug("�����̸� : "+file.getOriginalFilename());
			logger.debug("Ȯ���� : "+ext);
			logger.debug("���ε�� �����̸� : "+addImg);
			logger.debug("���ε� ��ġ : "+fileManager.getSaveAddonDir());
			logger.debug("���� ��� : "+fileManager.getSaveAddonDir()+File.separator+addImg);
			
		}
		
		//������
		for(Psize psize : product.getPsize()) {
			logger.debug("������ ������� ="+psize.getPetfit());
			psize.setProduct_id(product.getProduct_id());//fk����
			psizeDAO.insert(psize);
		}
		
		//����
		for(Color color : product.getColors()) {
			logger.debug("������ ������ ="+color.getPicker());
			color.setProduct_id(product.getProduct_id());
			colorDAO.insert(color);
		}
		
	}
	
	@Override
	public void update(FileManager fileManager,Product product) {
		
		colorDAO.delete(product.getProduct_id());
		psizeDAO.delete(product.getProduct_id()); 
		//������ ���� �� ���� 
		for(int i=0;i<product.getPsize().length;i++) { 
			Psize psize= product.getPsize()[i];
			psize.setProduct_id(product.getProduct_id()); psizeDAO.insert(psize); 
		} 
		//�÷������� ���� 
		for(int i=0; i<product.getColors().length;i++) { 
			Color color =product.getColors()[i]; color.setProduct_id(product.getProduct_id());
			colorDAO.insert(color); 
		}
		if(product.getAddImg()!=null) {			
			//�߰� �̹��� ����
			for(int i=0; i<product.getAddImg().length;i++) {				
				System.out.println("������??"+product.getAddImg());
				MultipartFile file=product.getAddImg()[i];
				String ext=fileManager.getExtend(file.getOriginalFilename());
				
				Image image = new Image();
				image.setProduct_id(product.getProduct_id()); //fk
				image.setFilename(ext); //Ȯ���� �ֱ�
				imageDAO.insert(image);
				
				String addImg = image.getImage_id()+"."+fileManager.getExtend(file.getOriginalFilename());
				fileManager.saveFile(fileManager.getSaveAddonDir()+File.separator+addImg, file);
			}
		} 
			
		if(product.getRepImg().getOriginalFilename()!="") {
			//System.out.println("RepImg : "+product.getRepImg().getOriginalFilename());
			//fileManager.delFile(new File(fileManager.getSaveBasicDir()+File.separator+product.getProduct_id()+"."+product.getFilename()));			
			//System.out.println("���䰡?"+product.getFilename());
			//���� �̹��� ����
			String ext=fileManager.getExtend(product.getRepImg().getOriginalFilename());
			String basicImg = product.getProduct_id()+"."+ext;
			fileManager.saveFile(fileManager.getSaveBasicDir()+File.separator+basicImg, product.getRepImg());
			product.setFilename(ext);
		}
		System.out.println("getfilename"+product.getFilename());
		productDAO.update(product);
	}

	@Override
	public void delete(Product product) {
		
		//db���� ����
		colorDAO.delete(product.getProduct_id());
		psizeDAO.delete(product.getProduct_id());
		productDAO.delete(product.getProduct_id());
	}

}