<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Video Yêu Thích Của User</title>
</head>
<body>
    <h1>${user.fullName}</h1> <!-- Dynamic: Nguyễn Văn Tèo -->
    <h2>Các video đã yêu thích</h2>
    <ul>
        <c:forEach var="video" items="${videos}">
            <li>${video.title}</li> <!-- Favorite.getVideo().getTitle() -->
        </c:forEach>
    </ul>
    <c:if test="${empty videos}">
        <p>Không có video yêu thích nào.</p>
    </c:if>
    <a href="${pageContext.request.contextPath}/lab3/allFavorites">Xem tất cả favorites</a>
</body>
</html>