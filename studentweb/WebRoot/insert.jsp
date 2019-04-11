<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'insert.jsp' starting page</title>
  </head>
<body background="img/1.jpg">
   <center><h2>添加学生资料</h2>
 <br><hr><br><br>
<form method="get" action="InsertServlet">
 <table width="30%" height="40%" border="1">
  <tr>
   <td>学号:</td>
<td><input type="text" name="sno"/>*</td>
   </tr>
   <tr>
   <td>姓名:</td>
   <td><input type="text" name="sname"/>*</td>
   </tr>
   <tr>
   <td>性别:</td>
   <td><input type="radio" name="sex"value="男人"/>男人
   <input type="radio" name="sex" value="女人"/>女人</td>
   </tr>
   <tr>
   <td>年龄:</td>
   <td><input type="text" name="sage"/>*</td>
   </tr>
   <tr>
   <td><input type="reset" value="重填"/></td>
   <td><input type="submit" value="确定"/></td>
</tr>
</table>
</form>
  <a href="jinru.jsp">返回到主界面</a></center>
<br><br><br><br>
<br><br><br>
  </body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>