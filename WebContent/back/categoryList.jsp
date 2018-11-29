<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品分类</title>
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
            <div class="mem_tit">分类管理</div>
            <div><a id="tianjia" style="color:white;  padding:0px 5px; display: inline-block;background: #FF4E00;height: 30px;float:
             right;position: relative;right: 20px;line-height: 30px">添加分类</a></div>
            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="12%">选择</td>
                <td width="22%">分类名称</td>
                <td width="22%">分类级别</td>
                <td width="22%">父级分类</td>
                <td width="22%">操作（有子类时无法删除）</td>
                <!-- <td width="15%">操作</td> -->
              </tr>
              <c:forEach items="${product_categoryPage.objList }" var="product_category">
	              <tr>
	                <td><input type="radio" name="xuanze" value=""/></td>
	                <td>${product_category.name }</td>
	                <td>
		                <c:if test="${product_category.type==1 }">一级分类</c:if>
		                <c:if test="${product_category.type==2 }">二级分类</c:if>
		                <c:if test="${product_category.type==3 }">三级分类</c:if>
	                </td>
	                <td>${product_category.parentName }</td>
	                <td><a href="${pageContext.request.contextPath }/handerDelete?aim=category&categoryId=${product_category.id }">删除</a></td>
	              </tr>
              </c:forEach>
            </table>
            <div class="pages">
           		<c:if test="${product_categoryPage.currPageNo>1}">
            	<a href="${pageContext.request.contextPath }/back?aim=categoryList&currentPageNo=1" class="p_fir">首页</a>	
  				<a href="${pageContext.request.contextPath }/back?aim=categoryList&currentPageNo=${product_categoryPage.currPageNo-1}" class="p_pre">上一页</a>
 				</c:if>
 				<c:forEach begin="1" end="${product_categoryPage.totalPageCount}" step="1" varStatus="i">
 				<a href="#" <c:if test="${(i.index)==product_categoryPage.currPageNo }">class="cur"</c:if>>${i.index }</a>
 				</c:forEach>
 				<c:if test="${product_categoryPage.currPageNo<product_categoryPage.totalPageCount}">
 					<a href="${pageContext.request.contextPath }/back?aim=categoryList&currentPageNo=${product_categoryPage.currPageNo+1}" class="p_pre">下一页</a>
 					<a href="${pageContext.request.contextPath }/back?aim=categoryList&currentPageNo=${product_categoryPage.totalPageCount}" class="p_last">尾页</a>
 				</c:if>
			</div>
			<div id="showtianjia">
				<form action="${pageContext.request.contextPath }/category?action=add" method="post">
					<table class="addcatetory order_tab" border="0" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
						<tr>
							<td>分类级别</td>
							<td style="text-align: left">
								<select name="jibie" class="jibie">
									<option value="0">请选择</option>
									<option value="1">一级分类</option>
									<option value="2">二级分类</option>
									<option value="3">三级分类</option>
								</select>
							</td>
						</tr>
						<tr class="t1">
							<td>一级分类</td>
							<td style="text-align: left"><select name="yiji" class="yiji"><option>请选择</option></select></td>
						</tr>
						<tr class="t2">
							<td>二级分类</td>
							<td style="text-align: left"><select name="erji" class="erji"><option>请选择</option></select></td>
						</tr>
						<tr>
							<td>分类名称</td>
							<td style="text-align: left"><input name="cattegoryName" value=""/>(*必填)</td>
						</tr>
					</table>
					<div><input type="submit" name="sub" value="添加分类" style="color:white;  padding:0px 5px; display: inline-block;background: #FF4E00;height: 30px;float:
            	 right;position: relative;right: 20px;line-height: 30px"/></div>
				</form>
				
			</div>
        </div>
    </div>
	<!--End 用户中心 End--> 
    <!--Begin Footer Begin -->
    <%@include file="/common/pre/footer.jsp" %>
    <!--End Footer End -->    
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/category.js"></script>
<script type="text/javascript">
$(function(){
	$("#category").addClass("now")
	var error ='${param.error}'
	if(error=='yes'){
		alert("不能删除有子分类或商品的类别，删除失败!");
	}else if(error=='no'){
		alert("删除成功!");
	}
})
</script>
</body>
</html>