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
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("working");
        try
        {
            System.out.println("In the Login Servlet");
            LoginBean user = new LoginBean();
            user.setUserName(request.getParameter("netID"));
            user.setPassword(request.getParameter("password"));
            user = LoginDAO.login(user);
            if(user.isValid())
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("netID",user.getUsername());
                session.setAttribute("name", user.getFirstName());
                response.sendRedirect("LoginSuccess.jsp");
            }else
                response.sendRedirect("LoginFailed.jsp");
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
