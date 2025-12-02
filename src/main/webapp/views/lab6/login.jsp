<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lab 6 Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row">
        
        <div class="col-md-5">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h5 class="mb-0">Đăng Nhập</h5>
                </div>
                <div class="card-body">
                    <c:url var="postUrl" value="/login" />

                    <c:if test="${not empty sessionScope.securityMessage}">
                        <div class="alert alert-danger">
                            ${sessionScope.securityMessage}
                        </div>
                        <c:remove var="securityMessage" scope="session" />
                    </c:if>

                    <c:if test="${not empty message}">
                        <div class="alert alert-warning">
                            ${message}
                        </div>
                    </c:if>

                    <form action="${postUrl}" method="post">
                        <div class="mb-3">
                            <label class="form-label">Tài Khoản:</label>
                            <input name="username" class="form-control" value="${param.username}">
                        </div>
                        
                        <div class="mb-3">
                            <label class="form-label">Mật Khẩu:</label>
                            <input name="password" type="password" class="form-control">
                        </div>
                        
                        <button class="btn btn-primary w-100">Đăng Nhập</button>
                    </form>
                </div>
            </div>
        </div>

        <div class="col-md-7">
            <div class="card">
                <div class="card-header">
                    <h5 class="mb-0">Menu Test</h5>
                </div>
                <div class="card-body">
                    

                    <c:if test="${not empty sessionScope.user}">
                        <div class="alert alert-success d-flex justify-content-between align-items-center">

                            <a href="<c:url value='/logoff'/>" class="btn btn-sm btn-danger">Thoát</a>
                        </div>
                    </c:if>
                    <c:if test="${empty sessionScope.user}">
                        <div class="alert alert-secondary">Chưa đăng nhập</div>
                    </c:if>

                    <div class="row">
                        <div class="col-6">
                            <h6>Người dùng</h6>
                            <div class="list-group">
                                <a href="${pageContext.request.contextPath}/video/list" class="list-group-item list-group-item-action">Trang chủ</a>
                                <a href="${pageContext.request.contextPath}/account/change-password" class="list-group-item list-group-item-action">Đổi mật khẩu</a>
                                <a href="${pageContext.request.contextPath}/account/edit-profile" class="list-group-item list-group-item-action">Sửa hồ sơ</a>
                                <a href="${pageContext.request.contextPath}/video/like/v1" class="list-group-item list-group-item-action">Like Video</a>
                            </div>
                        </div>
                        <div class="col-6">
                            <h6>Admin</h6>
                            <div class="list-group">
                                <a href="${pageContext.request.contextPath}/admin/video" class="list-group-item list-group-item-action">Quản lý Video</a>
                                <a href="${pageContext.request.contextPath}/admin/user" class="list-group-item list-group-item-action">Quản lý User</a>
                                <a href="${pageContext.request.contextPath}/admin/like" class="list-group-item list-group-item-action">Thống kê Like</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>