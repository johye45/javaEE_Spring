<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
function regist(){
	var form = document.querySelector("form");
	form.action="/emp/regist";
	form.method="post";
	form.submit();
}
</script>
</head>
<body>
	[ 입사등록 양식 ]
	
	<form>
		<input type="text" name="deptno" value="50"><p>	
		<input type="text" name="dname" value="MARKETING"><p>		
		<input type="text" name="loc" value="KOREA"><p>	
		
		<input type="text" name="empno" value="7777"><p>
		<input type="text" name="ename" value="batman"><p>
		<input type="text" name="sal" value="8900"><p>
		<button type="button" onClick="regist()">사원등록</button>
	</form>
</body>
</html>