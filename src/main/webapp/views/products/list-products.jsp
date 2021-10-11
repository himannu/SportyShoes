    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
	<jsp:include page="../header.jsp"></jsp:include>
	<main class = "container-fluid p-4">
		<a href="/admin/products/add" class="btn btn-primary" role="button" data-bs-toggle="button">Add Product</a>
		<br/><br/>

		<table class =" table table-striped table-bordered">
		
			<thead>
				<tr>
					<th>Shoe Name</th>
					<th>Description</th>
					<th>Category</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Modify</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${products }" var="product">
			<tr>
				<td><c:out value="${product.getName() }"/></td>
				<td><c:out value="${product.getDescription() }"/></td>
				<td><c:out value="${product.getCategory().getName() }"/></td>
				<td><c:out value="${product.getPrice() }"/></td>
				<td><c:out value="${product.getQuantity() }"/></td>
				<td>
				<a href="/admin/products/edit/${product.id}" 
				class="btn btn-primary" role="button" data-bs-toggle="button">Edit</a>
				<a href="/admin/products/delete/${product.id}" class="btn btn-primary" role="button" data-bs-toggle="button">Delete</a>
			</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</main>
		<jsp:include page="../footer.jsp"></jsp:include>
