<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看购物车</title>
</head>
<body>
<!--Begin Header Begin-->
<%@include file="/common/pre/header.jsp" %>
<div id="search">
<%@include file="/common/pre/searchBar.jsp" %>
</div>
<!--End Header End--> 
<!--Begin Menu Begin-->
<%@include file="/common/pre/category.jsp" %>
<!--End Menu End-->
<div id="dd">
<div class="i_bg">  
    <div class="content mar_20">
    	<img src="${pageContext.request.contextPath }/statics/common/images/img1.jpg" />        
    </div>
    
    <!--Begin 第一步：查看购物车 Begin -->
    <div class="content mar_20">
    	<table border="0" class="car_tab" style="width:1200px; margin-bottom:50px;" cellspacing="0" cellpadding="0">
          <tr>
            <td class="car_th" width="490">商品名称</td>
            <td class="car_th" width="140">属性</td>
            <td class="car_th" width="150">购买数量</td>
            <td class="car_th" width="130">小计</td>
            <td class="car_th" width="140">返还积分</td>
            <td class="car_th" width="150">操作</td>
          </tr>
          <c:if test="${shoppingCart.items!=null }">
          	<c:forEach items="${shoppingCart.items }" var="ShoppingCartItem" varStatus="i"> 
	          	<tr <c:if test="${i.index%2!=0 }">class="car_tr"</c:if> >
		            <td>
		            	<div class="c_s_img"><img src="${pageContext.request.contextPath }/statics/common/images/${ShoppingCartItem.product.fileName }" width="73" height="73" /></div>
		                ${ShoppingCartItem.product.name }
		            </td>
		            <td align="center">单价：${ShoppingCartItem.product.price }</td>
		            <td align="center">
		            	<div class="c_num">
		                    <input type="button" value="" onclick="jianUpdate1(jq(this),${ShoppingCartItem.product.price },${i.index },${ShoppingCartItem.product.id });" class="car_btn_1" />
		                	<input type="text" readonly value="${ShoppingCartItem.quantity }" name="" class="car_ipt" id="car_ipt${i.index }" />  
		                    <input type="button" value="" onclick="addUpdate1(jq(this),${ShoppingCartItem.product.price },${i.index },${ShoppingCartItem.product.id });" class="car_btn_2" />
		                </div>
		            </td>
		            <td align="center" style="color:#ff4e00;" class="itemMoney" id="itemMoney${i.index }">￥${ShoppingCartItem.cost }</td>
		            <td align="center">26R</td>
		            <td align="center"><a onclick="ShowDiv('MyDiv','fade')">删除</a></td>
		          </tr>
	          </c:forEach> 
          </c:if>
          
          
         
          
          <tr height="70">
          	<td colspan="6" style="font-family:'Microsoft YaHei'; border-bottom:0;">
                <span class="fr">商品总价：<b class="totalMoney" style="font-size:22px; color:#ff4e00;"></b></span>
            </td>
          </tr>
          
          <tr valign="top" height="150">
          	<td colspan="6" align="right">
            	<a href="${pageContext.request.contextPath }/load"><img src="${pageContext.request.contextPath }/statics/common/images/buy1.gif" /></a>&nbsp; &nbsp; <a id="cart_two"><img src="${pageContext.request.contextPath }/statics/common/images/buy2.gif" /></a>
            </td>
          </tr>
        </table>
        
    </div>
	<!--End 第一步：查看购物车 End--> 
    
    
    <!--Begin 弹出层-删除商品 Begin-->
    <div id="fade" class="black_overlay"></div>
    <div id="MyDiv" class="white_content">             
        <div class="white_d">
            <div class="notice_t">
                <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv('MyDiv','fade')"><img src="${pageContext.request.contextPath }/statics/common/images/close.gif" /></span>
            </div>
            <div class="notice_c">
           		
                <table border="0" align="center" style="font-size:16px;" cellspacing="0" cellpadding="0">
                  <tr valign="top">
                    <td>您确定要把该商品移除购物车吗？</td>
                  </tr>
                  <tr height="50" valign="bottom">
                    <td><a href="#" class="b_sure">确定</a><a href="#" class="b_buy">取消</a></td>
                  </tr>
                </table>
                    
            </div>
        </div>
    </div>    
    <!--End 弹出层-删除商品 End-->
 </div>   
    
    <!--Begin Footer Begin -->
    <%@include file="/common/pre/footer.jsp" %>
    <!--End Footer End -->    
</div>
 <script type="text/javascript">
 $(function(){
	 totalMoney();
 })
 </script>
 <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/buycar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/num.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/buycar_gotoTwo.js"></script>

</body>
</html>