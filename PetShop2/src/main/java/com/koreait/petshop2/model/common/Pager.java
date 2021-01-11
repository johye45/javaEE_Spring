//����¡ ó���� ���뼺�� ���� Ŭ���� ����
package com.koreait.petshop2.model.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
@Data
public class Pager {
	private int totalRecord ;//�� ���ڵ� �� 
	private int pageSize=10;//�������� ������ ���ڵ� �� 
	private int totalPage;//�� ���ڵ���� ���������� ���� ������ �ø�
	private int blockSize=10;//�÷��� ������ ������ ��
	private int currentPage = 1;//���� ������
	private int firstPage;//������������ ���� ������ ��(���� �����ִ� �������� 18�̶�� ���۹�ȣ�� 11����)
	private int lastPage;//������ ������ ���� ��� 20, 30, �̷��� , blockSize�� 10�̴ϱ�
	private int curPos;//�������� List������ ���� index
	private int num ;//�������� ���� ��ȣ

	//����� ���� �ʱ�ȭ
	public void init(HttpServletRequest request, List list) {
		totalRecord = list.size();//�Ѱܹ��� list�� ���� �´�
		totalPage = (int)Math.ceil((float)totalRecord/pageSize);
		
		//�������� ������ ��쿣, �� ���õ� �������� ��ü
		if(request.getParameter("currentPage")!=null) {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}

		firstPage=currentPage-(currentPage-1)%blockSize;
		lastPage = firstPage+(blockSize-1);
		curPos=(currentPage-1)*pageSize;
		num = totalRecord-curPos;
	}

	
}
