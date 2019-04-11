package sqlbean;
import com.User;
import java.sql.*;


public class UserWorksql {
	//Connsql connsql=new Connsql();
	 //添加管理员信息
    public int insertInformation(User u){
    	int n=0;//n=0 说明添加不成功
    	try{
    		Connsql connsql=new Connsql();
    		Connection con=connsql.getConnection();
    		Statement stmt=con.createStatement();
    		String t1=u.getUserName();
    		System.out.println(t1);
    		n=stmt.executeUpdate("insert into user values('"+u.getUserName()+"','"+u.getUserPassword()+"');");
    		stmt.close();
    		con.close();
    	}
    	catch(SQLException e){
    	
    		}
    	return n;
    }
    //查询管理员信息
    public User selectInformation(User u){
    	User u1=new User();
    	try{
    		Connsql connsql=new Connsql();
    		Connection con=connsql.getConnection();
    		Statement stmt=con.createStatement();
    		ResultSet rs=stmt.executeQuery("select * from user where name='"+u.getUserName()+"';");
    		if(rs!=null){
    			while(rs.next()){
    				
    			    
    				u1.setUserName(rs.getString(1));
    				u1.setUserPassword(rs.getString(2));
    				
    			}
    		}
    		stmt.close();
    		con.close();
    	}
    	catch(Exception e){
    		
    	}
    	return u1;
    }
    //修改管理员信息
    public int amendInformation(User u){
        int n=0;//n=0说明修改不成功
    	try{
    		Connsql connsql=new Connsql();
    		Connection con=connsql.getConnection();
    		Statement stmt=con.createStatement();
    		n=stmt.executeUpdate("update user set password='"+u.getUserPassword()+"' where name='"+u.getUserName()+"';");
    		stmt.close();
    		con.close();
        }	
    	catch(Exception e){
    	
    	}
    	return n;
    }
    //删除管理员信息
    public int deleteInformation(User u){
        int n=0;//n=0说明删除不成功
    	try{
    		Connsql connsql=new Connsql();
    		Connection con=connsql.getConnection();
    		Statement stmt=con.createStatement();
    		n=stmt.executeUpdate("delete from user where name='"+u.getUserName()+"';");
    		stmt.close();
    		con.close();
        }	
    	catch(Exception e){
    	
    	}
    	return n;
    }

}