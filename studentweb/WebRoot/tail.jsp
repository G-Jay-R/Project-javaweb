<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<base href="<%=basePath%>">
    <title>My JSP 'tail.jsp' starting page</title>
  </head>
  <%
  //<body bgcolor="#cc6cc">
  %>
  <body>
  <hr>
  <center>联系我们 qq：200111   |   学校：河海大学计信院    |   e_mail：hhu.edu.com</center>
  </body>
</html>