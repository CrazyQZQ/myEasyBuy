<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的收货地址</title>
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
            <div class="mem_tit">收货地址</div>
            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="25%">收货人姓名</td>
                <td width="25%">收货地址</td>
                <td width="25%">是否为默认地址</td>
                <td width="25%">标记</td>
              </tr>
              <c:forEach items="${userAddressPage.objList }" var="userAddress">
	              <tr>
	                <td>${user.userName }</td>
	                <td>${userAddress.address }</td>
	                <td><c:if test="${userAddress.isDefault==0 }">否</c:if><c:if test="${userAddress.isDefault==1 }">是</c:if></td>
	                <td>${userAddress.remark }</td>
	              </tr>
              </c:forEach>
              
              
            </table>

            <div class="pages">
            
           		<c:if test="${userAddressPage.currPageNo>1}">
            	<a href="${pageContext.request.contextPath }/back?aim=userAddressList&currentPageNo=1" class="p_fir">首页</a>	
  				<a href="${pageContext.request.contextPath }/back?aim=userAddressList&currentPageNo=${userAddressPage.currPageNo-1}" class="p_pre">上一页</a>
 				</c:if>
 				<c:forEach begin="1" end="${userAddressPage.totalPageCount}" step="1" varStatus="i">
 				<a href="#" <c:if test="${(i.index)==userAddressPage.currPageNo }">class="cur"</c:if>>${i.index }</a>
 				</c:forEach>
 				<c:if test="${userAddressPage.currPageNo<userAddressPage.totalPageCount}">
 					<a href="${pageContext.request.contextPath }/back?aim=userAddressList&currentPageNo=${userAddressPage.currPageNo+1}" class="p_pre">下一页</a>
 					<a href="${pageContext.request.contextPath }/back?aim=userAddressList&currentPageNo=${userAddressPage.totalPageCount}" class="p_last">尾页</a>
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
	$("#myAddress").addClass("now")
})
</script>
</body>
</html>