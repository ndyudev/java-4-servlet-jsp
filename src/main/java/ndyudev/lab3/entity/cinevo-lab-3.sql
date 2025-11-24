CREATE DATABASE java_4_servlet_jsp
drop database java_4_servlet_jsp
use java_4_servlet_jsp
-- use java3_servlet_jsp

CREATE TABLE students (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(50) NOT NULL,
    salary FLOAT CHECK (salary >= 0)
);

select * from students;
SELECT u.id, u.password, u.Fullname
FROM users u
WHERE u.id LIKE 'u00%';

select * from Users

CREATE TABLE Users (
    Id NVARCHAR(20) NOT NULL,
    Password NVARCHAR(50) NOT NULL,
    Fullname NVARCHAR(50) NOT NULL,
    Email NVARCHAR(50) NOT NULL,
    Admin BIT NOT NULL,
    PRIMARY KEY (Id)
);

-- BẢNG VIDEO
CREATE TABLE Video (
    Id NVARCHAR(50) PRIMARY KEY,
    Title NVARCHAR(200) NOT NULL,
    Poster NVARCHAR(255),
    Views INT DEFAULT 0 CHECK (Views >= 0),
    Description NVARCHAR(MAX),
    Active BIT DEFAULT 1
);
GO

-- BẢNG FAVORITE
CREATE TABLE Favorite (
    Id BIGINT IDENTITY(1,1) PRIMARY KEY,
    UserId NVARCHAR(20) NOT NULL,
    VideoId NVARCHAR(50) NOT NULL,
    LikeDate DATE DEFAULT GETDATE(),
    FOREIGN KEY (UserId) REFERENCES Users(Id),
    FOREIGN KEY (VideoId) REFERENCES Video(Id)
);
GO

-- BẢNG SHARE
CREATE TABLE Share (
    Id BIGINT IDENTITY(1,1) PRIMARY KEY,
    UserId NVARCHAR(20) NOT NULL,
    VideoId NVARCHAR(50) NOT NULL,
    Emails NVARCHAR(255) NOT NULL,
    ShareDate DATE DEFAULT GETDATE(),
    FOREIGN KEY (UserId) REFERENCES Users(Id),
    FOREIGN KEY (VideoId) REFERENCES Video(Id)
);
GO

-- 1. THÊM 20 USERS (Đủ admin và user thường)
INSERT INTO Users (Id, Password, Fullname, Email, Admin) VALUES
('U001', '123', N'Châu Nhật Duy', 'duy@example.com', 1),
('U002', '123', N'Nguyễn Minh Anh', 'minhanh@gmail.com', 0),
('U003', '123', N'Lê Hoàng Nam', 'nam.le@gmail.com', 0),
('U004', '123', N'Trần Thu Hằng', 'hangtran@gmail.com', 0),
('U005', '123', N'Phạm Đức Toàn', 'toanpham@gmail.com', 1),
('U006', '123', N'Đỗ Ngọc Linh', 'linhdn@gmail.com', 0),
('U007', '123', N'Vũ Thanh Tùng', 'tungvu@gmail.com', 0),
('U008', '123', N'Ngô Quỳnh Trang', 'trangngo@gmail.com', 0),
('U009', '123', N'Lâm Hải Nam', 'hailam@gmail.com', 1),
('U010', '123', N'Đinh Bảo Ngọc', 'ngocbao@gmail.com', 0),
('U011', '123', N'Nguyễn Hoài Phương', 'phuongnh@fpt.edu.vn', 0),
('U012', '123', N'Lê Thanh Bình', 'binhlt@fpt.edu.vn', 1),
('U013', '123', N'Trần Anh Tuấn', 'tuanta@fpt.edu.vn', 0),
('U014', '123', N'Đỗ Thảo My', 'mydt@fpt.edu.vn', 0),
('U015', '123', N'Phạm Hữu Tài', 'taiph@fpt.edu.vn', 1),
('U016', '123', N'Hoàng Văn Thụ', 'thuhv@gmail.com', 0),
('U017', '123', N'Trương Vô Kỵ', 'kytv@gmail.com', 0),
('U018', '123', N'Lý Mạc Sầu', 'saulm@gmail.com', 0),
('U019', '123', N'Quách Tĩnh', 'tinhq@gmail.com', 0),
('U020', '123', N'Hoàng Dung', 'dungh@gmail.com', 1);
GO

