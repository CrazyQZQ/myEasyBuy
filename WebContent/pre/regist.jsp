<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/common/css/style.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->    
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/jquery.bxslider_e88acd1b.js"></script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/menu.js"></script>    
        
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/select.js"></script>
    
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/lrscroll.js"></script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/iban.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/fban.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/f_ban.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/mban.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/bban.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/hban.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/tban.js"></script>
    
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/lrscroll_1.js"></script>
<title>易购用户注册</title>
</head>
<body>
<script type="text/javascript">
 var path = "${pageContext.request.contextPath }";
</script>
<!--Begin Header Begin-->
<div class="soubg">
	<div class="sou">
        <span class="fr">
        	<span class="f_l">你好，请<a href="${pageContext.request.contextPath }/pre/login.jsp">登录</a>&nbsp; <a href="${pageContext.request.contextPath }/pre/regist.jsp" style="color:#ff4e00;">免费注册</a>&nbsp; </span>
            <span class="f_l">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="${pageContext.request.contextPath }/statics/common/images/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<!--End Header End--> 
<!--Begin Login Begin-->
<div class="log_bg">	
    <div class="top">
        <div class="logo"><a href="${pageContext.request.contextPath }/pre/index.jsp"><img src="${pageContext.request.contextPath }/statics/common/images/logo.png" /></a></div>
    </div>
	<div class="regist">
    	<div class="log_img"><img src="${pageContext.request.contextPath }/statics/common/images/l_img.png" width="611" height="425" /></div>
		<div class="reg_c">
        	<form method="post" action="${pageContext.request.contextPath }/user?mess=regist" onsubmit="return checkAgreement()">
            <table border="0" style="width:420px; font-size:14px; margin-top:20px;" cellspacing="0" cellpadding="0">
              <tr height="50" valign="top">
              	<td width="95">&nbsp;</td>
                <td>
                	<span class="fl" style="font-size:24px;">注册</span>
                    <span class="fr">已有商城账号，<a href="${pageContext.request.contextPath }/pre/login.jsp" style="color:#ff4e00;">我要登录</a></span>
                </td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;用户名 &nbsp;</td>
                <td><input type="text" name="loginname" value="" class="l_user ob" /></td>
              </tr>
              
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;密码 &nbsp;</td>
                <td><input type="password" name="password1" value="" class="l_pwd ob 2_pwd" /></td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;确认密码 &nbsp;</td>
                <td><input type="password" name="password2" value="" class="l_pwd ob " /></td>
              </tr>
               <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;真实姓名 &nbsp;</td>
                <td><input type="text" name="username" value="" class="l_mem ob" /></td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;身份证号 &nbsp;</td>
                <td><input type="text" name="identityCode" value="" class="l_num ob" /></td>
              </tr>
               <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;性别 &nbsp;</td>
                <td><input type="radio" name="sex" value="1" checked/>男<input type="radio" name="sex" value="0"/>女</td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;邮箱 &nbsp;</td>
                <td><input type="text" name="email" value="" class="l_email ob" /></td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;手机 &nbsp;</td>
                <td><input type="text" name="mobile" value="" class="l_tel ob" /></td>
              </tr>
             
              <tr height="50" class="tr_change">
                <td align="right"> <font color="#ff4e00">*</font>&nbsp;验证码 &nbsp;</td>
                <td width="100px">
                    <input type="text" name="checkCode" value="" class="l_ipt ob" />
                    <a class="changeCode" style="font-size:12px; font-family:'宋体';">换一张</a>
                </td>
                <td class="td_change"><img  style="position:absolute;top:655px;right:400px" alt="验证码" src="${pageContext.request.contextPath }/statics/common/checkCodeImages/${defaultCheckCode.name}"></td>
              </tr>
              <tr>
              	<td>&nbsp;</td>
                <td style="font-size:12px; padding-top:20px;">
                	<span style="font-family:'宋体';" class="fl">
                    	<label class="r_rad"><input id="agreement" type="checkbox" /></label><label class="r_txt">我已阅读并接受《用户协议》</label>
                    </span>
                </td>
              </tr>
              <tr height="60">
              	<td>&nbsp;</td>
                <td><input type="submit" value="立即注册" class="log_btn" /></td>
              </tr>
            </table>
            </form>
            <span class="prompt"  style="position:absolute;top:225px;right:450px;color:red;font-size:16px"></span>
            <span class="cprompt"  style="position:absolute;top:505px;right:450px;color:red;font-size:16px"></span>
            <span class="checkprompt"  style="position:absolute;top:690px;right:580px;color:red;font-size:16px"></span>
        </div>
    </div>
</div>
<!--End Login End--> 
<!--Begin Footer Begin-->
<div class="btmbg">
    <div class="btm">
        备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
        <img src="${pageContext.request.contextPath }/statics/common/images/b_1.gif" width="98" height="33" /><img src="${pageContext.request.contextPath }/statics/common/images/b_2.gif" width="98" height="33" /><img src="${pageContext.request.contextPath }/statics/common/images/b_3.gif" width="98" height="33" /><img src="${pageContext.request.contextPath }/statics/common/images/b_4.gif" width="98" height="33" /><img src="${pageContext.request.contextPath }/statics/common/images/b_5.gif" width="98" height="33" /><img src="${pageContext.request.contextPath }/statics/common/images/b_6.gif" width="98" height="33" />
    </div>    	
</div>
<!--End Footer End -->  
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/finalRegist.js"></script>
<script type="text/javascript">
function checkAgreement(){
	if(!$("#agreement").prop("checked")){
		alert("请先同意协议！")
		return false;
	}
	return true;
}
$(function(){
	
	var error ='${param.error}'
	if(error=='yes'){
		alert("用户名已存在，注册失败!");
	}
	$(".changeCode").click(function(){
		 $.get("http://localhost:8080/easybuy/checkCode","info=changeCode",function(result){
			$(".td_change").html("<img  style=\"position:absolute;top:655px;right:400px\" alt=\"验证码\" src=\"${pageContext.request.contextPath }/statics/common/checkCodeImages/"+result+"\">")
		},"text") 
	})
})
</script>
</body>
</html>