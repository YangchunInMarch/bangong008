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
<title>会议</title>
<link rel="stylesheet" href="${ct}css/bootstrap.min.css">
<script src="${ct}js/jquery.min.js"></script>
<script src="${ct}js/popper.min.js"></script>
<script src="${ct}js/bootstrap.min.js"></script>
<style>
</style>
</head>
<body>

	<div class="container-fluid">
		<form   method="post" id="form1" >
			<input name="uid" value="${employee.id}" id="uid" type="hidden">
			<div class="form-group">
				<label>开会时间: </label>
				 <input type="text" class="form-control"
					id="meetingtime"   name="meetingtime"  >
			</div>
			
			<div class="form-group">
				<label>主题: </label>
				 <input type="text" class="form-control"
					id="mtitle"   name="mtitle"  >
			</div>
			
			<div class="form-group">
				<label for="comment">主要内容:</label>
				<textarea class="form-control" rows="5" id="mcontent" name="mcontent"></textarea>
			</div>
			<!-- 会议室 -->
			<div class="form-group">
					<label for="sel1">会预定议室:</label> <select class="form-control"
						id="mroomname" name="mroomname">
						<c:if test="${lists_room!=null }">
						 <c:forEach items="${lists_room}" var="room">
						    <option value="${room.roomname}">${room.roomname}</option>
						 </c:forEach>
						</c:if>
					</select>
	     	</div>
							
			
			<!-- 邀请人员 -->		
			<div class="form-group">	
			
			<label for="comment">邀请人:</label>
			  </div>
          <div class="form-check form-check-inline">
     	
     		 	<c:if test="${lists_employee!=null }">
						 <c:forEach items="${lists_employee}" var="em">
						  <label class="form-check-label">
						   <input type="checkbox" name="mperson" id="mperson" class="form-check-input" value="${em.id}">${em.uname}
				            </label>
				         </c:forEach>
				</c:if>		 
          </div>
        
		<br/>	<br/>
		<button type="submit" id="btn_submit" class="btn btn-primary">Submit</button>
		</form>

	</div>
</body>

 <script type="text/javascript">
 var CT = '${ct}';
 $("#btn_submit").click(function(){
	 
	//判定文件的标题
	    var mleader=$("#uid").val();
	    var meetingtime=$("#meetingtime").val();
	    var mtitle=$("#mtitle").val();
	    var mcontent=$("#mcontent").val();
	    var mroomname=$("#mroomname").val();
	    var mtitle=$("#mtitle").val();
	     if(mtitle ==null || mtitle==''){
	    	 alert('主题不能为空');
	    	 return false;
	     }	
	     
	     if(mcontent ==null || mcontent==''){
	    	 alert('主要内容不能为空');
	    	 return false;
	     }	
	     if(meetingtime ==null || meetingtime==''){
	    	 alert('会议时间不能为空');
	    	 return false;
	     }		 
	     
	   //获取所有name为demand的对象
	     var obj = document.getElementsByName('mperson');
	     var demand = '';
	     for (var i = 0; i < obj.length; i++) {
	       if (obj[i].checked) {
	         demand += obj[i].value + ',';//如果选中，将value添加到变量s中
	       }
	      }
	     
	    var data={}
	    data.meetingtime=meetingtime;
	    data.mtitle=mtitle;
	    data.mcontent=mcontent;
	    data.mroomname=mroomname;
	    data.mperson=demand;  //
	    data.mleader=mleader;  //mleader
	    
	    

	    $.ajax({  
	        async:false,  
	        type: "POST",  
	        url: "${ct}meeting/meetingAddSave.json",//注意路径  
	        data:data,  
	        dataType:"json",  
	        success:function(data){  
	            if(data.success){  
	                alert("成功");  
	            	window.location.href =  CT + "meeting/look?mstate=0";
	            }else{  
	                alert("失败");  
	            }  
	        },  
	        error:function(data){  
	            alert(data);  
	        }  
	    });  
	    
	 
	    
	    
 });

 </script>
 
</html>