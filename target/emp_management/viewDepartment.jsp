<%@ page import="beans.Department" %>
<%@ page import="dao.AdminDAO" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departments</title>
</head>
<body>
	<%
		List<Department> departments = AdminDAO.getDepartments();
	%>
	<table rules="all" border="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Full Name</th>
		</tr>
		
	<%
		for(Department dep:departments){
	%>
		<tr>
			<td><%= dep.getId()%></td>
			<td><%= dep.getName()%></td>
			<td><%= dep.getFullName()%></td>
		</tr>
	<%
		}
	%>	
	</table>
</body>
</html>