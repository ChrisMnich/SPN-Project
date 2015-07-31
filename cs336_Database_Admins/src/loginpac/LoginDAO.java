
package loginpac;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class LoginDAO{
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public static LoginBean login(LoginBean bean){
		Statement stmt = null;
		String username = bean.getUsername();
		String password = bean.getPassword();
		String searchQuery = "select * from Student S, Person P where S.netID = P.netID AND S.netID='" + username + "' AND P.password='" + password + "'";
		
		try
		{
			//System.out.println("working 0");
			//connecting to the DB
			currentCon = ConnectionManager.getConnection();
			//System.out.println("working 1");
			stmt=currentCon.createStatement();
			//System.out.println("working 2");
			rs = stmt.executeQuery(searchQuery);
			//System.out.println("working 3");
			boolean userExists = rs.next();
			//System.out.println("working 4");
			 
			if (!userExists){
				System.out.println("Username/Password entered is Incorrect or User doesnot Exists.");
				bean.setValid(false);
			}
			else if (userExists){
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				System.out.println("Welcome " + firstName);
				bean.setFirstName(firstName);
				bean.setLastName(lastName);
				bean.setValid(true);
			}
			 
		}catch (Exception ex){
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}
		
	return bean;
	}
	
	public static LoginBean profLogin(LoginBean bean){
		Statement stmt = null;
		String username = bean.getUsername();
		String password = bean.getPassword();
		String searchQuery = "select * from Professor S, Person P where S.netID = P.netID AND S.netID='" + username + "' AND P.password='" + password + "'";
		
		try
		{
				//System.out.println("working 0");
			//connecting to the DB
			currentCon = ConnectionManager.getConnection();
				//System.out.println("working 1");
			stmt=currentCon.createStatement();
				//System.out.println("working 2");
			rs = stmt.executeQuery(searchQuery);
				//System.out.println("working 3");
			boolean userExists = rs.next();
				//System.out.println("working 4");
			 
			if (!userExists){
				System.out.println("Username/Password entered is Incorrect or User does not Exists.");
				bean.setValid(false);
			}else if (userExists){
				boolean admin = rs.getBoolean("Admin");
				String firstName = rs.getString("FirstName");
				if(firstName == null)
					firstName = "";
				
				String lastName = rs.getString("LastName");
				if(lastName == null)
					lastName = "";
				
				System.out.println("Welcome " + firstName);
				
				bean.setAdmin(admin);
				bean.setFirstName(firstName);
				bean.setLastName(lastName);
				bean.setValid(true);
			}
			 
		}catch (Exception ex){
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}
		
	return bean;
	}
}