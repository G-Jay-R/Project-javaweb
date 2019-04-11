<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>   

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  <base href="<%=basePath%>"> 
<title>修改设备信息</title>

</head>
<body background="images/admin_else.jpg" style="background-size:100% 100%;">
<center>
<h2>修改设备信息</h2>
  <%
  	   request.setCharacterEncoding("utf-8");	//设置请求编码格式	
		//获取修改列表信息
  	   String s1 = request.getParameter("s1");
	   String s2 = request.getParameter("s2");
	   String s3 = request.getParameter("s3");
	   String s4 = request.getParameter("s4");
	   String s5 = request.getParameter("s5");
	   String s6 = request.getParameter("s6");
	   String s7 = request.getParameter("s7");
	   String s8 = request.getParameter("s8");
	   String s9 = request.getParameter("s9");
	   
   %>
<form method="post" action="modifyServlet" >  
   <table width="35%" height="45%" border="1">
   <input type="hidden" name="id" value="<%=s1%>"/>
  <tr>
   <td>设备名称:</td>
	<td><input type="text" name="ename" value="<%=s2%>"/></td>
   </tr>
   <tr>
   <td>品    牌:</td>
   <td><input type="text" name="brand" value="<%=s3%>"/></td>
   </tr>
   <tr>
   <td>型    号:</td>
   <td><input type="text" name="model" value="<%=s4%>"/></td>
   </tr>
   <tr>
   <td>种    类:</td>
   <td><select name="type">
         <option value="电脑">电脑</option>
         <option value="显微镜">显微镜</option>
         <option value="勘测器">勘测器</option>
         <option value="投影仪">投影仪</option>
         <option value="麦克风" selected="selected">麦克风</option>
       </select>
       </td>
   </tr>
   <tr>
   <td>所属部门:</td>
   <td><select name="department">
         <option value="实验室2">实验室2</option>
         <option value="实验室3">实验室3</option>
         <option value="实验室4">实验室4</option>
         <option value="实验室5">实验室5</option>
         <option value="实验室1" selected="selected">实验室1</option>
       </select></td>
   </tr>
   <tr>
   <td>领 取 人:</td>
   <td><input type="text" name="staff" value="<%=s7%>"/></td>
   </tr>
   <tr>
   <td>存放位置：</td>
   <td><input type="text" name="position" value="<%=s8%>"/></td>
   </tr>
   <tr>
   <td>购入时间：</td>
   <td><input type="text" name="date" value="<%=s9%>"/></td>
   <tr>
    	<td colspan="2" style="text-align: center">
    	<input name="Submit2" type="button" class="btn" onclick="location.href='javascript:history.go(-1);'" value="返 回"/>&nbsp;&nbsp;&nbsp;
    	<input type="submit" value="提交信息"></td>
   </tr>
  </table>
</form>
</center>
</body>
</html>