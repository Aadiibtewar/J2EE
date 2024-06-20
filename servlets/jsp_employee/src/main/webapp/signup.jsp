<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body align="center">
<% String message =(String) request.getAttribute("message");
	if(message!=null){
%>
<%=message %>
<% } %>

<form action="signUp" method="post">
	Id:<input type="text" name="id"><br>
	Name:<input type="text" name="name"><br>
	phone:<input type="tel" name="phone"><br>
	Email:<input type="email" name="email"><br>
	Password:<input type="text" name="password"><br>
	Designation:<input type="text" name="designation"><br>
	salary:<input type="text" name="salary"><br><br>
	<button>Submit</button>


</form>

</body>
</html>