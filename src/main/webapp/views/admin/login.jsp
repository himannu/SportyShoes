<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<!-- 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 -->
 	
 	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 
 
 
 
<title>Admin Login Form</title>
</head>
<body class="container-fluid">
	<nav class="navbar navbar-default navbar-light navbar-expand-sm text-center" style="background-color: #e3f2fd;">
		<ul class="nav navbar-nav navbar-center">
			  <li><img  src="../../static/sporty-shoe.png" alt="Sporty Shoes" width="70" height="40">	</li>
		</ul>
	</nav>
	<div class="container col-md-6">

	<h2> Welcome Admin To Sporty Shoes</h2>


		<form:form action="/admin/login"  method="POST"  >
		<div class="form-group ">
			<label for="userName">User Name</label>
			<input class="form-control" type="text" required="required" name="username"  path="username" />
			<label for="password">Password</label>
			<input class="form-control" type="password" required="required"  name="password" path="password" />
		</div>
		<div class="form-group text-center" style="color:red; background-color:#e0fefb; ">
			<strong>${SPRING_SECURITY_LAST_EXCEPTION.message }</strong>
			<strong>${changePasswordError }</strong>
			<strong>${registeredSuccessfully}</strong>
		</div>
		<div class="form-group text-center">
		
			<button type="submit" class="btn btn-primary text-center">Login</button>
			<a href="/admin/changePassword" class="btn btn-primary" role="button" data-bs-toggle="button">Change Password</a>
			
						
		</div>
		<div class="form-group text-center">
			Do not have an account? <a  href="/admin/register" >Register Here</a>
		</div>
		</form:form>
	</div>
</body>
</html>