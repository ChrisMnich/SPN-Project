<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Info</title>
</head>
<body>

	<br>
	<B>Add info</B>
	<form name="actionForm" action="addInfo" method ="GET">
	<table>
	<tr><td>Credits: </td><td><input type="text" name="Credits"/></td></tr>
	<tr><td>GPA: </td><td><input type="text" name="GPA"/></td></tr>
	<tr><td>Major: </td><td><input type="text" name="Major"/></td></tr>
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