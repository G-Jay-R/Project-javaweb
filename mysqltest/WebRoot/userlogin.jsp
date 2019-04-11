<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  <base href="<%=basePath%>">
    <title>My JSP 'userlogin.jsp' starting page</title>
  </head>
  
<body background="img/1.jpg">
  <center>
  <h1>管理员登陆界面</h1>
  <hr>
  <form method="post" action="loginservlet">
  		<input type="hidden" name="oper" value="login" />
	  <table width="55%" border="1">
	  <tr>
	  <td>管理员:</td>
	  <td><input type="text" name="userName" placeholder="用户名"/>(不识别中文，请输入英文)</td>
	  </tr>
	  <tr>
	  <td>密  码：</td>
	  <td><input type="password" name="userPassword" placeholder="密码"/></td>
	  </tr>
	  <tr>
	  <td><input type="reset" name="nook" value="重置"></td>
	  <td><input type="submit" name="ok" value="登录"/></td>
	  </tr>
	  </table>
  </form>
  
  <%
  	Object obj=request.getAttribute("flag"); 
	if(obj!=null){	
  %>
  <center><span style="font-size:15px;font-weight:bold;color:red">用户名或者密码错误！！</span></center><br>
  <%} %>
  	
  <a href="userReg.jsp">注册新管理员</a>
  <a href="index.jsp">退出管理员界面</a>
  </center>
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br>
  </body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>