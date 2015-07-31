package loginpac;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        try
        {	
          //  System.out.println("In the Account Creation Servlet");
            
            String[] form = new String[6];
            String[] parameters = new String[6];
            String status = "";
            
            
            
            form[0] = "'" + request.getParameter("netID") + "'";
            form[1] = "'" + request.getParameter("password") + "'";
            form[2] = "'" + request.getParameter("FirstName") + "'";
            form[3] = "'" + request.getParameter("LastName") + "'";
            form[4] = "'" + request.getParameter("RUID") + "'";
            form[5] = "'" + request.getParameter("Email") + "'";


            status = request.getParameter("Status");
            
            parameters[0] = "netID";
            parameters[1] = "password";
            parameters[2] = "FirstName";
            parameters[3] = "LastName";
            parameters[4] = "RUID";
            parameters[5] = "Email";
            
          //  System.out.println(form[0] + " " + form[4]);

            if(form[0].length() > 2 && form[1].length() > 2){				//only run if netID and password are present
            	
            	Connection conn = ConnectionManager.getConnection();
	            Statement stmt = conn.createStatement();
            
	            StringBuilder valuesPerson = new StringBuilder();			//These build strings that define the values to be inserted
	            StringBuilder insertPerson = new StringBuilder();			// as well as where to insert them in table: Person
	            
	            for(int i = 0; i < 4; i++){
	            	if(form[i] != null){
	            		if(valuesPerson.length() > 0){
	                		valuesPerson.append(", ");
	                		insertPerson.append(", ");
	                	}
	                	valuesPerson.append(form[i]);
	                	insertPerson.append(parameters[i]);
	            	}	
	            }
	            
	            String command = "INSERT INTO Person(" + insertPerson.toString() + ") VALUES (" + valuesPerson.toString() + ")";
	            
	            stmt.executeUpdate(command);
	            
	            if(status.equals("Student")&& form[4].length() > 2){		//These build strings for value and where to insert them
	            	StringBuilder values = new StringBuilder();				//but for table: student
		            StringBuilder insert = new StringBuilder();
		            
		        //    System.out.println("hello in there");
		            
		            for(int i = 0; i < 6; i++){
		            	if(form[i] != null){
		            		if(values.length() > 0){
		                		values.append(", ");
		                		insert.append(", ");
		                	}
		                	values.append(form[i]);
		                	insert.append(parameters[i]);
		            	}
		            	
		            	if(i == 0)
		            		i=3;
		            }
		            
		            command = "INSERT INTO Student(" + insert.toString() + ") VALUES (" + values.toString() + ")";
		            stmt.executeUpdate(command);
		            
		            
		            
	            }else if(status.equals("Professor")){
	            	StringBuilder values = new StringBuilder();				//but for table: student or table: professor
		            StringBuilder insert = new StringBuilder();
		            
		            for(int i = 0; i < 6; i++){
		            	if(form[i] != null){
		            		if(values.length() > 0){
		                		values.append(", ");
		                		insert.append(", ");
		                	}
		                	values.append(form[i]);
		                	insert.append(parameters[i]);
		            	}
		            	if(i == 0)
		            		i=4;
		            }
		            
		            command = "INSERT INTO Professor(" + insert.toString() + ") VALUES (" + values.toString() + ")";
		        //    System.out.println(insert.toString());
		        //    System.out.println(values.toString());
		            stmt.executeUpdate(command);
		            
	            }
	            
	            conn.close();
	            stmt.close();
            }
            
            response.sendRedirect("Login.jsp");
                
        } catch (Throwable exc){
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
