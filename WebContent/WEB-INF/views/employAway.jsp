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
<title>离职</title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
<script src="${ct}js/jquery.min.js"></script>
<script src="${ct}js/popper.min.js"></script>
<script src="${ct}js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
<h4>员工离职</h4>
<div class="input-group">
	<input type='text' class="form-control" id='uid' name="uid" placeholder="请输入员工工号"/>
	  <span class="input-group-btn">
	    <input class="btn btn-secondary"  id="select_btn" type="submit" value="搜索" >
	</span>
</div>
<c:if test="${em!=null }">
 
		<form method="post" id="form1" action="${ct }manager/employAwaySave" onsubmit="return check()">
			<div class="form-group">
				<label>工号:${em.id}</label> 
				<input type="hidden" class="form-control" id="id"
					 name="id" value="${em.id}">
			</div>

			<div class="form-group">
				<label>姓名: ${em.uname}</label> 
			</div>
			<div class="form-group">

				<label>性别: <c:if test="${em.ugender==1}">男</c:if> <c:if
						test="${em.ugender==0}">女</c:if>
				</label>

			</div>
			



				<div class="form-group">
					<label>部门：</label> 
						  <c:if test="${em.department=='1'}">技术部</c:if>
							<c:if test="${em.department=='2'}">财务部</c:if>
							<c:if test="${em.department=='3'}">人事部</c:if>
							<c:if test="${em.department=='4'}">总裁办</c:if>
						 
						 
				</div>
			<div class="form-group">
				<label for="comment">离职原因:</label>
				<textarea class="form-control" rows="5" id="ecomment" name="econtent"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
 

</c:if>
</div>
</body>
<script type="text/javascript">
$("#select_btn").click(function(){
	
    var id=$("#uid").val();
	 if(id != null || id !='' ){
		 window.location.href = "${ct}manager/employAway?id="+id;
	   }
	 
 });

function check(){
	 var ecomment=$("#ecomment").val();
	 if(ecomment==null || ecomment==''){
		 alert('离职原因不能为空');
		 return false;
	 }
}

</script>
</html>