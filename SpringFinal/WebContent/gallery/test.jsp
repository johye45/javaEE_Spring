<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	InitialContext context = new InitialContext();
	DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
	out.print(ds.getConnection());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>

</style>
<script>

</script>
</head>
<body>

</body>
</html>