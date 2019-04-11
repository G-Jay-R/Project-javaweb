<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>---设备管理系统---</title>
	
  </head>
<body background="images/login_bg.jpg">
	<br>
	<center>*************************************************************************************</center>
	<h1><center>--- 河 海 大 学 设 备 管 理 系 统 ---</center></h1>
	<center>*************************************************************************************</center>
	<br><br><br><br><br><br><br><br><br><br><br>
	<center>
	<table>
	<tr>
	<td><a href="adminlogin.jsp"><h2>--管理员进入--</h2></a></td>
	</tr>
	<tr>
	<td><a href="userlogin.jsp"><h2>--用 户 进 入--</h2></a></td>
	</tr>
	</table>
	</center>
	<br><br><br><br>
	  <hr>
  <center><b>联系我们 邮编：210000   |   学校：河海大学计信院    |   e_mail：hhu.edu.cn</b></center>
</body>

</html>
