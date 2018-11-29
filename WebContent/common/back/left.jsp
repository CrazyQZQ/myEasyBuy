<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="m_left">
        	<div class="left_n">管理中心</div>
            <div class="left_m">
            	<div class="left_m_t t_bg1">订单中心</div>
                <ul>
                	<li><a id="myOrder" href="${pageContext.request.contextPath }/back?aim=order">我的订单</a></li>
                    <li><a id="myAddress" href="${pageContext.request.contextPath }/back?aim=userAddressList">收货地址</a></li>
                    <c:if test="${user.type==1 }"><li><a id="allOrder" href="${pageContext.request.contextPath }/back?aim=orderList">全部订单</a></li></c:if>
                </ul>
            </div>
            <div class="left_m">
            	<div class="left_m_t t_bg2">会员中心</div>
                <ul>
                	<c:if test="${user.type==1 }"><li><a id="userList" href="${pageContext.request.contextPath }/back?aim=userList">用户列表</a></li></c:if>
                	<li><a id="userInfo" href="${pageContext.request.contextPath }/back/userInfo.jsp">用户信息</a></li>
                    <li><a id="myCollection" href="${pageContext.request.contextPath }/collection?action=collection">我的收藏</a></li>
                </ul>
            </div>
            <c:if test="${user.type==1 }">
            <div class="left_m">
            	<div class="left_m_t t_bg3">商品管理</div>
                <ul>
                	<li><a id="category" href="${pageContext.request.contextPath }/back?aim=categoryList">分类管理</a></li>
                    <li><a id="product" href="${pageContext.request.contextPath }/back?aim=productList">商品管理</a></li>
                    <li><a id="newProduct" href="${pageContext.request.contextPath }/newProduct?action=load">商品上架</a></li>
                </ul>
            </div>
            </c:if>
            <div class="left_m">
            	<div class="left_m_t t_bg4">资讯中心</div>
                <ul>
                	<li><a id="news" href="${pageContext.request.contextPath }/back?aim=newsList">资讯列表</a></li>
                </ul>
            </div>
        </div>
</body>
</html>