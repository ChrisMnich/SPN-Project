<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="loginpac.ConnectionManager, java.sql.Connection, java.sql.ResultSet, java.sql.Statement, loginpac.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comments</title>
</head>
<body>
		<div align="center"><br>
		<B>Request</B>
	<%
		String student = (String)session.getAttribute("person");
		String course = (String)session.getAttribute("class");
		String section = (String)session.getAttribute("sec");
		
		
		String query="SELECT R.netID, R.CourseID, R.SectionNo, R.Status, R.Comment FROM SPRequest R WHERE R.netID = '" + student + "' AND R.CourseID = '" + course + "' AND R.SectionNo = " + section;
		
		
		Connection conn= ConnectionManager.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);
	%>
	
	<B>Waiting List</B>
	<table border="2">
	<tr>
	<th>Student</th>
	<th>CourseID</th>
	<th>Section</th>
	<th>Status</th>
	<th>Comment</th>

	</tr>
		<% while(rs.next()){
		%>	
			
				<tr>
					<td> <%=rs.getString("netID") %> </td>
					<td> <%=rs.getString("CourseID") %> </td>
					<td> <%=rs.getInt("SectionNo") %> </td>
					<td> <%=rs.getString("Status") %> </td>
					<td> <%=rs.getString("Comment") %> </td>
				</tr>
		<% } 
		
		rs.close();
		stmt.close();
		conn.close();
		%>
	</table>
	</div>
	
	<form name="comment" action="ProcessComment" method="get">
	<div align="center"><br>
	Enter your comment below...<br>
	<input type="text" maxlength = "100" name="Comment" size="50" >
	<br>
	<input type="submit" value="Submit" /> 
	</div>
	</form>
		
	<br>
	<br>
	<FORM NAME="actionForm" action="ProfReturn" method='get'>
		<input type="submit" name="ProfReturn" value="Return to Professor Hub">
    </FORM>
	<br>
	<FORM NAME="actionForm" action="Logout" method='get'>
		<input type="submit" name="Logout" value="Logout">
    </FORM>
	
</body>
</html>