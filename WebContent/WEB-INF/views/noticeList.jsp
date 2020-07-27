<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set var="ct" value="<%=basePath%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>联系人</title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
<script src="${ct}js/jquery.min.js"></script>
<script src="${ct}js/popper.min.js"></script>
<script src="${ct}js/bootstrap.min.js"></script>
<style>
   .aa{
    margin-left:100px;
    
 }
</style>

</head>
<body>

<div class="container-fluid">
		<h4>公司公告</h4>
<div class="input-group">
	<input type='text' class="form-control" id='ntitle' name="ntitle"/>
	  <span class="input-group-btn">
	    <input class="btn btn-secondary" id="select_btn" type="submit" value="搜索" >
	</span>
</div>
		<c:if test="${lists!=null }">
			<c:forEach items="${lists }" var="notice">
				<div class="card-body">
                <strong>${notice.ntitle}</strong>
                
                <div style="float:right;display: inline">
				  <a href="${ct }notice/lookNotice?id=${notice.id}"   class="aa"> 查看</a>
				 <!-- 只有总裁办的人才有权利删除公告 -->
				 <c:if test="${employee.department==4}">
				  <a href="${ct }notice/deleteNotice?id=${notice.id}"   class="aa"> 删除这条公告</a>
				 </c:if> 
				 
				 </div><br/>
				 发布时间 ：${notice.ntime}
				</div>
			</c:forEach>

		</c:if>

	</div>
	
</body>
<script type="text/javascript">
  $("#select_btn").click(function(){
     var ntitle=$("#ntitle").val();
	 if(ntitle != null || ntitle !='' ){
		 window.location.href = "${ct}notice/noticeList?ntitle="+ntitle;
	   }
  });
</script>
</html>