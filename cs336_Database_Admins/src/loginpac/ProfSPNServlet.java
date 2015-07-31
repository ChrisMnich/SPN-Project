package loginpac;

import helper.SPNRequests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfSPNServlet
 */
@WebServlet("/ProfSPNServlet")
public class ProfSPNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfSPNServlet() {
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
			//System.out.println("working in Professor SPN Handling servlet");
	        try{	
	        	
	        	if(theURL.contains("ProfApprove")){
	        		if(SPNRequests.Approved(request.getParameter("netID"), request.getParameter("CourseID"), request.getParameter("SectionNo")))
	        			response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/ProfCourseView.jsp"));
	        		else
	        			response.sendRedirect("Empty.jsp");
	        		//response.sendRedirect("Professor.jsp");	
	        	}else if(theURL.contains("ProfDeny")){
	        		SPNRequests.Denied(request.getParameter("netID"), request.getParameter("CourseID"), request.getParameter("SectionNo"));
	        		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/ProfCourseView.jsp"));
	        	}else if(theURL.contains("ProfComment")){
	        		session.setAttribute("person", request.getParameter("netID"));
	        		session.setAttribute("class", request.getParameter("CourseID"));
	        		session.setAttribute("sec", request.getParameter("SectionNo"));
	        		response.sendRedirect("ProfComment.jsp");
	        	}

	        	
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
