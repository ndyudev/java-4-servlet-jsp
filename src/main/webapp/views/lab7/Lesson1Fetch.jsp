<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lab 8 - Bài 1: Fetch API Demo</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <script src="https://kit.fontawesome.com/f4e3fc99b3.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container mt-5 text-center">
        
        <button onclick="fetchData()" class="btn btn-primary btn-lg">
            Lấy dữ liệu
        </button>
        
        <div id="result" class="mt-4 text-success"></div>
    </div>
    <script>
        function fetchData() {
            
            const url = "<c:url value='/lab7/lesson1'/>"; 

            fetch(url)
                .then(function(response) {
					
					console.log("Status",response.status);
					console.log("Ok", response.ok);
					console.log("Status Text", response.statusText);

                    return response.json();
                })
                .then(function(data) {
                    
                    document.getElementById('result').innerText = 
                        "Đã nhận: " + data.hoTen + " - Lương: " + data.luong;
                })
                .catch(function(error) {
                    console.error('Có lỗi xảy ra:', error);
                });
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>