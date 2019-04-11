<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>   

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
	  <base href="<%=basePath%>"> 
	  <title>Insert title here</title>
	<style type="text/css">
	html,body {
	    height: 100%;
	    margin: 0;
	    overflow: 0;
	}

	iframe {
	    margin: 0;
	    border-style:none;
	    width: 100%;
	    height:84%;
	}

	</style>
  </head>
  <body bgcolor="#66ffff">
  <div align="right"><a href="pages/admin1.jsp">&nbsp;&nbsp;&nbsp;退出&nbsp;&nbsp;&nbsp;</a></div>
  <center>
	 	 <frame>
			 <iframe name="query" src="pages/query.jsp" style="width:100%;height:100px;"></iframe><br>
			 <iframe name="list" src="pages/list.jsp"></iframe>
		 </frame>
  </center>
  </body>
</html>
 