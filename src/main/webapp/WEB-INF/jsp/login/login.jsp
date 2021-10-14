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

<%-- 	<form method="post" action="/login/j_security_check">
		<c:if test="${error}">
			<div style="color:red">Invalid email or password.</div>
		</c:if> --%>


		Username : <input type="text" name="username" value=""> <br>
		Password : <input type="text" name="password"> <br> <input
			type="submit" name="submit" value="Submit" />
	</form>


</body>
</html>