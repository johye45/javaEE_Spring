<%@page import="com.koreait.fashionshop.model.domain.TopCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	List<TopCategory> topList = (List)request.getAttribute("topList");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../inc/header.jsp" %>
<style>
input[type=text], select, textarea {
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
/*드래그 관련*/
#dragArea{
	width:100%;
	height:300px;
	overflow:scroll;
	border:1px solid #ccc;
	float:left;
}
.dragBorder{
	background:#ffffff;
}

/*박스 크기 설정*/
.box{
	width:150px;
	float:left;
	padding:5px;
}
/*이미지 크기 설정*/
.box >img{
	width:100%;
}	
.close{
	cursor:pointer;
}
</style>
<script type="text/javascript">
var uploadFiles=[];//이미지 미리보기 목록
var psize=[] ;//유저가 선택한 사이즈를 담는 배열

$(function(){
	CKEDITOR.replace("detail");	
	
	//상위 카테고리 선택하면 하위 카테고리가 비동기로 불령ㅎㅁ
	$($("select")[0]).change(function(){
		//비동기 방식으로 서버에 요청하되, 순서 ajax보다는 jqeuery ajax를 이용하자
		getSubList(this);
	});

	/*드래그 관련 이벤트*/
	$("#dragArea").on("dragenter", function(e){//드래그로 영역에 진입했을때 
		$(this).append("dragenter<br>");
		$(this).addClass("dragBorder");
	});
	
	$("#dragArea").on("dragover", function(e){//드래그 영역 위에 있는 동안
		e.preventDefault();//여타 다른 이벤트를 비활성화 시키자
		//$(this).append("dragover<br>");
	});
	
	$("#dragArea").on("drop", function(e){//드래그영역 위에서 이미지를 떨구면
		e.preventDefault();//여타 다른 이벤트를 비활성화 시키자
		$(this).append("drop<br>");
		
		//자바스크립트로 드래그된 이미지 정보를 구해와서, div영역에 미리보기 효과
		var fileList = e.originalEvent.dataTransfer.files;//드래그한 파일들에 대한 배열 얻기
		console.log(fileList);
		
		//배열안에 들어있는 이미지들에 대한 미리보기처리, 이미지 하나하나 끄집어내기
		for(var i=0; i<fileList.length;i++){
			uploadFiles.push(fileList[i]);//fileList를 일반배열(uploadFiles)에 담기
			//왜? 배열이 지원하는 여러 메서드들을 화룡하기 위해(ex:indexOf사용하려고)
			preview(uploadFiles[i],i);//index번호 넘기기
		}
	})
	
	$("#dragArea").on("dragleave", function(e){//드래그로 영역에서 빠져나감
		$(this).append("dragleave<br>");
		$(this).removeClass("dragBorder");
	});
	
	//이미지 삭제 이벤트 처리
	$("#dragArea").on("click",".close", function(e){//close 클래스로 접근
		console.log(e);
		
		//대상 요소 배열에서 삭제
		//삭제 전에 uploadFiles라는 배열에 들어있는 file의 index를 구하자
		var f = uploadFiles[e.target.id];
		//우리가 지울 인덱스
		var index = uploadFiles.indexOf(f);//파일 객체가 몇번째 들어있는지 추출, index는 동적으로 변하기 때문에
		
		//alert(e.target.id+"눌렀어?");
		uploadFiles.splice(index,1);//인덱스,몇개
		
		//대상 요소 삭제 - 시각적으로 삭제
		$(e.target).parent().remove();//X를 감싸고 있는 전체 부모를 지우기 즉 box지우자
		
	
	});
	
	//체크박스 이벤트 구현
	$("input[type='checkbox']").on("click", function(e){
		var ch = e.target;//이벤트 일으킨 주체 컴포넌트 즉 체크박스
		//체크박스 길이 얻기
		var ch = $("input[name='size']");
		var len = $(ch).length;//반복문 이용
		console.log(len);
		

		psize=[];//psize초기화
		console.log("채우기 전 ", psize.length);
		
		for(var i=0; i<len; i++){
			//만일 체크가 되어있다면, 기존 배열을 모두 지우고, 체크된 체크박스 값만 배열에 넣자
			if($($(ch)[i]).is(":checked")){
				psize.push($($(ch)[i]).val());
			}
			//console.log(i,"번째 체크박스 상태는:",$($(ch)[i]).is(":checked"));
		}
		console.log("서버에 전송할 사이즈 배열의 구성은:",psize);
	
	});
	
});

//업로드 이미지 미리보기
function preview(file,index){
	//js로 이미지 미리보기를 구현하려면, 파일리더를 이용하면 된다 FileReader
	var reader = new FileReader();//아직 읽을 대상 파일이 결정되지 않음
	//파일을 읽어들이면, 이벤트 발생시킴
	reader.onload=function(e){
		//console.log(e);//이벤트 정보
		//console.log(reader.result);//console.log(this)에서 result가 이미지 정보임
		//console.log(e.currentTarget.result);//위와 같은 이미지 정보! 이벤트 객체로 진입
	
		var tag ="<div class=\"box\">";
		tag += "<div class=\"close\" id=\""+index+"\">X</div>";//이미지를 지우기 위해 div로 감싸기
		tag+="<img src=\""+e.currentTarget.result+"\">";
		tag+="</div>";
		$("#dragArea").append(tag);
	};
	reader.readAsDataURL(file);//지정한 파일을 읽는다(매개변수로 파일이 와야함)
	
}

