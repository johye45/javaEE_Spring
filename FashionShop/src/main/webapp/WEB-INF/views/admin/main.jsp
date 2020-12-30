<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="./inc/header.jsp" %>
</head>
<body>
<!-- 관리자 메인 -->

<!--main_navi영역  ,  웹사이트의 루트를 기준으로한 경로는 막혀있다, 따라서 상대경로로 가자
main.jsp입장에서 /경로를 쓰지 않고(웹인경우에 웹사이트의 루트를 말한다==views==보안된 폴더) ./한다-->
<%@include file="./inc/main_navi.jsp" %>

<h3>Dropdown Menu inside a Navigation Bar</h3>
<p>Hover over the "Dropdown" link to see the dropdown menu.</p>

</body>
</html>
