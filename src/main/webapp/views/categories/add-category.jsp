<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="../header.jsp"></jsp:include>
<title>Add New Category</title>
</head>
<body>
	<div class = "container col-md-6">
	<form:form method = "POST" modelAttribute="category">
	  <div class="form-group">
	    <form:input type="hidden" class="form-control" path="id" />
	    <form:label path="name">Product Name:</form:label>
	    <form:input type="text" class="form-control" path="name" />
	  </div>
	    <div class="form-group">
	  <button class="btn btn-default">Save Category</button>
	  </div>
	</form:form>
	</div>
<jsp:include page="../footer.jsp"></jsp:include>