/**
 * 
 */
$(function(){
	 $("#cart_two").click(function(){
		 $.ajax({
				"url" : "http://localhost:8080/easybuy/newOrder",// 要提交的URL路径
				"type" : "post", // 发送请求的方式
				"data" : {"action":"two"}, // 要发送到服务器的数据
				"dataType" : "html", // 预期接收的数据格式
				"success" : function(result) { // 请求成功后要执行的代码
					$("#dd").html(result)
				}
			});
	 })
 })