<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部订单</title>
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
            <div class="mem_tit">全部订单</div>
            <c:forEach items="${orderPage.objList }" var="order">
            	<div  style="position: relative; width: 930px; border:1px solid #EAEAEA; border-bottom: none; background: #F7ECE8">
	            	<span>&nbsp;&nbsp;用户：${order.loginName }</span>&nbsp;&nbsp;&nbsp;&nbsp;
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
			<div class="pages">
           		<c:if test="${orderPage.currPageNo>1}">
            	<a href="${pageContext.request.contextPath }/back?aim=orderList&currentPageNo=1" class="p_fir">首页</a>	
  				<a href="${pageContext.request.contextPath }/back?aim=orderList&currentPageNo=${orderPage.currPageNo-1}" class="p_pre">上一页</a>
 				</c:if>
 				<c:forEach begin="1" end="${orderPage.totalPageCount}" step="1" varStatus="i">
 				<a href="#" <c:if test="${(i.index)==orderPage.currPageNo }">class="cur"</c:if>>${i.index }</a>
 				</c:forEach>
 				<c:if test="${orderPage.currPageNo<orderPage.totalPageCount}">
 					<a href="${pageContext.request.contextPath }/back?aim=orderList&currentPageNo=${orderPage.currPageNo+1}" class="p_pre">下一页</a>
 					<a href="${pageContext.request.contextPath }/back?aim=orderList&currentPageNo=${orderPage.totalPageCount}" class="p_last">尾页</a>
 				</c:if>
			</div>
        </div>
    </div>
	<!--End 用户中心 End--> 
    <!--Begin Footer Begin -->
    <%@include file="/common/pre/footer.jsp" %>
    <!--End Footer End -->    
</div>
<script type="text/javascript">
$(function(){
	$("#allOrder").addClass("now")
})
</script>
</body>
</html>