<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  <base href="<%=basePath%>">
  <title>Login Form</title>

      <link rel="stylesheet" href="css/style.css">

</head>

<body>

  <body>
  <br><br><br><br>
	<div class="login">
		<div class="login-screen">
			<div class="app-title">
				<h1>User Login</h1>
			</div>

			<div class="login-form">
				<form action="loginservlet" method="post">
					<input type="hidden" name="oper" value="user" />
					<div class="control-group">
					<input type="text" name="username" placeholder="User-name" required="required"/>
					<label class="login-field-icon fui-user" for="login-name"></label>
					</div>
					<div class="control-group">
					<input type="password" name="upassword" placeholder="Password" required="required"/>
					<label class="login-field-icon fui-lock" for="login-pass"></label>
					</div>
					 <%
	  	Object obj=request.getAttribute("flag"); 
		if(obj!=null){	
 		 %>
 		 <center><span style="font-size:15px;font-weight:bold;color:red">用户名或者密码错误！！</span></center><br>
 		 <%} %>
					<input type="submit" class="btn btn-primary btn-large btn-block" value="Login">
				</form>
				<center><a href="index.jsp" ><span style="font-size:15px;color:black">返回主界面</span></a></center>
			</div>
		</div>
	</div>
</body>

</body>

</html>
   