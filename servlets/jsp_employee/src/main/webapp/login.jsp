<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="home.css">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<% String message =(String)request.getAttribute("message");
	if(message!=null){
%>
<%=message %>
<% } %>
<form action="login" method="post">
	email:<input type="text" name="email">
	password:<input type="text" name="password">
	<button>Login</button>
</form></div>
</body>
</html>