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
<title>联系人</title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
<script src="${ct}js/jquery.min.js"></script>
<script src="${ct}js/popper.min.js"></script>
<script src="${ct}js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container-fluid">


         分部门查看
		<div class="input-group  mb-3">
			<select class="form-control" name="depart" id="depart">
				<option value="1">技术部</option>
				<option value="2">财务部</option>
				<option value="4">总裁办</option>
				<option value="3">人事部</option>
			</select> 
			<span class="input-group-btn"> <input
				class="btn btn-secondary" id="select_btn" type="submit" value="搜索">
			</span>
		</div>

		<c:if test="${lists!=null}">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>工号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>部门</th>
						<th>手机号</th>
						<th>邮箱</th>
						<th>状态</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lists}" var="employee">
						<tr>
							<td>${employee.id}</td>
							<td>${employee.uname}</td>
							<td><c:if test="${employee.ugender==1}">男</c:if> <c:if
									test="${employee.ugender==0}">女</c:if></td>
							<td><c:if test="${employee.department==1}">技术部</c:if> <c:if
									test="${employee.department==2}">财务部</c:if> <c:if
									test="${employee.department==3}">人事部</c:if> <c:if
									test="${employee.department==4}">总裁办</c:if></td>
							<td>${employee.uphone}</td>
							<td>${employee.uemail}</td>
							<td>在职</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${lists==null }">
			<div class="card">
				<div class="card-body">暂无员工，请招人</div>
			</div>

		</c:if>
	</div>


</body>
<script type="text/javascript">
	$("#select_btn").click(
			function() {
				var depart = $("#depart").val();
				if (depart != null || depart != '') {
					window.location.href = "${ct}manager/employDepart?depart="
							+ depart;
				}
			});
</script>
</html>