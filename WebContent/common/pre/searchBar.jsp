<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->    
<title>Insert title here</title>
</head>
<body>

	<div class="top">
    <div class="logo"><a href="${pageContext.request.contextPath }/load"><img src="${pageContext.request.contextPath }/statics/common/images/logo.png" /></a></div>
    <div class="search">
    	<form method="post" action="${pageContext.request.contextPath }/product?mess=search">
        	<input type="text" name="search" value="" class="s_ipt" />
            <input type="submit" value="搜索" class="s_btn" />
        </form>                      
        <span class="fl"><a href="#">咖啡</a><a href="#">iphone 6S</a><a href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a></span>
    </div>
    <div class="i_car">
    	<div class="car_t">购物车 [ <span><c:if test="${shoppingCart.items!=null }">${shoppingCart.shoppingCartItemNum }</c:if>
    									<c:if test="${shoppingCart.items==null }">0</c:if>
    							</span> ]</div>
        <div class="car_bg">
       		<!--Begin 购物车未登录 Begin-->
        	<%-- <c:if test="${user==null }"><div class="un_login">还未登录！<a href="Login.html" style="color:#ff4e00;">马上登录</a> 查看购物车！</div></c:if> --%>
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->
            <ul class="cars">
            	<c:if test="${shoppingCart.items!=null }">
	            	<c:forEach items="${shoppingCart.items }" var="ShoppingCartItem">
		            	<li>
		                	<div class="img"><a href="#"><img src="${pageContext.request.contextPath }/statics/common/images/${ShoppingCartItem.product.fileName }" width="58" height="58" /></a></div>
		                    <div class="name"><a href="#">${ShoppingCartItem.product.name }</a></div>
		                    <div class="price"><font color="#ff4e00">￥${ShoppingCartItem.product.price }</font> X${ShoppingCartItem.quantity }</div>
		                </li>
	            	</c:forEach>
            	</c:if>
            </ul>
            <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span><c:if test="${shoppingCart.items!=null }">${shoppingCart.totalMoney }</c:if>
    									<c:if test="${shoppingCart.items==null }">0</c:if></span></div>
            <c:if test="${user!=null }"><div class="price_a"><a href="${pageContext.request.contextPath }/back/buycar.jsp">去购物车结算</a></div></c:if>
            <c:if test="${user==null }"><div class="price_a"><a href="${pageContext.request.contextPath }/pre/login.jsp">立即登录结算</a></div></c:if>
            <!--End 购物车已登录 End-->
        </div>
    </div>
</div>
</body>
</html>