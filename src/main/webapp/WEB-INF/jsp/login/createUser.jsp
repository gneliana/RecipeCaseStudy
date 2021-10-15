<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User Page</title>
    
    

</head>

<form method="post" action="/createUser">

<h1>Create User</h1>

<c:forEach var="error" items="${errors}" >
   <span style='color:red'>${error}</span>
   <br>
</c:forEach>

<br>
<hr>
<br>

	Email <input type="text" name="email" value="${form.email }"/>
	<c:forEach items="${errorFields}" var="errorField">
		<c:if test='${errorField.getField().equals("email") }'> 
 		 	<br>
	   		<span style='color:red'>${errorField.defaultMessage}</span>
	  		
 	  	</c:if> 
	</c:forEach>
	
    <br />
    Password <input type="text" name="password" value="${form.password }" />
    <c:forEach items="${errorFields}" var="errorField">
 		<c:if test='${errorField.field == "password" }'>
 			<br> 
	   		<span style='color:red'>${errorField.defaultMessage}</span>
 	  	</c:if> 
	</c:forEach>
    
    <br>
    Confirm Password <input type="text" name="confirmPassword"value="${form.confirmPassword }" />
    <c:forEach items="${errorFields}" var="errorField">
 		<c:if test='${errorField.field == "confirmPassword" }'>
 			<br> 
	   		<span style='color:red'>${errorField.defaultMessage}</span>
 	  	</c:if> 
	</c:forEach>
    
    
    <br>
    Full Name <input type="text" name="fullName" value="${form.fullName }"/>
    <br>

    <input type="submit" name="submit" value="Submit" />
    
     
</form>

</body>
</html>