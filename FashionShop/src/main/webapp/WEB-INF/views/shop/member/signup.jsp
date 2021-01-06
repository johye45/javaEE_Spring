<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Karl - Fashion Ecommerce Template | Home</title>

	<!--현재 index.jsp를 기준으로해서 -->
   <%@include file="../inc/header.jsp" %>
   
 <style>

input[type=text], select, textarea, input[type=password]{
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 120px;
  height: 120px;
  -webkit-animation: spin 2s linear infinite; /* Safari */
  animation: spin 2s linear infinite;
}

/* Safari */
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>
<script>
	$(function(){
		//회원가입 처리
		$("input[type='button']").click(function(){
			regist();
		});
	});
	
	//요청이 완료되는 시점에 로딩바를 감춘다!!
	function regist(){
		//비동기 방식으로 해야 로딩바를 사용할 수 있다
		
		//로딩바 시작
		$("#loader").addClass("loader");//class동적 적용
		
		//form태그의 파라미터들을 전송할 수 있는 상태로 둬야 data키값에 form자체를 넣을 수 있다
		var formData = $("#member_form").serialize();//전부 문자열화 시킨다
		
		$.ajax({
			url:"/shop/member/regist",
			type:"post",
			data:formData,
			success:function(responseData){
				//서버로부터 완료 응답을 받으면 로딩바 효과를 중단
				$("#loader").removeClass("loader");
				var json = JSON.parse(responseData);
				if(json.result==1){
					alert(json.msg);
					location.href="/";
				}else{
					alert(json.msg);
				}
			}
		});
		
		
		/*
		//동기 방식
		$("#member_form").attr({
			action:"/shop/member/regist",
			method:"post"
		});
		$("#member_form").submit();
		*/
	}
</script>
</head>

<body>
    <!-- ****** Top Discount Area End ****** -->
	<%@include file="../inc/top.jsp" %>
	
	<div class="container">
	<div id="loader" style="margin:auto"></div>
	  <form id="member_form">
		    <input type="text"  			name="user_id" 		placeholder="Your ID">
		   	<input type="text"  			name="name" 			placeholder="Your name..">
		   	<input type="password" 	name="password" 	placeholder="Your Password">
		   	<input type="text"  			name="email_id" 		placeholder="email_id">
		     <select name="email_server">
			      <option value="gmail.com">gmail.com</option>
			      <option value="daum.net">daum.net</option>
			      <option value="naver.com">naver.com</option>
		    </select>
		   	<input type="text"  			name="zipcode" 		placeholder="우편번호">
		   	<input type="text"  			name="addr" 		placeholder="주소">
		    <input type="button" 		value="가입하기">
	  </form>
</div>
	

     <!-- ****** Footer Area Start ****** -->
     	<%@include file="../inc/footer.jsp" %>
     <!-- ****** Footer Area End ****** -->
    </div>
    <!-- /.wrapper end -->

</body>

</html>