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
	<h4>添加员工成功</h4>
			<ul class="list-group">
						
						<li class="list-group-item">工号： ${em.id}
						<li class="list-group-item">姓名： ${em.uname}
						</li>
						<li class="list-group-item">部门：
						  <c:if test="${em.department==1}">技术部</c:if>
							<c:if test="${em.department==2}">财务部</c:if>
							<c:if test="${em.department==3}">人事部</c:if>
							<c:if test="${em.department==4}">总裁办</c:if>
						 
						</li>
					   <li class="list-group-item">性别： 
					        <c:if test="${em.ugender==1}">男</c:if>
							<c:if test="${em.ugender==0}">女</c:if>
					                                    </li>
						<li class="list-group-item">邮箱： ${em.uemail}				
						</li>
						<li class="list-group-item">手机号：${em.uphone}		
						</li>
						<li class="list-group-item">身份证号：${em.ucard}		
						</li>
					
					</ul>
		
	</div>
</body>
</html>