<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="${pageContext.request.contextPath }/statics/common/css/myAlert.css" rel="stylesheet" />
<title>查看商品</title>
</head>
<body>

<!--Begin Header Begin-->
<%@include file="/common/pre/header.jsp" %>
<div id="searchBar">
<%@include file="/common/pre/searchBar.jsp" %>
</div>
<!--End Header End--> 
<!--Begin Menu Begin-->
<%@include file="/common/pre/category.jsp" %>
<!--End Menu End--> 
<!-- Begin prodectList Begin -->
<div class="i_bg">
	<div class="postion">
    	<span class="fl">全部 > <c:if test="${search==null }">${pc1Name }</c:if><c:if test="${search!=null }">${search }</c:if></span>
    </div>
    <div class="content mar_20">
        <div class="l_list">
        	<div class="list_t">
                <span class="fr">共发现${totalProduct }件</span>
            </div>
            <div class="list_c">
                <ul class="cate_list">
                	<c:forEach items="${page.objList }" var="product">
	                	<li>
	                    	<div class="img"><a href="${pageContext.request.contextPath }/productDetail?productId=${product.id}"><img src="${pageContext.request.contextPath }/statics/common/images/${product.fileName}" width="210" height="185" /></a></div>
	                        <div class="price">
	                            <font>￥<span>${product.price}</span></font> &nbsp; 26R
	                        </div>
	                        <div class="name"><a href="#">${product.name}</a></div>
	                        <div class="carbg">
	                        	<a onclick="collect(${product.id})" class="ss">收藏</a>
	                            <a class="j_car" onclick="addCard(${product.id},1)">加入购物车</a>
	                        </div>
	                        
	                        <div class="wind" id="wind" style="background: #FF3200">
								<span class="inputWords" style="color:white">添加购物车成功</span>
							</div>
	                    </li>
                	</c:forEach>
                </ul>
               <div class="pages">
               		<c:if test="${page.currPageNo>1}">
	               		<a href="${pageContext.request.contextPath }/product?mess=pageMess&currentPageNo=1" class="p_fir">首页</a>
	     				<a href="${pageContext.request.contextPath }/product?mess=pageMess&currentPageNo=${page.currPageNo-1}" class="p_pre">上一页</a>
     				</c:if>
     				<c:forEach begin="1" end="${page.totalPageCount}" step="1" varStatus="i">
     				<a href="#" <c:if test="${(i.index)==page.currPageNo }">class="cur"</c:if>>${i.index }</a>
     				</c:forEach>
     				<c:if test="${page.currPageNo<page.totalPageCount}">
     					<a href="${pageContext.request.contextPath }/product?mess=pageMess&currentPageNo=${page.currPageNo+1}" class="p_pre">下一页</a>
     					<a href="${pageContext.request.contextPath }/product?mess=pageMess&currentPageNo=${page.totalPageCount}" class="p_last">尾页</a>
     				</c:if>
     				
 				</div>
            </div>
        </div>
    </div>
     <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
 $(function(){
	 $(".leftNav").hide();
		$(".nav").hover(function(){						   
			$(".leftNav").show();
		},function(){
			$(".leftNav").hide();
		});
	});
 </script>
<script type="text/javascript">
function addCard(productId,quantity){
	 $.ajax({
		url : "http://localhost:8080/easybuy/cart" ,
		method : "post",
		data:{"action":"clickAdd","productId":productId,"quantity":quantity},
		datatype:"html",
		success:function(result){
			$("#searchBar").html(result)
		}
	})
	$(".inputWords").html("添加购物车成功")
	$("#wind").fadeIn()
    setTimeout($("#wind").fadeOut(),4000)
}
</script>
<script type="text/javascript">
function collect(productId){
	$.ajax({
		url : "http://localhost:8080/easybuy/collection" ,
		method : "post",
		data:{"action":"clickAdd","productId":productId},
		datatype:"text",
		success:function(result){
			if (result=="true") {
				$(".inputWords").html("添加收藏成功")
				$("#wind").fadeIn();
			    setTimeout($("#wind").fadeOut(),4000)
			}else{
				$(".inputWords").html("添加收藏失败")
				$("#wind").fadeIn();
			    setTimeout($("#wind").fadeOut(),4000)
			}
		}
	})
}
</script>
 
<!-- End prodectList End -->
<!--Begin Footer Begin -->
    <%@include file="/common/pre/footer.jsp" %>
<!--End Footer End --> 
</body>
</html>