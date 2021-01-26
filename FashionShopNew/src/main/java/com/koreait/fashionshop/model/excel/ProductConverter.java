package com.koreait.fashionshop.model.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.koreait.fashionshop.model.domain.Color;
import com.koreait.fashionshop.model.domain.Product;
import com.koreait.fashionshop.model.domain.Psize;
import com.koreait.fashionshop.model.domain.SubCategory;

//엑셀을 읽어들여서 자바의 POJO형태로 변환하 용도
@Component//scan의 대상이 됨
public class ProductConverter {
	
	
	//누군가 이 메서드를 호출하는 자는, 자신이 보유한 스트림 주소를 넘기면 됨
	public List convertFromFile(String path) {
		List<Product> productList= new ArrayList<Product>();//리스트에 엑셀 분석 후 담으려구
		
		//엑셀 파일 접근 제어객체 생성
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			XSSFWorkbook book= new XSSFWorkbook(fis);
			
			//파일을 접근했으니, 쉬트에 접근해보자
			XSSFSheet sheet = book.getSheetAt(0);//첫번째 쉬트에 접근
			
			//이중반복문의 횟수를 구하기
			int rowCount=sheet.getPhysicalNumberOfRows();
		
			int columnCount;
			for(int i=1; i<rowCount;i++) {
				Product product = new Product();//텅빈 VO준비하기 채워넣기 위해
				//컬럼 수 만큼 반복문 처리
				XSSFRow row = sheet.getRow(i);//열 하나 얻기 , 컬럼들을 접근하기 위해
				for(int a=0; a<row.getPhysicalNumberOfCells();a++) {
					XSSFCell cell = row.getCell(a);//셀하나에 접근
					
					if(a==0) {//subcategory_id라면
						SubCategory subCategory = new SubCategory();
						subCategory.setSubcategory_id((int)cell.getNumericCellValue());
						product.setSubCategory(subCategory);
					}else if(a==1) {//product_name
						product.setProduct_name(cell.getStringCellValue());
					}else if(a==2) {//price
						product.setPrice((int)cell.getNumericCellValue());
					}else if(a==3) {//brand
						product.setBrand(cell.getStringCellValue());
					}else if(a==4) {
						//엑셀에 입력한 color를 배열로 받자
						String[] colors = cell.getStringCellValue().trim().split(",");//점을 기준으로 나누면, 스트링 배열이 반환됨
						List colorList = new ArrayList();
						for(String color :colors) {
							Color obj = new Color();
							obj.setPicker(color);//하나의 색상 vo에 색상정보를 대입
							colorList.add(obj);
						}
						product.setColorList(colorList);							
					}else if(a==5){//prize
						//엑셀에 입력한 psize가져오기
						String[] psizes = cell.getStringCellValue().trim().split(",");//trim은 공백을 없애버림
						List psizeList = new ArrayList();
						for(String psize :psizes) {
							Psize obj = new Psize();//empty vo
							obj.setFit(psize);//사이즈 정보 넣기
							psizeList.add(obj);
						}
						product.setPsizeList(psizeList);
					}else if(a==6) {//detail
						product.setDetail(cell.getStringCellValue());
					}else if(a==7) {//filename임시 저장
						product.setFilename(cell.getStringCellValue());//엑셀에 들어있는 원본 파일명(ex:tshirt.jpg)
						
					}
				}
				//완성된 상품을 리스트에 담자
				productList.add(product);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return productList;
	}
}
