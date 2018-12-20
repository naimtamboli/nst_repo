<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>UXP Systems</title>
<link href="/bootstrap.min.css" rel="stylesheet">
<script src="/jquery-2.2.1.min.js"></script>
<script src="/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<div class="container" style="margin: 50px">
			<div style="align: right">
				<form action="/logout" method="post">
					<button type="submit" class="btn btn-primary">Log Out</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</div>

			<div class="row text-center">
				<strong> User Details</strong>
			</div>
			<div class="row"
				style="border: 1px solid green; padding: 10px; background-color: green;">
				<div class="col-md-3 text-center">
					<strong style="font-color: white">UserId</strong>
				</div>
				<div class="col-md-3 text-center">
					<strong>UserName</strong>
				</div>
				<div class="col-md-3 text-center">
					<strong>Status</strong>
				</div>
				<div class="col-md-3 text-center">
					<strong>Action</strong>
				</div>
			</div>
			<c:forEach var="user" items="${users}">
				<div class="row" style="border: 1px solid green; padding: 10px">
					<div class="col-md-3 text-center">${user.id}</div>
					<div class="col-md-3 text-center">${user.username}</div>
					<div class="col-md-3 text-center">${user.status}</div>
					<div class="col-md-3 text-center">
						<a href="updateuser/${user.id}">Edit </a><a
							href="deleteuser/${user.id}">Delete</a>
					</div>
				</div>
			</c:forEach>
			<h3>
				<a href="adduser">Add New User</a>
			</h3>
		</div>
	</div>
</body>
</html>