<%@page import="com.koreait.petshop2.model.domain.Product"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Product> productList  = (List)request.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="./../../inc/header.jsp" %>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<style>
/* 컨테이너 영역 padding */
.container {
  padding: 16px;
  background-color: white;
}
/* 내용 영역 너비 조정 영역*/
input[type=text], input[type=password] {
  width: 99%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
}
select {
	width: 100%;
	padding: 15px;
 	margin: 5px 0 22px 0;
 	display: inline;
  	border: 1px solid #e1e1e1;
  	font-size: 14px;
  	color: #666666;
  	border-radius: 2px;
}
input[type=text]:focus, input[type=password]:focus ,select:focus {
  background-color: #ddd;
  outline: none;
}
.site-btn:hover {
  background-color: #ddd;
}
/* 로딩 바 스타일 영역 */
.loader {
	width: 40px;
	height: 40px;
	position: absolute;
	top: 55%;
	left: 50%;
	margin-top: -13px;
	margin-left: -13px;
	border-radius: 60px;
 	animation: loader 0.8s linear infinite; 
	-webkit-animation: loader 0.8s linear infinite; 	
}
/* 아이디 사용가능한 경우*/
.id_available{
		color : green;
		display : none;
	}
/* 아이디 사용불가능한 경우 */
.id_unavailable{
	color : red;
	display : none;
}
</style>	
<script>
function login(){
	$('#signin_form').attr({
		action:"/shop/member/login",
		method:"post"
	});
}
</script>
</head>
<body>

	<%@ include file="./../../inc/shop_navi.jsp"%>

	<!--상품 시작 -->
	<section class="shop spad">
		<div class="container">
			<div class="row">

				<div class="col-lg-9 col-md-9">
					<div class="row">
					<%for(int i = 0; i<productList.size();i++){ %>
						<div class="col-lg-4 col-md-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="/resources/img/shop/shop-1.jpg">
									<ul class="product__hover">
										<li><a href="/resources/img/shop/shop-1.jpg"
											class="image-popup"><span class="arrow_expand"></span></a></li>
										<li><a href="#"><span class="icon_bag_alt"></span></a></li>
									</ul>
								</div>
								<div class="product__item__text">
									<h6>
										<a href="#">Furry hooded parka</a>
									</h6>
									<div class="rating">
										<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i>
									</div>
									<div class="product__price">$ 59.0</div>
								</div>
							</div>
						</div>
					</div>
					<%} %>
				</div>
			</div>

			<!-- 상품  끝-->
			
			<div class="col-lg-12 text-center">
				<div class="pagination__option">
					<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#"><i
						class="fa fa-angle-right"></i></a>
				</div>
			</div>
			
		</div>
		</div>
		</div>
		</div>
	</section>

	<%@ include file="../shopFooter.jsp"%>
	<%@ include file="./../../inc/footer.jsp"%>

</body>

</html>