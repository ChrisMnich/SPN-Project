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
 * Servlet implementation class ProfPrereqInsertServlet
 */
@WebServlet("/ProfPrereqInsertServlet")
public class ProfPrereqInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfPrereqInsertServlet() {
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
	    		
		        try
		        {	
		        	//System.out.println(request.getRequestURL());

		    		//System.out.println("working in ProfPrereqInsert servlet");
		            
		            String course = (String) session.getAttribute("courseID");
		            String prereq = request.getParameter("prereq");
		            
		            if(course == null || course.length() < 1){
		            	session.setAttribute("badinput", "Please enter a prerequisite course");
		            	response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/ProfPrereq.jsp"));
		            }
		            
		           // System.out.println(course);
		            //System.out.println(prereq);
		            String[] sequence = new String[2];
		            //System.out.println("Hey");
		            if(course.length() > 0)
		            	sequence[0] = "'" + course +"'";

		            if(prereq.length() > 0)
		            	sequence[1] = "'" + prereq +"'";
		            

		            StringBuilder sb = new StringBuilder();


		            for(String item: sequence){
		            	if(item != null){
		            		if(sb.length() > 0){
		                		sb.append(", ");
		                	}
		                	sb.append(item);
		            	}	
		            }
		            
		            String criteria = sb.toString();
		           // System.out.println(criteria);
		            
		            if(criteria.length() > 0){
			            String command = "INSERT INTO PrereqList(CourseID, Prereq) VALUES (" + criteria + ")";

			            Connection conn = ConnectionManager.getConnection();
			            Statement stmt = conn.createStatement();
			            stmt.executeUpdate(command);
			            
			            conn.close();
			            stmt.close();
			            
			            response.sendRedirect("ProfPrereq.jsp");

			               // HttpSession session = request.getSession(true);
			               // session.setAttribute("netID",user.getUsername());
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
