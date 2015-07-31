package helper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



import java.util.Random;

import loginpac.ConnectionManager;

public class SPNRequests {
	
	public static boolean Approved(String netID, String course, String section){	
			
		try
		{	
			String source = netID + course + section;
			Random rng = new Random();
			
			String SPN = Generator.generate(rng, source, 6);
			
			String query = "SELECT DISTINCT T.SPtogive FROM Teaches T WHERE T.CourseID = '" + course + "' AND T.SectionNo = " + section;
			Connection conn= ConnectionManager.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int SPtogive = 0;
			
			while(rs.next()){
				SPtogive = rs.getInt("SPtogive");
			}
			
			if(SPtogive <= 0){
				stmt.close();
				conn.close();
				return false;
			}else{
				String command="UPDATE SPRequest SET Status = 'Approved', SPID = '" + SPN + "' WHERE netID='" + netID + "' AND CourseID = '" + course + "' AND SectionNo = " + section;
				stmt.execute(command);
				System.out.println(command);
				command="UPDATE Teaches SET SPtogive = SPtogive-1 WHERE CourseID = '" + course + "' AND SectionNo = " + section;
				System.out.println(command);
				stmt.execute(command);
				
				stmt.close();
				conn.close();
				return true;
			}
			
			
		}catch (Exception e){
			System.out.println("Request failed: An Exception has occurred! " + e);
		}
		return false;
	}
	
	public static void Denied(String netID, String course, String section){	
		
		try
		{	
			String command="UPDATE SPRequest SET Status = 'Denied', SPID = 'N/A' WHERE netID='" + netID + "' AND CourseID = '" + course + "' AND SectionNo = " + section;
			Connection conn= ConnectionManager.getConnection();
			Statement stmt=conn.createStatement();
			stmt.execute(command);

			stmt.close();
			conn.close();
		}catch (Exception e){
			System.out.println("Request failed: An Exception has occurred! " + e);
		}
	}
	
}
