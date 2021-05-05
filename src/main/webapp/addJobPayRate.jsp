<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Job Pay Rate</title>
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
				<form action="AddJobPayRate" method="post">
					<input type="number" class="form-control" placeholder="Job Id" name="jobId" required>
					<input type="number" class="form-control" placeholder="Per Year" name="perYear" step="any" required>
					<input type="number" class="form-control" placeholder="Per Hour" name="perHour" step="any" required>
					<input class="btn btn-outline-success" type="submit" name="button" value="Add Job Pay Rate">
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