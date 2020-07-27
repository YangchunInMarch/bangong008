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
	<h4>签=钱，记得每天打卡</h4>
	<div class="input-group">
	<input type='text' class="form-control" id="stime" name="stime" placeholder="根据具体月份搜索，如：2020-01"/>
	  <span class="input-group-btn">
	    <input class="btn btn-secondary" id="select_btn" type="submit" value="搜索" >
	</span>
</div>

		<table class="table table-hover">
    <thead>
      <tr>
        <th>日期</th>
        <th>上午打卡时间</th>
        <th>下午打卡时间</th>
        <th>是否签到成功</th>
      </tr>
    </thead>
    <tbody>
    
    <c:if test="${lists !=null }">
     <c:forEach items="${lists}" var="sign">
       <tr>
        <td>${sign.stime}</td>
        <td>${sign.onduty }</td>
        <td>${sign.offduty}</td>
        <td>
          <c:if test="${sign.onState ==1&& sign.offState==1}"><span style="color:green">成功</span></c:if>
          <c:if test="${sign.onState !=1|| sign.offState!=1}"><span style="color:red">失败</span></c:if>
        </td>
      </tr>
     
     </c:forEach>
    
    </c:if>
      
      </tbody>
      </table> 
	</div>
</body>

<script type="text/javascript">
  $("#select_btn").click(function(){
     var stime=$("#stime").val();
	 if(stime != null || stime !='' ){
		 window.location.href = "${ct}signin/selectSignin?stime="+stime;
	   }
  });
</script>

</html>