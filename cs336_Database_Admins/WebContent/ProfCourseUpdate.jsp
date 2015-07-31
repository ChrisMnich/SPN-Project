<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Update</title>
</head>
<body>
	<br>
	<br>
	<B>Add Meeting</B>
	<form name="actionForm" action="ProfCourseInfo" method ="GET">
	<table>
	<tr><td>CourseID:</td><td><%= (String)session.getAttribute("courseID") %></td></tr>
	<tr><td>Section Number:</td><td><%= (String)session.getAttribute("sectionNo") %></td></tr>
	<tr><td>Room:</td><td><input type="text" name="RoomID"/></td></tr>
	<tr><td><input type="radio" name="Meeting Type" value="Lecture">Lecture</td></tr>
	<tr><td><input type="radio" name="Meeting Type" value="Recitation">Recitation</td></tr>
	<tr><td><input type="radio" name="Meeting Type" value="Online">Online*</td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="submit"> </td></tr>
	</table>
	</form>
	
	<% if((String)session.getAttribute("error") != null){ %>
	<%= (String)session.getAttribute("error") %>
	<% } %>
	<br>
	*Online Courses please enter "N/A" for Room.
	<br>
	<br>
	<FORM NAME="actionForm" action="ProfReturn" method='get'>
		<input type="submit" name="ProfReturn" value="Return to Professor Hub">
    </FORM>
    
	<br>
	<br>
	<FORM NAME="actionForm" action="Logout" method='get'>
		<input type="submit" name="Logout" value="Logout">
    </FORM>
</body>
</html>