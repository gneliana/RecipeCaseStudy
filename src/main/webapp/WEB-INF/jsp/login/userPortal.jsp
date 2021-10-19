<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<body>

	<h1>Welcome ${user.fullName }</h1>
	
	<div><a href="/createRecipe" class="btn"> Create Recipe </a></div>
	<div><a href="/logout" class="btn"> Logout </a></div>
	
				<table border="1" cellpadding="3">
						 
						<c:forEach items="${recipe}" var="recipe">
						<tr>
							<td>${recipe.recipeDescription }</td>
							<td>${recipe.servings }</td>
							<td>${recipe.cookTime }</td>
							<td>${recipe.prepTime }</td>
							<td>${recipe.directions }</td>
							<td><img style="height:300px" src="${recipe.image}"></td>
						</tr>
					</c:forEach>
				</table>
</body>

</html>