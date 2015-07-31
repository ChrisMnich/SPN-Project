package helper;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;



import loginpac.ConnectionManager;

public class Rating {
	
	public static void insert(String netID){
		try{
			
			int rating = grab(netID);
			
			String command="Update SPRequest SET Rating = " + rating + " WHERE netID='" + netID + "'";
			Connection conn= ConnectionManager.getConnection();
			Statement stmt=conn.createStatement();
			stmt.execute(command);

		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	public static int grab(String netID){
		
		try{
			String query="SELECT DISTINCT * FROM Student S WHERE S.netID='" + netID + "'";
			Connection conn= ConnectionManager.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			
			Float gpa = 0.0f;
			int credits = 0;
			String major = "";
			
			while(rs.next()){
				gpa = rs.getFloat("GPA");
				credits = rs.getInt("CreditTotal");
				major = rs.getString("Major");
			}
			
			conn.close();
			stmt.close();
			rs.close();
			
			return RatingCalc(gpa, credits, major);
			
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		
		return 0;
		
	}
	
	public static int RatingCalc(Float GPA, int credits, String major){
		int rating = 0;
		
		if(major.equals("Computer Science"))
			rating += 3;
		
		if(GPA > 3)
			rating += 4;
		if(GPA > 2 && GPA <=3)
			rating += 3;
		if(GPA > 1 && GPA <=2)
			rating += 2;
		if(GPA >= 0 && GPA <=1)
			rating += 1;
		
		if(credits >= 90)
			rating +=4;
		if(credits >= 60 && credits < 90)
			rating +=3;
		if(credits >= 30 && credits < 60)
			rating +=2;
		if(credits >= 0 && credits < 0)
			rating +=1;
		return rating;
	}
}
