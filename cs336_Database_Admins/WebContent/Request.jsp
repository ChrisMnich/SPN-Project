<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="loginpac.ConnectionManager, java.sql.Connection, java.sql.ResultSet, java.sql.Statement, loginpac.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SPN Requests</title>
</head>
<body>

	<%
		String netID = (String)session.getAttribute("netID");			//grabs the netID from the session
		//System.out.println(netID);
		String query="SELECT R.CourseID, R.SectionNo, R.Status, R.SPID, R.Comment FROM SPRequest R, Student S WHERE S.netID = R.netID AND S.netID='"+ netID + "'";
		Connection conn= ConnectionManager.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);

		
		if (rs.next()){ 												//Check if there is something, and if there is then move it back up once
			rs.previous();															
	%>
			<B>SPN Requests</B>											<%-- table of SPN requests starts here --%>
			
			<table border="2">
			<tr>
			<th>CourseID</th>
			<th>Section</th>
			<th>Status</th>
			<th>SPID</th>
			<th>Comment</th>
			<th>Eligibility</th>
			</tr>
				<% while(rs.next()){	%>	
					<tr>
						<td> <%=rs.getString("CourseID") %> </td>
						<td> <%=rs.getString("SectionNo") %></td>
						<td> <%=rs.getString("Status") %></td>
						<% if(rs.getString("SPID")== null || rs.getString("SPID").length() == 0){ %>			<%-- if it's null, show N/A--%>
							<td> N/A </td>
						<%	}else{ %>
							<td> <%=rs.getString("SPID") %> </td>		<%-- if it's not null, show the value --%>
						<%  } %>
						<% if(rs.getString("Comment")== null){ %>			<%-- if it's null, show N/A--%>
							<td> N/A </td>
						<%	}else{ %>
							<td> <%=rs.getString("Comment") %> </td>		<%-- if it's not null, show the value --%>
						<%  } %>
						<td> <button type="button" onclick="location.href='StudentViewEligibility?netID=<%=netID %>&CourseID=<%=rs.getString("CourseID")%>&SectionNo=<%=rs.getInt("SectionNo")%>'">See Eligibility</button></td>
					</tr>
				<% } %>
			</table>		
	<%	}else{ %>														<%-- if there are no results, then show this statement --%>
		You don't have any requests at the moment.
	<%	}
		rs.close();
		stmt.close();
		conn.close();
	%>
		<br>
		<B>Make a Request</B>
		<form name="actionForm" action="makeRequest" method ="GET">
		<table>
		<tr><td>CourseID: </td><td><input type="text" name="Course"/></td></tr>
		<tr><td>Section: </td><td><input type="text" name="Section"/></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="submit"> </td></tr>
		</table>
		</form>
		
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