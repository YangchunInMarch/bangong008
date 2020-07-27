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
<title>公告</title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
<script src="${ct}js/jquery.min.js"></script>
<script src="${ct}js/popper.min.js"></script>
<script src="${ct}js/bootstrap.min.js"></script>
<style>
</style>
</head>
<body>

	<div class="container-fluid">
		<form action="${ct}notice/noticeAddSave" method="post" id="form1"  onsubmit="return check()" >
			<div class="form-group">

				<label>主题: </label>
				 <input type="text" class="form-control"
					id="ntitle"   name="ntitle"  >
			</div>
			
			<div class="form-group">
				<label for="comment">内容:</label>
				<textarea class="form-control" rows="5" id="ncontent" name="ncontent"></textarea>
			</div>
			<button type="submit" id="btn_submit" class="btn btn-primary">Submit</button>
		</form>

	</div>
</body>

 <script type="text/javascript">
   function check(){
	   //判定文件的标题
	   var ntitle=$("#ntitle").val();
	   var ncontent=$("#ncontent").val(); 
	     if(ntitle ==null || ntitle==''){
	    	 alert('主题不能为空');
	    	 return false;
	     }	
	     if(ncontent ==null || ncontent==''){
	    	 alert('主要内容不能为空');
	    	 return false;
	     }	   
   }

 </script>
 
</html>