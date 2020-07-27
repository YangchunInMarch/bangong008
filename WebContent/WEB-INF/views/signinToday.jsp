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
<title>签到</title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
<script src="${ct}js/jquery.min.js"></script>
<script src="${ct}js/popper.min.js"></script>
<script src="${ct}js/bootstrap.min.js"></script>
<style>
</style>
</head>
<body>
	<div class="container-fluid">
		<h4>每日一打卡</h4>
		<div class="card">
			<div class="card-body">
				<input type="hidden" name="id" id="id" value="${signin.id}">
				上班打卡时间：08:40-09:00
				<button class="btn btn-secondary" id="signin_01"
					value="${signin.onState}">
					<c:if test="${signin.onState==1}">
		    已打卡
		</c:if>
					<c:if test="${signin.onState==0}">打卡</c:if>
				</button>
                    <mark>${signin.onduty}</mark>
				<br />
				<br /> 下班打卡时间：18:00-23:00
				<button class="btn btn-secondary" id="signin_02"
					value="${signin.offState}">
					<c:if test="${signin.offState ==1}">已打卡</c:if>
					<c:if test="${signin.offState ==0}">打卡</c:if>
				</button>
				<mark>${signin.offduty}</mark>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$("#signin_01").click(function() {
			var id = $("#id").val();
			var target = $("#signin_01").val();
			if (target == 1) {
				alert('上午已打卡，请勿重复操作');
			} else {
				//打卡
					window.location.href =  "${ct}signin/signinCard?target=1&id="+id;
			}
		});

		$("#signin_02")
				.click(
						function() {
							var id = $("#id").val();
							var target = $("#signin_02").val();
							if (target == 1) {
								alert('下午已打卡，请勿重复操作');
							} else {
								//打卡
								window.location.href = "${ct}signin/signinCard?target=2&id="
										+ id;
							}
						});
	</script>
</body>
</html>