<%@page import="com.koreait.mvclegacy.model.domain.Notice"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	List<Notice> noticeList =  (List)request.getAttribute("noticeList");
	

%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</head>
<body>

	<table>
		<tr>
			<th>No</th>
			<th>title</th>
			<th>writer</th>
			<th>regdate</th>
			<th>hit</th>
		</tr>
		<%for(Notice notice : noticeList){ %>
		<tr>
			<th><%=notice.getNotice_id() %></th>
			<th><a href ="/client/notice/detail?notice_id=<%=notice.getNotice_id()%>"><%=notice.getTitle()%></th>
			<th><%=notice.getWriter() %></th>
			<th><%=notice.getRegdate() %></th>
			<th><%=notice.getHit() %></th>
			<th>Last Name</th>
			<th>Points</th>
		</tr>
		<%} %>
		<tr>
			<td colspan="6" style="text-align:center">
				[1][2][3]
			</td>
		</tr>
		<tr>
			<td colspan="6">
				<button onClick="location.href='/client/notice/registform'"> 글등록</button>
			</td>
		</tr>
	</table>

</body>
</html>