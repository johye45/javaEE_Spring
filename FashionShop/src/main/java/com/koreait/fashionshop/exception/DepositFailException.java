package com.koreait.fashionshop.exception;


//�Ա��Ҷ� ����
public class DepositFailException extends RuntimeException{

	public DepositFailException(String msg) {
		super(msg);
		
	}
	
	public DepositFailException(String msg, Throwable e) {
		super(msg, e);
	}
}
