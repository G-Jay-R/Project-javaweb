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
 </head>
 <body background="images/user_else.jpg"
	style="background-size:100% 100%;text-align:center;">
	<center>
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
	</tr>
  

 <%	
 	request.setCharacterEncoding("utf-8");
    String driver="com.mysql.jdbc.Driver";
    String uesr="root";
    String userPassword="111";
    String url="jdbc:mysql://localhost:3306/equip";
    Connection con=null;
    String s1=request.getParameter("term");
    String s2=request.getParameter("detail");
    try{
    Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection(url,uesr,userPassword);
	String sql=null;
	PreparedStatement ps=null;
	if(s1.equals("type")){
		sql="select * from shebei where type=?;";
		ps=con.prepareStatement(sql);
    	ps.setString(1,s2);	    
	}else if(s1.equals("department")){
		sql="select * from shebei where department=?;";
		ps=con.prepareStatement(sql);
    	ps.setString(1,s2);	 
	}else if(s1.equals("date")){
		sql="select * from shebei where date=?;";
		ps=con.prepareStatement(sql);
    	ps.setString(1,s2);	 
	}else if(s1.equals("brand")){
		sql="select * from shebei where brand=?;";
		ps=con.prepareStatement(sql);
    	ps.setString(1,s2);	 
	}	
    ResultSet rs=ps.executeQuery();

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
	 	 </tr>
    <%
    			}
    		}
    		ps.close();
	
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
 </body>
 </html>