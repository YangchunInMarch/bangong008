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
<title></title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
 <script src="${ct}js/jquery.min.js"></script>
  <script src="${ct}js/popper.min.js"></script>
  <script src="${ct}js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container-fluid">
	<h4>添加会议成功</h4>
					<ul class="list-group">
			<li class="list-group-item">召开人： ${employee.uname}</li>
			<li class="list-group-item">参加人： ${meeting.mperson}</li>
			<li class="list-group-item">主题： ${meeting.mtitle}</li>
			
			<li class="list-group-item">具体内容：
				<div class="card">
					<div class="card-body">${meeting.mcontent}</div>
				</div>
			</li>
		</ul>
		
	</div>
</body>
</html>