/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-01-15 04:07:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.shop.cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.common.Pager;
import com.koreait.petshop.model.common.Formatter;
import com.koreait.petshop.model.domain.Cart;
import java.util.List;

public final class cart_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/views/shop/cart/../shopFooter.jsp", Long.valueOf(1610679240000L));
    _jspx_dependants.put("/WEB-INF/views/shop/cart/./../../inc/footer.jsp", Long.valueOf(1610679240000L));
    _jspx_dependants.put("/WEB-INF/views/shop/cart/./../../inc/shop_navi.jsp", Long.valueOf(1610679240000L));
    _jspx_dependants.put("/WEB-INF/views/shop/cart/./../../inc/header.jsp", Long.valueOf(1610679240000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.koreait.petshop.model.domain.Member");
    _jspx_imports_classes.add("com.koreait.petshop.model.common.Formatter");
    _jspx_imports_classes.add("com.koreait.petshop.model.domain.Cart");
    _jspx_imports_classes.add("com.koreait.petshop.model.common.Pager");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

//장바구니에 상품이 담기긴 해요 ? 아니요 그럼 담는 쪽붙처 확인해ㅘ봐야 해요 
//Pager pager = (Pager)request.getAttribute("pager");
//List<Cart> cartList = pager.getList();
List<Cart> cartList = (List) request.getAttribute("cartList");
Member member=(Member)session.getAttribute("member");
String a = request.getParameter("quantity");


      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<meta name=\"description\" content=\"Ashion Template\">\n");
      out.write("    <meta name=\"keywords\" content=\"Ashion, unica, creative, html\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("    <title>Ashion | Petshop</title>\n");
      out.write("\n");
      out.write("    <!-- Google Font -->\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Cookie&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap\"\n");
      out.write("    rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Css Styles -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/css/bootstrap.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/css/font-awesome.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/css/elegant-icons.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/css/jquery-ui.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/css/magnific-popup.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/css/owl.carousel.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/css/slicknav.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/css/style.css\" type=\"text/css\">\n");
      out.write("    \n");
      out.write("     <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.ckeditor.com/4.15.1/standard/ckeditor.js\"></script>\n");
      out.write("    ");
      out.write("\n");
      out.write("<script>\n");
      out.write(" \n");
      out.write("\t//장바구니 비우기\n");
      out.write("\tfunction delCart() {\n");
      out.write("\t\tif (confirm(\"장바구니를 모두 비우시겠습니까?\")) {\n");
      out.write("\t\t\tlocation.href = \"/shop/cart/del\";\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("\t//수량변경\n");
      out.write("\tfunction editCart(){\n");
      out.write("\t\tif(confirm(\"주문 수량을 변경하시겠어요?\")){\n");
      out.write("\t\t\t$(\"#cart-form\").attr({\n");
      out.write("\t\t\t\taction:\"/shop/cart/edit\",\n");
      out.write("\t\t\t\tmethod:\"post\"\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t$(\"#cart-form\").submit();\n");
      out.write("\t\t}\t\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfunction delOneCart(cart_id){\n");
      out.write("\t\tif(confirm(\"삭제?\")){\n");
      out.write("\t\t\tlocation.href=\"/shop/cart/Onedel?cart_id=\"+cart_id;\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("\tfunction checkoutForm(){\n");
      out.write("\t\tlocation.href=\"/shop/payment/form\";\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t");
      out.write("\n");
      out.write("<!-- Page Preloder -->\n");
      out.write("\n");
      out.write(" <!-- Offcanvas Menu Begin -->\n");
      out.write("    <div class=\"offcanvas-menu-overlay\"></div>\n");
      out.write("    <div class=\"offcanvas-menu-wrapper\">\n");
      out.write("        <div class=\"offcanvas__close\">+</div>\n");
      out.write("        <ul class=\"offcanvas__widget\">\n");
      out.write("            <li><span class=\"icon_search search-switch\"></span></li>\n");
      out.write("            <li><a href=\"#\"><span class=\"icon_heart_alt\"></span>\n");
      out.write("                <div class=\"tip\">2</div>\n");
      out.write("            </a></li>\n");
      out.write("            <li><a href=\"/shop/cart/list\"><span class=\"icon_bag_alt\"></span>\n");
      out.write("                <div class=\"tip\">2</div>\n");
      out.write("            </a></li>\n");
      out.write("        </ul>\n");
      out.write("        <div class=\"offcanvas__logo\">\n");
      out.write("            <a href=\"/\"><img src=\"/resources/img/logo.png\" alt=\"\"></a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"mobile-menu-wrap\"></div>\n");
      out.write("        <div class=\"offcanvas__auth\">\n");
      out.write("            <a href=\"/shop/member/loginForm\">Login</a>\n");
      out.write("            <a href=\"/shop/member/registForm\">Register</a>\n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- Offcanvas Menu End -->\n");
      out.write("\n");
      out.write("    <!-- Header Section Begin -->\n");
      out.write("    <header class=\"header\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-xl-3 col-lg-2\">\n");
      out.write("                    <div class=\"header__logo\">\n");
      out.write("                        <a href=\"/\"><img src=\"/resources/img/logo.png\" alt=\"\"></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-xl-6 col-lg-7\">\n");
      out.write("                    <nav class=\"header__menu\">\n");
      out.write("                        <ul>\n");
      out.write("                        \t<li></li>\n");
      out.write("                            <li class=\"active\"><a href=\"/\">Home</a></li>\n");
      out.write("                            <li><a href=\"/shop/product/listAll\">옷</a>\n");
      out.write("                                <ul class=\"dropdown\">\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=1\">패딩</a></li>\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=2\">나시</a></li>\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=3\">점프수트</a></li>\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=4\">원피스</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"/shop/product/listAll\">사료</a>\n");
      out.write("                                <ul class=\"dropdown\">\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=5\">연어</a></li>\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=6\">소고기</a></li>\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=7\">양고기</a></li>\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=8\">닭고기</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"/shop/product/listAll\">간식</a>\n");
      out.write("                                <ul class=\"dropdown\">\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=9\">츄잉껌</a></li>\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=10\">츄르</a></li>\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=11\">소시지</a></li>\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=12\">육포말이</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"/shop/product/listAll\">악세서리</a>\n");
      out.write("                                <ul class=\"dropdown\">\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=13\">모자</a></li>\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=14\">목걸이</a></li>\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=15\">펫스텝</a></li>\n");
      out.write("                                    <li><a href=\"/shop/product/list?subcategory_id=16\">철망</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <!-- <li><a href=\"/\">Shop</a></li> -->\n");
      out.write("                            <li><a href=\"/shop/cart/list\">Cart</a>\n");
      out.write("                               <!--  <ul class=\"dropdown\">\n");
      out.write("                                    <li><a href=\"./product-details.html\">Product Details</a></li>\n");
      out.write("                                     <li><a href=\"/shop/cart/list\">Cart</a></li>\n");
      out.write("                                    <li><a href=\"./checkout.html\">Checkout</a></li>\n");
      out.write("                                    <li><a href=\"./blog-details.html\">Blog Details</a></li>\n");
      out.write("                            <li><a href=\"./blog.html\">Blog</a></li>\n");
      out.write("                            <li><a href=\"./contact.html\">Contact</a></li>\n");
      out.write("                                </ul> -->\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("                 <div class=\"col-lg-3\">\n");
      out.write("                    <div class=\"header__right\">\n");
      out.write("                        <div class=\"header__right__auth\">\n");
      out.write("                            ");
if(session.getAttribute("member")==null){ 
      out.write("\n");
      out.write("            \t\t\t\t\t<a href=\"/shop/member/loginForm\">Login</a>\n");
      out.write("                            \t<a href=\"/shop/member/registForm\">Register</a>\n");
      out.write("            \t\t\t\t");
}else{ 
      out.write("\n");
      out.write("            \t\t\t\t\t<a href=\"/shop/member/logout\">LogOut</a>\n");
      out.write("            \t\t\t\t\t<a href=\"/shop/member/mypage_order\">MyPage</a>\n");
      out.write("        \t\t\t\t\t");
} 
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <ul class=\"header__right__widget\">\n");
      out.write("                            <li><span class=\"icon_search search-switch\"></span></li>\n");
      out.write("                            <li><a href=\"#\"><span class=\"icon_heart_alt\"></span>\n");
      out.write("                                <div class=\"tip\">2</div>\n");
      out.write("                            </a></li>\n");
      out.write("                            <li><a href=\"#\"><span class=\"icon_bag_alt\"></span>\n");
      out.write("                                <div class=\"tip\">2</div>\n");
      out.write("                            </a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"canvas__open\">\n");
      out.write("                <i class=\"fa fa-bars\"></i>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </header>\n");
      out.write("    <!-- Header Section End -->");
      out.write("\n");
      out.write(" \t\n");
      out.write("    <div class=\"breadcrumb-option\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <div class=\"breadcrumb__links\">\n");
      out.write("                        <a href=\"../../\"><i class=\"fa fa-home\"></i> Home</a>\n");
      out.write("                        <span>Shopping cart</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\t<!-- Breadcrumb End -->\n");
      out.write("\n");
      out.write("\t<!-- Shop Cart Section Begin -->\n");
      out.write("\t<section class=\"shop-cart spad\">\n");
      out.write("\t\t\t<form id=\"cart-form\">\n");
      out.write("\t\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t\t<p style=\"font-family:Geneva;\" >");
      out.print(member.getName());
      out.write(" 님이 장바구니 목록입니다 </p>\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-12\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"shop__cart__table\">\n");
      out.write("\t\t\t\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<th>Product</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<th>Price</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<th>Quantity</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<th>Total</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<th></th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t</thead>\n");
      out.write("\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<tbody>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
int sum = 0; //합계
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
for (Cart cart : cartList) { 
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\"cart__product__item\"><a href=\"#\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"/resources/data/basic/");
      out.print(cart.getProduct_id());
      out.write('.');
      out.print(cart.getFilename());
      out.write("\" width=\"180\" height=\"150\" alt=\"Product\"></a>\n");
      out.write("\t\t\t\t\t\t\t \t\t\t\t\t\t <h6>");
      out.print(cart.getSubCategory().getName() );
      out.write(' ');
      out.write('>');
      out.write(' ');
      out.print(cart.getProduct_name() );
      out.write(" </h6>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cart__product__item__title\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h3>");
      out.print(cart.getProduct_name() );
      out.write("</h3>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"rating\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i> \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i> \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t           \n");
      out.write("\t\t\t\t\t\t\t     \t\t\t\n");
      out.write("                                    \t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\"cart__price\" name=\"price\" ><span>");
      out.print(Formatter.getCurrency(cart.getPrice()));
      out.write("</span></td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t            <!-- \"장바구니 수량 변경\" -->\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\"cart__quantity\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pro-qty\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"cart_id\" value=\"");
      out.print(cart.getCart_id());
      out.write("\"> \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"quantity\" value=\"");
      out.print(cart.getQuantity());
      out.write("\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t");

												sum = sum + (cart.getPrice() * cart.getQuantity());
												
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t <!-- \"장바구니 합계정보\" -->\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t <td class=\"cart__total\">");
      out.print(Formatter.getCurrency(cart.getPrice()*cart.getQuantity()) );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"cart__close\">\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"icon_close\" onClick=\"delOneCart(");
      out.print(cart.getCart_id());
      out.write(")\"> \t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
}
      out.write("\t\n");
      out.write("\t\t\t\t\t\t\t\t\t</tbody>\n");
      out.write("\t\t\t\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-6 col-md-6 col-sm-6\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"cart__btn\">\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"../../\">메인으로</a>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-6 col-md-6 col-sm-6\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"cart__btn update__btn\">\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:editCart()\"></span> Update cart</a>\n");
      out.write("\t\t\t\t\t\t\t\t <a href=\"javascript:delCart()\"></span> 카트비우기</a>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t                <div class=\"col-lg-6\">\n");
      out.write("\t\t                    <div class=\"discount__content\">\n");
      out.write("\t\t                        <h6>Discount codes</h6>\n");
      out.write("\t\t                        <form action=\"#\">\n");
      out.write("\t\t                            <input type=\"text\" placeholder=\"Enter your coupon code\">\n");
      out.write("\t\t                            <button type=\"submit\" class=\"site-btn\">Apply</button>\n");
      out.write("\t\t                        </form>\n");
      out.write("\t\t                    </div>\n");
      out.write("\t\t                </div>\n");
      out.write("\t\t                \n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-4 offset-lg-2\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"cart__total__procced\">\n");
      out.write("\t\t\t\t\t\t\t\t<h6>Cart total</h6>\n");
      out.write("\t\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>Total <span>");
      out.print(Formatter.getCurrency(sum));
      out.write("</span></li>\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:checkoutForm()\" class=\"primary-btn\">결제하기</a>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</section>\n");
      out.write("\t<!-- Shop Cart Section End -->\n");
      out.write("\n");
      out.write("\t<!-- Search Begin -->\n");
      out.write("\t<div class=\"search-model\">\n");
      out.write("\t\t<div class=\"h-100 d-flex align-items-center justify-content-center\">\n");
      out.write("\t\t\t<div class=\"search-close-switch\">+</div>\n");
      out.write("\t\t\t<form class=\"search-model-form\">\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"search-input\" placeholder=\"Search here.....\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!-- Search End -->\n");
      out.write("\n");
      out.write("\t<!-- Js Plugins -->\n");
      out.write("\t");
      out.write("\n");
      out.write("<!-- Footer Section Begin -->\n");
      out.write("<footer class=\"footer\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-4 col-md-6 col-sm-7\">\n");
      out.write("                <div class=\"footer__about\">\n");
      out.write("                    <div class=\"footer__logo\">\n");
      out.write("                        <a href=\"./index.html\"><img src=\"/resources/img/logo.png\" alt=\"\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt\n");
      out.write("                    cilisis.</p>\n");
      out.write("                    <div class=\"footer__payment\">\n");
      out.write("                        <a href=\"#\"><img src=\"/resources/img/payment/payment-1.png\" alt=\"\"></a>\n");
      out.write("                        <a href=\"#\"><img src=\"/resources/img/payment/payment-2.png\" alt=\"\"></a>\n");
      out.write("                        <a href=\"#\"><img src=\"/resources/img/payment/payment-3.png\" alt=\"\"></a>\n");
      out.write("                        <a href=\"#\"><img src=\"/resources/img/payment/payment-4.png\" alt=\"\"></a>\n");
      out.write("                        <a href=\"#\"><img src=\"/resources/img/payment/payment-5.png\" alt=\"\"></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-2 col-md-3 col-sm-5\">\n");
      out.write("                <div class=\"footer__widget\">\n");
      out.write("                    <h6>Quick links</h6>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">About</a></li>\n");
      out.write("                        <li><a href=\"#\">Blogs</a></li>\n");
      out.write("                        <li><a href=\"#\">Contact</a></li>\n");
      out.write("                        <li><a href=\"#\">FAQ</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-2 col-md-3 col-sm-4\">\n");
      out.write("                <div class=\"footer__widget\">\n");
      out.write("                    <h6>Account</h6>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">My Account</a></li>\n");
      out.write("                        <li><a href=\"#\">Orders Tracking</a></li>\n");
      out.write("                        <li><a href=\"#\">Checkout</a></li>\n");
      out.write("                        <li><a href=\"#\">Wishlist</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-4 col-md-8 col-sm-8\">\n");
      out.write("                <div class=\"footer__newslatter\">\n");
      out.write("                    <h6>NEWSLETTER</h6>\n");
      out.write("                    <form action=\"#\">\n");
      out.write("                        <input type=\"text\" placeholder=\"Email\">\n");
      out.write("                        <button type=\"submit\" class=\"site-btn\">Subscribe</button>\n");
      out.write("                    </form>\n");
      out.write("                    <div class=\"footer__social\">\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-youtube-play\"></i></a>\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-instagram\"></i></a>\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-pinterest\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-12\">\n");
      out.write("                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n");
      out.write("                <div class=\"footer__copyright__text\">\n");
      out.write("                    <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class=\"fa fa-heart\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a></p>\n");
      out.write("                </div>\n");
      out.write("                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("<!-- Footer Section End -->\n");
      out.write("\n");
      out.write("<!-- Search Begin -->\n");
      out.write("<div class=\"search-model\">\n");
      out.write("    <div class=\"h-100 d-flex align-items-center justify-content-center\">\n");
      out.write("        <div class=\"search-close-switch\">+</div>\n");
      out.write("        <form class=\"search-model-form\">\n");
      out.write("            <input type=\"text\" id=\"search-input\" placeholder=\"Search here.....\">\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!-- Search End -->");
      out.write('\n');
      out.write('	');
      out.write("\n");
      out.write("<!-- Js Plugins -->\n");
      out.write("<script src=\"/resources/js/jquery-3.3.1.min.js\"></script>\n");
      out.write("<script src=\"/resources/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"/resources/js/jquery.magnific-popup.min.js\"></script>\n");
      out.write("<script src=\"/resources/js/jquery-ui.min.js\"></script>\n");
      out.write("<script src=\"/resources/js/mixitup.min.js\"></script>\n");
      out.write("<script src=\"/resources/js/jquery.countdown.min.js\"></script>\n");
      out.write("<script src=\"/resources/js/jquery.slicknav.js\"></script>\n");
      out.write("<script src=\"/resources/js/owl.carousel.min.js\"></script>\n");
      out.write("<script src=\"/resources/js/jquery.nicescroll.min.js\"></script>\n");
      out.write("<script src=\"/resources/js/main.js\"></script>");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
