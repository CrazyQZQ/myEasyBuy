// JavaScript Document
var jq = jQuery.noConflict();

jQuery(document).ready(function(){
	jq(".leftNav").hide();
	jq(".nav").hover(function(){						   
		jq(this).find(".leftNav").show();
	},function(){
		jq(this).find(".leftNav").hide();
	});
});	


