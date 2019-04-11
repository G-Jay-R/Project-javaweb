<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>管理员首页</title>

  </head>
  
  <body background="images/admin1_bg.jpg"
  style="background-size:100% 100%;">
  <center>
  <br>
  <h1>管理员界面</h1><hr>
  <br><br><br>
  <table>
  <tr>
  <td><a href="pages/show_equips.jsp"><h2>查看设备详情</h2></a></td>
  </tr>
  <tr>
  <td><a href="pages/addequips.jsp"><h2>添加设备</h2></a></td>
  </tr>
   <tr>
  <td><a href="pages/MyJsp.jsp"><h2>查询设备</h2></a></td>
  </tr>
  <tr>
  <td><a href="pages/manageman.jsp"><h2>管理用户</h2></a></td>
  </tr>
  <tr>
  <td><a href="adminlogin.jsp"><h2>退出</h2></a></td>
  </tr>
  </table>
  </center>
<br><br><br><br><br>
<br><br>
  </body>
</html>