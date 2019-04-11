<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'usermanage.jsp' starting page</title>

  </head>
  
  <body background="img/1.jpg">
  <center>
  <h1>管理员界面</h1><hr>
  <br><br><br>
  <table>
  <tr>
  <td><a href="jinru.jsp"><h2>管理学生资料</h2></a></td>
  </tr>
  <tr>
  <td><a href="manageman.jsp"><h2>管理用户</h2></a></td>
  </tr>
  <tr>
  <td><a href="UserPerishServlet"><h2>注销本管理员</h2></a></td>
  </tr>
  <tr>
  <td><a href="userlogin.jsp"><h2>退出</h2></a></td>
  </tr>
  </table>
  </center>
<br><br><br><br><br>
<br><br><br><br><br>
  </body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>