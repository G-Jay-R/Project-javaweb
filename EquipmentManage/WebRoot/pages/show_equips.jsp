<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>   

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  <base href="<%=basePath%>"> 
    <title>设备全览</title>

  </head>
  
	<body background="images/admin_else.jpg"
	style="background-size:100% 100%;">
	<center>
	<br>
	<h1>所有设备资料<h1><hr>
	<table width="80%" border="1">
	<tr style="font-weight:bold;font-size:23px;text-align:center;height:50px;">
	<td>序号</td>
	<td>名称</td>
	<td>品牌</td>
	<td>型号</td>
	<td>种类</td>
	<td>所属部门</td>
	<td>领取人</td>
	<td>存放部门</td>
	<td>购入时间</td>
	<td>操作</td>
	</tr>
  

 <%	
    String driver="com.mysql.jdbc.Driver";
    String uesr="root";
    String userPassword="111";
    String url="jdbc:mysql://localhost:3306/equip";
    Connection con=null;
    try{
    //out.println("<h1><center>所有学生资料</center><h1><hr>");
    Class.forName(driver);
	con=DriverManager.getConnection(url,uesr,userPassword);
	Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from shebei;");
	    		if(rs!=null){
    			while(rs.next()){
    			String str1=rs.getString(1);
    			String str2=rs.getString(2);
    			String str3=rs.getString(3);
    			String str4=rs.getString(4);
    			String str5=rs.getString(5);
    			String str6=rs.getString(6);
    			String str7=rs.getString(7);
    			String str8=rs.getString(8);
    			String str9=rs.getString(9);    			
    			 %>
	 	 <tr style="text-align:center;">
	 	 <td><%=str1%></td>
	 	 <td><%=str2%></td>
	 	 <td><%=str3%></td>
	 	 <td><%=str4%></td>
	 	 <td><%=str5%></td>
	 	 <td><%=str6%></td>
	 	 <td><%=str7%></td>
	 	 <td><%=str8%></td>
	 	 <td><%=str9%></td>
	 	 <td><a href="pages/modify.jsp?s1=<%=str1%>&s2=<%=str2%>&s3=<%=str3%>&s4=<%=str4%>&s5=<%=str5%>&s6=<%=str6%>&s7=<%=str7%>&s8=<%=str8%>&s9=<%=str9%>">修改&nbsp;&nbsp;</a>
	 	 <a href="delServlet?s1=<%=str1%>">删除&nbsp;&nbsp;</a></td>
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
 	<h3><a href="pages/admin1.jsp">返回主界面</a></h3></center>
  </body>
</html>