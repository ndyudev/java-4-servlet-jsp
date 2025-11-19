<%-- allFavorites.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  <!-- Giữ fmt để format Date -->
<html>
<head>
    <title>Danh Sách Video Yêu Thích</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h1>Danh sách các video đã được yêu thích</h1>
    <table>
        <thead>
            <tr>
                <th>Video Title</th>
                <th>Người thích</th>
                <th>Ngày thích</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="favorite" items="${favorites}">
                <tr>
                    <td>${favorite.video.title}</td>
                    <td>${favorite.user.fullName}</td>
                    <td><fmt:formatDate value="${favorite.likeDate}" pattern="dd/MM/yyyy" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${empty favorites}">
        <p>Không có dữ liệu favorites nào.</p>
    </c:if>
    <a href="${pageContext.request.contextPath}/lab3/userFavorites?userId=U001">Xem favorites của user cụ thể</a>
</body>
</html>