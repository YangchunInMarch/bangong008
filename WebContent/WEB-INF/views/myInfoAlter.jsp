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
<title>修改个人信息</title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
<script src="${ct}js/jquery.min.js"></script>
<script src="${ct}js/popper.min.js"></script>
<script src="${ct}js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container-fluid">


		<form method="post" id="form1">
			<div class="form-group">

				<label>头像</label>
				  <img src="https://static.runoob.com/images/mobile-icon.png" class="align-self-start mr-3" style="width:40px">
			</div>
			<div class="form-group">

				<label>工号:</label> <input type="text" class="form-control" id="id"
					readonly="readonly" name="id" value="${employee.id}">
			</div>

			<div class="form-group">

				<label>姓名: </label> <input type="text" class="form-control"
					id="uname" readonly="readonly" name="uname"
					value="${employee.uname}">
			</div>
			<div class="form-group">

				<label>性别: <c:if test="${employee.ugender==1}">男</c:if> <c:if
						test="${employee.ugender==0}">女</c:if>
				</label>

			</div>



			<div class="form-group">

				<label>手机号:</label> <input type="text" class="form-control"
					id="uphone" name="uphone" value="${employee.uphone}" size="11">
			</div>

			<div class="form-group">

				<label for="email">邮箱:</label> <input type="email"
					class="form-control" id="uemail" name="uemail"
					value="${employee.uemail}" size="31">
			</div>
			<div class="form-group">
				<label for="pwd">修改密码-请输入原密码:</label> <input type="password"
					class="form-control" id="password" name="upass" size="30">
			</div>

			<div class="form-group">
				<label for="pwd">输入新密码:</label> <input type="password"
					class="form-control" id="password1" name="upassNew" size="30">
			</div>
			<div class="form-group">
				<label for="pwd">重复新密码:</label> <input type="password"
					class="form-control" id="password2" size="30">
			</div>

			<button type="submit" class="btn btn-primary" id="btn_alter">Submit</button>
		</form>
	</div>

	<script type="text/javascript">
		var CT = '${ct}';
		$("#btn_alter").click(function() {

			//判断邮箱
			var uemail = $("#uemail").val();
			var phone = $("#uphone").val();
			var password = $("#password").val();
			var password1 = $("#password1").val();
			var password2 = $("#password2").val();

			if (phone == '' || phone == null) {
				alert('手机号不能为空');
				return false;
			}

			//判空
			if (uemail == '' || uemail == null) {
				alert('邮箱不能为空');
				return false;
			}

			if (password == '' || password == null) {
				alert('登录密码不能为空');
				return false;
			}

			if (password1 == '' || password1 == null) {
				alert('登录密码不能为空');
				return false;
			}

			if (password2 == '' || password2 == null) {
				alert('登录密码不能为空');
				return false;
			}

			if (password1 != password2) {
				alert('2次输入密码必须一致');
				return false;
			}
			var data = {}
			data.uemail = uemail;
			data.uphone = phone;
			data.upass = password;
			data.upassNew = password1;

			$.post(CT + "myInfo/toAlterInfo.json", data,

			function(data) {
				alert(JSON.stringify(data));
				//		alert("data.BResult.success:" + data.BResult.success);
				if (data.success) {
					alert(data);
					alert('修改成功');
					window.location.href = CT + "myInfo/myInfo";
				} else {
					alert('原密码输入错误');
				}
			}, "json");

		});
	</script>

</body>
</html>