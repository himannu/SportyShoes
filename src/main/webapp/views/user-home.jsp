<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
	<jsp:include page="user-header.jsp"></jsp:include>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
		<main class="container-fluid" >
		<div class="row ">
		<div class="col-2 ">
		<%-- <form:form action="/user/products/searchByPrice" class="form-inline py-2" method="POST">
			<div class="form-group py-2">
				<strong>Price: </strong>
				<input type="text" class="form-control" name="price"  />

			</div>
	    	<div class="form-group py-2">
	    	<p class="text-center">
	  			<button class="btn btn-secondary ">Search</button>
	  			</p>
	  		</div>
	  		</form:form>	 --%>
			</br>
			<div class="list-group ">
				<label  class="text-center">Search By Category:</label>
				  <a href="/user/products" class="list-group-item list-group-item-action active" >All </a>
					<c:forEach var="category" items="${categoriesMap }">
				  <a href="/user/products/searchByCategory/${category.key }" class="list-group-item list-group-item-action " >
				    ${category.value }
				  </a>
				  </c:forEach>
			</div>
		</div>
		<div class="col-10">
			<div class="card-group" > 
				<c:forEach var="product" items="${products }">
					<div class="col-sm-3 p-2">
						<div class="card border border-dark">
							<div class="card-header text-center bg-light p-2"><strong>${product.name }</strong></div>
							<div class="card-body">
								<span class="card-text p-2">${product.description }</span></br>
								<span class="card-text p-2"><strong>Category: </strong> ${product.category.name }</span></br>
								<span class="card-text p-2"><strong>Price:</strong> ${product.price }</span></br>
								<form:form action="/user/addCart/${product.id }" class="form-inline" method="POST">
								<div class="form-group card-text ">
								
									<span class="card-text p-2">Quantity: <input type="number" class="form-control" name="quantity"/></span>
									
								
								</div>									
								<div class="card-footer bg-light ">
									  <button type="submit" class="form-control btn btn-secondary text-center" style="background-color: #2873b7;" >Add To Cart</button>
	  								<a href="/user/checkout" style="background-color: #2873b7;" class="form-control btn btn-secondary text-center">Checkout</a> 
											  							
	  							</div>
								
									<%-- <a href="/user/addCart/${product.id }/${quantity}" style="background-color: #2873b7;" class="btn btn-secondary text-center">Add To Cart</a> --%>
								<!--  </p>-->
								</form:form>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			</div>
			</div>
		</main>
	</body>
</html>
	
	
	