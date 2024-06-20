<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jsp_employee.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body >
<%String value=(String)request.getAttribute("cookie");
if(value!=null){
%><h2>changed by <%=value %></h2>
<%} %>

<div align="center">
<%List<Employee>list = (List)request.getAttribute("list");%>
	
	<table border="1px" solid bordercolor="geen">
	<tr>
		<th>Id</th>
		<th>name</th>
		<th>phone</th>
		<th>Email</th>
		<th>password</th>
		<th>designation</th>
		<th>salary</th>
		<th>Action</th>
		
	</tr>
	<%for(Employee employee :list )
	{
		%>
	<tr>
	<td><%=employee.getId()%></td>
	<td><%=employee.getName()%></td>
	<td><%=employee.getPhone()%></td>
	<td><%=employee.getEmail()%></td>
	<td><%=employee.getPassword()%></td>
	<td><%=employee.getDesignation()%></td>
	<td><%=employee.getSalary()%></td>
	<td><a href="delete?id=<%=employee.getId()%>"><button>DELETE</button></a></td>
	<td><a href="edit.jsp"<%=employee.getId()%>><button>Edit</button></a></td>
	
	</tr>
	
	
	<%} %>
	</table>
	
</div>
	
	
</body>
</html>