package sqlbean;
import com.*;
import servlet.*;
import java.sql.*;

public class Connsql {
    public Connsql(){}
    //连接数据库
    String driver="org.gjt.mm.mysql.Driver";
    String uesr="root";
    String userPassword="111";
    String url="jdbc:mysql://localhost:3306/weiqilong";
    public Connection getConnection(){
    	Connection con=null;
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,uesr,userPassword);
		}
		catch(Exception e)
		{
			
		}
		return con;
    }
}
