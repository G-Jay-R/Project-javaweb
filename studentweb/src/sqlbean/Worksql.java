package sqlbean;

import java.sql.*;
import com.Student;

public class Worksql {
	//Connsql connsql=new Connsql();
	 //添加学生信息
    public int insertInformation(Student s){
    	int n=0;//n=0说明添加学生不成功
    	try{
    		Connsql connsql=new Connsql();
    		Connection con=connsql.getConnection();
    		Statement stmt=con.createStatement();
    		n=stmt.executeUpdate("insert into student values('"+s.getSno()+"','"+s.getName()+"','"+s.getSex()+"','"+s.getAge()+"');");
    		stmt.close();
    		con.close();
    	}
    	catch(SQLException e){
    	
    		}
    	return n;
    }
    //查询学生信息
    public Student selectInformation(Student s){
    	Student s1=new Student();
    	try{
    		Connsql connsql=new Connsql();
    		Connection con=connsql.getConnection();
    		Statement stmt=con.createStatement();
    		ResultSet rs=stmt.executeQuery("select * from student where sno='"+s.getSno()+"';");
    		if(rs!=null){
    			while(rs.next()){
    				
    			    s1.setSno(rs.getString(1));
    				s1.setName(rs.getString(2));
    				s1.setSex(rs.getString(3));
    				s1.setAge(rs.getString(4));
    			}
    		}
    		stmt.close();
    		con.close();
    	}
    	catch(Exception e){
    		
    	}
    	return s1;
    }
    //修改学生信息
    public int amendInformation(Student s){
        int n=0;//n=0说明修改不成功
    	try{
    		Connsql connsql=new Connsql();
    		Connection con=connsql.getConnection();
    		Statement stmt=con.createStatement();
    		n=stmt.executeUpdate("update student set name='"+s.getName()+"',sex='"+s.getSex()+"',age='"+s.getAge()+"' where sno='"+s.getSno()+"';");
    		stmt.close();
    		con.close();
        }	
    	catch(Exception e){
    	
    	}
    	return n;
    }
    //删除学生信息
    public int deleteInformation(Student s){
        int n=0;//n=0 说明删除不成功
    	try{
    		Connsql connsql=new Connsql();
    		Connection con=connsql.getConnection();
    		Statement stmt=con.createStatement();
    		n=stmt.executeUpdate("delete from student where sno='"+s.getSno()+"';");
    		stmt.close();
    		con.close();
        }	
    	catch(Exception e){
    	
    	}
    	return n;
    }

}
