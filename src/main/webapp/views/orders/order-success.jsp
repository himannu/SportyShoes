<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
	<jsp:include page="../user-header.jsp"></jsp:include>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
		<main class="container-fluid col-md-6 text-center" >
		<div class="card card-danger text-center">
			<div class="card-header text-success text-center">
				<h3>Success</h3>
				</div>
				<div class ="card-body">
				<p>
				<i class="fa fa-handshake-o fa-5x pull-left"></i>
				<h4>Your Order has been successfully placed ! Thank you for shopping with us. </h4>
				</p>
			</div>
			<div class="card-footer text-center">
				<span><h4><a href="/user/products" class="badge badge-info">Home</a></h4></span>
			</div>
		</div>
		
		</main>

	<jsp:include page="../footer.jsp"></jsp:include>
		