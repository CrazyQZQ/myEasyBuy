/**
 * 
 */
$(function(){
	 $("#cart_three").click(function(){
		 var adressId = 0;
		 var adress = null;
		 var remark = null;
		 $(".adressId").each(function(){
			 if ($(this).prop('checked')) {
				 adressId = $(this).val()
			}
		 })
		 if (adressId==-1) {
			 adress = $("#add_ipt").val();
			 remark = $("#rek_ipt").val();
		}
		 $.ajax({
				"url" : "http://localhost:8080/easybuy/newOrder",// 要提交的URL路径
				"type" : "post", // 发送请求的方式
				"data" : {"action":"three","adressId":adressId,"adress":adress,"remark":remark}, // 要发送到服务器的数据
				"dataType" : "html", // 预期接收的数据格式
				"success" : function(result) { // 请求成功后要执行的代码
					$("#dd").html(result)
				}
			});
	 })
 })