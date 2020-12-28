package com.springmvc.test.controller;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*�� Ŭ������ ��û�� ���������� ó���ϴ� ��Ʈ�ѷ����� ���
 * �߱��ϴ� ��ǥ :POJO(Plane Old Java Object)�������� ������ ������ ����*/

public class TestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3�ܰ� : �˸´� ������ü�� �� ��Ų��
		String msg ="�ȳ�";
		System.out.println(msg);
		
		//4�ܰ� : ������ ���� �ִٸ� request��ü�� ����
		ModelAndView mav = new ModelAndView();//request�� ��� ���� �ʾƵ��� �� ����Ǿ� ����
		mav.addObject("msg",msg);//Model�� �������
		
		//���� ��Ʈ�ѷ��� � �������� ������� ������ ���� ������ ������
		mav.setViewName("test/result");//������ ���,key��=dispatcher-servlet.xml���� ���ξ�� ���̾ �� �̸����� �Ѵ�
	
		
		return mav;
	}

}
