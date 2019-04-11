<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>login.jsp</title>	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">   
	<link rel="stylesheet" href="css/login.css">
	<link rel="stylesheet" href="css/bootstrap.css" />
	<script type="text/javascript" src="js/jquery-1.11.0.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<script type="text/javascript" src="js/util.js" ></script>

</head>
<body class="body_login">
<form name="loginForm" method="post" action="<%=path%>/login.do" >

	<div class="login_middle_center"><!--这个是起居中定位作用-!-->
		<div class="login_bj"><!--这个是背景大图片Height=684px,width=1000px-!-->
			
			<div class="login_bj_main"><!--这个定位了登录输入框位置-!-->
				<div class="login_ems_logo">					
					<span style="font-size:20px;font-weight: bold;color:#6E6E6E;font-style:Microsoft YaHei;letter-spacing:8px;">潭州框架系统</span>
 				</div>
 				<p><p>
 				<div class = "form-inline">
		            <div class = "form-group">
		            	<label>用户名:</label>
		            	<input type = "text" class = "form-control" id="userName" name="userName" placeholder = "请输入用户名" value="" style="width:120px;">
		            </div>
		            <p>
		            <div class = "form-group">
		            	<label>密码:&nbsp;&nbsp;&nbsp;</label>
		            	<input type = "password" class = "form-control" id="password" name="password" placeholder = "请输入密码" value="" style="width:120px;">
		            </div>
           		 </div>
				<p>
				<div><!--登录的按钮背景宽度-!-->
					&nbsp;&nbsp;&nbsp; 
					<input class="btn btn-primary" type="submit" value='登陆' /> 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="btn btn-primary" type="reset" value='重置' />
				</div>
			</div>
		</div> 			
	</div>

</form>
	
<div class="login_bottom_logo"></div>
<div class="login_bottom_text"></div>
		 
<script type="text/javascript">
 
 
 function tzLogin(){
		var userName = $("#userName").val();
		//document.getElementById("userName").value; --原生的js方式
		var password = $("#password").val();
		//document.getElementById("password").value;--原生的js方式
		if(isEmpty(userName)){
			alert("请输入用户名称");
			//$("#username").focus();
			//$("#errormessage").show().html("请输入账号!").fadeOut(3000);
			return;
		};
			
		if(isEmpty(password)){
			alert("请输入用户密码");
			//$("#password").focus();
			//$("#errormessage").show().html("请输入密码!").fadeOut(3000);
			return;
		};
		
		
		$.ajax({
			type:'post',//请求方式
			url:'<%=path%>/login',//请求服务器的URL地址
			dataType:'text', //有几种格式 xml html json text 等常用
			//data两种方式传值比如 key1=value1&key2=value2 ，也可以是一个映射，比如 {key1: 'value1', key2: 'value2'} 
			data:{"userName" : userName,"password":password},//传递给服务器的参数
			beforeSend:function(){
					
			},
			success:function(data){//与服务器交互成功调用的毁掉函数
				//data就是out.print输出的内容
				if(data=='error'){
					//$("#password").val("").focus();//清空密码
					alert("您输入的用户名和密码不正确");
					//$("#errormessage").show().html("用户名和密码不正确").fadeOut(3000);
				}else{
					//跳转到首页
					window.location.href = '<%=path%>/pages/main/main.html';	
				}
			},
			complete:function(data){//当请求完成以后,可以执行其他的动作	 
			}
		});
	};
 
 
</script>	 
</body>
</html>
