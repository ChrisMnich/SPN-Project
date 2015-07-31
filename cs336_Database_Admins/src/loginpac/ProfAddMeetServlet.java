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
 * Servlet implementation class ProfAddMeet
 */
@WebServlet("/ProfAddMeetServlet")
public class ProfAddMeetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfAddMeetServlet() {
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
    		
    		if(request.getParameter("RoomID").length() < 1 || request.getParameter("Meeting Type") == null){
    			//System.out.println("broken");
    			session.setAttribute("error", "Please enter all fields correctly");
    			response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/ProfCourseUpdate.jsp"));
    			//request.getRequestDispatcher("ProfCourseUpdate.jsp").forward(request, response);
    			return;
    		}
    		//System.out.println("working in ProfAddMeet servlet");
    		
    		
    		session.removeAttribute("error");
    		
	        try
	        {	
	            ClassBean course = new ClassBean();
	            
	            course.setCourse((String)session.getAttribute("courseID"));
	            course.setSection((String)session.getAttribute("sectionNo"));
	            course.setRoom(request.getParameter("RoomID"));
	            course.setType(request.getParameter("Meeting Type"));
	            
	            String[] sequence = new String[4];
	            //System.out.println(course.getType());

	            if(course.getCourse().length() > 0)
	            	sequence[0] = "'" + course.getCourse() + "'";
	            System.out.println(course.getSection());
	            if(course.getSection().length() > 0)
		            System.out.println("working in ProfAddMeet servlet");
	            	sequence[1] = course.getSection();
	            System.out.println("working in ProfAddMeet servlet2");
	            if(course.getRoom().length() > 0)
	            	sequence[2] = "'" + course.getRoom() + "'";
	            System.out.println("working in ProfAddMeet servlet3");
	            if(course.getType().length() > 0)
	            	sequence[3] = "'" + course.getType() + "'";
	            


	            
	            StringBuilder sb = new StringBuilder();
	            for(String item: sequence){
	            	//int i = 0;
	            	//System.out.println("prof add meet working" + i+i);
	            	if(item != null){
	            		if(sb.length() > 0){
	                		sb.append(", ");
	                	}
	                	sb.append(item);
	            	}
	            	//i++;
	            }
	            
	            //UPDATE Student SET GPA = 4.0 WHERE netID = 'jsj57' ;
	            String criteria = sb.toString();
	           System.out.println(criteria);
	          //  System.out.println(netID);
	            
	            if(criteria.length() > 0){
	            	
	            	//String command = "SELECT C.Credits FROM Course C, CoursesTaken T WHERE T.netID = '" + netID + 
	            	//		"' AND C.CourseID = '" + course.getCourse() + "'";
	            	
		            Connection conn = ConnectionManager.getConnection();
		            Statement stmt = conn.createStatement();
		            /*ResultSet rs=stmt.executeQuery(command);
		            rs.next();
		            int credits = rs.getInt("Credits");*/
	            	
		            String command = "INSERT INTO Meeting(CourseID, SectionNo, RoomID, Type) VALUES(" + criteria + ")";
		           // System.out.println(command);
		            stmt.executeUpdate(command);

		            
		            conn.close();
		            stmt.close();
	            }  

	            response.sendRedirect("Professor.jsp");
	                
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
