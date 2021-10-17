<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<!--  	<form method="post" action="/login/j_security_check"> -->
	<form method="post" action="/login/login">
		<c:if test="${error}">
			<div style="color:red">Invalid email or password.</div>
		</c:if> 


		Username : <input type="text" name="username" value=""> <br>
		Password : <input type="password" name="password"> <br> <input
			type="submit" name="submit" value="Submit" />
		<c:if test="${(not empty param.error) && (not empty SPRING_SECURITY_LAST_EXCEPTION)}"> </c:if> 
	</form>


</body>
</html>