<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<body>

	<form>
		Search <input type="text" name="search" value="${search }"> <input
			type="submit" value="Submit" />
	</form>
	
	<c:if test="${not empty search}">

		<c:choose>
			<c:when test="${empty recipe }">
				<h1>no results found</h1>
			</c:when>
			<c:otherwise>
				<table border="1" cellpadding="3">
					<tr>
						<td><b>Id</b></td>
						<td><b>Email</b></td>
						<td><b>Password</b></td>
						<td><b>Full Name</b></td>
						<td><b>Phone</b></td>
						<td><b>Detail</b></td>
					</tr>
	
					<c:forEach items="${recipe}" var="recipe">
						<tr>
							<td>${user.id }</td>
							<td>${user.email }</td>
							<td>${user.password }</td>
							<td>${user.fullName }</td>
							<td>${user.phone }</td>
							<td><a href="/detail?id=${user.id }">Detail</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</c:if>

</body>
