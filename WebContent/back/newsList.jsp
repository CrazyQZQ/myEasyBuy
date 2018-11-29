<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="${pageContext.request.contextPath }/statics/common/css/myAlert.css" rel="stylesheet" />
<title>所有资讯</title>
</head>
<body>
<!--Begin Header Begin-->
<%@include file="/common/pre/header.jsp" %>	
<%@include file="/common/back/back_searchBar.jsp" %>	
<!--End Header End--> 
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
	<div class="m_content">
   		<%@include file="/common/back/left.jsp" %>
		<div class="m_right">
            <p></p>
            <div class="mem_tit">资讯列表</div>
            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="35%">标题</td>
                <!-- <td width="30%">内容</td> -->
                <td width="35%">时间</td>
                <td width="30%" >操作</td>
                <!-- <td width="15%">操作</td> -->
              </tr>
              <c:forEach items="${newsPage.objList }" var="news">
	              <tr>
	                <td>${news.title }</td>
	                <!-- <td>--</td> -->
	                <td>${news.createTime }</td>
	                <td><a href="${pageContext.request.contextPath }/handerDelete?aim=news&newsId=${news.id }">删除</a></td>
	              </tr>
              </c:forEach>
            </table>
            <div class="pages">
           		<c:if test="${newsPage.currPageNo>1}">
            	<a href="${pageContext.request.contextPath }/back?aim=newsList&currentPageNo=1" class="p_fir">首页</a>	
  				<a href="${pageContext.request.contextPath }/back?aim=newsList&currentPageNo=${newsPage.currPageNo-1}" class="p_pre">上一页</a>
 				</c:if>
 				<c:forEach begin="1" end="${newsPage.totalPageCount}" step="1" varStatus="i">
 				<a href="#" <c:if test="${(i.index)==newsPage.currPageNo }">class="cur"</c:if>>${i.index }</a>
 				</c:forEach>
 				<c:if test="${newsPage.currPageNo<newsPage.totalPageCount}">
 					<a href="${pageContext.request.contextPath }/back?aim=newsList&currentPageNo=${newsPage.currPageNo+1}" class="p_pre">下一页</a>
 					<a href="${pageContext.request.contextPath }/back?aim=newsList&currentPageNo=${newsPage.totalPageCount}" class="p_last">尾页</a>
 				</c:if>
			</div>
        </div>
    </div>
	<!--End 用户中心 End--> 
	
    <!--Begin Footer Begin -->
    <%@include file="/common/pre/footer.jsp" %>
    <!--End Footer End -->    
</div>

<script type="text/javascript">
$(function(){
	$("#news").addClass("now")
	var error ='${param.error}'
	if(error=='yes'){
		alert("删除失败!");
	}else if(error=='no'){
		alert("删除成功!");
	}
})
</script>
</body>
</html>