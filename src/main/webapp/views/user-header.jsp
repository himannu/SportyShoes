    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
	<!DOCTYPE html>
	<html>
		<head>
		<meta charset="utf-8">
		 <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
		
		<title>Sporty Shoes</title>
	</head>
	<body>

			
		<nav class="navbar navbar-default navbar-light navbar-expand-sm" style="background-color: #e3f2fd;">
		
		      <ul class="nav navbar-nav navbar-center">
				  <li class="nav-item"><img  class = "navbarbrand" alt="" src="../static/sporty-shoe.png" style="width:70px;height:40px;">	</li>
		      	<li><a class = "navbarbrand" href="/user/products"><span class="glyphicon glyphicon-home">HOME</span></a></li>

		      </ul>
		      
		      <ul class="nav navbar-nav navbar-right">
<!-- 		            <li><a href="/user/checkOut"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
 -->		            <li class="nav-item"> <a href="/user/checkout"><i class="fa" style="font-size:24px" >&#xf07a;</i><span class="badge badge-success"> <%=session.getAttribute("cartItems") %> </span></a></li>
 
		            	<li class="nav-item"><a href="/logout"><span class="glyphicon glyphicon-user"></span>LOGOUT</a></li>
		      </ul>
		
		</nav>