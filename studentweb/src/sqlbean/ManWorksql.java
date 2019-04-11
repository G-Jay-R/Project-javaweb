package sqlbean;
import com.Man;
import java.sql.*;


public class ManWorksql {
	//Connsql connsql=new Connsql();
	//public String ToGBK(String str){
		   //byte GBK[]=new byte[str.length()];
		   //for(int i=0;i<str.length();i++){
		       //GBK[i]=(byte)str.charAt(i);
		   //}
		   //return new String(GBK);
    //}
	 //添加用户信息
    public int insertInformation(Man m){
    	int n=0;//n=0 说明添加不成功
    	try{
    		Connsql connsql=new Connsql();
    		Connection con=connsql.getConnection();
    		Statement stmt=con.createStatement();
    		n=stmt.executeUpdate("insert into man values('"+m.getManName()+"','"+m.getManPassword()+"');");
    		stmt.close();
    		con.close();
    	}
    	catch(SQLException e){
    	
    		}
    	return n;
    }
    //查询用户信息
    public Man selectInformation(Man m){
    	Man m1=new Man();
    	try{
    		Connsql connsql=new Connsql();
    		Connection con=connsql.getConnection();
    		Statement stmt=con.createStatement();
    		ResultSet rs=stmt.executeQuery("select * from man where name='"+m.getManName()+"';");
    		if(rs!=null){
    			while(rs.next()){
    				String str1=rs.getString(1);
    				String str2=rs.getString(2);
    				//str1=ToGBK(str1);
    				//str2=ToGBK(str2);
    			    m1.setManName(str1);
    				m1.setManPassword(str2);
    			
    			}
    		}
    		stmt.close();
    		con.close();
    	}
    	catch(Exception e){
    		
    	}
    	return m1;
    }
    //修改用户信息
    public int amendInformation(Man m){
        int n=0;//n=0
    	try{
    		Connsql connsql=new Connsql();
    		Connection con=connsql.getConnection();
    		Statement stmt=con.createStatement();
    		n=stmt.executeUpdate("update student set password='"+m.getManPassword()+"' where name='"+m.getManName()+"';");
    		stmt.close();
    		con.close();
        }	
    	catch(Exception e){
    	
    	}
    	return n;
    }
    //删除用户信息
    public int deleteInformation(Man m){
        int n=0;//n=0不成功
    	try{
    		Connsql connsql=new Connsql();
    		Connection con=connsql.getConnection();
    		Statement stmt=con.createStatement();
    		n=stmt.executeUpdate("delete from man where name='"+m.getManName()+"';");
    		stmt.close();
    		con.close();
        }	
    	catch(Exception e){
    	
    	}
    	return n;
    }

}