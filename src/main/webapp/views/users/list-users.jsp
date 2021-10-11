    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
	<jsp:include page="../header.jsp"></jsp:include>
	<main class = "container-fluid p-4">

		<form:form action="/admin/searchUser" class="form-inline py-2" method="POST">
			<div class="form-group">
				<strong>Username: </strong>
				<input type="text" name="uname" path="uname" class="form-control"/>
			</div>
			<div class="form-group">
				 <strong>Email: </strong>
				<input type="text" name="email" path="email" class="form-control"/>
			</div>
	    	<div class="form-group">
	  			<button class="btn btn-primary">Search</button>
	  		</div>
			
		</form:form>
		<br/>
		<table class =" table table-striped table-bordered">
		
			<thead>
				<tr>
					<th>User Name</th>
					<th>Role</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Phone Number</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.username }"/></td>
				<td><c:out value="${user.role}"/></td>
				<td><c:out value="${user.firstName }"/></td>
				<td><c:out value="${user.lastName }"/></td>
				<td><c:out value="${user.emailId}"/></td>
				<td><c:out value="${user.phoneNumber }"/></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</main>
		<jsp:include page="../footer.jsp"></jsp:include>
