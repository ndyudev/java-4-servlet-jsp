<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Video Favorite</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h2 class="mb-4 text-success">List favorite user</h2>

		<form
			action="${pageContext.request.contextPath}/lab4/report/userfavorites"
			method="get" class="mb-5">
			<div class="row g-3 align-items-center">
				<div class="col-auto">
					<label for="userSelect" class="col-form-label fw-bold">Chọn
						user:</label>
				</div>
				<div class="col-6">
					<select name="userId" id="userSelect" class="form-select"
						onchange="this.form.submit()">
						<c:forEach var="user" items="${userList}">
							<option value="${user.id}"
								${user.id == selectedUserId ? 'selected' : ''}>
								${user.fullName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</form>

		<hr>

		<div>
			<h3 class="mb-4 text-center">Video Đã Thích:</h3>
		</div>


		<div class="row">
			<c:choose>
				<c:when test="${empty favoriteVideos}">
					<div class="alert alert-warning">user chưa thích video nào.</div>
				</c:when>
				<c:otherwise>
					<c:forEach var="video" items="${favoriteVideos}">
						<div class="col-md-4 mb-4">
							<div class="card shadow-sm">
								<img src="${video.poster}" class="card-img-top" alt="Poster"
									style="height: 180px; object-fit: cover;">
								<div class="card-body">
									<h5 class="card-title text-primary">${video.title}</h5>
									<p class="card-text text-muted small">${video.description}
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>