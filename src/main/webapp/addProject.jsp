<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Project</title>
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
				<form action="AddProject" method="post">
					<input type="number" class="form-control" placeholder="Project Id" name="prId" required>
					<input type="text" class="form-control" placeholder="Name" name="name" required>
					<input type="text" class="form-control" placeholder="Description" name="description">
					<input type="number" class="form-control" placeholder="Department Id" name="depId" required>
					<input type="date" class="form-control" placeholder="Due Date" name="dueDate" required>
					<input type="date" class="form-control" placeholder="Submission Date" name="subDate" >
					<input type="date" class="form-control" placeholder="Assign Date" name="assignDate" required>
					<input type="text" class="form-control" placeholder="status" name="status" required>
					<input class="btn btn-outline-success" type="submit" name="button" value="AddProject">
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