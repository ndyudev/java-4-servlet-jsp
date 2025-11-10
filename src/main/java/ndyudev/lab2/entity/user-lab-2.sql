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
('U010', 'pass010', N'Đinh Bảo Ngọc', 'ngocbao@gmail.com', 0),

('U011', 'fpt011', N'Nguyễn Hoài Phương', 'phuongnh@fpt.edu.vn', 0),
('U012', 'fpt012', N'Lê Thanh Bình', 'binhlt@fpt.edu.vn', 1),
('U013', 'fpt013', N'Trần Anh Tuấn', 'tuanta@fpt.edu.vn', 0),
('U014', 'fpt014', N'Đỗ Thảo My', 'mydt@fpt.edu.vn', 0),
('U015', 'fpt015', N'Phạm Hữu Tài', 'taiph@fpt.edu.vn', 1);

select * from users