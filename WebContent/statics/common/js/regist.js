/**
 * 
 */
$(function(){
	var id = /^\w{18}$/;
	var emile = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var mobileNum = /^\d{5,11}$/
	$(".ob").blur(function(){
		var flag = "true";
		var name = $(this).attr("name");
		var value = $(this).val();
		if(value==null||value==""){
			if(name=="loginname"){
				$(".prompt").html("登录名不能为空！")
			}else if(name=="password1"){
				$(".prompt").html("密码不能为空！")
			}else if(name=="username"){
				$(".prompt").html("真实姓名不能为空！")
			}else if(name=="identityCode"){
				$(".prompt").html("身份证号不能为空！")
			}else if(name=="email"){
				$(".cprompt").html("邮箱不能为空！")
			}else if(name=="mobile"){
				$(".cprompt").html("手机号不能为空！")
			}else if(name=="checkCode"){
				$(".checkprompt").html("验证码不能为空！")
			}
		}else{
			if(name=="loginname"&&(value.length<2||value.length>10)){
				alert("登录名不能小于两个字符或者大于十个字符!")
			}else if(name=="loginname"&&(value.length>=2&&value.length<=10)){
				$.get("http://localhost:8080/easybuy/user","ajaxLoginName="+value,function(result){
					if(result=="true1"){
						flag = false;
						$(".prompt").html("该用户名已被注册，请直接登录。")
					}
				},"text")
			}
			if(name=="password2"&&(value!=$(".2_pwd").val())){
				flag = false;
				$(".prompt").html("两次输入的密码需一致！")
			}
			if(name=="username"&&(value.length<2||value.length>10)){
				alert(111)
				flag = false;
				$(".prompt").html("真实姓名不能小于两个字符或者大于十个字符！")
			}
			if(name=="identityCode"&&(!id.test(value))){
				flag = false;
				$(".prompt").html("身份证号格式不正确！")
			}
			if(name=="email"&&(!emile.test(value))){
				flag = false;
				$(".cprompt").html("邮箱格式不正确！")
			}
			if(name=="mobile"&&(!mobileNum.test(value))){
				flag = false;
				$(".cprompt").html("手机号格式不正确！")
			}
			if(name=="checkCode"){
				$.get("http://localhost:8080/easybuy/checkCode","checkCode="+value,function(result){
					if(result=="true"){
						$(".checkprompt").html("验证码输入有误！")
					}else{
						$(".checkprompt").html("")
					}
				},"text")
			}
			if(flag){
				$(".prompt").html("")
				$(".cprompt").html("")
				$(".checkprompt").html("")
			}
		}
	})
	 $(".changeCode").click(function(){
		 /*$.ajax({
			"url" : path+"/checkCode",// 要提交的URL路径
			"type" : "post", // 发送请求的方式
			"data" : "info=changeCode", // 要发送到服务器的数据
			"dataType" : "json", // 预期接收的数据格式
			"success" : function(result) { // 请求成功后要执行的代码
				alert(result)
			}
		}); */
		 $.get("http://localhost:8080/easybuy/checkCode","info=changeCode",function(result){
			$(".td_change").html("<img  style=\"position:absolute;top:655px;right:400px\" alt=\"验证码\" src=\"${pageContext.request.contextPath }/statics/common/checkCodeImages/"+result+"\">")
		},"text") 
	})
	
})