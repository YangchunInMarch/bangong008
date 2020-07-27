<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="#">百耀科技集团</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <input type="hidden" value="${employee.department }" id="department">
    <ul class="navbar-nav">
      <li class="nav-item">
        <button class="btn btn-dark" id="h_main">工作</button>
      </li>
     
       <li class="nav-item">
        <button class="btn btn-dark" id="h_signin">考勤</button>
      </li>  
         
       <li class="nav-item">
        <button class="btn btn-dark" id="h_share">文件共享</button>
      </li> 
       <li class="nav-item">
        <button class="btn btn-dark" id="h_manager">员工管理</button>
      </li> 
      
       <li class="nav-item">
        <button class="btn btn-dark" id="h_meeting">会议管理</button>
      </li> 
                         
       <li class="nav-item">
        <button class="btn btn-dark" id="h_notice">公告管理</button>
      </li> 
      
        <li class="nav-item">
        <button class="btn btn-dark" id="h_help">帮助</button>
      </li> 
                         
       <li class="nav-item">
        <button class="btn btn-dark" id="h_loginOut">注销登录</button>
      </li> 
                      
    </ul>
  </div>  
</nav>

<script type="text/javascript">
//主界面
  $("#h_main").click(function (){
	  
	  window.location.href = "${ct}main/toMain";
  });
//签到
  $("#h_signin").click(function (){
	  
	  window.location.href = "${ct}signin/signin";
  });
//文件共享 
  $("#h_share").click(function (){
	  
	  window.location.href = "${ct}upfile/upfile";
  });
  
//员工管理manager/employee  
  $("#h_manager").click(function (){
	  var department=$("#department").val();
	  if(department=='3'){
	  window.location.href = "${ct}manager/employee";
	  }else{
		  alert('您不是人事部门人员，请勿操作');
	  }
  });
  
//meeting/meeting  会议管理  
  $("#h_meeting").click(function (){
	  var department=$("#department").val();
	  if(department =='4'){
	  window.location.href = "${ct}meeting/meeting";
		  
	  }else{
		  alert('您没有权限');
	  }
  });
  
  //公告管理
  $("#h_notice").click(function (){
	  var department=$("#department").val();
	  if(department =='4'){
	  window.location.href = "${ct}notice/notice";
	  }else{
		  alert('您没有权限');
	  }
  });
  
  //帮助
    $("#h_help").click(function (){
	  
	  window.location.href = "${ct}main/help";
  });
  
  //注销登录
  $("#h_loginOut").click(function (){
	  
	  window.location.href = "${ct}main/loginout";
  });
  
</script>