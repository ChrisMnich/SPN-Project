package loginpac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfessorHandlingServlet
 */
@WebServlet("/ProfessorHandlingServlet")
public class ProfessorHandlingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorHandlingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		String theURL = request.getRequestURL().toString();
		//System.out.println(theURL);
		
		if(null == session.getAttribute("netID")){  
  		  // User is not logged in.
			session.invalidate();
			response.sendRedirect("Login.jsp");
		}else{  
  		  // User IS logged in.  
			//System.out.println("working in Professor Handling servlet");
	        try
	        {	
	        	
	        	if(theURL.contains("ProfAddCourse")){
	        		response.sendRedirect("ProfAddCourse.jsp");
	        	}else if(theURL.contains("ProfCourseUpdate")){
	        		//System.out.println(request.getParameter("CourseID"));
	        		session.setAttribute("courseID", request.getParameter("CourseID"));
	        		session.setAttribute("sectionNo", request.getParameter("SectionNo"));
	        		//System.out.println("Heeey");
	        		response.sendRedirect("ProfCourseUpdate.jsp");
	        		//System.out.println("Heeey");
	        	}else if(theURL.contains("ProfCourseView")){
	        		session.setAttribute("courseID", request.getParameter("CourseID"));
	        		session.setAttribute("sectionNo", request.getParameter("SectionNo"));
	        		response.sendRedirect("ProfCourseView.jsp");
	        	}else if(theURL.contains("ProfPrereq")){
	        		session.setAttribute("courseID", request.getParameter("CourseID"));
	        		session.setAttribute("sectionNo", request.getParameter("SectionNo"));
	        		response.sendRedirect("ProfPrereq.jsp");
	        	}else if(theURL.contains("ProfViewEligibility")){
	        		session.setAttribute("student", request.getParameter("netID"));
	        		session.setAttribute("courseID", request.getParameter("CourseID"));
	        		session.setAttribute("sectionNo", request.getParameter("SectionNo"));
	        		response.sendRedirect("ProfViewEligibility.jsp");
		
	        	}else if(theURL.contains("SInfoUpdates")){
	        		response.sendRedirect("Info.jsp");
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
