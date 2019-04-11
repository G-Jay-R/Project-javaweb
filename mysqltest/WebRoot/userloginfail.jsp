<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<base href="<%=basePath%>">
    <title>ing page</title>
  </head>
<body background="img/1.jpg">
<br><br><br><br><br><br>
  <h1><center>
  <%String str=(String)session.getAttribute("userloginstr"); %>
  <%=str%>
  </center></h1>  
  <h2><center><a href="userlogin.jsp">用户密码错误，请重新验证登陆</a></center><h2>
<br><br><br><br><br>
<br><br><br><br><br><br>
 </body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>
