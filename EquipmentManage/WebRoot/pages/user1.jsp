<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'manjinru.jsp' starting page</title>
  </head>
  
 <body background="images/user1_bg.jpg"
 style="background-size:100% 100%;">
 <br>
   <center><h1>用户操作页面</h1>
   <hr>
   <br><br><br>
   <table>
  <tr>
  <td><a href="pages/show_inuser.jsp"><h2>查看设备详情</h2></a></td>
  </tr>
  <tr>
  <td><a href="pages/addequips2.jsp"><h2>添加设备</h2></a></td>
  </tr>
   <tr>
  <td><a href="pages/Query_inuser.jsp"><h2>查询设备</h2></a></td>
  </tr>
  <tr>
  <td><a href="userlogin.jsp"><h2>退出</h2></a></td>
  </tr>
  </table>
  </center>
<br><br><br><br><br><br>

  </body>
</html>
