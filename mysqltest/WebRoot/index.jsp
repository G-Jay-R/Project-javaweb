<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
<body background="img/3.jpg">
<center>**************************************</center>
<h1><center>学生资料管理系统</center></h1>
<center>**************************************</center>
<br><br><br><br><br><br>
<center>
<table>
<tr>
<td></td>
<td><a href="userlogin.jsp"><h2>*管理员进入*</h2></a></td>
<td></td>
<td><a href="manlogin.jsp"><h2>*普通用户进入*</h2></a></td>
<td></td>
</tr>
</table>
</center>
<br><br><br><br><br><br><br>
<br><br><br>

  </body>
   <h4><jsp:include page="tail.jsp" flush="true"/></h4>
</html>
