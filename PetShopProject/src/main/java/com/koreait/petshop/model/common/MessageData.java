package com.koreait.petshop.model.common;

import lombok.Data;

//json�� �񵿱������� �����Ҷ�, result, msg, url�� �����Ѵ�

public class MessageData {
	private int resultCode; //���� ���� ���� �ڵ�
	private String msg;//Ŭ���̾�Ʈ�� ���Ե� �޽���
	private String url;//���Ӱ� ��û �������� �ִٸ� 
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
