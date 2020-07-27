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
<title>员工</title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
<script src="${ct}js/jquery.min.js"></script>
<script src="${ct}js/popper.min.js"></script>
<script src="${ct}js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
<h4>调整部门</h4>
  <div class="input-group">
	<input type='text' class="form-control" id='uid' name="uid"  placeholder="请输入员工工号"/>
	  <span class="input-group-btn">
	    <input class="btn btn-secondary"  id="select_btn" type="submit" value="搜索" >
	</span>
</div>
<c:if test="${em!=null }">
 
		<form method="post" id="form1" action="${ct }manager/employAlterSave">
			<div class="form-group">

				<label>工号:</label> <input type="text" class="form-control" id="id"
					readonly="readonly" name="id" value="${em.id}">
			</div>

			<div class="form-group">
				<label>姓名: </label> <input type="text" class="form-control"
					id="uname" readonly="readonly" name="uname"
					value="${em.uname}">
			</div>
			<div class="form-group">

				<label>性别: <c:if test="${em.ugender==1}">男</c:if> <c:if
						test="${em.ugender==0}">女</c:if>
				</label>

			</div>
			<div class="form-group">
				<label>手机号:</label> <input type="text" class="form-control" readonly="readonly"
					id="uphone" name="uphone" value="${em.uphone}">
			</div>

			<div class="form-group">

				<label for="email">邮箱:</label> <input type="email" readonly="readonly"
					class="form-control" id="uemail" name="uemail"
					value="${em.uemail}">
			</div>

          <div class="form-group">

				<div class="form-group">
					<label for="sel1">部门:</label> <select class="form-control"
						id="department" name="depart">
						<option value="1">技术部</option>
						<option value="2">财务部</option>
						<option value="4">总裁办</option>
						<option value="3" >人事部</option>
					</select>
				</div>
			</div>
			
			<button type="submit" class="btn btn-primary" id="btn_alter">Submit</button>
		</form>
 

</c:if>
</div>
</body>
<script type="text/javascript">
$("#select_btn").click(function(){
    var id=$("#uid").val();
	 if(id != null || id !='' ){
		 window.location.href = "${ct}manager/employAlterSelect?id="+id;
	   }
 });

</script>
</html>