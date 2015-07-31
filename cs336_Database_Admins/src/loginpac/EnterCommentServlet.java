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
 * Servlet implementation class EnterCommentServlet
 */
@WebServlet("/EnterCommentServlet")
public class EnterCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterCommentServlet() {
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
		        	
		          //  System.out.println((String)session.getAttribute("person"));
		          //  System.out.println((String)session.getAttribute("class"));
		          //  System.out.println((String)session.getAttribute("sec"));
		            String student = (String)session.getAttribute("person");	
		            String comment = request.getParameter("Comment");
		            
		            comment = comment.replace("'", "\\'");
		            
		            System.out.println(comment);
		            
		            ClassBean course = new ClassBean();

		            course.setCourse((String)session.getAttribute("class"));
		            course.setSection((String)session.getAttribute("sec"));
		            
		            

		            Connection conn = ConnectionManager.getConnection();
		            Statement stmt = conn.createStatement();

	            	
		            String command = "UPDATE SPRequest SET COMMENT = '" + comment + "' WHERE netID = '" + student + "' AND CourseID = '" + course.getCourse() + "' AND SectionNo = " + course.getSection();
		          //  System.out.println(command);
		            stmt.executeUpdate(command);

		            conn.close();
		            stmt.close();
		            
		            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/ProfComment.jsp"));
		                
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
