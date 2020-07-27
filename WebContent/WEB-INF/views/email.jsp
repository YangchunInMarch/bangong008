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
<title>邮件</title>
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
	<h4>日常一处理，邮箱空空也~</h4>
	<!-- 搜索框 -->
		<div class="input-group">
			<input type='text' class="form-control" id="efromName" name="efromName" /> <span
				class="input-group-btn"> <input class="btn btn-secondary"
				id="select_btn" type="submit" value="搜索">
			</span>
		</div>
	<!-- 选择按钮 -->	
		<div class="card">
			<div class="card-body">
				<button class="btn btn-secondary" id="btn_email_0">待处理</button>
				<button class="btn btn-secondary" id="btn_email_1">已处理</button>
				<button class="btn btn-secondary" id="btn_email_send">已发送的邮件</button>
			</div>
		</div>
   <!--  邮件列表  待处理 以及 已处理-->
   <c:if test="${lists!=null}">
      <c:forEach items="${lists}" var="email">
      	<div class="card">
			<div class="card-body">
			<c:if test="${email.efrom  eq employee.id}">	<strong>${email.esendName} </strong>   </c:if>
			<c:if test="${email.efrom  != employee.id}"><strong>${email.efromName} </strong>      </c:if>
				
				<div style="float:right;display: inline">
				<a href="${ct }email/lookEmail?id=${email.id}"   class="aa"> 查看</a>
				
				<c:if test="${ email.estate==0}">
				 <a href="${ct }email/targetEmail?id=${email.id}" class="aa"> 未读</a>
				</c:if>
				<c:if test="${ email.estate==1}">
				<span class="aa">   已读 </span>
				</c:if>
				 
				 <a href="${ct }email/deleteEmail?id=${email.id}"   class="aa"> 删除邮件</a>
				 
				 </div>
				
				 
				 <br/>
				${email.etitle} 
				<div style="float:right;display: inline"><mark>${email.etime} </mark> </div>
			</div>
		</div>
      </c:forEach>
   </c:if>
   
   
	</div>
<script type="text/javascript">
 //邮件的查询，查询发送者 
   $("#select_btn").click(function(){
     var efromName=$("#efromName").val();
		 window.location.href = "${ct}email/selectEmail?efromName="+efromName;
	    
  });
 
   $("#btn_email_0").click(function(){
			 window.location.href = "${ct}email/email";
		    
	});
   //
   $("#btn_email_1").click(function(){
		 window.location.href = "${ct}email/email02";
	    
}); 
   
   $("#btn_email_send").click(function(){
		 window.location.href = "${ct}email/selectMe";
}); 
   
</script>


</body>
</html>