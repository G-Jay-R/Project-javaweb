<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<html>
  <head><title>My JSP 'userjc.jsp' starting page</title>
</head> 
<body background="img/1.jpg">
   <center>
  <h1>管理员注册界面</h1>
  <hr>
  <form method="get" action="UserJcServlet">
  <table width="50%" border="1">
  <tr>
  <td>管理员:</td>
  <td><input type="text" name="userName"/>(不识别中文，请输入英文)</td>
  </tr>
  <tr>
  <td>密  码：</td>
  <td><input type="password" name="userPassword"/></td>
  </tr>
  <tr>
  <td><input type="reset" name="nook" value="重置"></td>
  <td><input type="submit" name="ok" value="注册"/></td>
  </tr>
  </table>
  </form>
  <a href="userlogin.jsp">返回</a>
  </center>
<br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
  </body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>