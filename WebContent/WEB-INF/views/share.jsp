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
<style>
   .aa{
    margin-left:100px;
    
 }
</style>
</head>
<body>

	<div class="container-fluid">
		<h4>好资源，一同分享</h4>
		<div class="input-group">
			<input type='text' class="form-control" id='uploadfile' name="uploadfile" /> <span
				class="input-group-btn"> <input class="btn btn-secondary"
				id="select_btn" type="submit" value="搜索">
			</span>
		</div>
         <br/>
      <c:if test="${lists!=null }">
       <c:forEach  items="${lists }" var="file">
   		<div class="card">
			<div class="card-body">
			<strong>   ${file.title}</strong><br/> 	${file.uploadfile}
			<div style="float:right;display: inline">
					<a href="${ct}upfile/download?fileName=${file.uploadfile}" class="aa">下载</a> 
					<a href="${ct}upfile/deleteFile?id=${file.id}" class="aa">删除</a>
			</div>	
		
			</div>
			
		</div>   
		</c:forEach>
      </c:if>
      
        <c:if test="${lists==null }">暂无文件，可点击上传</c:if>

	</div>

</body>
<script type="text/javascript">
	$("#select_btn").click(function() {
		var uploadfile = $("#uploadfile").val();
		if (uploadfile != null || uploadfile != '') {
			window.location.href = "${ct}upfile/selectFile?uploadfile=" + uploadfile;
		}
	});
</script>
</html>