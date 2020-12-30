<%@page import="com.study.springfinal.domain.Emp"%>
<%@page import="com.study.springfinal.domain.Dept"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.koreait.mylegacy.mybatis.config.MybatisConfigManager"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%!
	//선언부
	MybatisConfigManager manager = MybatisConfigManager.getInstance();
	
%>
<%
	//오라클 접속이 되는지 확인
	//InitialContext context = new InitialContext();
	//DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
	//out.print(ds.getConnection());
	
	//service메서드 영역
	SqlSession sqlSession= manager.getSqlSession();
	List<Dept> list= sqlSession.selectList("Emp.selectAll");
	out.print("검색된 총 사원 수"+list.size());
	
	
%>



