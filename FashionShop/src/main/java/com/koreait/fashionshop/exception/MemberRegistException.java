package com.koreait.fashionshop.exception;


//CRUD�۾��� �߻��Ǵ� ���� 
//��Ͻ� ���� exception
public class MemberRegistException extends RuntimeException{

	public MemberRegistException(String msg) {
		super(msg);
		
	}
	
	public MemberRegistException(String msg, Throwable e) {
		super(msg, e);
	}
}