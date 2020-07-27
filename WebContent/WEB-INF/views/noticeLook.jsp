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
<title>公告</title>
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
			<li class="list-group-item">公告主题： ${notice.ntitle}</li>
			<li class="list-group-item">发布人： ${notice.npeople}</li>
			<li class="list-group-item">发布时间： ${notice.ntime}</li>
			<li class="list-group-item">具体内容：
				<div class="card">
					<div class="card-body">${notice.ncontent}</div>
				</div>
			</li>
		</ul>

	</div>
</body>
</html>