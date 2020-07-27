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
<title>添加日程</title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
<script src="${ct}js/jquery.min.js"></script>
<script src="${ct}js/popper.min.js"></script>
<script src="${ct}js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">

		<form method="post" id="form1">

			<div class="form-group">

				<label>主题:</label> <input type="text" name="title" id="title"
					class="form-control">
			</div>


			<div class="form-group">
				<label for="comment">具体安排:</label>
				<textarea class="form-control" rows="5" id="content" name="content"></textarea>
			</div>
			<button type="submit"  id="btn_work" class="btn btn-primary">Submit</button>
		</form>
	</div>
	
</body>


<script type="text/javascript">
var CT = '${ct}';
$("#btn_work").click(function() {
	var title = $("#title").val();
	var content = $("#content").val();
	if(title==''||title==null){
		alert('主题不能为空');
		return false;
	}
	if(content==''||content==null){
		alert('主要内容不能为空');
		return false;
	}
	 
	  $.post(CT +"goals/workAddtoSave.json", $('#form1').serialize(),
	          
				function(data) {
			//		alert(JSON.stringify(data));
			//		alert("data.BResult.success:" + data.BResult.success);
					if (data.success) {
			//			    alert('保存成功');
					window.location.href = CT + "goals/goals";
					} else {
						alert('保存失败，请稍后重试');
					}
				}, "json");
	  
	});
</script>
</html>