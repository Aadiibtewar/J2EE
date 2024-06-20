<%@page import="jsp_employee.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Employee employee=(Employee)request.getAttribute("employee");
%>


<form action="update" method="post">
	
	Name:<input type="text" name="name" value=<%=employee.getName()%>><br>
	phone:<input type="tel" name="phone" value=<%=employee.getPhone()%>><br>
	Email:<input type="email" name="email" value=<%=employee.getEmail()%>><br>
	Password:<input type="text" name="password" value=<%=employee.getPassword()%>><br>
	Designation:<input type="text" name="designation" value=<%=employee.getDesignation()%>>
	salary:<input type="text" name="salary" value= <%=employee.getSalary()%>><br><br>
	<button>Update</button>


</form>

</body>
</html>