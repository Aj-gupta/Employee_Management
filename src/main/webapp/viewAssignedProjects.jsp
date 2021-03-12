<%@page import="dao.AdminDAO" %>
<%@page import="java.util.List" %>
<%@page import="beans.Works_On" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assigned Projects</title>
</head>
<body>
	<%
		List<Works_On> works = AdminDAO.getWorkingProjects();
	%>
	<table rules="all" border="2">
		<tr>
			<th>Employee Id</th>
			<th>Project Id</th>
			<th>Role</th>
		</tr>
		
	<%
		for(Works_On work:works){
	%>
		<tr>
			<td><%= work.getEmpId()	%></td>
			<td><%= work.getPrId() %></td>
			<td><%= work.getRole() %></td>
		</tr>
	<%
		}
	%>	
	</table>
</body>
</html>