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
<title>员工管理</title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
<script src="${ct}js/jquery.min.js"></script>
<script src="${ct}js/popper.min.js"></script>
<script src="${ct}js/bootstrap.min.js"></script>
<%@include file="header.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<!-------------------------------- 左侧----------------------->
			<div class="col-sm-2 bg-light">
				<div class="media mt-3">
					<img src="https://static.runoob.com/images/mobile-icon.png"
						class="align-self-start mr-3" style="width: 40px">
					<div class="media-body">
						<a href="${ct}myInfo/myInfo" target="middleframe">${employee.uname}(
						 <c:if test="${employee.department==1}">技术部</c:if>
							<c:if test="${employee.department==2}">财务部</c:if>
							<c:if test="${employee.department==3}">人事部</c:if>
							<c:if test="${employee.department==4}">总裁办</c:if>
						)</a>
					</div>
				</div>


    <nav class="navbar bg-light">
 <ul class="nav nav-pills flex-column">
        <li class="nav-item">
		 <button class="btn btn-light">   <a class="nav-link" href="${ct}manager/employList" target="middleframe" >员工列表</a></button>
        </li>
		  <li class="nav-item">
		 <button class="btn btn-light">   <a class="nav-link" href="${ct}manager/employAdd" target="middleframe">新员工入职</a></button>
        </li>
	 <li class="nav-item">
		 <button class="btn btn-light">   <a class="nav-link" href="${ct }manager/employAway" target="middleframe">离职</a></button>
        </li>
		 <li class="nav-item">
		 <button class="btn btn-light">   <a class="nav-link" href="${ct}manager/employAlter" target="middleframe">调整部门</a></button>
        </li>
      </ul>
	  
	       	
</nav>
<br>

      <hr class="hidden-sm hidden-md hidden-lg">
    </div>
	<!------------------------ 中间-------------------------->
    <div class="col-sm-10">
   <div class="embed-responsive embed-responsive-4by3">
      <iframe name="middleframe" class="embed-responsive-item" style="width:100%" src="${ct }manager/right"></iframe>
</div>

    </div>
    
  </div>

</div>
    

</body>
</html>