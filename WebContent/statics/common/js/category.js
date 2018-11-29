/**
 * 
 */

$(function(){
	$(".t1").hide();
	$(".t2").hide();
	$("#showtianjia").hide();
	$("#tianjia").click(function(){
		$("#showtianjia").show();
	})
	$(".jibie").change(function(){
		var value = $(this).val();
		if (value==1) {
			$(".t1").hide();
			$(".t2").hide();
		}
		if (value==2) {
			if (value!=0) {
				$.ajax({
					"url" : "http://localhost:8080/easybuy/category",// 要提交的URL路径
					"type" : "post", // 发送请求的方式
					"data" : {"cate":"first"}, // 要发送到服务器的数据
					"dataType" : "json", // 预期接收的数据格式
					"success" : function(result) { // 请求成功后要执行的代码
						$(".yiji").html("<option>请选择</option>");
						for(var s in result){
			                $(".yiji").append("<option value="+result[s].id+">"+result[s].name+"</option>");
			            }
					}
				});
			}
			
			$(".t1").show();
			$(".t2").hide();
		}
		if (value==3) {
			if (value!=0) {
				$.ajax({
					"url" : "http://localhost:8080/easybuy/category",// 要提交的URL路径
					"type" : "post", // 发送请求的方式
					"data" : {"cate":"first"}, // 要发送到服务器的数据
					"dataType" : "json", // 预期接收的数据格式
					"success" : function(result) { // 请求成功后要执行的代码
						$(".yiji").html("<option>请选择</option>");
						for(var s in result){
			                $(".yiji").append("<option value="+result[s].id+">"+result[s].name+"</option>");
			            }
					}
				});
			}
			$(".t1").show();
			$(".t2").show();
		}
	})
	$(".yiji").change(function(){
		var yijiId = $(this).val();
		if (yijiId!="请选择") {
			$.ajax({
				"url" : "http://localhost:8080/easybuy/category",// 要提交的URL路径
				"type" : "post", // 发送请求的方式
				"data" : {"cate":"second","id":yijiId}, // 要发送到服务器的数据
				"dataType" : "json", // 预期接收的数据格式
				"success" : function(result) { // 请求成功后要执行的代码
					$(".erji").html("<option>请选择</option>");
					for(var s in result){
		                $(".erji").append("<option value="+result[s].id+">"+result[s].name+"</option>");
		            }
				}
			});
		}
		
	})
	
})