<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Login Page</title> </head>
<body>
<form name="actionForm" action="LoginServlet" method ="GET">
<table>
<tr><td>Enter your NetID: </td><td><input type="text" name="netID"/></td></tr>
<tr><td>Enter your Password: </td><td><input type="password" name="password"/></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="submit"> </td></tr>
</table>
</form>
<a href="ProfLogin.jsp">Professors</a>
<a href="CreateAccount.jsp">Create account</a>
</body>
</html>