<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="loginpac.ConnectionManager, java.sql.Connection, java.sql.ResultSet, java.sql.Statement, loginpac.*, helper.Rating" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Professor View</title>
</head>
<body>

	<B>Courses</B>
	<%
		String netID = (String)session.getAttribute("netID");
		String course = "'" + (String)session.getAttribute("courseID") + "'";
		String section = "'" + (String)session.getAttribute("sectionNo") + "'";
		//System.out.println(netID);
		//System.out.println(course);
		//System.out.println(section);
		
		String query="SELECT R.SPID, R.netID, C.CourseID, C.SectionNo, R.Date, R.Rating, R.Status FROM Course C, Teaches T, SPRequest R WHERE C.CourseID = T.CourseID AND C.SectionNo = T.SectionNo AND T.CourseID = R.CourseID AND T.SectionNo = R.SectionNo AND T.netID='" + netID + "' AND R.CourseID = " + course + " AND R.SectionNo = " + section + " ORDER BY RATING DESC";
		Connection conn= ConnectionManager.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		
		while(rs.next()){
			Rating.insert(rs.getString("netID"));
		}
		
		rs=stmt.executeQuery(query);
		
		
	%>
	<B>Waiting List</B>
	<FORM NAME="actionForm" action="ProfCourseUpdate" method='get'>
	<table border="2">
	<tr>
	<th>Student</th>
	<th>CourseID</th>
	<th>Section</th>
	<th>Date</th>
	<th>Rating</th>
	<th>Status</th>
	<th>SPID</th>
	<th>Approve</th>
	<th>Deny</th>
	<th>Comment</th>
	<th>Eligibilty</th>
	</tr>
		<% while(rs.next()){
				
				if(rs.getString("Status").equals("Pending")){
		%>	
			
				<tr>
					<td> <%=rs.getString("netID") %> </td>
					<td> <%=rs.getString("CourseID") %> </td>
					<td> <%=rs.getInt("SectionNo") %> </td>
					<td> <%=rs.getString("Date") %> </td>
					<td> <%=rs.getString("Rating") %> </td>
					<td> <%=rs.getString("Status") %> </td>
					<td> <%=rs.getString("SPID") %></td>
					<td> <button type="button" onclick="location.href='ProfApprove?netID=<%=rs.getString("netID") %>&CourseID=<%=rs.getString("CourseID")%>&SectionNo=<%=rs.getInt("SectionNo")%>'">Approve</button></td>
					<td> <button type="button" onclick="location.href='ProfDeny?netID=<%=rs.getString("netID") %>&CourseID=<%=rs.getString("CourseID")%>&SectionNo=<%=rs.getInt("SectionNo")%>'">Deny</button></td>
					<td> <button type="button" onclick="location.href='ProfComment?netID=<%=rs.getString("netID") %>&CourseID=<%=rs.getString("CourseID")%>&SectionNo=<%=rs.getInt("SectionNo")%>'">Leave a comment</button></td>
					<td> <button type="button" onclick="location.href='ProfViewEligibility?netID=<%=rs.getString("netID") %>&CourseID=<%=rs.getString("CourseID")%>&SectionNo=<%=rs.getInt("SectionNo")%>'">See Eligibility</button></td>
				</tr>
				
		<%
				}
			}rs.beforeFirst();
		%>
	</table>
	
	
	<br>
	<br>
	<B>Finished</B>
	
	<table border="2">
	<tr>
	<th>Student</th>
	<th>CourseID</th>
	<th>Section</th>
	<th>Date</th>
	<th>Rating</th>
	<th>Status</th>
	<th>SPID</th>
	<th>Approve</th>
	<th>Deny</th>
	<th>Comment</th>
	</tr>
		<% while(rs.next()){	
				if(rs.getString("Status").equals("Approved") || rs.getString("Status").equals("Denied")){
		%>	
			
				<tr>
					<td> <%=rs.getString("netID") %> </td>
					<td> <%=rs.getString("CourseID") %> </td>
					<td> <%=rs.getInt("SectionNo") %> </td>
					<td> <%=rs.getString("Date") %> </td>
					<td> <%=rs.getString("Rating") %> </td>
					<td> <%=rs.getString("Status") %> </td>
					<td> <%=rs.getString("SPID") %></td>
					<td> <button type="button" onclick="location.href='ProfApprove?netID=<%=rs.getString("netID") %>&CourseID=<%=rs.getString("CourseID")%>&SectionNo=<%=rs.getInt("SectionNo")%>'">Approve</button></td>
					<td> <button type="button" onclick="location.href='ProfDeny?netID=<%=rs.getString("netID") %>&CourseID=<%=rs.getString("CourseID")%>&SectionNo=<%=rs.getInt("SectionNo")%>'">Deny</button></td>
					<td> <button type="button" onclick="location.href='ProfComment?netID=<%=rs.getString("netID") %>&CourseID=<%=rs.getString("CourseID")%>&SectionNo=<%=rs.getInt("SectionNo")%>'">Leave a comment</button></td>
				</tr>
		<%		}
			}	
		%>
		
	</table>
	</FORM>

		
	<%
		rs.close();
		stmt.close();
		conn.close();
	%>
	
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