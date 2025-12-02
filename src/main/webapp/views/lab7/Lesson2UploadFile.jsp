<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Lab 7 Lesson 2 Upload File</title>

            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

            <script src="https://kit.fontawesome.com/f4e3fc99b3.js" crossorigin="anonymous"></script>
        </head>

        <body>
            <div class="container mt-3">
                <input type="file" name="photo" id="photo">
                <button class="btn btn-info" onclick="uploadFile()">Upload</button>
            </div>
            <script>
                function uploadFile() {
                    let input = document.getElementById('photo');
                    let formData = new FormData();
                    formData.append("photo", input.files[0]);
                    const url = "<c:url value='/lab7/lesson2/upload'/>";

                    let option = {
                        method: 'POST',
                        body: formData
                    }

                    fetch(url, option)
                        .then(response => response.json())
                        .then(data => {
                            console.log("Success", data);
                            alert("Upload thành công file: " + data.name);
                        })
                        .catch(err => {
                            console.error("Error", err);
                            alert("Lỗi upload file");
                        });
                }

            </script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        </body>

        </html>