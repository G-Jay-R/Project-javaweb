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
  
 <body background="img/4.jpg">
   <center><h1>普通用户查询界面</h1></center>
   <hr>
   <h2>
<br><br><br><br>   
   <center>
 <a href="manselect.jsp">查询学生资料</a><br>
 <a href="ManPerishServlet">注销本用户</a><br>
 <a href="manlogin.jsp">返回到用户登录界面</a>
   </center>
   </h2>
<br><br><br><br><br><br>
<br><br><br><br><br><br>
  </body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>
