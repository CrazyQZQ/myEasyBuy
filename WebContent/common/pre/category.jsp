<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
 <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/jquery-1.8.2.min.js"></script>
 <!-- <script >
 	$(function(){
 		$.get("http://localhost:8080/easybuy02/load")
 	})
 </script>  -->

	<div class="menu_bg">
	<div class="menu">
    	<!--Begin 商品分类详情 Begin-->    
    	<div class="nav">
        	<div class="nav_t ">全部商品分类</div>
            <div class="leftNav ">
                <ul> 
                  <c:forEach items="${allMenu }" var="pcu1" varStatus="i">
                   	<li>
                    	<div class="fj">
                        	<span class="n_img"><span></span><img src="${pageContext.request.contextPath }/statics/common/images/nav0${i.index+1 }.png" /></span>
                            <span class="fl">${pcu1.product_category.name }</span>
                        </div>
                        <div class="zj" style="top:${0-i.index*40 }px">
                       		
	                            <div class="zj_l">
	                            <c:forEach items="${pcu1.pcList }" var="pcu2" varStatus="j">
	                                <div class="zj_l_c">
	                                    <h2><a href="${pageContext.request.contextPath }/product?mess=center&pcId=${pcu2.product_category.id}&pc1Name=${pcu2.product_category.name}">${pcu2.product_category.name }</a></h2>
	                                    <c:forEach items="${pcu2.pcList }" var="pcu3" varStatus="k"><a href="${pageContext.request.contextPath }/product?mess=center&pcId=${pcu3.product_category.id}&pc1Name=${pcu3.product_category.name}">${pcu3.product_category.name }</a>|</c:forEach>
	                                </div>
	                             </c:forEach>
	                            </div>
	                             <div class="zj_r">
		                             <a href="#"><img src="${pageContext.request.contextPath }/statics/common/images/n_img1.jpg" width="236" height="200" /></a>
		                             <a href="#"><img src="${pageContext.request.contextPath }/statics/common/images/n_img2.jpg" width="236" height="200" /></a>
	                     		</div>
                        </div>
                    </li>
                   </c:forEach>
                </ul>            
            </div>
        </div>  
        <!--End 商品分类详情 End-->                                                     
    	<ul class="menu_r" style="width:860px">                                                                                                                                               
        	<li><a href="${pageContext.request.contextPath }/load">首页</a></li>
        	<c:forEach items="${allMenu }" var="pcu1">
        		<li style="width:100px ;font-size:14px"><a href="${pageContext.request.contextPath }/product?mess=center&pcId=${pcu1.product_category.id}&pc1Name=${pcu1.product_category.name}" style="width:100px">${pcu1.product_category.name }</a></li>
        	</c:forEach>
           
        </ul>
        <div class="m_ad" style="width:120px">中秋送好礼！</div>
    </div>
</div>

</body>
</html>