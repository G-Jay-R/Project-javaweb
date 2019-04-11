<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<html>
  <head>
    <title></title>
  </head>
<body background="img/1.jpg">
<br><br><br><br><br><br>
  <h1><center>
  <%String str=(String)session.getAttribute("userjcstr"); %>
  <%=str%>
  </center></h1>
  <h2><center><a href="userjc.jsp">返回到管理员注册界面</a></center><h2>
<br><br><br><br><br>
<br><br><br><br><br><br>
 </body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>
