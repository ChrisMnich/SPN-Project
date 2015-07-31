package loginpac;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfCourseInsert
 */
@WebServlet("/ProfCourseInsert")
public class ProfCourseInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfCourseInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	if(null == session.getAttribute("netID")){  
    		  // User is not logged in.
    		session.invalidate();
    		response.sendRedirect("Login.jsp");
    	}else{  
    		  // User IS logged in.  
    		//System.out.println("working in ProfCourseInsert servlet");
	        try
	        {	

	            String netID = (String)session.getAttribute("netID");			//session is validated, grab the info and use it
	            
	            ClassBean course = new ClassBean();
	            
	            course.setCourse(request.getParameter("Course"));
	            course.setSection(request.getParameter("SectionNo"));
	            course.setCredits(request.getParameter("Credits"));
	            
	            //System.out.println(netID);
	           // System.out.println(course.getSection());
	            String[] sequence = new String[2];
	            
	            if(course.getCourse().length() > 0)
	            	sequence[0] = "'" + course.getCourse() + "'";
	            
	            if(course.getSection().length() > 0)
	            	sequence[1] = course.getSection();
	            
	            //if(course.getCredits().length() > 0)
	            //	sequence[1] = "'" + course.getCredits() + "'";
	            
	            StringBuilder sb = new StringBuilder();
	            for(String item: sequence){
	            	if(item != null){
	            		if(sb.length() > 0){
	                		sb.append(", ");
	                	}
	                	sb.append(item);
	            	}	
	            }
	            
	            //UPDATE Student SET GPA = 4.0 WHERE netID = 'jsj57' ;
	            String criteria = sb.toString();
	            //System.out.println(criteria);
	           // System.out.println(netID);
	            
	            if(criteria.length() > 0){
	            	
	            	//String command = "SELECT C.Credits FROM Course C, CoursesTaken T WHERE T.netID = '" + netID + 
	            	//		"' AND C.CourseID = '" + course.getCourse() + "'";
	            	
		            Connection conn = ConnectionManager.getConnection();
		            Statement stmt = conn.createStatement();
		            /*ResultSet rs=stmt.executeQuery(command);
		            rs.next();
		            int credits = rs.getInt("Credits");*/
	            	
		            String command = "INSERT INTO Teaches(CourseID, SectionNo, netID, SPtogive) VALUES(" + criteria + ", '" + netID + "', 10)";
		            //System.out.println(command);
		            stmt.executeUpdate(command);
		            conn.close();
		            stmt.close();
		            
		            response.sendRedirect("Professor.jsp");
		            
		            

	            }  

	            response.sendRedirect("NoChanges.jsp");
	                
	        } catch (Throwable exc){
	            System.out.println(exc);
	        }
    	}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
