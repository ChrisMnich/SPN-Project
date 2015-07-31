<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Courses Taught</title>
</head>
<body>
	<br>
	<br>
	<B>Add info</B>
	<form name="actionForm" action="InsertProfCourse" method ="GET">
	<table>
	<tr><td>CourseID:</td><td><input type="text" name="Course"/></td></tr>
	<tr><td>Section Number:</td><td><input type="text" name="SectionNo"/></td></tr>
	<%-- <tr><td>Credits:</td><td><input type="text" name="Credits"/></td></tr>--%>
	<tr><td colspan="2" align="center"><input type="submit" value="submit"> </td></tr>
	</table>
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