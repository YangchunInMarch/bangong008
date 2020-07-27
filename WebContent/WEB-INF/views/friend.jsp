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
</head>
<body>

<div class="container-fluid">
		<h4>同事~同时一起，多联系</h4>
<div class="input-group">
	<input type='text' class="form-control" id='uname' name="uname"/>
	  <span class="input-group-btn">
	    <input class="btn btn-secondary" id="select_btn" type="submit" value="搜索" >
	</span>
</div>
		<c:if test="${lists!=null }">
			<c:forEach items="${lists }" var="employee">
				<div class="card-body">
					<div class="media mt-3">
						<img src="https://static.runoob.com/images/mobile-icon.png"
							class="align-self-start mr-3" style="width: 40px">
						<div class="media-body">
							<p>
								${employee.uname} (
							   <c:if test="${employee.department==1}">技术部</c:if>
							<c:if test="${employee.department==2}">财务部</c:if>
							<c:if test="${employee.department==3}">人事部</c:if>
							<c:if test="${employee.department==4}">总裁办</c:if>
								) <a href="${ct}email/replyEmail?id=${employee.id}" target="middleframe">发邮件</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</c:if>


		<c:if test="${listsByName!=null}">
			<c:forEach items="${listsByName}" var="employee">
				<div class="card-body">
					<div class="media mt-3">
						<img src="https://static.runoob.com/images/mobile-icon.png"
							class="align-self-start mr-3" style="width: 40px">
						<div class="media-body">
							<p>
								${employee.uname} (
							   <c:if test="${employee.department==1}">技术部</c:if>
							<c:if test="${employee.department==2}">财务部</c:if>
							<c:if test="${employee.department==3}">人事部</c:if>
							<c:if test="${employee.department==4}">总裁办</c:if>
								) <a href="sendEmail.html">发邮件</a>
						</div>
					</div>
				</div>
			</c:forEach>
			
		</c:if>
	</div>
	
</body>
<script type="text/javascript">
  $("#select_btn").click(function(){
     var uname=$("#uname").val();
	 if(uname != null || uname !='' ){
		 window.location.href = "${ct}friend/selectFriend?uname="+uname;
	   }
  });
</script>
</html>