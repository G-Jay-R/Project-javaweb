<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!
  String ToGBK(String str){
   byte GBK[]=new byte[str.length()];
   for(int i=0;i<str.length();i++){
       GBK[i]=(byte)str.charAt(i);
   }
   return new String(GBK);
  }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'manageman.jsp' starting page</title>
  </head>
<body background="img/1.jpg">
<h1><center>用户管理</center><h1>
<table width="80%" border="1">
<tr>
<td><h3>用户名</h3></td>
<td><h3>密码</h3></td>
<td><h3>操作</h3></td>
</tr>
 <%
    String driver="org.gjt.mm.mysql.Driver";
    String uesr="root";
    String userPassword="111";
    String url="jdbc:mysql://localhost:3306/mnglogin";
    Connection con=null;
    try{
    Class.forName(driver);
	con=DriverManager.getConnection(url,uesr,userPassword);
	Statement stmt=con.createStatement();
	%>
	<%
    ResultSet rs=stmt.executeQuery("select * from man;");
    String s="";
	    		if(rs!=null){
    			while(rs.next()){
    			String str1=rs.getString(1);
    			String str2=rs.getString(2);
    			str1=ToGBK(str1);
    			str2=ToGBK(str2);
%>
<tr>
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
 <h4><center><a href="usermanage.jsp">返回到管理员界面</a></center></h4>  
</body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>