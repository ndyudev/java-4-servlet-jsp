<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* CSS tùy chỉnh cho form */
        .container-fluid { 
            max-width: 400px; 
            margin-top: 50px; 
            padding: 20px; 
            border: 1px solid #ccc; 
            border-radius: 5px; 
        }
    </style>
</head>
<body>
    <c:url value="/lab4/cau2/login" var="login"/>
	
	<div class="container-fluid">
        <h2 class="text-center mb-4">Đăng Nhập</h2>
        
        <c:if test="${not empty message}">
            <div class="alert alert-info" role="alert">
                ${requestScope.message}
            </div>
        </c:if>
        
		<form action="${login }" method="post">
			<div class="mb-3">
				<label class="form-label">Tài khoản/Email:</label>
				<input class="form-control" name="user" required>
			</div>
			
			<div class="mb-3">
				<label class="form-label">Mật khẩu:</label>
				<input class="form-control" type="password" name="password" required>
			</div>
			<button class="btn btn-info text-white fw-bolder w-100">Login</button>
		</form>
	</div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>