<%@page import="dao.AdminDAO" %>
<%@page import="java.util.List" %>
<%@page import="beans.Job" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jobs</title>
</head>
<body>
	<%
		List<Job> jobs = AdminDAO.getJobs();
	%>
	<table rules="all" border="2">
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Description</th>
			<th>Total Jobs</th>
			<th>Vacancies</th>
			<th>Department ID</th>
		</tr>
		
	<%
		for(Job job:jobs){
	%>
		<tr>
			<td><%= job.getId()%></td>
			<td><%= job.getTitle() %></td>
			<td><%= job.getDescription() %></td>
			<td><%= job.getTotalJobs() %></td>
			<td><%= job.getVacancies() %></td>
			<td><%= job.getDepId() %></td>
		</tr>
	<%
		}
	%>	
	</table>
</body>
</html>