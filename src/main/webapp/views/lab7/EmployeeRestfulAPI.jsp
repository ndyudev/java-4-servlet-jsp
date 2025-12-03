<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Management (No Alert)</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center text-primary">Quản lý Nhân Viên</h2>
        
        <div class="card p-4 shadow-sm mb-4">
            <div class="row g-3">
                <div class="col-md-6">
                    <label class="form-label">Mã nhân viên (ID):</label>
                    <input id="id" class="form-control" placeholder="NV...">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Họ và tên:</label>
                    <input id="fullname" class="form-control" placeholder="Họ tên...">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Lương:</label>
                    <input id="salary" type="number" class="form-control" placeholder="Lương...">
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
             <tbody id="list"></tbody> 
        </table>
    </div>
    
    <script> 
        const API_URL = "<c:url value='/lab7/restfullapi/employee'/>";

        let ctrl = { 
            // 1. Set form
            setForm(employee){
                document.getElementById("id").value = employee.id; 
                document.getElementById("fullname").value = employee.fullname; 
                document.getElementById("salary").value = employee.salary; 
                if(employee.gender){ 
                    document.getElementById("male").checked = true; 
                } else { 
                    document.getElementById("female").checked = true; 
                }
            }, 
            
            // 2. Get form
            getForm(){
                return { 
                    id: document.getElementById("id").value, 
                    fullname: document.getElementById("fullname").value, 
                    gender: document.getElementById("male").checked, 
                    salary: parseFloat(document.getElementById("salary").value) 
                } 
            }, 
            
            // 3. Render Table
            fillToTable(employees){ 
                var rows = employees.map(e => `
                    <tr> 
                        <td>\${e.id}</td> 
                        <td>\${e.fullname}</td> 
                        <td>\${e.gender ? 'Nam' : 'Nữ'}</td> 
                        <td>\${e.salary}</td> 
                        <td>
                            <a href="#" onclick="ctrl.edit('\${e.id}')" class="btn btn-sm btn-info text-white">Edit</a>
                        </td> 
                    </tr>`
                );
                document.getElementById("list").innerHTML = rows.join(''); 
            }, 
            
            // 4. Load All
            loadAll(){ 
                fetch(API_URL).then(resp => resp.json())
                .then(data => this.fillToTable(data))
                .catch(err => console.error(err));
            }, 
            
            // 5. Create (Bỏ alert)
            create(){ 
                var data = this.getForm(); 
                fetch(API_URL, { 
                    method: "POST", 
                    headers: {"Content-Type": "application/json"}, 
                    body: JSON.stringify(data) 
                }).then(resp => {
                    this.loadAll(); // Load lại bảng ngay
                    this.reset();   // Xóa form ngay
                }).catch(err => console.error(err));
            }, 
            
            // 6. Update (Bỏ alert)
            update(){ 
                var data = this.getForm(); 
                var url = `\${API_URL}/\${data.id}`; 
                fetch(url, { 
                    method: "PUT", 
                    headers: {"Content-Type": "application/json"}, 
                    body: JSON.stringify(data) 
                }).then(resp => {
                    this.loadAll(); // Load lại bảng ngay
                }).catch(err => console.error(err));
            }, 
            
            // 7. Delete (Bỏ confirm + Bỏ alert)
            delete(){ 
                var id = document.getElementById("id").value; 
                if(!id) return; // Không có ID thì thôi, không báo gì

                var url = `\${API_URL}/\${id}`; 
                fetch(url, {method: "DELETE"}).then(resp => { 
                    this.loadAll(); // Load lại bảng ngay
                    this.reset();   // Xóa form ngay
                }).catch(err => console.error(err));
            }, 
            
            // 8. Reset
            reset(){ 
                this.setForm({id:"", fullname:"", salary:"", gender:true}); 
            }, 
            
            // 9. Edit (Đổ ngược lên form)
            edit(id){ 
                var url = `\${API_URL}/\${id}`; 
                fetch(url).then(resp => resp.json())
                .then(data => this.setForm(data))
                .catch(err => console.error(err));
            } 
        } 
        
        // Init
        ctrl.loadAll(); 
     </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>