/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-01-16 12:40:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.shop.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mypage_005forder_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/views/shop/member/./../../inc/shop_navi.jsp", Long.valueOf(1610679240000L));
    _jspx_dependants.put("/WEB-INF/views/shop/member/./../../inc/header.jsp", Long.valueOf(1610679240000L));
    _jspx_dependants.put("/WEB-INF/views/shop/member/../shopFooter.jsp", Long.valueOf(1610679240000L));
    _jspx_dependants.put("/WEB-INF/views/shop/member/./../../inc/footer.jsp", Long.valueOf(1610679240000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"zxx\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  ");
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
      out.write(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
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
      out.write("\t<!-- 사이트 이동경로 시작 -->\n");
      out.write("    <div class=\"breadcrumb-option\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <div class=\"breadcrumb__links\">\n");
      out.write("                        <a href=\"/shop/member/mypage_order\"><i class=\"fa fa-home\"></i> Mypage</a>\n");
      out.write("                        <span>My Order</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- 사이트 이동경로 종료 -->\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Blog Details Section Begin -->\n");
      out.write("    <section class=\"blog-details spad\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-2 col-md-2\">\n");
      out.write("                    <div class=\"blog__sidebar\">\n");
      out.write("                        <div class=\"blog__sidebar__item\">\n");
      out.write("                            <div class=\"section-title\">\n");
      out.write("                                <h4>My Page</h4>\n");
      out.write("                            </div>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"/shop/member/mypage_order\">주문내역 </a></li>\n");
      out.write("                                <li><a href=\"/shop/member/mypage_profile\">계정관리 </a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            \n");
      out.write("                <div class=\"col-lg-9 col-md-9\">\n");
      out.write("                    <div class=\"blog__details__content\">\n");
      out.write("                        <div class=\"blog__details__item\">\n");
      out.write("                            <img src=\"img/blog/details/blog-details.jpg\" alt=\"\">\n");
      out.write("                            <div class=\"blog__details__item__title\">\n");
      out.write("                                <span class=\"tip\">Street style</span>\n");
      out.write("                                <h4>Being seen: how is age diversity effecting change in fashion and beauty?</h4>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li>by <span>Ema Timahe</span></li>\n");
      out.write("                                    <li>Seb 17, 2019</li>\n");
      out.write("                                    <li>39 Comments</li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"blog__details__desc\">\n");
      out.write("                            <p>Afashion season can be defined as much by the people on the catwalk as it can by the\n");
      out.write("                                clothes they are wearing. This time around, a key moment came at the end of Marc Jacobsâ\n");
      out.write("                                New York show, when an almost makeup-free Christy Turlington made a rare return to the\n");
      out.write("                                catwalk, aged 50 (she also stars, with the designer himself, in the labelâs AW ad\n");
      out.write("                            campaign), where the average catwalk model is around 18.</p>\n");
      out.write("                            <p>A few days later, Simone Rocha arguably upped the ante. The 32-year-oldâs show â in part\n");
      out.write("                                inspired by Louise Bourgeois, who lived until she was 98 â featured models in their 30s\n");
      out.write("                            and 40s, including cult favourite Jeny Howorth and actor ChloÃ« Sevigny.</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"blog__details__quote\">\n");
      out.write("                            <div class=\"icon\"><i class=\"fa fa-quote-left\"></i></div>\n");
      out.write("                            <p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore dolore magna\n");
      out.write("                                aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut\n");
      out.write("                            aliquip ex ea commodo consequat.</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"blog__details__desc\">\n");
      out.write("                            <p>Occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est\n");
      out.write("                                laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor\n");
      out.write("                                incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\n");
      out.write("                                exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure\n");
      out.write("                            dolor in reprehenderit in voluptate.</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"blog__details__tags\">\n");
      out.write("                            <a href=\"#\">Fashion</a>\n");
      out.write("                            <a href=\"#\">Street style</a>\n");
      out.write("                            <a href=\"#\">Diversity</a>\n");
      out.write("                            <a href=\"#\">Beauty</a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"blog__details__btns\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-lg-6 col-md-6 col-sm-6\">\n");
      out.write("                                    <div class=\"blog__details__btn__item\">\n");
      out.write("                                        <h6><a href=\"#\"><i class=\"fa fa-angle-left\"></i> Previous posts</a></h6>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-6 col-md-6 col-sm-6\">\n");
      out.write("                                    <div class=\"blog__details__btn__item blog__details__btn__item--next\">\n");
      out.write("                                        <h6><a href=\"#\">Next posts <i class=\"fa fa-angle-right\"></i></a></h6>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("    <!-- Blog Details Section End -->\n");
      out.write("\t\n");
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
