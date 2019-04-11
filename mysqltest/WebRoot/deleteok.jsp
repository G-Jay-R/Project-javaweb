<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'deleteok.jsp' starting page</title>


  </head>
  
<body background="img/1.jpg">
<br><br><br><br><br><br>
 <center><h1>学生资料删除成功！<h1/></center>

   <h2><center><a href="jinru.jsp">返回到主界面</a></center><h2>
<br><br><br><br><br>
<br><br><br><br><br><br>
  </body>  
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>