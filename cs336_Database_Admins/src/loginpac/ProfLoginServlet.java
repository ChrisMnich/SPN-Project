package loginpac;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
/**
* Servlet implementation class LoginServlet
*/
public class ProfLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//System.out.println("Unique Prof working");
        try
        {
            //System.out.println("In the Login Servlet");
            LoginBean user = new LoginBean();
            user.setUserName(request.getParameter("netID"));
            user.setPassword(request.getParameter("password"));
            user = LoginDAO.profLogin(user);
            if(user.isValid())
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("netID",user.getUsername());
                session.setAttribute("name", user.getFirstName());
                //System.out.println(user.isAdmin());
                
                if(user.isAdmin()){
                	session.setAttribute("admin", Boolean.TRUE);
                	session.setAttribute("welcome", "Welcome Administrator " + user.getFirstName());
                }else{
                	session.setAttribute("admin", Boolean.FALSE);
                	session.setAttribute("welcome", "Welcome " + user.getFirstName());
                }
                //System.out.println(session.getAttribute("admin"));
                
                response.sendRedirect("ProfLoginSuccess.jsp");
            }else
                response.sendRedirect("ProfLoginFailed.jsp");
        } catch (Throwable exc)
        {
            System.out.println(exc);
        }
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
 
}
