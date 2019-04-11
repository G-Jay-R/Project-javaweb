<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'select.jsp' starting page</title>


  </head>
  
<body background="img/1.jpg">
  <h2><center>查询学生资料</center></h2>
  <hr>
  <br>
  <form method="get" action="SelectServlet">
  <br><br>
  <center><br>
<table width="30%" border="1">
  <tr>
  <td>学生学号：</td>
    <td><input type="text" name="sno"/></td>
  </tr>
  <tr>
   <td><input type="reset" value="重填"/></td>
   <td><input type="submit" value="确定"/></td>
  </tr>
  <tr></tr>
  </table>
  </center>
  </form>
  <center><a href="jinru.jsp">返回到主界面</a></center>
<br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br>
  </body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>