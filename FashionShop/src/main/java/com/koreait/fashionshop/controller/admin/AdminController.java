package com.koreait.fashionshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//������ �������� ó���� ��Ʈ�ѷ�
@Controller
public class AdminController {
	
	//������ ��� ���� ��û
	@RequestMapping("/admin")
	public String adminMain() {
		return "admin/main";
	}
}
