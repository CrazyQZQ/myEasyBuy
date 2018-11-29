/**
 * 
 */

$(function(){
	$(".l_user").blur(function(){
		var value = $(this).val();
		if(value!=null&&value!=""){
			$.get("http://localhost:8080/easybuy/user","ifExsitName="+value,function(result){
				if(result=="true"){
					$(".prompt").html("该用户名尚未注册。")
				}else{
					$(".prompt").html("");
				}
			},"text")
		}
	})
})

