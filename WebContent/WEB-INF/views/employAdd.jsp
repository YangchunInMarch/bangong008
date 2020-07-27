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
		<form  id="form1"  action="${ct}manager/employSave" method="post" onsubmit="return check()">
			<div class="form-group">
				<label>工号:</label> <input type="text" value="${eid}" readonly="readonly" name="id" class="form-control">
			</div>
					
			<div class="form-group">
				<label>姓名:</label> <input type="text" name="uname"  id="uname" class="form-control">
			</div>
			<div class="form-group">
				<label>性别:</label>

				<div class="radio">
					<label><input type="radio" name="ugender" value="1" checked="checked">男</label> <label><input
						type="radio" name="ugender" value="0">女</label>
				</div>


			</div>
			<div class="form-group">

				<label>身份证号:</label> <input type="text" name="ucard" id="ucard" class="form-control">
			</div>

			<div class="form-group">

				<label>手机号:</label> <input type="text" name="uphone" id="uphone" class="form-control">
			</div>

			<div class="form-group">

				<label for="email">邮箱:</label> <input type="email" name="uemail"  id="uemail"
					class="form-control" >
			</div>
			<div class="form-group">

				<div class="form-group">
					<label for="sel1">部门:</label> <select class="form-control"
						id="department" name="department">
						<option value="1">技术部</option>
						<option value="2">财务部</option>
						<option value="4">总裁办</option>
						<option value="3" >人事部</option>
					</select>
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


	</div>



</body>
<script type="text/javascript">
function check(){
	
	//判断邮箱
	var uphone=$("#uphone").val();
	var ucard = $("#ucard").val();
	var uemail = $("#uemail").val();
	var uname = $("#uname").val();
	 
	if(uphone==''||uphone==null){
		alert('手机号不能为空');
		return false;
	}
	 
	if(uname==''||uname==null){
		alert('姓名不能为空');
		return false;
	}
	//判空
    if(ucard==''||ucard==null){
		alert('身份证号不能为空');
		return false;
	}
	
	 
	 
	if(uemail==''||uemail==null){
		alert('邮箱不能为空');
		return false;
	}
}
</script>
</html>