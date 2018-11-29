<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品上架</title>
<style type="text/css">
#f_img,#f{vertical-align: middle;}
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
            <div class="mem_tit">商品上架</div>
			<div id="showtianjia">
				<form action="${pageContext.request.contextPath }/updateProduct?aim=doUpdate&id=${UpdateProduct.id}" method="post" enctype="multipart/form-data">
					<table class="addcatetory order_tab" border="0" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
						<tr class="t1">
							<td>一级分类</td>
							<td style="text-align: left">
							<select name="yiji" class="yiji">
								<option value="0">请选择</option>
								<c:forEach items="${firMenu }" var="product_category"><option value="${product_category.id }" <c:if test="${product_category.id==UpdateProduct.categoryLevel1Id }">selected</c:if> >${product_category.name }</option></c:forEach>
							</select>
							</td>
						</tr>
						<tr class="t2">
							<td>二级分类</td>
							<td style="text-align: left">
							<select name="erji" class="erji">
								<option>请选择</option>
								<c:forEach items="${secMenu }" var="product_category"><option value="${product_category.id }" <c:if test="${product_category.id==UpdateProduct.categoryLevel2Id }">selected</c:if> >${product_category.name }</option></c:forEach>
							</select>
							</td>
						</tr>
						<tr class="t3">
							<td>三级分类</td>
							<td style="text-align: left">
							<select name="sanji" class="sanji">
							<option>请选择</option>
							<c:forEach items="${thiMenu }" var="product_category"><option value="${product_category.id }" <c:if test="${product_category.id==UpdateProduct.categoryLevel3Id }">selected</c:if> >${product_category.name }</option></c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td>商品名称</td>
							<td style="text-align: left"><input name="cattegoryName" value="${UpdateProduct.name }"/>(*必填)</td>
						</tr>
						<tr>
							<td>商品图片</td>
							<td style="text-align: left"><img id="f_img" width="50px" height="50px" src="${pageContext.request.contextPath }/statics/common/images/${UpdateProduct.fileName }"/><input id="f" type="file" name="fileName" value=""/></td>
						</tr>
						<tr>
							<td>单价</td>
							<td style="text-align: left"><input name="price" value="${UpdateProduct.price }"/></td>
						</tr>
						<tr>
							<td>库存</td>
							<td style="text-align: left"><input name="stock" value="${UpdateProduct.stock }"/></td>
						</tr>
						<tr>
							<td>描述</td>
							<td style="text-align: left"><textarea name="description" rows="3" cols="20"></textarea></td>
						</tr>
					</table>
					<div><input type="submit" name="sub" value="确认修改" style="color:white;  padding:0px 5px; display: inline-block;background: #FF4E00;height: 30px;float:
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
<script type="text/javascript">
$(function(){
	$("#f").click(function(){
		$("#f_img").hide()
	})
	$("#product").addClass("now")
	$(".yiji").change(function(){
		var yi = $(this).val();
		if(yi!=-1){
			$.ajax({
				"url" : "http://localhost:8080/easybuy/updateProduct",// 要提交的URL路径
				"type" : "post", // 发送请求的方式
				"data" : {"jibie":"first","id":yi}, // 要发送到服务器的数据
				"dataType" : "json", // 预期接收的数据格式
				"success" : function(result) { // 请求成功后要执行的代码
					$(".erji").html("<option>请选择</option>");
					for(var s in result){
		                $(".erji").append("<option value="+result[s].id+">"+result[s].name+"</option>");
		            }
				}
			});
		}
	})
	$(".erji").change(function(){
		var er = $(this).val();
		if(er!=-1){
			$.ajax({
				"url" : "http://localhost:8080/easybuy/updateProduct",// 要提交的URL路径
				"type" : "post", // 发送请求的方式
				"data" : {"jibie":"second","id":er}, // 要发送到服务器的数据
				"dataType" : "json", // 预期接收的数据格式
				"success" : function(result) { // 请求成功后要执行的代码
					$(".sanji").html("<option>请选择</option>");
					for(var s in result){
		                $(".sanji").append("<option value="+result[s].id+">"+result[s].name+"</option>");
		            }
				}
			});
		}
	})
})
</script>
</body>
</html>