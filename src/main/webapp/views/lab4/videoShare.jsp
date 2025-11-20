<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Video Share</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            max-width: 900px;
        }
    </style>
</head>
<body>
    
    <div class="container mt-3"> 
        
        <h1 class="text-primary mb-4 text-center">Video Share</h1>
        
        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
                Lỗi: ${error}
            </div>
        </c:if>

        <c:choose>
            <c:when test="${empty listVideoShare}">
                <div class="alert alert-info" role="alert">
                    Không có dữ liệu.
                </div>
            </c:when>
            <c:otherwise>
                <table class="table table-striped table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <th>STT</th>
                            <th>Tiêu đề Video</th>
                            <th>Số lượt chia sẻ</th>
                            <th>Ngày chia sẻ đầu tiên</th>
                            <th>Ngày chia sẻ cuối cùng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${listVideoShare}" varStatus="status">
                            <tr>
                                <td>${status.count}</td> 
                                <td>${item[0]}</td> 
                                <td>${item[1]}</td> 
                                <td>
                                    <fmt:formatDate value="${item[2]}" pattern="dd-MM-yyyy"/> 
                                </td>
                                <td>
                                    <fmt:formatDate value="${item[3]}" pattern="dd-MM-yyyy"/> 
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>

    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>