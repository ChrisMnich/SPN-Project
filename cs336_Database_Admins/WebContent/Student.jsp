<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="loginpac.ConnectionManager, java.sql.Connection, java.sql.ResultSet, java.sql.Statement, loginpac.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<body>

	Welcome <%= (String)session.getAttribute("name") %>
	<br>
	<br>
	<B>Info</B>
	<%
		String netID = (String)session.getAttribute("netID");
		//System.out.println(netID);	
	
		String query="SELECT * FROM Person P, Student S WHERE P.netID = S.netID AND S.netID='" + netID + "'";
		Connection conn= ConnectionManager.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);
	%>

	
	<table border="2">
	<tr>
	<th>RUID</th>
	<th>NetID</th>
	<th>Credits</th>
	<th>GPA</th>

	</tr>
		<% while(rs.next()){	%>	
			<tr>
				<td> <%=rs.getString("RUID") %> </td>
				<td> <%=rs.getString("NetID") %> </td>
				<td> <%=rs.getString("CreditTotal") %> </td>
				<td> <%=rs.getInt("GPA") %> </td>
			</tr>
		<% } %>
	</table>
		
	<%
		rs.close();
		stmt.close();
		conn.close();
	%>
	<BR>
	<BR>
	
	<B>Courses Taken</B>
	<%
		query="SELECT DISTINCT C.CourseID, T.Grade, T.Credits, T.SectionNo FROM Course C, CoursesTaken T WHERE C.CourseID = T.CourseID AND T.netID='" + netID + "'";
		conn= ConnectionManager.getConnection();
		stmt=conn.createStatement();
		rs=stmt.executeQuery(query);
	%>

	
	<table border="2">
	<tr>
	<th>CourseID</th>
	<th>Section</th>
	<th>Grade</th>
	<th>Credits</th>
	</tr>
		<% while(rs.next()){	%>	
			<tr>
				<td> <%=rs.getString("CourseID") %> </td>
				<td> <%=rs.getInt("SectionNo") %></td>
				<td> <%=rs.getString("Grade") %> </td>
				<td> <%=rs.getInt("Credits") %> </td>
			</tr>
		<% } %>
	</table>
		
	<%
		rs.close();
		stmt.close();
		conn.close();
	%>
	<br>
	Make a Request
	<FORM NAME="actionForm" action="RequestUpdates" method='get'>
		<input type="submit" name="SPNRequest" value="Make a SPN Request">
    </FORM>

	<br>
	Update your info
	<FORM NAME="actionForm" action="SInfoUpdates" method='get'>
		<input type="submit" name="StudentInfo" value="Updates your Info">
    </FORM>
	
	<br>
	Add Courses You've Taken
	<FORM NAME="actionForm" action="SCourseUpdates" method='get'>
		<input type="submit" name="CoursesTaken" value="Add Courses">
    </FORM>
	
	<br>
	<br>
	<FORM NAME="actionForm" action="Logout" method='get'>
		<input type="submit" name="Logout" value="Logout">
    </FORM>


</body>




</html>