package com.koreait.fashionshop.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//ȸ���� ���õ� ��� ��û ó��
@Controller
public class MemberController {
	
	//ȸ�������� ��û
	@RequestMapping(value="/shop/member/registForm", method=RequestMethod.GET)
	public String getRegistForm() {
		return "shop/member/signup";
		
	}
}
