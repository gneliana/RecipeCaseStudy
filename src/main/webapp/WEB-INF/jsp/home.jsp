<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Recipe Share</title>
        <!-- favicon -->
    <link rel="shortcut icon" href="./assets/favicon.ico" type="image/x-icon" />

    
      <!-- font-awesome -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"
    />
   <!--  Style css -->
        <style type="text/css">
    <%@include file="/pub/css/style.css" %>
    </style>
        
</head>

<body>
	<!-- navigation   -->
    <nav class="navbar">
      <div class="nav-center">
        <div class="nav-header">
          <a href="/home" class="nav-logo">
            <img src="https://case-study-recipe.s3.us-east-2.amazonaws.com/images/Screen+Shot+2021-10-18+at+1.43.45+PM.png" alt="Recipe Share" />
          </a>
        </div>
        <div class="nav-links">
          <a href="/home" class="nav-link"> home </a>
          <a href="/search" class="nav-link"> search </a>
          <a href="/home" class="nav-link"> about </a>

          <div class="nav-link">
            <a href="/login" class="btn"> Login </a>
          </div>
        </div>
      </div>
    </nav>
    <!-- end of nav -->

</body>
</html>