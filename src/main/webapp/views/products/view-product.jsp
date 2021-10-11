<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<jsp:include page="../header.jsp"></jsp:include>
<title>Add New Product</title>
</head>
<body>
	<div class = "container col-md-6">
	<form:form method = "POST" modelAttribute="product">
		<form:input type="hidden" class="form-control" path="id" />
		<div class="card border-dark text-center">
						<div class="card border border-dark">
							<div class="card-header text-center bg-light p-2"><strong>${product.name }</strong></div>
							<div class="card-body bg-light">
								<span class="card-text p-2">${product.description }</span></br>
								<span class="card-text p-2"><strong>Category: </strong> ${product.category.name }</span></br>
								<span class="card-text p-2"><strong>Price:</strong> ${product.price }</span></br></br>
								<p class="card-footer text-center" >
									<button type="submit" class="btn btn-secondary text-center">Add Cart</button>
								</p>
							</div>
			</div>
			</div>	    
	</form:form>
	</div>
<jsp:include page="../footer.jsp"></jsp:include>