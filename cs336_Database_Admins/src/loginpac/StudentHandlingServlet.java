package loginpac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentHandlingServlet
 */
@WebServlet("/StudentHandlingServlet")
public class StudentHandlingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentHandlingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("Working here in the studentu pdates");
		
		HttpSession session = request.getSession();
		String theURL = request.getRequestURL().toString();
		//System.out.println(theURL);
		
		if(null == session.getAttribute("netID")){  
  		  // User is not logged in.
			session.invalidate();
			response.sendRedirect("Login.jsp");
		}else{  
  		  // User IS logged in.  
			//System.out.println("working in student update servlet");
	        try
	        {	
	        	
	        	if(theURL.contains("SCourseUpdates"))
	        		response.sendRedirect("CourseTaken.jsp");
	        	else if(theURL.contains("RequestUpdates")){
	        		response.sendRedirect("Request.jsp");
	        	}else if(theURL.contains("SInfoUpdates")){
	        		response.sendRedirect("Info.jsp");
	        	}else if(theURL.contains("StudentViewEligibility")){
	        		session.setAttribute("courseID", request.getParameter("CourseID"));
	        		session.setAttribute("sectionNo", request.getParameter("SectionNo"));
	        		response.sendRedirect("StudentViewEligibility.jsp");
	        	}else
	        		response.sendRedirect("Student.jsp");
	        	
	        }catch(Exception e){
	        	System.out.println(e);
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
