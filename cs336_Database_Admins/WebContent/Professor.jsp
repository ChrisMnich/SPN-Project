<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="loginpac.ConnectionManager, java.sql.Connection, java.sql.ResultSet, java.sql.Statement, loginpac.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Professor</title>
</head>
<body>

	
	<%= (String)session.getAttribute("welcome") %>
	<br>
	<br>
	<B>Your Classes</B>
	<%
		String netID = (String)session.getAttribute("netID");
		//System.out.println(netID);	
		
		String query="SELECT * FROM Course C, Teaches T WHERE C.CourseID = T.CourseID AND C.SectionNo = T.SectionNo AND T.netID='" + netID + "'";
		Connection conn= ConnectionManager.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);
	%>

	<FORM NAME="actionForm" action="ProfCourseUpdate" method='get'>
	<table border="2">
	<tr>
	<th>CourseID</th>
	<th>SectionNo</th>
	<th>SPN count</th>
	<th>Add Info</th>
	<th>View Requests</th>
	<th>Prerequisites</th>
	</tr>
		<% while(rs.next()){	%>	
			
			<tr>
				<td> <%=rs.getString("CourseID") %> </td>
				<td> <%=rs.getInt("SectionNo") %> </td>
				<td> <%=rs.getInt("SPtogive") %></td>
				<td> <button type="button" onclick="location.href='ProfCourseUpdate?CourseID=<%=rs.getString("CourseID")%>&SectionNo=<%=rs.getInt("SectionNo")%>'">Add Info</button></td>
				<td> <button type="button" onclick="location.href='ProfCourseView?CourseID=<%=rs.getString("CourseID")%>&SectionNo=<%=rs.getInt("SectionNo")%>'">View SPN Requests</button></td>
				<td> <button type="button" onclick="location.href='ProfPrereq?CourseID=<%=rs.getString("CourseID")%>&SectionNo=<%=rs.getInt("SectionNo")%>'">Add Prerequisites</button></td>
			</tr>
			
		<% } %>
	</table>
	</FORM>
		
	<%
		rs.close();
		stmt.close();
		conn.close();
	%>

	<br>
	Add courses
	<FORM NAME="actionForm" action="ProfAddCourse" method='get'>
		<input type="submit" name="ProfAddCourse" value="Add courses">
    </FORM>
    
    <br>
    <% if((Boolean)session.getAttribute("admin")){ %>
		Add Data
		<FORM NAME="actionForm" action="LargeData" method='get'>
			<input type="submit" name="LargeData" value="Insert Data">
   		</FORM>
    <% } %>

	<br>
	<%-- Update your info
	<FORM NAME="actionForm" action="ViewCourse" method='get'>
		<input type="submit" name="ViewCourse" value="View Your Courses">
    </FORM>
	--%>
	<br>
	<FORM NAME="actionForm" action="Logout" method='get'>
		<input type="submit" name="Logout" value="Logout">
    </FORM>
</body>
</html>