<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Management (AJAX)</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center text-primary">Quản lý Nhân Viên (REST API)</h2>
        
        <!-- FORM NHẬP LIỆU -->
        <div class="card p-4 shadow-sm mb-4">
            <div class="row g-3">
                <div class="col-md-6">
                    <label class="form-label">Mã nhân viên (ID):</label>
                    <input id="id" class="form-control" placeholder="Ví dụ: NV01">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Họ và tên:</label>
                    <input id="fullname" class="form-control" placeholder="Nhập họ tên...">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Lương:</label>
                    <input id="salary" type="number" class="form-control" placeholder="Nhập lương...">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Giới tính:</label><br>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="male" name="gender" value="true" checked>
                        <label class="form-check-label" for="male">Nam</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="female" name="gender" value="false">
                        <label class="form-check-label" for="female">Nữ</label>
                    </div>
                </div>
            </div>
            
            <div class="mt-4 text-center">
                <button onclick="ctrl.create()" class="btn btn-primary px-4">Create</button> 
                <button onclick="ctrl.update()" class="btn btn-warning px-4 text-white">Update</button> 
                <button onclick="ctrl.delete()" class="btn btn-danger px-4">Delete</button> 
                <button onclick="ctrl.reset()" class="btn btn-secondary px-4">Reset</button>
            </div>
        </div>
        
        <!-- BẢNG DANH SÁCH -->
        <table class="table table-bordered table-hover"> 
            <thead class="table-dark"> 
                <tr> 
                    <th>ID</th>
                    <th>Fullname</th> 
                    <th>Gender</th> 
                    <th>Salary</th> 
                    <th>Action</th> 
                </tr> 
             </thead> 
             <tbody id="list">
                <!-- Dữ liệu sẽ được JS đổ vào đây -->
             </tbody> 
        </table>
    </div>
    
    <script> 
        // Đường dẫn gốc API (Sử dụng c:url để lấy đúng Context Path)
        const API_URL = "<c:url value='/lab7/employees'/>";

        let ctrl = { 
            // 1. Đổ dữ liệu từ Object vào Form
            setForm(employee){
                document.getElementById("id").value = employee.id; 
                // Lưu ý: Java Entity là 'fullname', nên JSON trả về cũng là 'fullname'
                document.getElementById("fullname").value = employee.fullname; 
                document.getElementById("salary").value = employee.salary; 
                if(employee.gender){ 
                    document.getElementById("male").checked = true; 
                } else { 
                    document.getElementById("female").checked = true; 
                }
            }, 
            
            // 2. Lấy dữ liệu từ Form đóng gói thành Object
            getForm(){
                return { 
                    id: document.getElementById("id").value, 
                    fullname: document.getElementById("fullname").value, 
                    gender: document.getElementById("male").checked, 
                    salary: parseFloat(document.getElementById("salary").value) 
                } 
            }, 
            
            // 3. Hiển thị danh sách lên bảng
            fillToTable(employees){ 
                var rows = []; 
                employees.forEach(e => { 
                    var row = `<tr> 
                        <td>\${e.id}</td> 
                        <td>\${e.fullname}</td> 
                        <td>\${e.gender ? 'Nam' : 'Nữ'}</td> 
                        <td>\${e.salary}</td> 
                        <td>
                            <a href="#" onclick="ctrl.edit('\${e.id}')" class="btn btn-sm btn-info text-white">Edit</a>
                        </td> 
                    </tr>`; 
                    rows.push(row);
                });
                document.getElementById("list").innerHTML = rows.join(''); 
            }, 
            
            // 4. Load tất cả dữ liệu (GET)
            loadAll(){ 
                fetch(API_URL, {method: "GET"})
                    .then(resp => resp.json())
                    .then(employees => { 
                        this.fillToTable(employees); 
                    })
                    .catch(err => console.error("Lỗi load data:", err));
            }, 
            
            // 5. Thêm mới (POST)
            create(){ 
                var data = this.getForm(); 
                fetch(API_URL, { 
                    method: "POST", 
                    headers: {"Content-Type": "application/json"}, 
                    body: JSON.stringify(data) 
                }).then(resp => resp.json()).then(json => { 
                    alert("Thêm thành công!");
                    this.loadAll(); 
                    this.reset(); 
                }).catch(err => alert("Lỗi thêm mới"));
            }, 
            
            // 6. Cập nhật (PUT)
            update(){ 
                var data = this.getForm(); 
                // URL: /lab7/employees/NV01
                var url = `\${API_URL}/\${data.id}`; 
                
                fetch(url, { 
                    method: "PUT", 
                    headers: {"Content-Type": "application/json"}, 
                    body: JSON.stringify(data) 
                }).then(resp => {
                    // PUT thường không trả về body hoặc trả về rỗng, check status là đủ
                    if(resp.ok) {
                        alert("Cập nhật thành công!");
                        this.loadAll();
                    } else {
                        alert("Cập nhật thất bại!");
                    }
                });
            }, 
            
            // 7. Xóa (DELETE)
            delete(){ 
                var id = document.getElementById("id").value; 
                if(!id) {
                    alert("Vui lòng nhập hoặc chọn ID để xóa!");
                    return;
                }
                
                if(!confirm("Bạn có chắc muốn xóa nhân viên " + id + "?")) return;

                var url = `\${API_URL}/\${id}`; 
                fetch(url, {method: "DELETE"}).then(resp => { 
                    if(resp.ok) {
                        alert("Xóa thành công!");
                        this.loadAll(); 
                        this.reset(); 
                    } else {
                        alert("Xóa thất bại!");
                    }
                }); 
            }, 
            
            // 8. Xóa trắng form
            reset(){ 
                var employee = {id:"", fullname:"", salary:"", gender:true}; 
                this.setForm(employee); 
            }, 
            
            // 9. Đổ dữ liệu lên form để sửa (GET by ID)
            edit(id){ 
                var url = `\${API_URL}/\${id}`; 
                fetch(url, {method: "GET"})
                    .then(resp => resp.json())
                    .then(employee => { 
                        this.setForm(employee); 
                    })
                    .catch(err => console.error("Lỗi lấy chi tiết:", err));
            } 
        } 
        
        // Load danh sách ngay khi chạy trang
        ctrl.loadAll(); 
     </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>