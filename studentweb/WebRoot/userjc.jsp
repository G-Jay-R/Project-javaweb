<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<html>
  <head><title>My JSP 'userjc.jsp' starting page</title>
</head> 
<body background="img/1.jpg">
   <center>
  <h1>����Աע�����</h1>
  <hr>
  <form method="get" action="UserJcServlet">
  <table width="50%" border="1">
  <tr>
  <td>����Ա:</td>
  <td><input type="text" name="userName"/>(��ʶ�����ģ�������Ӣ��)</td>
  </tr>
  <tr>
  <td>��  �룺</td>
  <td><input type="password" name="userPassword"/></td>
  </tr>
  <tr>
  <td><input type="reset" name="nook" value="����"></td>
  <td><input type="submit" name="ok" value="ע��"/></td>
  </tr>
  </table>
  </form>
  <a href="userlogin.jsp">����</a>
  </center>
<br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
  </body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>