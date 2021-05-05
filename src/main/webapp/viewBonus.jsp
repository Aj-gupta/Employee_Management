<%@ page import="beans.Bonus" %>
<%@ page import="dao.AdminDAO" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deductions</title>
</head>
<body>
	<%
		List<Bonus> bonus = AdminDAO.getBonus();
	%>
	<table rules="all" border="2">
		<tr>
			<th>Id</th>
			<th>Type</th>
			<th>From</th>
			<th>To</th>
			<th>Amount</th>
			<th>Employee ID</th>
		</tr>
		
	<%
		for(Bonus bon:bonus){
	%>
		<tr>
			<td>bon.getId()</td>
			<td>bon.getType()</td>
			<td>bon.getFrom()</td>
			<td>bon.getTo()</td>
			<td>bon.getAmount()</td>
			<td>bon.getEmpId()</td>
		</tr>
	<%
		}
	%>	
	</table>
</body>
</html>