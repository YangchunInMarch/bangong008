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
<title>百耀科技集团注册</title>
<link rel="stylesheet" type="text/css" href="css/02/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/02/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/02/component.css" />
<script src="${ct}js/jquery.min.js"></script>
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>百耀科技集团注册</h3>
						<form action="#" method="post" id="form1">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="id"  id="id" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入工号">
							</div>
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="uphone"  id="uphone" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入手机号">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="upass" id="password1" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" type="password" placeholder="请输入密码">
							</div>
							
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" id="password2" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" type="password" placeholder="请输入密码">
							</div>
							<div class="mb2"><a class="act-but submit"   style="color: #FFFFFF" id="register_submit"> 注册</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="${ct }js/02/TweenLite.min.js"></script>
		<script src="${ct }js/02/EasePack.min.js"></script>
		<script src="${ct }js/02/rAF.js"></script>
		<script src="${ct }js/02/demo-1.js"></script>
		
</body>

<script type="text/javascript">
var CT = '${ct}';
$("#register_submit").click(function() {

	//判断邮箱
	var id = $("#id").val();
	var phone=$("#uphone").val();
	var password1 = $("#password1").val();
	var password2 = $("#password2").val();
	 
	var data={}
	data.uphone=phone;
	data.id=id;
	data.upass=password1;
	
	if(phone==''||phone==null){
		alert('手机号不能为空');
		return false;
	}
	
	//判空
    if(id==''||id==null){
		alert('工号不能为空');
		return false;
	}
	
	 
	 
	if(password1==''||password1==null){
		alert('登录密码不能为空');
		return false;
	}
	 
	 
	if(password2==''||password2==null){
		alert('登录密码不能为空');
		return false;
	}
	 
	if(password1 !=password2){
		alert('2次输入密码必须一致');
		return false;
	}
	
	  
	  
	  $.post(CT +"employee/register.json", data,
	          
				function(data) {
				//	alert(JSON.stringify(data));
			//		alert("data.BResult.success:" + data.BResult.success);
					if (data.success) {
				//		alert('成功');
						window.location.href = "${ct}login.jsp";
					} else {
						alert('工号、手机号输入有误，请检查');
					}
				}, "json");
	  
	  

	
	
	});
</script>
</html>