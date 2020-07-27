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
<title>邮件</title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
<script src="${ct}js/jquery.min.js"></script>
<script src="${ct}js/popper.min.js"></script>
<script src="${ct}js/bootstrap.min.js"></script>
<style>
.aa {
	margin-left: 100px;
}
</style>
</head>
<body>


	<div class="container-fluid">
		<h4>会议模式~</h4>

		<!-- 选择按钮 -->
		<div class="card">
			<div class="card-body">
				<button class="btn btn-secondary" id="btn_meeting_0">待处理</button>
				<button class="btn btn-secondary" id="btn_meeting_1">已处理</button>
			</div>
		</div>

		<!--  邮件列表  待处理 以及 已处理-->
		<c:if test="${lists!=null}">
			<c:forEach items="${lists}" var="meeting">
				<div class="card">
					<div class="card-body">
						<strong>${meeting.mtitle}</strong>
						<div style="float: right; display: inline">
							<a href="${ct }meeting/meetingLook?id=${meeting.id}" class="aa">
								查看</a>

							<c:if test="${ meeting.mstate==0}">
								<a href="${ct }meeting/targetMeeting?id=${meeting.id}"
									class="aa"> 标为已处理</a>
							</c:if>
							<c:if test="${ meeting.mstate==1}">
								<span class="aa"> 已处理 </span>
							</c:if>

							<c:if test="${ meeting.mstate==1}">
								<a href="${ct }meeting/deleteMeeting?id=${meeting.id}"
									class="aa"> 删除会议</a>
							</c:if>
						</div><br/>
						开会时间：${meeting.meetingtime}
						<div style="float: right; display: inline">
							发布时间：<mark>${meeting.mtime} </mark>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>


	</div>
	<script type="text/javascript">
		$("#btn_meeting_0").click(function() {
			window.location.href = "${ct}meeting/look?mstate=0";

		});

		$("#btn_meeting_1").click(function() {
			window.location.href = "${ct}meeting/look?mstate=1";

		});
	</script>


</body>
</html>