<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Deduction</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS --> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <style>
    	.error{
    		color:red;
    	}
    	.success{
    		color:green;
    	}
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center"> 
        <div class="col-12 col-md-6">
			<form action="AddDeduction" method="post">
				<input type="number" class="form-control" placeholder="Id" name="id" required>
				<input type="number" class="form-control" placeholder="Employee Id" name="empId" required>
				<input type="date" class="form-control" placeholder="Start Date" name="startDate" required>
				<input type="date" class="form-control" placeholder="End Date" name="endDate" required>
				<input type="text" class="form-control" placeholder="Type" name="type" required>
				<input type="number" class="form-control" placeholder="Amount" name="amount" step="any">
				<input class="btn btn-outline-success" type="submit" name="button" value="Add Deduction">
			</form>
				<%
        			if(request.getAttribute("error") != null){
        		%>
        			<h4 class="error"><%=request.getAttribute("error").toString() %></h4>
        		<%	
        			}        		
        		%>
        		<%
        			if(request.getAttribute("success") != null){
        		%>
        			<h4 class="success"><%=request.getAttribute("success").toString() %></h4>
        		<%	
        			}        		
        		%>
		</div>
	</div>
</div>
</body>
</html>