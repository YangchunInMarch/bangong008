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
</style>
</head>
<body>
	<div class="container-fluid">
		<ul class="list-group">
			<li class="list-group-item">发件人： ${email.efromName}</li>
			<li class="list-group-item">收件人： ${email.esendName}</li>
			<li class="list-group-item">部门： <c:if
					test="${employee.department==1}">技术部</c:if> <c:if
					test="${employee.department==2}">财务部</c:if> <c:if
					test="${employee.department==3}">人事部</c:if> <c:if
					test="${employee.department==4}">总裁办</c:if>

			</li>
			<li class="list-group-item">主题： ${email.etitle}</li>
			<li class="list-group-item">具体内容：
				<div class="card">
					<div class="card-body">${email.econtent}</div>
				</div>
			</li>
			<li class="list-group-item">附件：
			<a href="${ct }email/materialDowload?fileName=${email.efile}"> ${email.efile}</a></li>
	        <li class="list-group-item">
	        <c:if test="${email.efrom != employee.id}">
	            <a href="${ct}email/replyEmail?id=${email.efrom}">回信</a>
	        </c:if>
	      
	        </li>
		</ul>

	</div>
</body>
</html>