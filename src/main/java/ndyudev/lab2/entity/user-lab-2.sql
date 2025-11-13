CREATE DATABASE Slider_1_Student
drop database Slider_1_Student
use Slider_1_Student
use java3_servlet_jsp

CREATE TABLE students (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(50) NOT NULL,
    salary FLOAT CHECK (salary >= 0)
);

select * from students

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

INSERT INTO Users (Id, Password, Fullname, Email, Admin)
VALUES
('U001', '123456', N'Châu Nhật Duy', 'duy@example.com', 1),
('U002', 'pass002', N'Nguyễn Minh Anh', 'minhanh@gmail.com', 0),
('U003', 'pass003', N'Lê Hoàng Nam', 'nam.le@gmail.com', 0),
('U004', 'pass004', N'Trần Thu Hằng', 'hangtran@gmail.com', 0),
('U005', 'pass005', N'Phạm Đức Toàn', 'toanpham@gmail.com', 1),
('U006', 'pass006', N'Đỗ Ngọc Linh', 'linhdn@gmail.com', 0),
('U007', 'pass007', N'Vũ Thanh Tùng', 'tungvu@gmail.com', 0),
('U008', 'pass008', N'Ngô Quỳnh Trang', 'trangngo@gmail.com', 0),
('U009', 'pass009', N'Lâm Hải Nam', 'hailam@gmail.com', 1),
('U010', 'pass010', N'Đinh Bảo Ngọc', 'ngocbao@gmail.com', 0),  -- ✅ thêm dấu phẩy ở đây
('U011', 'fpt011', N'Nguyễn Hoài Phương', 'phuongnh@fpt.edu.vn', 0),
('U012', 'fpt012', N'Lê Thanh Bình', 'binhlt@fpt.edu.vn', 1),
('U013', 'fpt013', N'Trần Anh Tuấn', 'tuanta@fpt.edu.vn', 0),
('U014', 'fpt014', N'Đỗ Thảo My', 'mydt@fpt.edu.vn', 0),
('U015', 'fpt015', N'Phạm Hữu Tài', 'taiph@fpt.edu.vn', 1);


select * from users

-- DỮ LIỆU MẪU VIDEO
INSERT INTO Video (Id, Title, Poster, Views, Description, Active)
VALUES
('V001', N'Học Java Servlet Cơ Bản', 'poster1.jpg', 1250, N'Hướng dẫn cơ bản về Java Servlet', 1),
('V002', N'Lập trình JSP nâng cao', 'poster2.jpg', 980, N'Ứng dụng JSP trong dự án thực tế', 1),
('V003', N'Học SQL Server cho Developer', 'poster3.jpg', 2000, N'Trọn bộ kiến thức SQL cho lập trình viên', 1),
('V004', N'Thiết kế giao diện web với Bootstrap', 'poster4.jpg', 860, N'Xây dựng web responsive với Bootstrap', 1),
('V005', N'Học Spring Boot toàn tập', 'poster5.jpg', 3200, N'Từ cơ bản đến nâng cao với Spring Boot', 1);
GO

-- DỮ LIỆU MẪU FAVORITE
INSERT INTO Favorite (UserId, VideoId, LikeDate)
VALUES
('U001', 'V001', '2024-05-01'),
('U002', 'V003', '2024-05-02'),
('U003', 'V005', '2024-05-03'),
('U004', 'V002', '2024-05-04'),
('U005', 'V001', '2024-05-05'),
('U006', 'V004', '2024-05-06'),
('U007', 'V002', '2024-05-07'),
('U008', 'V003', '2024-05-08'),
('U009', 'V005', '2024-05-09'),
('U010', 'V001', '2024-05-10');
GO

-- DỮ LIỆU MẪU SHARE
INSERT INTO Share (UserId, VideoId, Emails, ShareDate)
VALUES
('U001', 'V001', 'friend1@gmail.com', '2024-06-01'),
('U002', 'V002', 'friend2@gmail.com', '2024-06-02'),
('U003', 'V003', 'friend3@gmail.com', '2024-06-03'),
('U004', 'V004', 'friend4@gmail.com', '2024-06-04'),
('U005', 'V005', 'friend5@gmail.com', '2024-06-05'),
('U006', 'V001', 'friend6@gmail.com', '2024-06-06'),
('U007', 'V002', 'friend7@gmail.com', '2024-06-07'),
('U008', 'V003', 'friend8@gmail.com', '2024-06-08'),
('U009', 'V004', 'friend9@gmail.com', '2024-06-09'),
('U010', 'V005', 'friend10@gmail.com', '2024-06-10');
GO

-- XEM DỮ LIỆU
SELECT * FROM Users;
SELECT * FROM Video;
SELECT * FROM Favorite;
SELECT * FROM Share;