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
	List<Dept> list= sqlSession.selectList("Dept.selectAll");
	out.print("검색된 총 사원 수"+list.size());
	
	
%>
<table border="1px">
	<tr>
		<td>부서번호</td>
		<td>부서명</td>
		<td>부서위치</td>
		<td>사원정보</td>
	</tr>
	<%for(int i=0;i<list.size();i++){ %>
	<%Dept dept=list.get(i);%>
	<tr>
		<td><%=dept.getDeptno() %></td>
		<td><%=dept.getDname() %></td>
		<td><%=dept.getLoc() %></td>
		<td>
			<table>
				<%List<Emp> empList = dept.getEmpList(); %>
				<%for(int a=0;a<empList.size();a++){ %>
				<%Emp emp = empList.get(a); %>
				<tr>
					<td><%=emp.getEmpno()%></td>
					<td><%=emp.getEname()%></td>
					<td><%=emp.getHiredate()%></td>
					<td><%=emp.getSal()%></td>
					<td><%=emp.getMgr()%></td>
					<td><%=emp.getComm()%></td>
				</tr>
				<%} %>
			</table>
		</td>
	</tr>
	<%}%>
</table>


