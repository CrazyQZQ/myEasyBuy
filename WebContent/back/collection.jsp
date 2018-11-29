<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的收藏</title>
<style type="text/css">
.sm,.sp{vertical-align: middle;}
</style>
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
            <div class="mem_tit">我的收藏</div>
            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="50%">商品名称</td>
                <td width="25%">价格</td>
                <td width="25%">操作</td>
              </tr>
              <c:forEach items="${myCollection.productList }" var="product">
	              <tr>
	                <td><img class="sm" width="40px" height="40px" src="${pageContext.request.contextPath }/statics/common/images/${product.fileName }"/>&nbsp;&nbsp;&nbsp;<span class="sp">${product.name }</span></td>
	                <td>￥${product.price }</td>
	                <td><a href="${pageContext.request.contextPath }/collection?action=delete&productId=${product.id}">删除</a></td>
	              </tr>
              </c:forEach>
            </table>
        </div>
    </div>
	<!--End 用户中心 End--> 
    <!--Begin Footer Begin -->
    <%@include file="/common/pre/footer.jsp" %>
    <!--End Footer End -->    
</div>
<script type="text/javascript">
$(function(){
	$("#myCollection").addClass("now")
	var error ='${param.error}'
	if(error=='yes'){
		alert("删除失败!");
	}else if(error=='no'){
		alert("删除成功!");
	}
})
</script>	
</body>
</html>