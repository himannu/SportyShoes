    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
	<jsp:include page="../header.jsp"></jsp:include>
	<main class = "container-fluid p-4">

		<form:form action="/admin/searchOrders" class="form-inline py-2" method="POST">
			<div class="form-group">
				<strong>Date: </strong>
				<input type="date" name="orderDate" path="orderDate" class="form-control"/>
			</div>
			<div class="form-group">
				 <strong>Category: </strong>
				<input type="text" name="category" path="category" class="form-control"/>
			</div>
	    	<div class="form-group">
	  			<button class="btn btn-primary">Search</button>
	  		</div>
			
		</form:form>
		<br/>
		<table class =" table table-striped table-bordered">
		
			<thead>
				<tr>
					<th>Product Name</th>
					<th>User Name</th>
					<th>Product Category</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Order Date</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${orderProducts}" var="orderProduct">
			<tr>
				<td><c:out value="${orderProduct.orderProductId.product.name }"/></td>
				<td><c:out value="${orderProduct.orderProductId.order.user.username}"/></td>
				<td><c:out value="${orderProduct.orderProductId.product.category.name}"/></td>
				<td><c:out value="${orderProduct.quantity }"/></td>
				<td><c:out value="${orderProduct.orderProductId.product.price}"/></td>
				<td><c:out value="${orderProduct.orderProductId.order.orderDate }"/></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</main>
		<jsp:include page="../footer.jsp"></jsp:include>
