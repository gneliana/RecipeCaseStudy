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
					<li class="nav-item"><a class="nav-link" href="/search">Search</a>
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
	<form method="post" action="/createRecipe"
		enctype="multipart/form-data">
		<!-- Create Recipe Form -->
		<h1>Create Recipe</h1>
		<c:forEach var="error" items="${errors}">
			<span style='color: red'>${error}</span>
			<br>
		</c:forEach>

		<div class="container">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Recipe
					Name</label> <input type="text" class="form-control"
					id="exampleFormControlInput1" name="recipeDescription"
					value="${form.recipeDescription }" />
				<c:forEach items="${errorFields}" var="errorField">
					<c:if test='${errorField.getField().equals("recipeDescription") }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>

					</c:if>
				</c:forEach>
			</div>

			<div class="mb-3">
				<label for="formGroupExampleInput1" class="form-label">
					Choose Difficulty </label> <select class="form-select"
					aria-label="Default select example" name="difficulty"
					id="difficulty">
					<c:forEach items="${difficulty}" var="value">
						<option>${value}</option>
					</c:forEach>
				</select>
			</div>


			<div class="mb-3">
				<label for="formGroupExampleInput1" class="form-label">
					Preparation Time </label> <input type="text" class="form-control"
					id="fexampleFormControlInput1" name="prepTime"
					value="${form.prepTime }" />
				<c:forEach items="${errorFields}" var="errorField">
					<c:if test='${errorField.getField().equals("prepTime") }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>

					</c:if>
				</c:forEach>
			</div>

			<div class="mb-3">
				<label for="formGroupExampleInput1" class="form-label">
					Cooking Time </label> <input type="text" class="form-control"
					id="fexampleFormControlInput1" name="cookTime"
					value="${form.cookTime }" />
				<c:forEach items="${errorFields}" var="errorField">
					<c:if test='${errorField.getField().equals("cookTime") }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>

					</c:if>
				</c:forEach>
			</div>

			<div class="mb-3">
				<label for="formGroupExampleInput1" class="form-label">
					Servings </label> <input type="text" class="form-control"
					id="fexampleFormControlInput1" name="servings"
					value="${form.servings }" />
				<c:forEach items="${errorFields}" var="errorField">
					<c:if test='${errorField.getField().equals("servings") }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>

					</c:if>
				</c:forEach>
			</div>

			<div class="mb-3">
				<label for="formGroupExampleInput1" class="form-label">
					Category </label> <input type="text" class="form-control"
					id="fexampleFormControlInput1" name="description"
					value="${form.description }" />
				<c:forEach items="${errorFields}" var="errorField">
					<c:if test='${errorField.getField().equals("description") }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>

					</c:if>
				</c:forEach>
			</div>

			<div class="mb-3">
				<label for="formGroupExampleInput1" class="form-label">
					Ingredients </label> <input type="text" class="form-control"
					id="fexampleFormControlInput1" name="ingredientDescription"
					value="${form.ingredientDescription }" />
				<c:forEach items="${errorFields}" var="errorField">
					<c:if
						test='${errorField.getField().equals("ingredientDescription") }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>

					</c:if>
				</c:forEach>
			</div>

			<div class="mb-3">
				<label for="formGroupExampleInput1" class="form-label">
					Ingredient Amount </label> <input type="text" class="form-control"
					id="fexampleFormControlInput1" name="amount"
					value="${form.amount }" />
				<c:forEach items="${errorFields}" var="errorField">
					<c:if test='${errorField.getField().equals("amount") }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>

					</c:if>
				</c:forEach>
			</div>

			<div class="mb-3">
				<label for="formGroupExampleInput1" class="form-label">
					Ingredient unit of Measurement </label> <input type="text"
					class="form-control" id="fexampleFormControlInput1"
					name="measureDescription" value="${form.measureDescription }" />
				<c:forEach items="${errorFields}" var="errorField">
					<c:if test='${errorField.getField().equals("measureDescription") }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>

					</c:if>
				</c:forEach>
			</div>

			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">Cooking
					Directions</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="3" name="directions"><c:out
						value="${form.directions }"></c:out> </textarea>
				<c:forEach items="${errorFields}" var="errorField">
					<c:if test='${errorField.getField().equals("directions") }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>

					</c:if>
				</c:forEach>
			</div>

			<div class="mb-3">
				<label for="formFile" class="form-label">Upload Recipe Image</label>
				<input class="form-control" type="file" id="file" name="file">
			</div>

			<div>
				<button type="submit" value="submit" class="btn btn-primary">Submit</button>
			</div>

		</div>

		<br> <br>
	</form>
	<!-- Recipe form end -->


</body>
</html>