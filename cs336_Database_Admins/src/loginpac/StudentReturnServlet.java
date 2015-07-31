package loginpac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentReturnServlet
 */
@WebServlet("/StudentReturnServlet")
public class StudentReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentReturnServlet() {
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
	            //System.out.println("In the StudentReturn Servlet");
	            response.sendRedirect("Student.jsp");
	                
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
