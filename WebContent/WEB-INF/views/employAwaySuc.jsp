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
	<h4>离职成功</h4>
	</div>
</body>
</html>