<%@ page import="beans.Deductions" %>
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
		List<Deductions> deductions = AdminDAO.getDeductions();
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
		for(Deductions ded:deductions){
	%>
		<tr>
			<td>ded.getId()</td>
			<td>ded.getType()</td>
			<td>ded.getFrom()</td>
			<td>ded.getTo()</td>
			<td>ded.getAmount()</td>
			<td>ded.getEmpId()</td>
		</tr>
	<%
		}
	%>	
	</table>
</body>
</html>