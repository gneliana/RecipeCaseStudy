<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%-- <jsp:include page="include/header.jsp" />
 --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form method="post" action="/createRecipe" enctype="multipart/form-data">

    <h1>Create Recipe Page</h1>

    <c:forEach var="error" items="${errors}">
        <span style='color: red'>${error}</span>
        <br>
    </c:forEach>
    
    <br>
    
    
    
    <br>
     Recipe Title <input type="text"
        name="recipeDescription" value="${form.recipeDescription }" />
    <c:forEach items="${errorFields}" var="errorField">
        <c:if test='${errorField.getField().equals("recipeDescription") }'>
            <br>
            <span style='color: red'>${errorField.defaultMessage}</span>

        </c:if> 
    </c:forEach>
    <br />
    
        <br>
    Choose Difficulty 
            <select name="difficulty" id="difficulty">
             
                <c:forEach items="${difficulty}" var="value">
                   <option>${value}</option>
                </c:forEach>
            </select>

    <br />
    
    <br>
    Preparation Time <input type="text" name="prepTime"
        value="${form.prepTime }" />
    <c:forEach items="${errorFields}" var="errorField">
        <c:if test='${errorField.getField().equals("prepTime") }'>
            <br>
            <span style='color: red'>${errorField.defaultMessage}</span>

        </c:if>
    </c:forEach>
    <br />
    
    <br>
    Cooking Time <input type="text" name="cookTime"
        value="${form.cookTime }" />
    <c:forEach items="${errorFields}" var="errorField">
        <c:if test='${errorField.getField().equals("cookTime") }'>
            <br>
            <span style='color: red'>${errorField.defaultMessage}</span>

        </c:if>
    </c:forEach>
    <br />
    
    <br>
    Servings <input type="text" name="servings"
        value="${form.servings }" />
    <c:forEach items="${errorFields}" var="errorField">
        <c:if test='${errorField.getField().equals("servings") }'>
            <br>
            <span style='color: red'>${errorField.defaultMessage}</span>

        </c:if>
    </c:forEach>
    <br />
    
    
        <br>
    Category  <input type="text"  name="description"
        value="${form.description }" />
    <c:forEach items="${errorFields}" var="errorField">
        <c:if test='${errorField.getField().equals("description") }'>
            <br>
            <span style='color: red'>${errorField.defaultMessage}</span>

        </c:if>
    </c:forEach>
    <br />
    
        <br>
        Ingredients  <input type="text"  name="ingredientDescription"
        value="${form.ingredientDescription }" />
    <c:forEach items="${errorFields}" var="errorField">
        <c:if test='${errorField.getField().equals("ingredientDescription") }'>
            <br>
            <span style='color: red'>${errorField.defaultMessage}</span>

        </c:if>
    </c:forEach>
    <br />
    
    <br>
            amount  <input type="text"  name="amount"
        value="${form.amount }" />
    <c:forEach items="${errorFields}" var="errorField">
        <c:if test='${errorField.getField().equals("amount") }'>
            <br>
            <span style='color: red'>${errorField.defaultMessage}</span>

        </c:if>
    </c:forEach>
    <br />
    
        <br>
            Measurement of amount  <input type="text"  name="measureDescription"
        value="${form.measureDescription }" />
    <c:forEach items="${errorFields}" var="errorField">
        <c:if test='${errorField.getField().equals("measureDescription") }'>
            <br>
            <span style='color: red'>${errorField.defaultMessage}</span>

        </c:if>
    </c:forEach>
    <br />
    
        <br>
        Cooking    Directions  <input type="text"  name="directions"
        value="${form.directions }" />
    <c:forEach items="${errorFields}" var="errorField">
        <c:if test='${errorField.getField().equals("directions") }'>
            <br>
            <span style='color: red'>${errorField.defaultMessage}</span>

        </c:if>
    </c:forEach>
    <br /> 
    

<br>
Select file to upload <input type="file" name="file" />
        
<br>
    
    <br> <input type="submit" name="Submit" value="Submit" />


</form>
</body>
</html>