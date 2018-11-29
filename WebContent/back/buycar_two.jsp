<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认订单信息</title>
</head>
<body>
<%-- <!--Begin Header Begin-->
<%@include file="/common/pre/header.jsp" %>
<%@include file="/common/pre/searchBar.jsp" %>
<!--End Header End--> 
<!--Begin Menu Begin-->
<%@include file="/common/pre/category.jsp" %>
<!--End Menu End-->  --%>

<div class="i_bg"> 
<div class="content mar_20">
    	<img src="${pageContext.request.contextPath }/statics/common/images/img2.jpg" />        
    </div>
    
    <!--Begin 第二步：确认订单信息 Begin -->
    <div class="content mar_20">
    	<div class="two_bg">
        	<div class="two_t">
            	<span class="fr"></span>商品列表
            </div>
            <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="car_th" width="550">商品名称</td>
                <!-- <td class="car_th" width="140">属性</td> -->
                <td class="car_th" width="150">购买数量</td>
                <td class="car_th" width="130">小计</td>
               <!--  <td class="car_th" width="140">返还积分</td> -->
              </tr>
           <c:if test="${shoppingCart.items!=null }">
          	<c:forEach items="${shoppingCart.items }" var="ShoppingCartItem" varStatus="i"> 
	          	<tr <c:if test="${i.index%2!=0 }">class="car_tr"</c:if> >
			        <td>
	                    <div class="c_s_img"><img src="${pageContext.request.contextPath }/statics/common/images/${ShoppingCartItem.product.fileName }" width="73" height="73" /></div>
	                    ${ShoppingCartItem.product.name }
	                </td>
	               <!--  <td align="center">颜色：灰色</td> -->
	                <td align="center">${ShoppingCartItem.quantity }</td>
	                <td align="center" style="color:#ff4e00;">￥${ShoppingCartItem.cost }</td>
	                <!-- <td align="center">26R</td> -->
		        </tr>
	          </c:forEach> 
          </c:if>
              <tr>
                <td colspan="5" align="right" style="font-family:'Microsoft YaHei';">
                  <%--   商品总价：￥${shoppingCart.cost}  --%>
                </td>
              </tr>
            </table>
            
            <div class="two_t">
            	<span class="fr"></span>收货人信息
            </div>
            <table border="0" class="peo_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="p_td" width="160">用户名称</td>
                <td width="395">${user.userName }</td>
                <td class="p_td" width="160">登录名称</td>
                <td width="395">${user.loginName }</td>
              </tr>
              <tr>
                <td class="p_td">手机</td>
                <td>${user.mobile}</td>
                <td class="p_td" width="160">电子邮件</td>
                <td width="395">${user.email}</td>
            </tr>
            </table>
            <div class="two_t">
            <span class="fr"></span>选择地址
        	</div>
        	<table border="0" class="peo_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
            <c:forEach items="${userAddressList}" var="temp" varStatus="status">
                <tr>
                    <td class="p_td" width="160">
                        <c:choose>
                            <c:when test="${empty temp.remark}">
                                地址${status.index+1}
                            </c:when>
                            <c:otherwise>
                                ${temp.remark}
                            </c:otherwise>
                        </c:choose>
                        <input type="radio" name="selectAddress" class="adressId" value="${temp.id}">
                    </td>
                    <td>
                            ${temp.address}
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td class="p_td" width="160">
                    新地址<input type="radio" name="selectAddress" class="adressId" value="-1" checked>
                </td>
                <td>
                    地址&nbsp;<input type="text" value="" name="address" id="add_ipt" class="add_ipt">&nbsp;
                    备注&nbsp;<input type="text" value="" name="remark" id="rek_ipt" class="add_ipt">
                </td>
            </tr>
        </table>
            <table border="0" style="width:900px; margin-top:20px;" cellspacing="0" cellpadding="0">
              <tr height="70">
                <td align="right">
                    <b style="font-size:14px;">应付款金额：<span
                            style="font-size:22px; color:#ff4e00;">￥${shoppingCart.totalMoney}</span></b>
                </td>
            </tr>
            <tr height="70">
                <td align="right"><a id="cart_three"><img
                        src="${pageContext.request.contextPath }/statics/common/images/btn_sure.gif"/></a></td>
            </tr>
            </table>
        </div>
    </div> 
<%-- <!--Begin Footer Begin -->
  <%@include file="/common/pre/footer.jsp" %>
<!--End Footer End --> --%>
</div> 
</body>
  <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/buycar_two.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/buycar_two_adress.js"></script>
</html>