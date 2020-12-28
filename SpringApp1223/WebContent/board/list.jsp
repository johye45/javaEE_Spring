
<%@page import="com.model2.domain.Board"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="java.util.List"%>
<%@page import="common.board.Pager"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	//jsp에서는 이미 내장객체로 지원되기 때문에 session으로 사용하면 됨
	List<Board> list = (List)request.getAttribute("boardList");
	out.print("게시물 수는"+list.size());
	Pager pager = new Pager();
	pager.init(request, list); //페이지 처리에 대한 계산!!
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
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<%
			int num=pager.getNum();
			int curPos=pager.getCurPos();
		%>
		<%for(int i=1;i<=pager.getPageSize();i++){ %>
		<%if(num<1)break;%>
		<%Board board=(Board)list.get(curPos++); %>
		<tr>
			<td><%=num--%></td>
			<td><a href="/board/detail?board_id=<%=board.getBoard_id()%>"><%=board.getTitle() %></a>[<%=board.getCnt()%>]</td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getRegdate().substring(0,10) %></td>
			<td><%=board.getHit() %></td>
		</tr>
		<%} %>
				<tr>
			<td colspan="6" style="text-align:center">
			<%if((pager.getFirstPage()-1)>=1){ %>
				<a href = "/board/list.jsp?currentPage=<%=pager.getFirstPage()-1%>">◀</a>
			<%}else{ %>
				<a href ="javascript:alert('처음 페이지입니다.')">◀</a>
			<%} %>
			<%for(int i=pager.getFirstPage();i<pager.getLastPage();i++){ %>
				<%if(i>pager.getTotalPage())break; %>
				<a href ="/board/list.jsp?currentPage=<%=i%>" <% if(pager.getCurrentPage()==i){%>class="pageNum"<%} %>>[<%=i %>]</a>
			<%} %>
			<%if((pager.getLastPage()+1)<pager.getTotalPage()){ %>
				<a href = "/board/list.jsp?currentPage=<%=pager.getFirstPage()-1%>">▶</a>
			<%}else{ %>	
				<a href ="javascript:alert('마지막 페이지입니다.')">▶</a>
			<%} %>
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<button onClick="location.href='regist_form.jsp'">글등록</button>
			</td>
		</tr>
	</table>
</body>
</html>
