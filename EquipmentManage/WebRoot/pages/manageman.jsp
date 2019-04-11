<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'manageman.jsp' starting page</title>
  </head>
<body background="images/admin_else.jpg"
  style="background-size:100% 100%;">
<center>
<br>
<h1>用户管理<h1>
<hr>
<table width="60%" border="1">
<tr style="font-weight:bold;font-size:20px;text-align:center;height:35px;">
<td>用户名</td>
<td>密码</td>
<td>操作</td>
</tr>
 <%
    String driver="org.gjt.mm.mysql.Driver";
    String uesr="root";
    String userPassword="111";
    String url="jdbc:mysql://localhost:3306/equip";
    Connection con=null;
    try{
    Class.forName(driver);
	con=DriverManager.getConnection(url,uesr,userPassword);
	Statement stmt=con.createStatement();
	%>
	<%
    ResultSet rs=stmt.executeQuery("select * from user;");
    String s="";
	    		if(rs!=null){
    			while(rs.next()){
    			String str1=rs.getString(1);
    			String str2=rs.getString(2);
    			%>
<tr style="text-align:center;">
<td><%=str1%></td>
<td><%=str2%></td>
<td><a href="UserDeleteManServlet?s=<%=str1%>">删除</a></td>
</tr>
 <%
    			}
    		}
    		stmt.close();
	
    }catch(SQLException sqle){
        out.println(sqle.getMessage());
    }
    catch(Exception e){
        out.println(e.getMessage());
    }
    finally{
        try{
            if(con!=null)
            con.close();
        }
        catch(SQLException sqle){out.println(sqle.getMessage());}
        catch(Exception e){out.println(e.getMessage());}
    }
  %>
  </table>
  </center>
<center><a href="/equipmng/pages/admin1.jsp">返回到管理员界面</a></center>  
</body>
</html>