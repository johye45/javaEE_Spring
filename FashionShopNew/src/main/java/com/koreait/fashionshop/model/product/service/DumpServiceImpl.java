package com.koreait.fashionshop.model.product.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.model.common.FileManager;
import com.koreait.fashionshop.model.domain.Color;
import com.koreait.fashionshop.model.domain.Product;
import com.koreait.fashionshop.model.domain.Psize;
import com.koreait.fashionshop.model.excel.ProductConverter;
import com.koreait.fashionshop.model.product.repository.ColorDAO;
import com.koreait.fashionshop.model.product.repository.ProductDAO;
import com.koreait.fashionshop.model.product.repository.PsizeDAO;

@Service
public class DumpServiceImpl implements DumpService{
	private static final Logger logger=LoggerFactory.getLogger(DumpServiceImpl.class);
	
	@Autowired
	private ProductConverter productConverter;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ColorDAO colorDAO;
	
	@Autowired 
	private PsizeDAO psizeDAO;
	
	public void regist(String path) {
		//엑셀을 읽어서 데이터로 넣기
		List<Product > productList = productConverter.convertFromFile(path);
		logger.debug("엑셀파일을 분석하여 나온 결과 리스트"+productList.size());
	
		//리스트에 담겨진 만큼 product테이블에 insert 
		for(int i=0; i<productList.size();i++) {
			Product product = productList.get(i);//이 시점에는 insert전이기 때문에 product_id가 미결정
			productDAO.insert(product);//이시점에는!primayr key인 product_id가 결정이 
			//따라서 인서트하자마자 이 시점부터는 product VO에 이미 pk값이 채워져 있는 상태이다
			
			//하나의 상품에 딸려있는 색상을 넣자, 그러기 위해서는 product_id가 필요하다
			for(Color color :product.getColorList()) {//product가 보유한 colorList를 color에 담을거임
				color.setProduct_id(product.getProduct_id());//이 시점부터는 컬러가 fk를 보유했으므로
				//데이터를 담아보자color를
				colorDAO.insert(color);
			}

			//사이즈 담기
			for(Psize psize :product.getPsizeList()) {
				psize.setProduct_id(product.getProduct_id());
				psizeDAO.insert(psize);
			}
			
			//이미 들어간 파일명을 product_id+확장자 조합으로 교체하자 ex)35.jpg
			product.setFilename(product.getProduct_id()+"."+FileManager.getExtend(product.getFilename()));//update하기 전 파일명 새로 
			productDAO.update(product);//파일명만 수정
			
		}
		
		
	}

}
