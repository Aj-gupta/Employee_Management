<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS --> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<title>Login</title>
	<style>
		.error{
			color:red;
		}
	</style>
</head>
<body>
	<div class="container">
    <div class="row justify-content-center"> 
        <div class="col-12 col-md-6">
                <form action="Login" method="post">
                
                    	<h2 class="form-signin-heading ">Please sign in</h2>
                    
						<input type="email" class="form-control" placeholder="Email address" name="email" required autofocus>
					
	                    <input type="password" class="form-control" placeholder="Password" name="password" required>
	                    
	                    <select class="form-control" name="type" required>
	                    	<option selected>Choose...</option>
	                    	<option value="admin">Admin</option>
	                    	<option value="employee">Employee</option>
	                    </select>
	                    
                    	<button class="btn btn-outline-success" type="submit" name="button" value="Login">Login </button>
                    	
                </form>
                <%
        			if(request.getAttribute("error") != null){
        		%>
        			<h4 class="error"><%=request.getAttribute("error").toString() %></h4>
        		<%	
        			}        		
        		%>
        </div>
    </div>
</div>
</body>
</html>