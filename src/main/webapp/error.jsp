<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login-error</title>
</head>
<body>
	<%="error while logging in" %>
	<%=request.getAttribute("error").toString() %>
</body>
</html>