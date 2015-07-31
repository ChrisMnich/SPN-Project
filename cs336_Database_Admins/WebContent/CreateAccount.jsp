<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Creation</title>
</head>
<body>
<form name="actionForm" action="CreateAccount" method ="GET">
<table>
<tr><td>Enter your NetID: </td><td><input type="text" name="netID"/></td></tr>
<tr><td>Enter your Password: </td><td><input type="text" name="password"/></td></tr>
<tr><td>Enter your First Name: </td><td><input type="text" name="FirstName"/></td></tr>
<tr><td>Enter your Last Name: </td><td><input type="text" name="LastName"/></td></tr>
<tr><td>Enter your RUID: </td><td><input type="text" name="RUID"/></td></tr>
<tr><td>Enter your E-mail: </td><td><input type="text" name="Email"/></td></tr>
<tr><td><input type="radio" name="Status" value="Student" checked = "checked">Student</td></tr>
<tr><td><input type="radio" name="Status" value="Professor">Professor</td></tr>
<tr><td colspan="2" align="left"><input type="submit" value="submit"> </td></tr>
</table>
</form>


</body>
</html>