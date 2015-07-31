package loginpac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConnectionManager
{
    static Connection conn;
 
    public static Connection getConnection()
    {
    	//System.out.println("working CM1");
        try
        {
            String url = "jdbc:mysql://localhost:3306/";
            String dbName ="cs336_Database_Admins"; // here "cs336_Database_Admins" is the name of Database.
            String uname = "root";
            String pwd = "rutgerscs336";
 
            Class.forName("com.mysql.jdbc.Driver");
            try
            {
                conn = DriverManager.getConnection(url+dbName,uname,pwd);
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        return conn;
    }
 
}