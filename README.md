# 🚀 Java 4 – Lập trình Web với Servlet & JSP

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Servlet](https://img.shields.io/badge/Jakarta_Servlet-Fail--Fast-blue?style=for-the-badge)
![JSP](https://img.shields.io/badge/JSP-Tomcat-orange?style=for-the-badge&logo=apache-tomcat&logoColor=black)

<!-- Thêm các badge phù hợp khác (Database, Build, v.v.) -->

> Repository chứa **Labs + Assignment** môn **Java 4 – Lập trình Web với Servlet & JSP**. 

---

## 📌 Mục lục

- [Giới thiệu](#-giới-thiệu)
- [Công nghệ sử dụng](#-công-nghệ-sử-dụng)
- [Cấu trúc thư mục](#-cấu-trúc-thư-mục)
- [Chức năng chính (Assignment)](#-chức-năng-chính-assignment)
- [Hướng dẫn cài đặt](#-hướng-dẫn-cài-đặt)
- [Cách chạy & Demo](#-cách-chạy--demo)
- [Đóng góp](#-đóng-góp)
- [Tác giả](#-tác-giả)

---

## 📖 Giới thiệu

[**HÃY THAY ĐỔI ĐOẠN NÀY!**] Mô tả chi tiết hơn về dự án. Ví dụ:

> Dự án này được xây dựng nhằm phục vụ học tập và thực hành **Java Web** với:
>
> - **Servlet**: Xử lý nghiệp vụ & điều hướng
> - **JSP/JSTL**: Hiển thị giao diện
> - **MVC**: [**NẾU SỬ DỤNG MVC**] Tách bạch Model – View – Controller, code dễ đọc, dễ maintain
> - **[DATABASE] + Hibernate/JPA**: [**NẾU SỬ DỤNG DATABASE**] Quản lý & thao tác dữ liệu
>
> Phù hợp cho sinh viên đang học **Java 4 ( SOF3012 )** hoặc muốn ôn lại nền tảng **Servlet & JSP**.

---

## 🛠 Công nghệ sử dụng

### Core

- **JDK**: 17 [**HOẶC PHIÊN BẢN KHÁC NẾU DÙNG**]
- **Build Tool**: Maven

### Backend

- **Jakarta Servlet API**
- **JSP / JSTL**
- [**Hibernate Core / JPA (NẾU SỬ DỤNG)**]
- [**SQL Server JDBC Driver (NẾU SỬ DỤNG SQL SERVER)**]
- [**Lombok (NẾU SỬ DỤNG)**]

### Frontend

- **HTML / CSS / JavaScript**
- [**Bootstrap 5 (NẾU SỬ DỤNG)**]

### Server & Database

- **Apache Tomcat**: 9.0 / 10.0 [**HOẶC PHIÊN BẢN KHÁC NẾU DÙNG**]
- [**Microsoft SQL Server (NẾU SỬ DỤNG)**]

---

## 📂 Cấu trúc thư mục

```text
java-4-servlet-jsp/
├── src/
│   ├── main/
│   │   ├── java/               # Servlet, Controller, Model, DAO, Utils
│   │   ├── resources/          # Cấu hình (Hibernate, DB)
│   │   └── webapp/             # JSP, CSS, JS, Images
├── [**database/ (NẾU SỬ DỤNG DATABASE)**]  # Script SQL tạo CSDL
├── pom.xml                     # Maven dependencies
└── README.md                   # Tài liệu dự án
```

---

## ✨ Chức năng chính (Assignment)

[**HÃY THAY ĐỔI ĐOẠN NÀY!**] Liệt kê các chức năng chính của dự án. Ví dụ:

### 👤 Quản lý Tài khoản (NẾU CÓ)

- Đăng nhập / Đăng xuất
- Đổi mật khẩu
- Cập nhật thông tin cá nhân

### 📦 Quản lý Sản phẩm (NẾU CÓ)

- Thêm / Sửa / Xóa sản phẩm
- Xem danh sách & chi tiết sản phẩm

### 🛒 Quản lý Đơn hàng (NẾU CÓ)

- Giỏ hàng
- Lịch sử mua hàng

### 🔐 Phân quyền (NẾU CÓ)

- **Admin**
  - CRUD Users
  - CRUD Products
- **User**
  - Xem sản phẩm
  - Mua hàng

### ⚙️ Tiện ích khác (NẾU CÓ)

- Upload hình ảnh
- Gửi Email
- Đa ngôn ngữ (I18n)

---

## 🚀 Hướng dẫn cài đặt

### 1️⃣ Clone repository

```bash
git clone https://github.com/ndyudev/java-4-servlet-jsp.git
cd java-4-servlet-jsp
```

### 2️⃣ Cấu hình Database (NẾU SỬ DỤNG DATABASE)

1.  Mở **SQL Server Management Studio (SSMS)**
2.  Chạy file script trong thư mục `database/` (ví dụ: `Poly.sql`)
3.  Cập nhật thông tin kết nối DB:

    **hibernate.cfg.xml** hoặc **DBContext.java**

    ```xml
    <property name="connection.username">sa</property>
    <property name="connection.password">YOUR_PASSWORD</property>
    ```

### 3️⃣ Build & Run

1.  Mở project bằng **IntelliJ IDEA** hoặc **Eclipse** (Import Maven Project)
2.  Đợi Maven tải dependencies
3.  Cấu hình **Tomcat Server**
    - Artifact: `java-4-servlet-jsp:war exploded`
4.  Nhấn **Run / Debug**

---

## ▶️ Cách chạy & Demo

Truy cập trên trình duyệt:

```
http://localhost:8080/java-4-servlet-jsp
```

---

## 🤝 Đóng góp

- Fork repository
- Tạo branch mới
- Commit & tạo Pull Request

Mọi ý kiến đóng góp đều được welcome. Phát hiện bug thì cứ mạnh dạn mở **Issue**.

---

## 👤 Tác giả

**Châu Nhật Duy**

- GitHub: [@ndyudev](https://github.com/ndyudev)
- Facebook: Châu Nhật Duy

---

> Made with ❤️ & ☕ by **ndyudev**
