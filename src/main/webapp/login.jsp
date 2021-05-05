<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS --> 
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<title>Login</title>
	<style>
		.error{
			color:red;
		}
	</style>
</head>
<body>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		  <a class="navbar-brand" href="#">Company</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav ml-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">About Us</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">Contact</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="login.jsp">Login</a>
		      </li>
		    </ul>
		  </div>
		</nav>
		 
  
  <div class="container">
            <div class="row">
                <div class="col-md-6 login-form-1">
                    <h3>Login</h3>
                    <form action="Login" method="POST">
                        <div class="form-group">
                            <input type="email" class="form-control" placeholder="Your Email *" name="email" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Your Password *" name="password" />
                        </div>
                        <div class="form-group">
				          <select class="form-control" name="type" required>
					             <option selected value="">Choose...</option>
					             <option value="admin">Admin</option>
					             <option value="employee">Employee</option>
					      </select>
		  				</div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-outline-success" value="Login" />
                        </div>                      
                    </form>
                </div>
          </div>
          
          		<%
        			if(request.getAttribute("error") != null){
        		%>
        			<h4 class="error"><%=request.getAttribute("error").toString() %></h4>
        		<%	
        			}        		
        		%>
</body>
</html>