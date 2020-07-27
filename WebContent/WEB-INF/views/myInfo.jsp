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
<title>首页</title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
 <script src="${ct}js/jquery.min.js"></script>
  <script src="${ct}js/popper.min.js"></script>
  <script src="${ct}js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container-fluid">
	
			<ul class="list-group">
						<li class="list-group-item">
						<div class="media">
                     <input type="hidden" id="uid" value="">		
							头像：	
								 <img src="https://static.runoob.com/images/mobile-icon.png" class="align-self-start mr-3" style="width:40px">
							</div>
							</li>
						<li class="list-group-item">姓名： ${employee.uname}
						</li>
						<li class="list-group-item">部门：
						  <c:if test="${employee.department==1}">技术部</c:if>
							<c:if test="${employee.department==2}">财务部</c:if>
							<c:if test="${employee.department==3}">人事部</c:if>
							<c:if test="${employee.department==4}">总裁办</c:if>
						 
						</li>
					   <li class="list-group-item">性别： 
					        <c:if test="${employee.ugender==1}">男</c:if>
							<c:if test="${employee.ugender==0}">女</c:if>
					                                    </li>
						<li class="list-group-item">邮箱： ${employee.uemail}				
						</li>
						<li class="list-group-item">密码：********** 
						</li>
						<li class="list-group-item">手机号：${employee.uphone}		
						</li>
						<li class="list-group-item">身份证号：${employee.ucard}		
						</li>
						<li class="list-group-item"><a href="${ct}myInfo/alterInfo" target="middleframe"> 修改个人信息   </a></li>
					
					</ul>
		
	</div>
</body>
</html>