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
public class InfoUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//System.out.println("working");

        HttpSession session = request.getSession();
    	if(null == session.getAttribute("netID")){  
    		  // User is not logged in.
    		session.invalidate();
    		response.sendRedirect("Login.jsp");
    	}else{  
    		  // User IS logged in.  
    		//System.out.println("working in info servlet");
	        try
	        {	

	           // System.out.println("In the Info Handler Servlet");
	            
	            String netID = (String)session.getAttribute("netID");			//session is validated, grab the info and use it
	            
	            StudentBean studentInfo = new StudentBean();
	            
	            studentInfo.setCredits(request.getParameter("Credits"));
	            studentInfo.setGPA(request.getParameter("GPA"));
	            studentInfo.setMajor(request.getParameter("Major"));
	            
	           // System.out.println(netID);
	           // System.out.println(studentInfo.getCredits());
	            String[] sequence = new String[3];
	            
	            if(studentInfo.getCredits().length() > 0)
	            	sequence[0] = "CreditTotal =" + studentInfo.getCredits();
	            
	            if(studentInfo.getGPA().length() > 0)
	            	sequence[1] = "GPA =" + studentInfo.getGPA();
	            
	            if(studentInfo.getMajor().length() > 0)
	            	sequence[2] = "Major = '" + studentInfo.getMajor() + "'";
	            
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
	           // System.out.println(criteria);
	          //  System.out.println(netID);
	            
	            if(criteria.length() > 0){
		            String command = "UPDATE Student SET " + criteria + " WHERE netID = '" + netID + "'";
		            
		            
		            Connection conn = ConnectionManager.getConnection();
		            Statement stmt = conn.createStatement();
		            stmt.executeUpdate(command);
		            conn.close();
		            stmt.close();
		            
		            response.sendRedirect("Student.jsp");

		            
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
