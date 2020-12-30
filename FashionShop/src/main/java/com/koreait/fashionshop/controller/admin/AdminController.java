package com.koreait.fashionshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//관리자 페이지를 처리할 컨트롤러
@Controller
public class AdminController {
	
	//관리자 모드 메인 요청
	@RequestMapping("/admin")
	public String adminMain() {
		return "admin/main";
	}
}
