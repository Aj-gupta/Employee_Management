<%@page import="dao.AdminDAO" %>
<%@page import="java.util.List" %>
<%@page import="beans.Employee_Leave" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Leave</title>
</head>
<body>
	<%
		List<Employee_Leave> leaves = AdminDAO.getEmployeeLeaves();
	%>
	<table rules="all" border="2">
		<tr>
			<th>Token</th>
			<th>Employee Id</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Total Days</th>
			<th>Reason</th>
			<th>Status</th>
			<th>Options</th>
		</tr>
		
	<%
		for(Employee_Leave leave:leaves){
	%>
		<tr>
			<td><%= leave.getToken() %></td>
			<td><%= leave.getEmpId() %></td>
			<td><%= leave.getStartDate() %></td>
			<td><%= leave.getEndDate() %></td>
			<td><%= leave.getTotalDays()%></td>
			<td><%= leave.getReason() %></td>
			<td><%= leave.getStatus() %></td>
			<td><a href="#">Approve</a> | <a href="#">Cancel</a><td>
		</tr>
	<%
		}
	%>	
	</table>
</body>
</html>