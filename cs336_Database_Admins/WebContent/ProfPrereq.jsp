<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Professor: Prerequisites</title>
</head>
<body>
	<br>
	<br>
	<B>Add Prerequisite</B>
	<form name="actionForm" action="ProfPrereqInsert" method ="GET">
	<table>
	<tr><td>CourseID:</td><td><%= (String)session.getAttribute("courseID") %></td></tr>
	<tr><td>Prerequisite:</td><td><input type="text" name="prereq"/></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="submit"> </td></tr>
	</table>
	</form>
	
	<%  if((String)session.getAttribute("error") != null){%>
	<%= (String)session.getAttribute("badinput") %>
	<%  } %>
	<br>
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