-- 2. THÊM 15 VIDEOS (Đủ loại: view cao, view thấp, ẩn, hiện)
INSERT INTO Video (Id, Title, Poster, Views, Description, Active) VALUES
('V001', N'Học Java Servlet Cơ Bản', 'poster1.jpg', 1250, N'Hướng dẫn cơ bản về Java Servlet từ A-Z', 1),
('V002', N'Lập trình JSP nâng cao', 'poster2.jpg', 980, N'Ứng dụng JSP/JSTL trong dự án thực tế FPT Polytechnic', 1),
('V003', N'Học SQL Server cho Developer', 'poster3.jpg', 5000, N'Trọn bộ kiến thức SQL, Stored Proc, Trigger', 1),
('V004', N'Thiết kế web với Bootstrap 5', 'poster4.jpg', 860, N'Xây dựng web responsive đẹp mắt nhanh chóng', 1),
('V005', N'Spring Boot & Microservices', 'poster5.jpg', 3200, N'Kiến trúc Microservices với Spring Boot 3.0', 1),
('V006', N'Lập trình ReactJS 2024', 'poster6.jpg', 4100, N'Khóa học ReactJS Hooks, Redux mới nhất', 1),
('V007', N'NodeJS & ExpressJS REST API', 'poster7.jpg', 2100, N'Xây dựng Backend mạnh mẽ với NodeJS', 1),
('V008', N'Lập trình C# .NET Core API', 'poster8.jpg', 1500, N'Hướng dẫn Web API với .NET 8', 1),
('V009', N'DevOps với Docker & Kubernetes', 'poster9.jpg', 600, N'Triển khai ứng dụng Container hóa', 1),
('V010', N'Python cho Trí tuệ nhân tạo (AI)', 'poster10.jpg', 8000, N'Machine Learning cơ bản với Python', 1),
('V011', N'HTML5 & CSS3 Hiệu ứng đẹp', 'poster11.jpg', 300, N'Các thủ thuật CSS Animation', 1),
('V012', N'Angular Framework toàn tập', 'poster12.jpg', 1100, N'Xây dựng Single Page Application với Angular', 1),
('V013', N'Git & Github cho người đi làm', 'poster13.jpg', 50, N'Quản lý mã nguồn chuyên nghiệp', 1),
('V014', N'Kỹ năng phỏng vấn IT', 'poster14.jpg', 0, N'Video này chưa có ai xem', 1), -- Test view = 0
('V015', N'Video Bị Ẩn (Deleted)', 'poster15.jpg', 100, N'Video này đã set Active = 0', 0); -- Test Active = 0
GO

-- 3. THÊM FAVORITES (Tạo dữ liệu để test Like, test IS EMPTY)
-- Lưu ý: V013, V014, V015 sẽ KHÔNG có like nào để test chức năng "Video không ai thích"
INSERT INTO Favorite (UserId, VideoId, LikeDate) VALUES
('U001', 'V001', '2024-05-01'), ('U001', 'V003', '2024-05-02'),
('U002', 'V003', '2024-05-02'), ('U002', 'V001', '2024-05-05'),
('U003', 'V005', '2024-05-03'), ('U003', 'V010', '2024-05-10'),
('U004', 'V002', '2024-05-04'), ('U004', 'V006', '2024-05-11'),
('U005', 'V001', '2024-05-05'), ('U005', 'V005', '2024-05-09'),
('U006', 'V004', '2024-05-06'), ('U006', 'V007', '2024-05-12'),
('U007', 'V002', '2024-05-07'), ('U007', 'V008', '2024-05-13'),
('U008', 'V003', '2024-05-08'), ('U008', 'V010', '2024-05-14'),
('U009', 'V005', '2024-05-09'), ('U009', 'V011', '2024-05-15'),
('U010', 'V001', '2024-05-10'), ('U010', 'V012', '2024-05-16'),
('U011', 'V003', '2024-05-17'), ('U012', 'V003', '2024-05-17'), -- V003 nhiều like
('U013', 'V010', '2024-05-18'), ('U014', 'V010', '2024-05-18'), -- V010 nhiều like
('U015', 'V006', '2024-05-19'), ('U016', 'V006', '2024-05-19');
GO

-- 4. THÊM SHARES
INSERT INTO Share (UserId, VideoId, Emails, ShareDate) VALUES
('U001', 'V001', 'friend1@gmail.com', '2024-06-01'),
('U002', 'V002', 'friend2@gmail.com', '2024-06-02'),
('U003', 'V003', 'friend3@gmail.com', '2024-06-03'),
('U004', 'V004', 'friend4@gmail.com', '2024-06-04'),
('U005', 'V005', 'friend5@gmail.com', '2024-06-05'),
('U006', 'V010', 'friend6@gmail.com', '2024-06-06'),
('U007', 'V010', 'friend7@gmail.com', '2024-06-07'),
('U008', 'V006', 'friend8@gmail.com', '2024-06-08'),
('U009', 'V006', 'friend9@gmail.com', '2024-06-09'),
('U010', 'V008', 'friend10@gmail.com', '2024-06-10'),
('U001', 'V003', 'boss@gmail.com', '2024-06-11');
-- XEM DỮ LIỆU
SELECT * FROM Users;
SELECT * FROM Video;
SELECT * FROM Favorite;
SELECT * FROM Share;