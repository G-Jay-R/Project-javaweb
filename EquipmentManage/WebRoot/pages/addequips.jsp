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
<body background="images/admin_else.jpg">
   <center><h2>添加学生资料</h2>
 <br><hr><br><br>
<form method="post" action="insertServlet">
 <table width="30%" height="45%" border="1">
  <tr>
   <td>设备名称:</td>
<td><input type="text" name="ename" required="required"/></td>
   </tr>
   <tr>
   <td>品    牌:</td>
   <td><input type="text" name="brand" required="required"/></td>
   </tr>
   <tr>
   <td>型    号:</td>
   <td><input type="text" name="model" required="required"/></td>
   </tr>
   <tr>
   <td>种    类:</td>
   <td><select name="type">
         <option value="电脑" ${type=="电脑"?'selected':''}>电脑</option>
         <option value="显微镜" ${type=="显微镜"?'selected':''}>显微镜</option>
         <option value="勘测器" ${type=="勘测器"?'selected':''}>勘测器</option>
         <option value="投影仪" ${type=="投影仪"?'selected':''}>投影仪</option>
         <option value="麦克风" ${type=="麦克风"?'selected':''}>麦克风</option>
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
   <td><input type="text" name="staff" required="required"/></td>
   </tr>
   <tr>
   <td>存放位置：</td>
   <td><input type="text" name="position" required="required"/></td>
   </tr>
   <tr>
   <td>购入时间：</td>
   <td><input type="text" name="date" placeholder="请按照格式'2010-01-01'" required="required"/></td>
   </tr>
   <tr>
   <td><input type="reset" value="重填"/></td>
   <td><input type="submit" value="确定"/></td>
</tr>
</table>
</form>
  <a href="pages/admin1.jsp">返回到主界面</a></center>
<br><br><br><br>
<br><br><br>
  </body>
</html>