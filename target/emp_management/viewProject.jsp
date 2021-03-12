<%@page import="dao.AdminDAO" %>
<%@page import="java.util.List" %>
<%@page import="beans.Project" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projects</title>
</head>
<body>
	<%
		List<Project> projects = AdminDAO.getProjects();
	%>
	<table rules="all" border="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Status</th>
			<th>Assign Date</th>
			<th>Due Date</th>
			<th>Department ID</th>
			<th>Submission Date</th>
		</tr>
		
	<%
		for(Project project:projects){
	%>
		<tr>
			<td><%= project.getId() %></td>
			<td><%= project.getName() %></td>
			<td><%= project.getDescription() %></td>
			<td><%= project.getStatus() %></td>
			<td><%= project.getAssignDate()%></td>
			<td><%= project.getDueDate() %></td>
			<td><%= project.getDepId() %></td>
			<td><%= project.getSubmissionDate() %></td>
		</tr>
	<%
		}
	%>	
	</table>
</body>
</html>