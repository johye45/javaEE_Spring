package com.koreait.fashionshop.model.product.service;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.fashionshop.common.FileManager;
import com.koreait.fashionshop.model.domain.Color;
import com.koreait.fashionshop.model.domain.Image;
import com.koreait.fashionshop.model.domain.Product;
import com.koreait.fashionshop.model.domain.Psize;
import com.koreait.fashionshop.model.product.repository.ColorDAO;
import com.koreait.fashionshop.model.product.repository.ImageDAO;
import com.koreait.fashionshop.model.product.repository.ProductDAO;
import com.koreait.fashionshop.model.product.repository.PsizeDAO;

@Service
public class ProductServiceimpl implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceimpl.class);
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectById(int subcategory_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product select(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	//DAO������ ����DB�� ����ϵ����ϰ�, ���⼭ ���� ���ε� �۾�
	@Override
	public void regist(FileManager fileManager, Product product) {
		String ext = fileManager.getExtend(product.getRepImg().getOriginalFilename());//��ǥ�̹��� Ȯ���� ���ؿ���
		product.setFilename(ext);//Ȯ���� ���
		
		productDAO.insert(product);//DB�� �ִ���
		
		//���� ���ε�� FileManager���� ��Ų��
		//��ǥ �̹��� ���ε�

		//��ǰ�� product_id�� �̿��Ͽ�, ��ǥ�̹������� ��������! data/basic������ ���� 
		String basicImg = product.getProduct_id()+"."+ext;//getExxtend(���� ���ϸ��� �ۼ�)
		fileManager.saveFile(fileManager.getSaveBasicDir()+File.separator+basicImg, product.getRepImg());
		
		//�߰� �̹��� ���ε�(FileManager���� �߰��̹��� ������ŭ ���ε� ������ ��Ű�� �ȴ�
		for(int i=0; i<product.getAddImg().length;i++) {
			MultipartFile file = product.getAddImg()[i];
			ext = fileManager.getExtend(file.getOriginalFilename());
			
			//db�� �ֱ� image���̺�
			Image image = new Image();
			image.setProduct_id(product.getProduct_id());//product_id���� ��� �׷��� image_id�� �����ȴ�
			image.setFilename(ext);//Ȯ���� �ֱ�
			imageDAO.insert(image);
			
					
			String addImg = image.getImage_id()+"."+ext;//addImg������
			//�Ŵ����� ����޼��� ȣ��
			fileManager.saveFile(fileManager.getSaveAddonDir()+File.separator+addImg,file);
		}
		
		//��Ÿ �ɼ� �� ����� ������ �ֱ�(�ݺ�������)
		
		//������
		for(Psize psize:product.getPsize()) {
			logger.debug("����� ������ �������:"+psize.getFit());
			//psize.setProduct_id(product.getProduct_id());//fk����
			//psizeDAO.insert(psize);
		}
		
		//����
		for(Color color : product.getColor()) {
			logger.debug("�Ѱܹ��� ������:"+color.getPicker());
			//color.setProduct_id(product.getProduct_id());
			//colorDAO.insert(color);
		}
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int product_id) {
		// TODO Auto-generated method stub
		
	}

}
