    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<jsp:include page="../header.jsp"></jsp:include>
	<main class = "container-fluid p-4">
		<a href="/admin/categories/add" class="btn btn-primary" role="button" data-bs-toggle="button">Add Category</a>
		<br/>

		<table class =" table table-striped table-bordered">
		
			<thead>
				<tr>
					<th>Category Name</th>
					<th>Modify</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${categories}" var="category">
			<tr>
				<td><c:out value="${category.name }"/></td>
				<td>
				<a href="/admin/categories/edit/${category.id}" 
				class="btn btn-primary" role="button" data-bs-toggle="button">Edit</a>
				<a href="/admin/categories/delete/${category.id}" class="btn btn-primary" role="button" data-bs-toggle="button">Delete</a>
			</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</main>
		<jsp:include page="../footer.jsp"></jsp:include>
