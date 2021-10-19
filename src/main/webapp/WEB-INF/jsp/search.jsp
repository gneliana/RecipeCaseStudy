<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<body>

	<form action="search" method = "POST">
	
		Search <input type="text" name="search"> <input
			type="submit" value="Submit"/>
	</form>
	
	<c:if test="${not empty search}">

		<c:choose>
			<c:when test="${empty recipe }">
				<h1>no results found</h1>
			</c:when>
			<c:otherwise>
				<table border="1" cellpadding="3">
					<tr>
						
						<td><b>Recipe Name</b></td>
						<td><b>Servings</b></td>
						<td><b>Cook time</b></td>
						<td><b>Prep Time</b></td>
						<td><b>Image</b></td>
					</tr>

					<c:forEach items="${recipe}" var="recipe">
						<tr>
							<td>${recipe.recipeDescription }</td>
							<td>${recipe.servings }</td>
							<td>${recipe.cookTime }</td>
							<td>${recipe.prepTime }</td>
							<td>${recipe.directions }</td>
							<td><img style="height:300px" src="${Image}"></td>
						<%-- 	<td><a href="/detail?id=${user.id }">Detail</a></td> --%>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</c:if>

</body>
