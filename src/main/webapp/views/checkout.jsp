<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
	<jsp:include page="user-header.jsp"></jsp:include>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
		<main class="container-fluid" >
			<div class="row">
			<div class="col-md-8">
			<h2 class="text-center">Shopping Cart</h2>
			<c:forEach var="orderProduct" items="${orderProducts }">
				<div class="card border border-dark">
					<div class="card-header text-center bg-light p-1"><h4>${orderProduct.product.name }</h4>
					</div>
						<div class="card-header text-right bg-light p-1">
							<a href="/user/removeCart/${ orderProduct.product.id}" class="card-link text-danger like">
							<i class="fa fa-times fa-2x" aria-hidden="true"></i>
						    </a>
						</div>
						<div class="card-body col-4" >
								 <h5>${orderProduct.product.description }</h5><br/>
								 <span class="card-title p-1"><strong>Category:  ${orderProduct.product.category.name }</strong><br/>
									<strong>Price: ${orderProduct.product.price}</strong></span><br/>
									<form:form action="/user/updateCart/${orderProduct.product.id }" class="form-inline" method="POST">
									<div class="form-group card-text d-flex justify-content-end">
										<strong>Quantity: </strong><input type="number" class="form-control" name="quantity" value="${orderProduct.quantity }"/>
										<button type="submit" class="form-control btn btn-secondary text-center" style="background-color: #2873b7;" ><h5>Update</h5></button>
										</div>									

									</form:form>

							</div>
					</div>
				 </c:forEach>
			</div>
			<div class="col-md-4">
			<h2 class="text-center">Checkout</h2>
				<div class="card border border-dark">
							<div class="card" >
						<div class="card-header"><h3 >SubTotal (<%=session.getAttribute("cartItems") %> Items) : ${totalPrice }</h3></div>

								 <div class="card-body">
									 <h5>${orderProduct.product.description }</h5>
		<form:form action="/user/saveCart"  method="POST"  modelAttribute="address" >
			<h4> Shipping Address</h4>
		 	<div class="form-group">
				<label for="lineOne">Flat, House No, Building</label>
				<input class="form-control" type="text" required="required" name="lineOne"  />
				<form:errors path="lineOne" style="color:red;"/>
			</div>
		 	<div class="form-group">
				<label for="lineTwo">Area, Street, Sector </label>
				<input class="form-control" type="text" required="required" name="lineTwo"  />
				<form:errors path="lineTwo" style="color:red;"/>
			</div>
			<div class="form-group">	
				<label for="city">City</label>
				<input class="form-control" type="text" required="required" name="city" />
				<form:errors path="city" style="color:red;"/>
			</div>
		 	<div class="form-group">
				<label for="state">State</label>
				<input class="form-control" type="state" required="required" name="state" />
				<form:errors path="state" style="color:red;"/>
			</div>
		 	<div class="form-group">
				<label for="pinCode">Pin Code</label>
				<input class="form-control" type="text" required="required" name="pinCode"  />
				<form:errors path="pinCode" style="color:red;"/>
			</div>
		      <div class="form-group form-check">
			            <label class="form-check-label mb-2" for="exampleCheck"><h5>This order contains a gift.....</h5></label>
			            <input type="checkbox" class="form-check-input  p-2" id="exampleCheck" />
			        </div>
			<div class="form-group text-center ">
				<button type="submit" class="form-control btn btn-info" style="background-color: #2873b7;" ><h4>Pay Now</h4></button>
			</div>	
			<div class="form-group  text-center ">
				<a href="/user/products" class="form-control btn btn-info" style="background-color: #2873b7;" role="button" data-bs-toggle="button"><h4>Cancel</h4></a>
			</div>
			</form:form>
		</div>
	 </div>
	</div>
			
			</div>
			</div>
		
		</main>
	</body>
</html>