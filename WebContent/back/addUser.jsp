<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
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
            <div class="mem_tit">添加用户</div>
            <form action="${pageContext.request.contextPath }/back?aim=addUser" method="post">
	            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
	            	<tr>
	            		<td>用户姓名</td>
	            		<td><input name="loginName" value=""/></td>
	            	</tr>
	            	<tr>
	            		<td>真实姓名</td>
	            		<td><input name="userName" value=""/></td>
	            	</tr>
	            	<tr>
	            		<td>性别</td>
	            		<td>
	            		<input type="radio" name="sex" value="1" checked/>男
	            		<input type="radio" name="sex" value="1"/>女
	            		</td>
	            	</tr>
	            	<tr>
	            		<td>密码</td>
	            		<td><input type="password" name="password1" value=""/></td>
	            	</tr>
	            	<tr>
	            		<td>确认密码</td>
	            		<td><input type="password" name="password" value=""/></td>
	            	</tr>
	            	<tr>
	            		<td>身份证号</td>
	            		<td><input name="identityCode" value=""/></td>
	            	</tr>
	            	<tr>
	            		<td>电子邮箱</td>
	            		<td><input type="text" name="email" value=""/></td>
	            	</tr>
	            	<tr>
	            		<td>手机</td>
	            		<td><input type="text" name="mobile" value=""/></td>
	            	</tr>
	            	<tr>
	            		<td>用户类型</td>
	            		<td>
	            			<select name="type">
	            				<option value="1">管理员</option>
	            				<option value="0">普通用户</option>
	            			</select>
	            		</td>
	            	</tr>
	            	<tr>
	            		<td></td>
	            		<td><input type="submit" name="sub" value="添加用户"/></td>
	            	</tr>
	            </table>
            </form>
        </div>
    </div>
	<!--End 用户中心 End--> 
    <!--Begin Footer Begin -->
    <%@include file="/common/pre/footer.jsp" %>
    <!--End Footer End -->    
</div>
</body>
</html>