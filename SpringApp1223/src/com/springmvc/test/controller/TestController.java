package com.springmvc.test.controller;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*이 클래스는 요청을 실제적으로 처리하는 컨트롤러임을 명시
 * 추구하는 목표 :POJO(Plane Old Java Object)기기반으로 가려는 경향이 강함*/

public class TestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계 : 알맞는 로직객체에 일 시킨다
		String msg ="안녕";
		System.out.println(msg);
		
		//4단계 : 저장할 것이 있다면 request객체에 저장
		ModelAndView mav = new ModelAndView();//request를 명시 하지 않아도됨 다 저장되어 있음
		mav.addObject("msg",msg);//Model에 담아진다
		
		//상위 컨트롤러가 어떤 페이지를 보여줘야 할지에 대한 정보는 여전히
		mav.setViewName("test/result");//페이지 명시,key값=dispatcher-servlet.xml에서 접두어와 접미어를 뺀 이름으로 한다
	
		
		return mav;
	}

}
