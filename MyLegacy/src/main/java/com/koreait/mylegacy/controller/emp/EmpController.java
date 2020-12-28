package com.koreait.mylegacy.controller.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mylegacy.model.dao.JdbcDeptDAO;
import com.koreait.mylegacy.model.domain.Dept;
import com.koreait.mylegacy.model.domain.Emp;


//component-scan에 등록하려면 Controller 어노테이션
@Controller
public class EmpController {
	@Autowired
	private JdbcDeptDAO jdbcDeptDAO;
	
	//regist_form.jsp를 불러
	@RequestMapping("/emp/registForm")//method 디폴트값은 Get
	public String registForm() {
		return "emp/regist_form";
	}
	
		@RequestMapping(value = "/emp/regist", method = RequestMethod.POST)
	public String regist(Dept dept, Emp emp) {
		//파라미터 받아와 출력해보기
		System.out.println(dept.getDeptno());
		System.out.println(dept.getDname());
		System.out.println(dept.getLoc());
		
		System.out.println(emp.getEmpno());
		System.out.println(emp.getEname());
		System.out.println(emp.getSal());
		System.out.println(emp.getDeptno());
	
	
		//DB에 등록
		System.out.println("jdbcDeptDAO: "+jdbcDeptDAO);
		jdbcDeptDAO.regist(dept);
		
		return null;
	}
}
