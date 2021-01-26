package com.koreait.fashionshop.model.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

/*
 * �ϴ� ��ȣȭ �� ���Ŀ�, ��ȣȭ ��ų �� ���� SHA256�˰������� ȸ���� ��й�ȣ�� ��ȣȭ ��Ű�� 
 * */
@Component
public class SecureManager {
	
	
	public String getSecureData(String password) {//�츮�� ���� ���� password
		
		StringBuffer sb = new StringBuffer();//���ڿ��� ������ų ��ü	
		
		//�޽����� ��ȣȭ �����ִ� ��ü
		try {
			MessageDigest digest= MessageDigest.getInstance("SHA-256");
			byte[] data = password.getBytes("UTF-8");//��ȣ �ɰ���(byte�� �迭��)
			byte[] hash = digest.digest(data);//��ȣȭ�۾�
			
			//�ɰ��� �����͸� ������� 16���� ������ ��ȯ
			for(int i =0; i<hash.length;i++) {
				String hex = Integer.toHexString(0xff &hash[i]);//16���� ���ڿ���(������) �ٲ��ִ� �޼���
				//System.out.println(hex);//�߰�����
				if(hex.length()==1) {
					sb.append("0");
				}
				sb.append(hex);
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}

//	public static void main(String[] args) {
//		String result = new SecureManager().getSecureData("bananaking");
//		System.out.println(result);
//	}
}
