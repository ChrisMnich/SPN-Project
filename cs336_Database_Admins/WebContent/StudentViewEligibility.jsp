<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="loginpac.ConnectionManager, java.sql.Connection, java.sql.ResultSet, java.sql.Statement, loginpac.*, helper.Rating" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Prerequisites</title>
</head>
<body>
<B>Required Courses</B>
	<%
		String netID = (String)session.getAttribute("netID");
		String course = "'" + (String)session.getAttribute("courseID") + "'";

		//System.out.println(course);
		
		String query="SELECT DISTINCT P.Prereq, C.Credits FROM PrereqList P, Course C WHERE C.CourseID = P.Prereq AND P.CourseID = " + course + " ORDER BY P.CourseID";
		String queryTwo="SELECT DISTINCT T.CourseID, T.Grade, netID FROM PrereqList P, CoursesTaken T WHERE P.Prereq = T.CourseID AND T.NetID = '" + netID + "' AND P.CourseID = " + course + " ORDER BY P.CourseID";
		Connection conn= ConnectionManager.getConnection();
		Statement stmt=conn.createStatement();
		
		//System.out.println(query);
		//System.out.println(queryTwo);
		
		ResultSet rs=stmt.executeQuery(query);
	%>
	<B>Required Prerequisites</B>
	<table border="2">
	<tr>
	<th>CourseID</th>
	<th>Credits</th>
	</tr>
		<% while(rs.next()){
		%>	
			
				<tr>
					<td> <%=rs.getString("Prereq") %> </td>
					<td> <%=rs.getString("Credits") %> </td>
				</tr>
				
		<%
			}
		
			rs.close();
			stmt.close();
			conn.close();
			
			conn= ConnectionManager.getConnection();
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(queryTwo);
		%>
	</table>
	
	<B>Prerequisites met by student</B>
	<table border="2">
	<tr>
	<th>netID</th>
	<th>CourseID</th>
	<th>Grade</th>

	</tr>
		<% while(rs.next()){
		%>	
			
				<tr>
					<td> <%=rs.getString("netID") %> </td>
					<td> <%=rs.getString("CourseID") %> </td>
					<td> <%=rs.getString("Grade") %> </td>
				</tr>
				
		<%
			}
		%>
	</table>
		
	<%
		rs.close();
		stmt.close();
		conn.close();
	%>
	
			<br>	
		<FORM NAME="actionForm" action="StudentReturn" method='get'>
			<input type="submit" name="StudentReturn" value="Return to Student Hub">
    	</FORM>
		<br>
		<br>
		<FORM NAME="actionForm" action="Logout" method='get'>
			<input type="submit" name="Logout" value="Logout">
	    </FORM>
</body>
</html>