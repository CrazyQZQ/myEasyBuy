// JavaScript Document


function addUpdate(jia){		
	var c = jia.parent().find(".n_ipt").val();
	c=parseInt(c)+1;	
	jia.parent().find(".n_ipt").val(c);
}

function jianUpdate(jian){    
	var c = jian.parent().find(".n_ipt").val();
	if(c==1){    
		c=1;    
	}else{    
		c=parseInt(c)-1;    
		jian.parent().find(".n_ipt").val(c);
	}
}    




function addUpdate1(jia,price,index,productId){		
	var c = jia.parent().find("#car_ipt"+index).val();
	c=parseInt(c)+1;	
	jia.parent().find(".car_ipt").val(c);
	var itemMoney = c*price
	$("#itemMoney"+index).html("￥"+itemMoney)
	totalMoney()
	$.ajax({
		"url" : "http://localhost:8080/easybuy/cart",// 要提交的URL路径
		"type" : "post", // 发送请求的方式
		"data" : {"id":productId,"do":"jia"}, // 要发送到服务器的数据
		"dataType" : "html", // 预期接收的数据格式
		"success" : function(result) { // 请求成功后要执行的代码
			$("#search").html(result)
		}
	});
}

function jianUpdate1(jian,price,index,productId){ 
	var c = jian.parent().find("#car_ipt"+index).val();
	if(c==1){    
		c=1;    
	}else{    
		c=parseInt(c)-1;    
		jian.parent().find(".car_ipt").val(c);
	}
	var itemMoney = c*price
	$("#itemMoney"+index).html("￥"+itemMoney)
	totalMoney()
	if (c!=1) {
		$.ajax({
			"url" : "http://localhost:8080/easybuy/cart",// 要提交的URL路径
			"type" : "post", // 发送请求的方式
			"data" : {"id":productId,"do":"jian"}, // 要发送到服务器的数据
			"dataType" : "html", // 预期接收的数据格式
			"success" : function(result) { // 请求成功后要执行的代码
				$("#search").html(result)
			}
		});
	}
}    

function totalMoney(){
	var totalMoney = 0;
	$(".itemMoney").each(function(){
		var h = $(this).html();
		var itemMoney1 = h.substring(1)
		var itemMoney2 = parseFloat(itemMoney1)
		totalMoney=totalMoney+itemMoney2;
	})
	$(".totalMoney").html("￥"+totalMoney);
}
