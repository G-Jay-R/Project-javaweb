<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  <base href="<%=basePath%>"> 
    <title>My JSP 'jinru.jsp' starting page</title>
  </head>
  
<body background="img/1.jpg">
   <center><h1>管理系统主界面</h1></center>
   <hr>
<br><br><br><br>   
   <h2>
   <center>
   <a href="insert.jsp">添加学生资料</a><br>
   <a href="select.jsp">查询学生资料</a><br>
   <a href="delete.jsp">删除学生资料</a><br>
   <a href="amend.jsp">修改学生资料</a><br>
   <a href="studentAllInformation.jsp">查看学生资料库</a><br>
   <a href="usermanage.jsp">返回到管理员界面</a>
   </center>
   </h2>
<br><br><br><br><br>
<br><br><br><br><br>
  </body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>