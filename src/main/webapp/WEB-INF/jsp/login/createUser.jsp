<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recipe Share	</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
    integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
    crossorigin="anonymous"></script>
 </head>
<!--  navbar   -->
<body>
<nav class="navbar fixed-navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Recipe Share</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="/home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/search">Search</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/createUser">Create User</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="/login">Login</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<!-- navbar -->


<form method="post" action="/createUser">

<h1>Create User</h1>

<c:forEach var="error" items="${errors}" >
   <span style='color:red'>${error}</span>
   <br>
</c:forEach>


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