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
<title>百耀科技集团登录</title>
<link rel="stylesheet" type="text/css" href="${ct}css/02/normalize.css" />
<link rel="stylesheet" type="text/css" href="${ct}css/02/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="${ct}css/02/component.css" />
<script src="${ct}js/jquery.min.js"></script>
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>百耀科技集团登录</h3>
						<form action="#" method="post" id="form1">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="id"  id="id" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="upass" id="upass" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" type="password" placeholder="请输入密码">
							</div>
							<a href="${ct}register.jsp">注册</a>
							<div class="mb2"><a class="act-but submit"   style="color: #FFFFFF" id="button_submit"> 登 录</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="${ct}js/02/TweenLite.min.js"></script>
		<script src="${ct}js/02/EasePack.min.js"></script>
		<script src="${ct}js/02/rAF.js"></script>
		<script src="${ct}js/02/demo-1.js"></script>
		
</body>


<script type="text/javascript">
var CT = '${ct}';
$("#button_submit").click(function() {
	var id = $("#id").val();
	var upass = $("#upass").val();
	if(id==''||id==null){
		alert('工号不能为空');
		return false;
	}
	if(upass==''||upass==null){
		alert('密码不能为空');
		return false;
	}
	 
	//  alert($('#form1').serialize());
	  
	  
	  $.post(CT +"employee/login.json", $('#form1').serialize(),
	          
				function(data) {
			//		alert(JSON.stringify(data));
			//		alert("data.BResult.success:" + data.BResult.success);
					if (data.success) {
						window.location.href = CT + "main/toMain";
					} else {
						alert('登录失败,用户名或者密码错误');
					}
				}, "json");
	  
	  

	
	
	});
</script>
</html>