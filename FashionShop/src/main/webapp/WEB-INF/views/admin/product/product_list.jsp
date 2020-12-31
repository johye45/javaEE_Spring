<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="../inc/header.jsp" %>
<script>
	$(function(){
		$("button").click(function(){
			location.href="/admin/product/registform";//글쓰기 폼 요청
			
		});
		
	});

</script>
</head>
<body>


<!--  관리자 상품관리 페이지-->
<%@include file="../inc/main_navi.jsp" %>

<h3>상품 목록</h3>
<p>
	<table>
		<tr>
			  <th>First Name</th>
			  <th>Last Name</th>
			  <th>Points</th>
			  <th>Points</th>
			  <th>Points</th>
		</tr>
		<tr>
			  <td>Jill</td>
			  <td>Smith</td>
			  <td>50</td>
			  <td>50</td>
			  <td>50</td>
		</tr>
	</table>
	<tr>
		<td colspan="5">
			<button type="button">상품등록</button>
		</td>
	</tr>
</p>

</body>
</html>
