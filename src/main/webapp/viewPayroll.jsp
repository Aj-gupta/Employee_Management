<%@ page import="beans.Payroll" %>
<%@ page import="dao.AdminDAO" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payroll</title>
</head>
<body>
	<%
		List<Payroll> payroll = AdminDAO.getPayroll();
	%>
	<table rules="all" border="2">
		<tr>
			<th>Id</th>
			<th>Employee Id</th>
			<th>From</th>
			<th>To</th>
			<th>Gross Pay</th>
			<th>Net Pay</th>
			<th>Deductions</th>
			<th>Bonus</th>
			<th>Hours Worked</th>
		</tr>
		
	<%
		for(Payroll pays:payroll){
	%>
		<tr>
			<td>pays.getId()</td>
			<td>pays.getEmpId()</td>
			<td>pays.getFrom()</td>
			<td>pays.getTo()</td>
			<td>pays.getGrossPay()</td>
			<td>pays.getNetPay()</td>
			<td>pays.getDeductions()</td>
			<td>pays.getBonus()</td>
			<td>pays.getHoursWorked()</td>
		</tr>
	<%
		}
	%>	
	</table>
</body>
</html>