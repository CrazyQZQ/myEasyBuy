<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--[if IE 6]>
    <script src="${pageContext.request.contextPath }/statics/common/js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->
    <link type="text/css" href="${pageContext.request.contextPath }/statics/common/css/myAlert.css" rel="stylesheet" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/common/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/menu.js"></script>    
            
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/lrscroll_1.js"></script>   
     
    
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/n_nav.js"></script>
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/common/css/ShopShow.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/common/css/MagicZoom.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/MagicZoom.js"></script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/num.js">
    	var jq = jQuery.noConflict();
    </script>
        
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/p_tab.js"></script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/shade.js"></script>
<title>商品详情</title>
</head>
<body>
<!--Begin Header Begin-->
<%@include file="/common/pre/header.jsp" %>
<div id="searchBar">
<%@include file="/common/pre/searchBar.jsp" %>
</div>


<!--End Header End--> 
<!--Begin Menu Begin-->
<%@include file="/common/pre/category.jsp" %>
<!--End Menu End--> 
<div class="i_bg">
	<div class="postion">
    	<span class="fl">全部 > ${productDetail.name}</span>
    </div>    
    <div class="content">
    	                    
        <div id="tsShopContainer">
            <div id="tsImgS"><a href="${pageContext.request.contextPath }/statics/common/images/${productDetail.fileName}" title="Images" class="MagicZoom" id="MagicZoom"><img src="${pageContext.request.contextPath }/statics/common/images/${productDetail.fileName}" width="390" height="390" /></a></div>
            <div id="tsPicContainer">
                <div id="tsImgSArrL" onclick="tsScrollArrLeft()"></div>
                <div id="tsImgSCon" style="width: 350px">
                    <ul>
                        <li onclick="showPic(0)" rel="MagicZoom" class="tsSelectImg"><img src="${pageContext.request.contextPath }/statics/common/images/${productDetail.fileName}" tsImgS="${pageContext.request.contextPath }/statics/common/images/${productDetail.fileName}" width="79" height="79" /></li>
                    </ul>
                </div>
                <div id="tsImgSArrR" onclick="tsScrollArrRight()"></div>
            </div>
            <img class="MagicZoomLoading" width="16" height="16" src="${pageContext.request.contextPath }/statics/common/images/loading.gif" alt="Loading..." />				
        </div>
        
        <div class="pro_des">
        	<div class="des_name">
            	<p>${productDetail.name}</p>
                “开业巨惠，北京专柜直供”，不光低价，“真”才靠谱！
            </div>
            <div class="des_price">
            	本店价格：<b>￥${productDetail.price}</b><br />
                消费积分：<span>28R</span>
            </div>
            <div class="des_choice">
            	<span class="fl">型号选择：</span>
                <ul>
                	<li class="checked">30ml<div class="ch_img"></div></li>
                    <li>50ml<div class="ch_img"></div></li>
                    <li>100ml<div class="ch_img"></div></li>
                </ul>
            </div>
            <div class="des_choice">
            	<span class="fl">颜色选择：</span>
                <ul>
                	<li>红色<div class="ch_img"></div></li>
                    <li class="checked">白色<div class="ch_img"></div></li>
                    <li>黑色<div class="ch_img"></div></li>
                </ul>
            </div>
            <div class="des_share">
            	<div class="d_sh">
                	分享
                    <div class="d_sh_bg">
                    	<a href="#"><img src="${pageContext.request.contextPath }/statics/common/images/sh_1.gif" /></a>
                        <a href="#"><img src="${pageContext.request.contextPath }/statics/common/images/sh_2.gif" /></a>
                        <a href="#"><img src="${pageContext.request.contextPath }/statics/common/images/sh_3.gif" /></a>
                        <a href="#"><img src="${pageContext.request.contextPath }/statics/common/images/sh_4.gif" /></a>
                        <a href="#"><img src="${pageContext.request.contextPath }/statics/common/images/sh_5.gif" /></a>
                    </div>
                </div>
                <div class="d_care"><a onclick="ShowDiv('MyDiv','fade')">关注商品</a></div>
            </div>
            <div class="des_join">
            	<div class="j_nums">
                	<input type="text" value="1" name="" class="n_ipt" />
                    <input type="button" value="" onclick="addUpdate(jq(this));" class="n_btn_1" />
                    <input type="button" value="" onclick="jianUpdate(jq(this));" class="n_btn_2" />   
                </div>
                <span class="fl"><a onclick="Show(${productDetail.stock})"><img src="${pageContext.request.contextPath }/statics/common/images/j_car.png" onclick="addCard(${productDetail.id})"  /></a></span>
            </div>            
        </div>    
        
           
        
        
    </div>
    <div class="content mar_20">
    	
        <div class="l_list">        	
            
            <div class="des_border">
                <div class="des_tit">
                	<ul>
                    	<li class="current"><a href="#p_attribute">商品属性</a></li>
                    </ul>
                </div>
                <div class="des_con" id="p_attribute">
                	
                	<table border="0" align="center" style="width:100%; font-family:'宋体'; margin:10px auto;" cellspacing="0" cellpadding="0">
                      <tr>
                        <td>商品名称：${productDetail.name}</td>
                        <td>商品编号：1546211</td>
                        <td>品牌： ${productDetail.name}</td>
                        <td>上架时间：2015-09-06 09:19:09 </td>
                      </tr>
                      <tr>
                        <td>商品毛重：160.00g</td>
                        <td>商品产地：China</td>
                        <td>香调：</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>容量： </td>
                        <td>类型：</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                    </table>                                               
                                            
                        
                </div>
          	</div>  
        </div>
    </div>
    <!--Begin 弹出层-收藏成功 Begin-->
    <div id="fade" class="black_overlay"></div>
    <div id="MyDiv" class="white_content">             
        <div class="white_d">
            <div class="notice_t">
                <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv('MyDiv','fade')"><img src="${pageContext.request.contextPath }/statics/common/images/close.gif" /></span>
            </div>
            <div class="notice_c">
           		
                <table border="0" align="center" style="margin-top:;" cellspacing="0" cellpadding="0">
                  <tr valign="top">
                    <td width="40"><img src="${pageContext.request.contextPath }/statics/common/images/suc.png" /></td>
                    <td>
                    	<span style="color:#3e3e3e; font-size:18px; font-weight:bold;">您已成功收藏该商品</span><br />
                    	<a href="#">查看我的关注 >></a>
                    </td>
                  </tr>
                  <tr height="50" valign="bottom">
                  	<td>&nbsp;</td>
                    <td><a href="#" class="b_sure">确定</a></td>
                  </tr>
                </table>
                    
            </div>
        </div>
    </div>    
    <!--End 弹出层-收藏成功 End-->
    
    
    <!--Begin 弹出层-加入购物车 Begin-->
    <div id="wind_p" style="display: none;background: #FF3200" class="wind" >
		<span class="inputWords" style="color:white">操作成功</span>
	</div> 
    <!--End 弹出层-加入购物车 End-->
    
    
    
    <!--Begin Footer Begin -->
     <%@include file="/common/pre/footer.jsp" %>
    <!--End Footer End -->    
</div>
</body>
 <script type="text/javascript" src="${pageContext.request.contextPath }/statics/common/js/jquery-1.8.2.min.js"></script>
<%-- <script src="${pageContext.request.contextPath }/statics/common/js/ShopShow.js"></script> --%>
<script src="${pageContext.request.contextPath }/statics/common/js/product_addcart.js"></script>
<script type="text/javascript">
function Show(stock){
	var num = $(".n_ipt").val();
	if(isNaN(num)){
		alert("非法输入！！")
	}else if(num>stock){
		alert("库存不足！！")
	}
	$("#wind_p").fadeIn();
    setTimeout($("#wind_p").fadeOut(),4000)
}
</script>
<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>