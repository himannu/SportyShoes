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
 
 <title>Change Password</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-light navbar-expand-sm" style="background-color: #e3f2fd;">
		
      <ul class="nav navbar-nav navbar-center ">
		<li><img alt="Sporty Shoes" src="../static/sporty-shoe.png" width="70" height="40">	</li>
      </ul>
	</nav>

	<div class="container col-md-6">
	<h3> Welcome To Sporty Shoes</h3>

		<form:form action="changePassword"  method="POST" modelAttribute="userForm" >
		
		<div class="form-group ">
			<label for="userName">User Name</label>
			<input class="form-control" type="text" required="required" name="username"  placeholder="user name" />
			<label for="password">Old Password</label>
			<input class="form-control" type="password" required="required"  name="password" placeHolder ="old password"  />
			<label for="passwordConfirm">New Password</label>
			<input class="form-control" type="password" required="required"  name="passwordConfirm" placeHolder ="new password"  />
			
		</div>
		
		<div class="form-group text-center" style="color:red; background-color:#e0fefb; ">
			<strong>${error }</strong>
		</div>
		
		<div class="form-group text-center	">
			<button type="submit" class="btn btn-primary text-center">Submit</button>
			<a href="/login" class="btn btn-primary" role="button" data-bs-toggle="button">Cancel</a>
			
		</div>
		</form:form>
	</div>
</body>
</html>