//비동기 방식으로 하위 카테고리 요청하기
function getSubList(obj){
	//alert($(obj).val());
	
	$.ajax({
		url:"/admin/product/sublist", 
		type:"get",
		data:{
			topcategory_id:$(obj).val()			
		},
		success:function(result){
			//alert("서버로 부터 받은 결과는 "+result);
			//서버가 이미  json 으로 전송해주었으므로 별도의  parsing이 필요없다!!
			//기존 option태그를 먼저 지우자!!
			$($("select")[1]).empty();
			$($("select")[1]).append("<option>하위카테고리 선택</option>");
			
			for(var i=0;i<result.length;i++){
				var subCategory = result[i]; //subcategory 1건에 대한 json 객체얻기!!
				$($("select")[1]).append("<option value=\""+subCategory.subcategory_id+"\">"+subCategory.name+"</option>");
			}
		}
	});
}

//사이즈 선택시 배열 재구성 하기
function setPsizeArray(){
	
}

function regist(){
	/*비동기 전송시, 기존의 form을 이용할 수 있다*/
	//$("textarea").val(CKEDITOR.instances.detail.getData());//상세내용 ckditor사용시!db에 담기위해
	
	var formData = new FormData($("form")[0]);//<form>태그가 아니다, 전송할때 파라미터들을 담을 수 있지만 이 자체가 폼태그XX
	
	//미리보기했던이미지들은 파일컴포넌트화 되어있지 않기 때문에, 전송데이터에서 빠져있다
	//따라서 formData전송전에, 동적으로 파일 컴포넌트화 시켜 formData에 추가하자
	//java에서의 improved for문과 동일한 역할(주로 컬렉션에서 객체를 꺼낼때 편하게 사용)
	$.each(uploadFiles,function(i,file){//집합, 익명함수(횟수인덱스, 끄집어낸 요소 file)
		formData.append("addImg",file,file.name);//이미지 컴포넌트 컴포넌트명<input type ="file" name="addImg">, 업로드할 파일 객체, 파일명 		
		console.log(file.name);//추가이미지 파일이름
	});

	//폼데이터에 에디터긔 값 추가하기
	formData.append("detail", CKEDITOR.instances["detail"].getData());
	for(var i = 0; i<psize.length;i++){
		formData.append("psize["+i+"].fit",psize[i]);//psize.fit(Psize객체의 fit안에 ) 이름으로 psize배열 (psize배열은 전역변수)	
	}

	/*
	"test"는 name
	아래의 코드와 같은 내용
	input type ="checkbox" name="test" value="banana"
	input type ="checkbox" name="test" value="apple"
	input type ="checkbox" name="test" value="orange"
	*/
	
	
	/*비동기 업로드*/
	$.ajax({
		url:"/admin/product/regist",
		data:formData,
		//아래 두개는 같이 지정해줘야 함
		contentType:false,//false일 경우 multipart/form-data로 간주하기로 함
		processData:false,//false일 경우 query-string으로 전송하지 않음==get방식으로가 아니라 post방식으로,
		type:"post",
		success:function(responseData){
			console.log(responseData);
			//responseData.result; //성공실패 여부를 판단할 수 있는 데이터
			var json = JSON.parse(responseData);//String->json으로 파싱
			if(json.result==1){
				alert(json.msg);
				location.href="/admin/product/list";
			}else{
				alert(json.msg);
			}
		}
	});
	
	/* 동기 방식
	$("form").attr({
		action:"/admin/product/regist",
		method:"post",
		enctype:"multipart/form-data"
		
	});
	$("form").submit();
	*/
}
</script>
</head>
<body>
<%@ include file="../inc/main_navi.jsp" %>

<h3>Contact Form</h3>
<div class="container">
  <form>
  	
  	<select>
  		<option>상위카테고리 선택</option>
  		<%for(TopCategory topCategory : topList){%>
  		<option value="<%=topCategory.getTopcategory_id()%>"><%=topCategory.getName() %></option>
  		<%} %>
  	</select>
  	<select name="subCategory.subcategory_id">
  		<option>하위카테고리 선택</option>
  	</select>
   <input type="text" name="product_name" placeholder="상품명">
    <input type="text" name="price" placeholder="가격">
    <input type="text" name="brand" placeholder="브랜드">
	<!-- 파일 최대 4개까지 지원 -->
	<p>대표이미지: <input type="file" name="repImg"></p>
	
	<div id="dragArea" >
		<!-- 이미지 미리 보기 영역 -->
		
	</div>
	
	<!-- 지원 사이즈 선택  -->
	<p>
	상의 사이즈:
		XS<input type="checkbox" 	name="size"	value="XS">
		S<input type="checkbox"	 	name="size"	value="S">
		M<input type="checkbox"		name="size"	value="M">
		L<input type="checkbox"		name="size"	value="L">
		XL<input type="checkbox"	name="size"	value="XL">
		XXL<input type="checkbox"	name="size"	value="XXL">

	</p>
	
	<p>
		지원 색상 선택:
		<input type="color" name="color[0].picker" value="#ccfefe">
		<input type="color" name="color[1].picker" value="#ffffff">
		<input type="color" name="color[2].picker" value="#000000">
		<input type="color" name="color[3].picker" value="#fdfdfd">
		<input type="color" name="color[4].picker" value="#0000ff">
		<input type="color" name="color[5].picker" value="#ff0000">
	</p>	
    
    <textarea id="detail" name="detail" placeholder="상세정보.." style="height:200px"></textarea>
    <input type="button" value="상품등록" onClick="regist()">
    <input type="button" value="상품목록보기" onClick="location.href='/admin/product/list'">
  </form>
</div>

</body>
</html>