/**
 * 
 */

 $(function(){
	 $(".leftNav").hide();
		$(".nav").hover(function(){						   
			$(".leftNav").show();
		},function(){
			$(".leftNav").hide();
		});
	});