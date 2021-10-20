<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recipe Share</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
</head>
<!--  navbar   -->
<body>
	<nav class="navbar fixed-navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/home">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/createUser">Create
							User</a></li>
					<li class="nav-item"><a class="nav-link" href="/login">Login</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- navbar -->
	<br>
	<div class="container-fluid">
		<form action="search" method="POST">

			Search <input type="text" name="search"> <input type="submit"
				value="Submit" />
		</form>
	<br>

		<c:if test="${not empty search}">

			<c:choose>
				<c:when test="${empty recipe }">
					<h1>No results found.</h1>
				</c:when>
				<c:otherwise>
					<table border="1" cellpadding="3">
						<tr>

							<td><b>Recipe Name</b></td>
							<td><b>Servings</b></td>
							<td><b>Cook time</b></td>
							<td><b>Prep Time</b></td>
							<td><b>Directions</b></td>
						</tr>

						<c:forEach items="${recipe}" var="recipe">
							<tr>
								<td>${recipe.recipeDescription }</td>
								<td>${recipe.servings }</td>
								<td>${recipe.cookTime }</td>
								<td>${recipe.prepTime }</td>
								<td>${recipe.directions }</td>
								<td><img style="height: 300px" src="${recipe.image}"></td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>


</body>