package com.koreait.petshop2.model.common;

import lombok.Data;

//json�� �񵿱������� �����Ҷ�, result, msg, url�� �����Ѵ�
@Data
public class MessageData {
	private int resultCode; //���� ���� ���� �ڵ�
	private String msg;//Ŭ���̾�Ʈ�� ���Ե� �޽���
	private String url;//���Ӱ� ��û �������� �ִٸ� 
}
