package loginpac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.Statement;
 
/**
* Servlet implementation class LoginServlet
*/
public class RequestHandlerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestHandlerServlet() {
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
	        try
	        {	
	            //System.out.println("In the Request Handler Servlet");
	            
	            String netID = (String)session.getAttribute("netID");			//session is validated, grab the info and use it
	            
	            ClassBean info = new ClassBean();
	            
	            info.setCourse(request.getParameter("Course"));
	            info.setSection(request.getParameter("Section"));
	            int rating = 0;
	           // System.out.println(netID);
	            //System.out.println(info.getCourse());
	            
	            String course = info.getCourse();
	            String section = info.getSection();
	            
	            if(course.length() > 0 && section.length() > 0){
	            	String command = "INSERT INTO SPREQUEST(netID, CourseID, SectionNo, Date, Status, Rating) VALUES ('"
		            		+ netID + "', '" + info.getCourse() + "', " +  info.getSection() + ", NOW(), " + "'Pending', " + rating + ")";
		            
		            Connection conn = ConnectionManager.getConnection();
		            Statement stmt = conn.createStatement();
		            
		            stmt.executeUpdate(command);
		            conn.close();
		            stmt.close();
		            
		            response.sendRedirect("Request.jsp");
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