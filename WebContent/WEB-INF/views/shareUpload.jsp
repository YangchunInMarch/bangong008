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
	
					
<form method="post" action="${ct}upfile/uploadFile" enctype="multipart/form-data">
 
  
  <div class="form-group"> 
  
    <label>标题:</label>
    <input type="text" class="form-control" name="title" id="etitle" >
  </div>
  
   	 <div class="form-group">
      <label>附件:</label>
     <input type="file" name="uploadfile" id="uploadfile">
    </div>
	 <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>


</body>
<script type="text/javascript">
	$("#select_btn").click(function() {
		
		 var etitle=$("#etitle").val();
	     if(etitle ==null || etitle==''){
	    	 alert('文件主题不能为空');
	    	 return false;
	     }	
	     
	   //判定文件格式  
	   var files=document.getElementById("uploadFile").files;
	   var filesize=0;
	   var files2=document.getElementById("uploadFile").value;
	   var fileExt = files2.substring(files2.lastIndexOf(".")).toLowerCase(); //文件后缀名
	   if(files.length!=0){
			  fileSize=files[0].size; 
	 }
	   else{
		   alert("文件不能为空！");
		   return false;
		   }
	   if(fileExt==".exe"||fileExt==".bat"||fileExt==".com"){
    	   alert("不能上传可执行文件");
    	   return false;
       }else if(fileSize>50*1024*1024){//文件控制大小50MB
		   alert("文件超标");
		   return false;
	   }
	   
	  
	   
		
		var uploadfile = $("#uploadfile").val();
		if (uploadfile != null || uploadfile != '') {
			window.location.href = "${ct}upfile/selectFile?uploadfile=" + uploadfile;
		}
	});
</script>
</html>