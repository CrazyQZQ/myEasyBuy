<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
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
            <div class="mem_tit">商品列表</div>
            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="20%">商品名称</td>
                <td width="20%">商品图片</td>
                <td width="15%">库存</td>
                <td width="15%">价格</td>
                <td width="15%" colspan="2">操作</td>
                <!-- <td width="15%">操作</td> -->
              </tr>
              <c:forEach items="${productPage.objList }" var="product">
	              <tr>
	                <td>${product.name }</td>
	                <td><img width="40px" height="40px" src="${pageContext.request.contextPath }/statics/common/images/${product.fileName }"/></td>
	                <td>${product.stock }</td>
	                <td>${product.price }</td>
	                <td><a href="${pageContext.request.contextPath }/updateProduct?aim=wantUpdate&productId=${product.id }">修改</a></td>
	                <td><a href="${pageContext.request.contextPath }/handerDelete?aim=product&productId=${product.id }">删除</a></td>
	              </tr>
              </c:forEach>
              
              
            </table>

            <div class="pages">
            
           		<c:if test="${productPage.currPageNo>1}">
            	<a href="${pageContext.request.contextPath }/back?aim=productList&currentPageNo=1" class="p_fir">首页</a>	
  				<a href="${pageContext.request.contextPath }/back?aim=productList&currentPageNo=${productPage.currPageNo-1}" class="p_pre">上一页</a>
 				</c:if>
 				<c:forEach begin="1" end="${productPage.totalPageCount}" step="1" varStatus="i">
 				<a href="#" <c:if test="${(i.index)==productPage.currPageNo }">class="cur"</c:if>>${i.index }</a>
 				</c:forEach>
 				<c:if test="${productPage.currPageNo<productPage.totalPageCount}">
 					<a href="${pageContext.request.contextPath }/back?aim=productList&currentPageNo=${productPage.currPageNo+1}" class="p_pre">下一页</a>
 					<a href="${pageContext.request.contextPath }/back?aim=productList&currentPageNo=${productPage.totalPageCount}" class="p_last">尾页</a>
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
	$("#product").addClass("now")
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