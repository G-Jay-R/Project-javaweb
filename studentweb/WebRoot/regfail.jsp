<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<base href="<%=basePath%>">
    <title></title>
  </head>
<body background="img/1.jpg">
<br><br><br><br><br><br>
  <h1><center>注册失败</center></h1>
  <h2><center><a href="userReg.jsp">返回到管理员注册界面</a></center><h2>
<br><br><br><br><br>
<br><br><br><br><br><br>
 </body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>
