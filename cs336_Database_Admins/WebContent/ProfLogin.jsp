<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Login Page</title> </head>
<body>
<form name="actionForm" action="ProfLoginServlet" method ="GET">
<table>
<tr><td>Enter your NetID: </td><td><input type="text" name="netID"/></td></tr>
<tr><td>Enter your Password: </td><td><input type="password" name="password"/></td></tr>

<tr><td colspan="2" align="center"><input type="submit" value="submit"> </td></tr>
</table>
</form>
</body>
</html>