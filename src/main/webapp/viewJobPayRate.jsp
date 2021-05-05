<%@ page import="beans.Pay_Rate" %>
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
		List<Pay_Rate> rates = AdminDAO.getPayRate();
	%>
	<table rules="all" border="2">
		<tr>
			<th>Job Id</th>
			<th>Per Year</th>
			<th>Per Hour</th>
		</tr>
		
	<%
		for(Pay_Rate rate:rates){
	%>
		<tr>
			<td><%= rate.getJobId() %></td>
			<td><%= rate.getPerYear() %></td>
			<td><%= rate.getPerHour() %></td>
		</tr>
	<%
		}
	%>	
	</table>
</body>
</html>