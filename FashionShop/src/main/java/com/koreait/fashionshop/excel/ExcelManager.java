package com.koreait.fashionshop.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {

	FileInputStream fis;
	
	public ExcelManager() {
		//������ ������ �����ϱ� ���ؼ��� ��Ʈ���� �ʿ���
		try {
			fis = new FileInputStream("D:/workspace/javaee_spring/FashionShop/src/main/webapp/resources/excel/myskill.xlsx");
			//������ �����ϴ� ��ü ���� XSSFWorkbook
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			//���� �������� ������ �����̹Ƿ�, �� �������ʹ� ��Ʈ�� �����Ѵ�
			XSSFSheet sheet = workbook.getSheetAt(0);//ù��° ��Ʈ ����
			
			//�� �������ʹ� sheet�� ������ �� �����Ƿ�, �� ����� �����ϴ��� ���� �˾ƺ���
			int rows = sheet.getPhysicalNumberOfRows();//�����Ͱ� ä���� ��
			
			System.out.println("���ڵ� ��:"+rows);
			
			//�ο�� �÷��� ��ŭ �ݺ��� �����ϸ�, �����͸� �����غ���
			for(int i = 0; i<rows; i++) {
				XSSFRow row = sheet.getRow(i);//�ϳ��� �α��� ����
				
				//�÷��� ��ŭ �ݺ�
				int columnCount = row.getPhysicalNumberOfCells();
				for(int a=0; a<columnCount;a++ ) {
					XSSFCell cell = row.getCell(a);//�÷� �Ѱ��� ����
					
					//�� ���� �ڷ����� �Ǵ��Ͽ� �������� �������� �׿� �°� ����
					if(cell.getCellType()==CellType.STRING) {//���� �ڷ����� ������ ���
						System.out.print(cell.getStringCellValue()+"\t");						
					}else if(cell.getCellType()==CellType.NUMERIC) {
						System.out.print((int)cell.getNumericCellValue()+"\t");
					}
					
				}
				System.out.println();//�ٹٲ�
			}
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		
	}
	
	public static void main(String[] args) {
		new ExcelManager();
	}
}
