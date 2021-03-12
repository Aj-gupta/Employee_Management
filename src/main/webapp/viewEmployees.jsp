<%@page import="dao.AdminDAO" %>
<%@page import="java.util.List" %>
<%@page import="dao.DatabaseConnectionFactory" %>
<%@page import="beans.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees</title>
</head>
<body>
	<%
		List<Employee> employees = AdminDAO.getAllEmployees();
	%>
	<table rules="all" border="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Contact No</th>
			<th>DOB</th>
		</tr>
		
	<%
		for(Employee emp:employees){
	%>
		<tr>
			<td><%= emp.getId()%></td>
			<td><%= emp.getName()%></td>
			<td><%= emp.getGender()%></td>
			<td><%= emp.getAddress()%></td>
			<td><%= emp.getContactNo()%></td>
			<td><%= emp.getDob()%></td>
		</tr>
	<%
		}
	%>	
	</table>
	
</body>
</html>