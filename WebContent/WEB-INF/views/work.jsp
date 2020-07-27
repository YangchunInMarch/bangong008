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
<title>日程</title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
 <script src="${ct}js/jquery.min.js"></script>
  <script src="${ct}js/popper.min.js"></script>
  <script src="${ct}js/bootstrap.min.js"></script>
</head>
<body>
  
<div class="container-fluid">
  <span style="font-size:25px">工作</span>  <a href="${ct}goals/workAdd" target="middleframe">添加工作安排</a><br/>

  <c:forEach items="${lists}" var="goal">
    <div class="card">
  <div class="card-body">
	 <span id="${goal.id}" class="card-link">${goal.title}， ${goal.time}  </span><br/>
	 ${goal.content}
	</div>
   </div>
  </c:forEach>
    
  
   
</div>
</body>
</html>