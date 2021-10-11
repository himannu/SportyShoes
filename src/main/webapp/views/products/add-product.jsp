<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<jsp:include page="../header.jsp"></jsp:include>
<title>Add New Product</title>
</head>
<body>
	<div class = "container-fluid col-md-6">
	<form:form method = "POST" modelAttribute="product">
		<form:input type="hidden" class="form-control" path="id" />
	
	  <div class="form-group">
	    <form:label path="name">Product Name:</form:label>	
	    <form:input type="text" class="form-control" path = "name" id="name"/>
	  </div>
	  <div class="form-group">
	    <form:label path="description">Product Description:</form:label>
	    <form:input type="text" class="form-control" path = "description" id="description"/>
	  </div>
	  <div class="form-group">
	    <form:label path="category">Product Category: </form:label>
	    <form:select path ="category" items="${ categoriesMap}" />
	  </div>
	  <div class="form-group">
	    <form:label path="price">Product Price: </form:label>
	    <form:input type="number" class="form-control" path = "price" id="price"/> 
	  </div>
	<div class="form-group">
	    <form:label path="quantity">Quantity:</form:label>
	    <form:input type="text" class="form-control" path = "quantity" id="quantity" required="true"/>
	  </div>
	    <div class="form-group">
	  <button type="submit" class="btn btn-default">Submit</button>
	  </div>
	</form:form>
	</div>
<jsp:include page="../footer.jsp"></jsp:include>