<%@ page import="beans.Payments" %>
<%@ page import="dao.AdminDAO" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payments</title>
</head>
<body>
	<%
		List<Payments> payments = AdminDAO.getPayments();
	%>
	<table rules="all" border="2">
		<tr>
			<th>Id</th>
			<th>Employee Id</th>
			<th>From</th>
			<th>To</th>
			<th>Amount</th>
			<th>Payment Date</th>
		</tr>
		
	<%
		for(Payments pays:payments){
	%>
		<tr>
			<td>pays.getId()</td>
			<td>pays.getEmpId()</td>
			<td>pays.getFrom()</td>
			<td>pays.getTo()</td>
			<td>pays.getAmount()</td>
			<td>pays.getPaymentDate()</td>
		</tr>
	<%
		}
	%>	
	</table>
</body>
</html>