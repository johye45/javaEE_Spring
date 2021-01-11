package com.koreait.petshop2.model.product.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.petshop2.model.common.FileManager;
import com.koreait.petshop2.model.domain.Color;
import com.koreait.petshop2.model.domain.Image;
import com.koreait.petshop2.model.domain.Product;
import com.koreait.petshop2.model.domain.Psize;
import com.koreait.petshop2.model.product.repository.ColorDAO;
import com.koreait.petshop2.model.product.repository.ImageDAO;
import com.koreait.petshop2.model.product.repository.ProductDAO;
import com.koreait.petshop2.model.product.repository.PsizeDAO;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ImageDAO imageDAO;
	@Autowired
	private PsizeDAO psizeDAO;
	@Autowired
	private ColorDAO colorDAO;

	//�����ڸ�� ��� ��������
	@Override
	public List selectAll() {
	
		return productDAO.selectAll();
	}

	@Override
	public List selectById(int subcategory_id) {
		// TODO Auto-generated method stub
		return productDAO.selectById(subcategory_id);
	}

	//������ ��� ��ǰ �󼼺���
	@Override
	public Product select(int product_id) {
		
		return productDAO.select(product_id);
	}

	public void regist(FileManager fileManager, Product product) {
		String ext=fileManager.getExtend(product.getRepImg().getOriginalFilename());
		product.setFilename(ext);
		productDAO.regist(product);
		
		//���� ���ε�!!�� FileManager���� ��Ű��
		//��ǥ�̹��� ���ε�
		//��ǰ�� product_id�� �̿��Ͽ�, ��ǥ�̹������� ��������!!
		String basicImg = product.getProduct_id()+"."+fileManager.getExtend(product.getRepImg().getOriginalFilename());
		fileManager.saveFile(fileManager.getSaveBasicDir()+File.separator+basicImg, product.getRepImg());
		
		//�߰��̹��� ���ε� (FileManager���� �߰��̹��� ������ŭ ���ε� ��Ű�� �ȴ�.)
		for(int i=0; i<product.getAddImg().length; i++) {
			
			MultipartFile file=product.getAddImg()[i];
			ext=fileManager.getExtend(file.getOriginalFilename());
			
			//image table�� �ֱ�
			Image image = new Image();
			image.setProduct_id(product.getProduct_id()); //fk
			image.setFilename(ext); //Ȯ���� �ֱ�
			imageDAO.insert(image);
			
			//�޴����� ���� �޼��� ȣ��
			String addImg = image.getImage_id()+"."+fileManager.getExtend(file.getOriginalFilename());
			fileManager.saveFile(fileManager.getSaveAddonDir()+File.separator+addImg, file);
		}
		//��� �ɼ� ��, ���� ������ �ֱ�
		
		//������
		for(Psize psize : product.getPsize()) {
			//logger.debug("������ ������� ="+psize.getFit());
			psize.setProduct_id(product.getProduct_id());//fk����
			psizeDAO.insert(psize);
		}
		
		//����
		for(Color color : product.getColor()) {
			//logger.debug("������ ������ ="+color.getPicker());
			color.setProduct_id(product.getProduct_id());
			colorDAO.insert(color);
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
