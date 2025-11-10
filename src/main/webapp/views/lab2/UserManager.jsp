<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous" />
<title>Lab 2 | User Manager</title>
</head>

<body>
	<c:url var="baseURL" value="/lab2/user" />

	<div class="container mt-4">
		<h4 class="mb-3">Quản lý user</h4>

		<c:if test="${not empty message}">
			<div class="alert alert-info">${message}</div>
		</c:if>

		<form method="post" class="mb-4">
			<div class="mb-2">
				<label class="form-label">ID:</label> <input name="id"
					class="form-control" value="${form.id}" required>
			</div>

			<div class="mb-2">
				<label class="form-label">Fullname:</label> <input name="fullname"
					class="form-control" value="${form.fullname}" required>
			</div>

			<div class="mb-2">
				<label class="form-label">Password:</label> <input name="password"
					type="password" class="form-control" value="${form.password}"
					required>
			</div>

			<div class="mb-2">
				<label class="form-label">Email:</label> <input name="email"
					type="email" class="form-control" value="${form.email}" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Role:</label><br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="admin"
						value="true" ${form.admin ? 'checked' : ''} id="admin"> 
					<label class="form-check-label" for="admin">Admin</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="admin"
						value="false" ${!form.admin ? 'checked' : ''} id="user"> 
					<label class="form-check-label" for="user">User</label>
				</div>
			</div>

			<div class="d-flex gap-2">
				<button formaction="${baseURL}/create" class="btn btn-primary">Create</button>
				<button formaction="${baseURL}/update" class="btn btn-success">Update</button>
				<button formaction="${baseURL}/reset" class="btn btn-secondary">Reset</button>
			</div>
		</form>
	</div>

	<div class="container mt-5">
		<table class="table table-bordered table-striped">
			<thead class="table-dark text-center">
				<tr>
					<th>#</th>
					<th>ID</th>
					<th>Full name</th>
					<th>Email</th>
					<th>Role</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${listUser}" varStatus="count">
					<tr>
						<td class="text-center">${count.count}</td>
						<td>${u.id}</td>
						<td>${u.fullname}</td>
						<td>${u.email}</td>
						<td>${u.admin ? 'Admin' : 'User'}</td>
						<td class="text-center">
							<a href="${baseURL}/edit/${u.id}" class="btn btn-warning btn-sm">Edit</a> 
							<a href="${baseURL}/delete?id=${u.id}" class="btn btn-danger btn-sm">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav class="mt-3 d-flex justify-content-center">
			<ul class="pagination">
				<c:forEach var="i" begin="1" end="${totalPages}">
					<li class="page-item ${currentPage == i ? 'active' : ''}"><a
						class="page-link" href="${baseURL}/index?page=${i}">${i}</a></li>
				</c:forEach>
			</ul>
		</nav>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
		crossorigin="anonymous"></script>
</body>
</html>
