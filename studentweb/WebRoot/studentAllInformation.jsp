<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>   

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  <base href="<%=basePath%>"> 
    <title>My JSP 'studentAllInformation.jsp' starting page</title>

  </head>
  
<body background="img/1.jpg">
  <%
  /*
		  <%!
		  String ToGBK(String str){
		   byte GBK[]=new byte[str.length()];
		   for(int i=0;i<str.length();i++){
		        GBK[i]=(byte)str.charAt(i);
		   		}
		   return new String(GBK);
		  }
		  */
		 // %> 
      
  <center>
<h1>所有学生资料<h1><hr>
<table width="50%" border="1">
<tr>
<td><h3>学号</h3></td>
<td><h3>姓名</h3></td>
<td><h3>性别</h3></td>
<td><h3>年龄</h3></td>
</tr>
 <%	
    String driver="com.mysql.jdbc.Driver";
    String uesr="root";
    String userPassword="111";
    String url="jdbc:mysql://localhost:3306/weiqilong";
    Connection con=null;
    try{
    //out.println("<h1><center>所有学生资料</center><h1><hr>");
    Class.forName(driver);
	con=DriverManager.getConnection(url,uesr,userPassword);
	Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from student;");
	    		if(rs!=null){
    			while(rs.next()){
    			String str1=rs.getString(1);
    			String str2=rs.getString(2);
    			String str3=rs.getString(3);
    			String str4=rs.getString(4);
    			//str1=ToGBK(str1);原代码保存，但显示中文乱码
    			//str2=ToGBK(str2);
    			//str3=ToGBK(str3);
    			//str4=ToGBK(str4);
    			 //out.println("学号："+str1+"<br>");
    			 //out.println("姓名："+str2+"<br>");
    			 //out.println("性别："+str3+"<br>");
    			 //out.println("年龄："+str4+"<br>");
    			 //out.println("<hr>");
    			 %>
	 	 <tr>
	 	 <td><%=str1%></td>
	 	 <td><%=str2%></td>
	 	 <td><%=str3%></td>
	 	 <td><%=str4%></td>
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
 <a href="jinru.jsp">返回到主界面</a></center>
  </body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>