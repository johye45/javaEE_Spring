package com.koreait.fashionshop.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//회원과 관련된 모든 요청 처리
@Controller
public class MemberController {
	
	//회원가입폼 요청
	@RequestMapping(value="/shop/member/registForm", method=RequestMethod.GET)
	public String getRegistForm() {
		return "shop/member/signup";
		
	}
}
