package com.koreait.fashionshop.common;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

//��¥ , ��ȭ �� ���� ����ϴ� ǥ�⿡ ���� ó��
public class Formatter {

	
	//���ڸ� �ش�ý����� ��ȭ�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼���
	public static String getCurrency(long number) {//3�ڸ� ���� ��ǥ ó��
		String currency = Currency.getInstance(Locale.KOREA).getSymbol();//�ش� ���� ��ȭ ��ȯ
		DecimalFormat df = new DecimalFormat("###,###.###");
																				//234,345.222
		String result = currency+df.format(number);
		return result;
	}
	

}
