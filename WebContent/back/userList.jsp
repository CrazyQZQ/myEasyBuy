<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有用户</title>
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
            <div class="mem_tit">用户列表</div>
            <div><a href="${pageContext.request.contextPath }/back/addUser.jsp" style="color:white;  padding:0px 5px; display: inline-block;background: #FF4E00;height: 30px;float:
             right;position: relative;right: 20px;line-height: 30px">添加用户</a></div>
            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="15%">登录名</td>
                <td width="15%">用户名</td>
                <td width="10%">性别</td>
                <td width="20%">邮箱</td>
                <td width="20%">手机号</td>
                <td width="20%">操作</td>
                <!-- <td width="15%">操作</td> -->
              </tr>
              <c:forEach items="${userPage.objList }" var="user">
	              <tr>
	                <td>${user.loginName }</td>
	                <td>${user.userName }</td>
	                <td><c:if test="${user.sex==1 }">男</c:if><c:if test="${user.sex==0 }">女</c:if></td>
	                <td>${user.email }</td>
	                <td>${user.mobile }</td>
	                <td><c:if test="${user.type==1 }">--</c:if> <c:if test="${user.type==0 }"><a href="${pageContext.request.contextPath }/handerDelete?aim=user&userId=${user.id }">删除</a></c:if></td>
	              </tr>
              </c:forEach>
            </table>
            <div class="pages">
           		<c:if test="${userPage.currPageNo>1}">
            	<a href="${pageContext.request.contextPath }/back?aim=userList&currentPageNo=1" class="p_fir">首页</a>	
  				<a href="${pageContext.request.contextPath }/back?aim=userList&currentPageNo=${userPage.currPageNo-1}" class="p_pre">上一页</a>
 				</c:if>
 				<c:forEach begin="1" end="${userPage.totalPageCount}" step="1" varStatus="i">
 				<a href="#" <c:if test="${(i.index)==userPage.currPageNo }">class="cur"</c:if>>${i.index }</a>
 				</c:forEach>
 				<c:if test="${userPage.currPageNo<userPage.totalPageCount}">
 					<a href="${pageContext.request.contextPath }/back?aim=userList&currentPageNo=${userPage.currPageNo+1}" class="p_pre">下一页</a>
 					<a href="${pageContext.request.contextPath }/back?aim=userList&currentPageNo=${userPage.totalPageCount}" class="p_last">尾页</a>
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
	$("#userList").addClass("now")
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