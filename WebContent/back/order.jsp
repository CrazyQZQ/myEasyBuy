<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/menu.js"></script>    
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/select.js"></script>
<title>我的订单</title>
</head>
<body>
<!--Begin Header Begin-->
<%@include file="/common/pre/header.jsp" %>	
<%@include file="/common/back/back_searchBar.jsp" %>	
<!--End Header End--> 
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
	<div class="m_content">
   		<%@include file="/common/back/left.jsp" %>
		<div class="m_right">
            <p></p>
            <div class="mem_tit">我的订单</div>
            
            <c:forEach items="${orderList }" var="order">
	            <div  style="position: relative; width: 930px; border:1px solid #EAEAEA; border-bottom: none; background: #F7ECE8">
	            	<span>&nbsp;&nbsp;用户名：${user.userName }</span>&nbsp;&nbsp;&nbsp;&nbsp;
	            	<span>&nbsp;&nbsp;&nbsp;&nbsp;订单号：${order.serialNumber }</span>&nbsp;&nbsp;&nbsp;&nbsp;
	            	<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址：${order.userAddress }</span>&nbsp;&nbsp;&nbsp;&nbsp;
	            	<span>&nbsp;&nbsp;&nbsp;&nbsp;订单金额：￥${order.cost}</span>
	            </div>
	            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
	              <tr>                                                                                                                                                    
	                <td width="25%">商品名称</td>
	                <td width="25%">商品图片</td>
	                <td width="25%">数量</td>
	                <td width="25%">价格</td>
	              </tr>
	              <c:forEach items="${order.orderDetailList }" var="OrderDetail">
		              <tr>
		                <td><font color="#ff4e00">${OrderDetail.product.name }</font></td>
		                <td><img width="40px" height="40px" src="${pageContext.request.contextPath }/statics/common/images/${OrderDetail.product.fileName }"/></td>
		                <td>￥${OrderDetail.quantity}</td>
		                <td>￥${OrderDetail.cost}</td>
		              </tr>
	              </c:forEach>
	            </table>
            </c:forEach>
            
            

            
        </div>
    </div>
	<!--End 用户中心 End--> 
    <!--Begin Footer Begin -->
    <%@include file="/common/pre/footer.jsp" %>
    <!--End Footer End -->    
</div>
<script type="text/javascript">
$(function(){
	$("#myOrder").addClass("now")
})
</script>
</body>
</html>