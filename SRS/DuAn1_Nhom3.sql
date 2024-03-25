CREATE DATABASE DuAn1_Nhom3
GO
USE DuAn1_Nhom3;
GO
CREATE TABLE chat_lieu (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_chat_lieu VARCHAR(255) NULL,
	ten_chat_lieu NVARCHAR(255) NULL,
	trang_thai BIT NULL,
	ngay_tao DATE NULL,
	ngay_sua DATE NULL,
)

CREATE TABLE hinh_anh (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_hinh_anh VARCHAR(255) NULL,
	duong_dan NVARCHAR(255) NULL,
	trang_thai BIT NULL,
	ngay_tao DATE NULL,
	ngay_sua DATE NULL,
)

CREATE TABLE hoa_tiet (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_hoa_tiet VARCHAR(255) NULL,
	ten_hoa_tiet NVARCHAR(255) NULL,
	trang_thai BIT NULL,
	ngay_tao DATE NULL,
	ngay_sua DATE NULL,
)

CREATE TABLE kich_thuoc (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_kich_thuoc VARCHAR(255) NULL,
	ten_kich_thuoc NVARCHAR(255) NULL,
	trang_thai BIT NULL,
	ngay_tao DATE NULL,
	ngay_sua DATE NULL,
)

CREATE TABLE kieu_dang (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_kieu_dang VARCHAR(255) NULL,
	ten_kieu_dang NVARCHAR(255) NULL,
	trang_thai BIT NULL,
	ngay_tao DATE NULL,
	ngay_sua DATE NULL,
)

CREATE TABLE mau_sac (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_mau VARCHAR(255),
	ten_mau NVARCHAR(255),
	trang_thai BIT,
	ngay_tao DATE,
	ngay_sua DATE,
)

CREATE TABLE san_pham (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_san_pham VARCHAR(255) NULL,
	ten_san_pham NVARCHAR(255) NULL,
	trang_thai BIT,
	ngay_tao DATE,
	ngay_sua DATE,
)

CREATE TABLE thuong_hieu (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_thuong_hieu VARCHAR(255) NULL,
	ten_thuong_hieu NVARCHAR(255) NULL,
	trang_thai BIT NULL,
	ngay_tao DATE NULL,
	ngay_sua DATE NULL,
)

CREATE TABLE phieu_giam_gia(
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_phieu VARCHAR(255) NULL,
	ten_phieu NVARCHAR(255) NULL,
	phan_tram_giam DECIMAL(5,2) NULL,
	ngay_bat_dau DATE NULL,
	ngay_ket_thuc DATE NULL,
	trang_thai INT NULL,
	ngay_tao DATE NULL,
	ngay_sua DATE NULL
)
CREATE TABLE khach_hang(
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_khach_hang VARCHAR(255) NULL,
	ten_khach_hang NVARCHAR(255) NULL,
	sdt NVARCHAR(10) NULL,
	ngay_sinh DATE NULL,
	gioi_tinh BIT NULL,
	dia_chi NVARCHAR(255) NULL,
	email VARCHAR(255) NULL,
	cccd VARCHAR(255) NULL,
	trang_thai BIT NULL,
	ngay_tao DATE NULL,
	ngay_sua DATE NULL
)

CREATE TABLE nhan_vien(
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_nhan_vien VARCHAR(255) NULL,
	ten_nhan_vien NVARCHAR(255) NULL,
	mat_khau VARCHAR(20) NULL,
	chuc_vu BIT NULL,
	sdt NVARCHAR(10) NULL,
	ngay_sinh DATE NULL,
	gioi_tinh BIT NULL,
	dia_chi NVARCHAR(255) NULL,
	email VARCHAR(255) NULL,
	cccd VARCHAR(255) NULL,
	trang_thai INT NULL,
	ngay_tao DATE NULL,
	ngay_sua DATE NULL,
)

CREATE TABLE spct(
	id INT IDENTITY(1,1) PRIMARY KEY,
	id_chat_lieu INT NULL,
	id_hinh_anh INT NULL,
	id_hoa_tiet INT NULL,
	id_kich_thuoc INT NULL,
	id_kieu_dang INT NULL,
	id_mau_sac INT NULL,
	id_san_pham INT NULL,
	id_thuong_hieu INT NULL,
	ma_spct VARCHAR(255) NULL,
	so_luong INT NULL,
	gia DECIMAL(18,2) NULL,
	mo_ta NVARCHAR(255) NULL,
	trang_thai INT NULL,
	ngay_tao DATE NULL,
	ngay_sua DATE NULL,
	CONSTRAINT fk_chat_lieu FOREIGN KEY (id_chat_lieu) REFERENCES chat_lieu(id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_hinh_anh FOREIGN KEY (id_hinh_anh) REFERENCES hinh_anh(id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_hoa_tiet FOREIGN KEY (id_hoa_tiet) REFERENCES hoa_tiet(id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_kich_thuoc FOREIGN KEY (id_kich_thuoc) REFERENCES kich_thuoc(id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_kieu_dang FOREIGN KEY (id_kieu_dang) REFERENCES kieu_dang(id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_mau_sac FOREIGN KEY (id_mau_sac) REFERENCES mau_sac(id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_san_pham FOREIGN KEY (id_san_pham) REFERENCES san_pham(id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_thuong_hieu FOREIGN KEY (id_thuong_hieu) REFERENCES thuong_hieu(id) ON UPDATE CASCADE ON DELETE CASCADE
)

CREATE TABLE hoa_don(
	id INT IDENTITY(1,1) PRIMARY KEY,
	id_nhan_vien INT NULL,
	id_khach_hang INT NULL,
	id_phieu_giam_gia INT NULL,
	ma_hoa_don VARCHAR(255) NULL,
	trang_thai INT NULL,
	ngay_tao DATE NULL,
	ngay_sua DATE NULL
	CONSTRAINT fk_nhan_vien FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_khach_hang FOREIGN KEY (id_khach_hang) REFERENCES khach_hang(id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_phieu_giam_gia FOREIGN KEY (id_phieu_giam_gia) REFERENCES phieu_giam_gia(id) ON UPDATE CASCADE ON DELETE CASCADE
)

CREATE TABLE hoa_don_chi_tiet(
	id INT IDENTITY(1,1) PRIMARY KEY,
	id_hoa_don INT NULL,
	id_spct INT NULL,
	so_luong INT NULL,
	don_gia DECIMAL(18, 2) NULL,
	trang_thai BIT NULL,
	ngay_tao DATE NULL,
	ngay_sua DATE NULL
	CONSTRAINT fk_hoa_don FOREIGN KEY (id_hoa_don) REFERENCES hoa_don(id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_spct FOREIGN KEY (id_spct) REFERENCES spct(id) ON UPDATE CASCADE ON DELETE CASCADE
)
select * from nhan_vien

INSERT INTO chat_lieu(ma_chat_lieu, ten_chat_lieu, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (NEWID(), 'Material 1', 1, '2024-03-25', '2024-03-25'),
    (NEWID(), 'Material 2', 1, '2024-03-24', '2024-03-24'),
    (NEWID(), 'Material 3', 1, '2024-03-23', '2024-03-23'),
    (NEWID(), 'Material 4', 1, '2024-03-22', '2024-03-22'),
    (NEWID(), 'Material 5', 1, '2024-03-21', '2024-03-21'),
    (NEWID(), 'Material 6', 1, '2024-03-20', '2024-03-20'),
    (NEWID(), 'Material 7', 1, '2024-03-19', '2024-03-19'),
    (NEWID(), 'Material 8', 1, '2024-03-18', '2024-03-18'),
    (NEWID(), 'Material 9', 1, '2024-03-17', '2024-03-17'),
    (NEWID(), 'Material 10', 1, '2024-03-16', '2024-03-16');


INSERT INTO hinh_anh(ma_hinh_anh, duong_dan, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (NEWID(), 'https://example.com/image1.jpg', 1, '2024-03-25', '2024-03-25'),
    (NEWID(), 'https://example.com/image2.jpg', 1, '2024-03-24', '2024-03-24'),
    (NEWID(), 'https://example.com/image3.jpg', 1, '2024-03-23', '2024-03-23'),
    (NEWID(), 'https://example.com/image4.jpg', 1, '2024-03-22', '2024-03-22'),
    (NEWID(), 'https://example.com/image5.jpg', 1, '2024-03-21', '2024-03-21'),
    (NEWID(), 'https://example.com/image6.jpg', 1, '2024-03-20', '2024-03-20'),
    (NEWID(), 'https://example.com/image7.jpg', 1, '2024-03-19', '2024-03-19'),
    (NEWID(), 'https://example.com/image8.jpg', 1, '2024-03-18', '2024-03-18'),
    (NEWID(), 'https://example.com/image9.jpg', 1, '2024-03-17', '2024-03-17'),
    (NEWID(), 'https://example.com/image10.jpg', 1, '2024-03-16', '2024-03-16');

INSERT INTO hoa_tiet (ma_hoa_tiet, ten_hoa_tiet, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (NEWID(), 'Pattern 1', 1, '2024-03-25', '2024-03-25'),
    (NEWID(), 'Pattern 2', 1, '2024-03-24', '2024-03-24'),
    (NEWID(), 'Pattern 3', 1, '2024-03-23', '2024-03-23'),
    (NEWID(), 'Pattern 4', 1, '2024-03-22', '2024-03-22'),
    (NEWID(), 'Pattern 5', 1, '2024-03-21', '2024-03-21'),
    (NEWID(), 'Pattern 6', 1, '2024-03-20', '2024-03-20'),
    (NEWID(), 'Pattern 7', 1, '2024-03-19', '2024-03-19'),
    (NEWID(), 'Pattern 8', 1, '2024-03-18', '2024-03-18'),
    (NEWID(), 'Pattern 9', 1, '2024-03-17', '2024-03-17'),
    (NEWID(), 'Pattern 10', 1, '2024-03-16', '2024-03-16');


INSERT INTO kich_thuoc (ma_kich_thuoc, ten_kich_thuoc, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (NEWID(), 'Size 1', 1, '2024-03-25', '2024-03-25'),
    (NEWID(), 'Size 2', 1, '2024-03-24', '2024-03-24'),
    (NEWID(), 'Size 3', 1, '2024-03-23', '2024-03-23'),
    (NEWID(), 'Size 4', 1, '2024-03-22', '2024-03-22'),
    (NEWID(), 'Size 5', 1, '2024-03-21', '2024-03-21'),
    (NEWID(), 'Size 6', 1, '2024-03-20', '2024-03-20'),
    (NEWID(), 'Size 7', 1, '2024-03-19', '2024-03-19'),
    (NEWID(), 'Size 8', 1, '2024-03-18', '2024-03-18'),
    (NEWID(), 'Size 9', 1, '2024-03-17', '2024-03-17'),
    (NEWID(), 'Size 10', 1, '2024-03-16', '2024-03-16');


INSERT INTO kieu_dang (ma_kieu_dang, ten_kieu_dang, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (NEWID(), 'Style 1', 1, '2024-03-25', '2024-03-25'),
    (NEWID(), 'Style 2', 1, '2024-03-24', '2024-03-24'),
    (NEWID(), 'Style 3', 1, '2024-03-23', '2024-03-23'),
    (NEWID(), 'Style 4', 1, '2024-03-22', '2024-03-22'),
    (NEWID(), 'Style 5', 1, '2024-03-21', '2024-03-21'),
    (NEWID(), 'Style 6', 1, '2024-03-20', '2024-03-20'),
    (NEWID(), 'Style 7', 1, '2024-03-19', '2024-03-19'),
    (NEWID(), 'Style 8', 1, '2024-03-18', '2024-03-18'),
    (NEWID(), 'Style 9', 1, '2024-03-17', '2024-03-17'),
    (NEWID(), 'Style 10', 1, '2024-03-16', '2024-03-16');


INSERT INTO mau_sac (ma_mau, ten_mau, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (NEWID(), 'Color 1', 1, '2024-03-25', '2024-03-25'),
    (NEWID(), 'Color 2', 1, '2024-03-24', '2024-03-24'),
    (NEWID(), 'Color 3', 1, '2024-03-23', '2024-03-23'),
    (NEWID(), 'Color 4', 1, '2024-03-22', '2024-03-22'),
    (NEWID(), 'Color 5', 1, '2024-03-21', '2024-03-21'),
    (NEWID(), 'Color 6', 1, '2024-03-20', '2024-03-20'),
    (NEWID(), 'Color 7', 1, '2024-03-19', '2024-03-19'),
    (NEWID(), 'Color 8', 1, '2024-03-18', '2024-03-18'),
    (NEWID(), 'Color 9', 1, '2024-03-17', '2024-03-17'),
    (NEWID(), 'Color 10', 1, '2024-03-16', '2024-03-16');


INSERT INTO san_pham (ma_san_pham, ten_san_pham, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (NEWID(), 'Product 1', 1, '2024-03-25', '2024-03-25'),
    (NEWID(), 'Product 2', 1, '2024-03-24', '2024-03-24'),
    (NEWID(), 'Product 3', 1, '2024-03-23', '2024-03-23'),
    (NEWID(), 'Product 4', 1, '2024-03-22', '2024-03-22'),
    (NEWID(), 'Product 5', 1, '2024-03-21', '2024-03-21'),
    (NEWID(), 'Product 6', 1, '2024-03-20', '2024-03-20'),
    (NEWID(), 'Product 7', 1, '2024-03-19', '2024-03-19'),
    (NEWID(), 'Product 8', 1, '2024-03-18', '2024-03-18'),
    (NEWID(), 'Product 9', 1, '2024-03-17', '2024-03-17'),
    (NEWID(), 'Product 10', 1, '2024-03-16', '2024-03-16');


INSERT INTO thuong_hieu (ma_thuong_hieu, ten_thuong_hieu, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (NEWID(), 'Brand 1', 1, '2024-03-25', '2024-03-25'),
    (NEWID(), 'Brand 2', 1, '2024-03-24', '2024-03-24'),
    (NEWID(), 'Brand 3', 1, '2024-03-23', '2024-03-23'),
    (NEWID(), 'Brand 4', 1, '2024-03-22', '2024-03-22'),
    (NEWID(), 'Brand 5', 1, '2024-03-21', '2024-03-21'),
    (NEWID(), 'Brand 6', 1, '2024-03-20', '2024-03-20'),
    (NEWID(), 'Brand 7', 1, '2024-03-19', '2024-03-19'),
    (NEWID(), 'Brand 8', 1, '2024-03-18', '2024-03-18'),
    (NEWID(), 'Brand 9', 1, '2024-03-17', '2024-03-17'),
    (NEWID(), 'Brand 10', 1, '2024-03-16', '2024-03-16');


INSERT INTO phieu_giam_gia (ma_phieu, ten_phieu, phan_tram_giam, ngay_bat_dau, ngay_ket_thuc, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (NEWID(), 'Discount 1', 10.00, '2024-03-25', '2024-04-25', 1, '2024-03-25', '2024-03-25'),
    (NEWID(), 'Discount 2', 15.00, '2024-03-24', '2024-04-24', 1, '2024-03-24', '2024-03-24'),
    (NEWID(), 'Discount 3', 20.00, '2024-03-23', '2024-04-23', 1, '2024-03-23', '2024-03-23'),
    (NEWID(), 'Discount 4', 25.00, '2024-03-22', '2024-04-22', 1, '2024-03-22', '2024-03-22'),
    (NEWID(), 'Discount 5', 30.00, '2024-03-21', '2024-04-21', 1, '2024-03-21', '2024-03-21'),
    (NEWID(), 'Discount 6', 35.00, '2024-03-20', '2024-04-20', 1, '2024-03-20', '2024-03-20'),
    (NEWID(), 'Discount 7', 40.00, '2024-03-19', '2024-04-19', 1, '2024-03-19', '2024-03-19'),
    (NEWID(), 'Discount 8', 45.00, '2024-03-18', '2024-04-18', 1, '2024-03-18', '2024-03-18'),
    (NEWID(), 'Discount 9', 50.00, '2024-03-17', '2024-04-17', 1, '2024-03-17', '2024-03-17'),
    (NEWID(), 'Discount 10', 55.00, '2024-03-16', '2024-04-16', 1, '2024-03-16', '2024-03-16');

INSERT INTO khach_hang (ma_khach_hang, ten_khach_hang, sdt, ngay_sinh, gioi_tinh, dia_chi, email, cccd, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (NEWID(), 'Customer 1', '1234567890', '1990-01-01', 1, 'Address 1', 'customer1@example.com', '123456789', 1, '2024-03-25', '2024-03-25'),
    (NEWID(), 'Customer 2', '1234567891', '1991-02-02', 0, 'Address 2', 'customer2@example.com', '123456788', 1, '2024-03-24', '2024-03-24'),
    (NEWID(), 'Customer 3', '1234567892', '1992-03-03', 1, 'Address 3', 'customer3@example.com', '123456787', 1, '2024-03-23', '2024-03-23'),
    (NEWID(), 'Customer 4', '1234567893', '1993-04-04', 0, 'Address 4', 'customer4@example.com', '123456786', 1, '2024-03-22', '2024-03-22'),
    (NEWID(), 'Customer 5', '1234567894', '1994-05-05', 1, 'Address 5', 'customer5@example.com', '123456785', 1, '2024-03-21', '2024-03-21'),
    (NEWID(), 'Customer 6', '1234567895', '1995-06-06', 0, 'Address 6', 'customer6@example.com', '123456784', 1, '2024-03-20', '2024-03-20'),
    (NEWID(), 'Customer 7', '1234567896', '1996-07-07', 1, 'Address 7', 'customer7@example.com', '123456783', 1, '2024-03-19', '2024-03-19'),
    (NEWID(), 'Customer 8', '1234567897', '1997-08-08', 0, 'Address 8', 'customer8@example.com', '123456782', 1, '2024-03-18', '2024-03-18'),
    (NEWID(), 'Customer 9', '1234567898', '1998-09-09', 1, 'Address 9', 'customer9@example.com', '123456781', 1, '2024-03-17', '2024-03-17'),
    (NEWID(), 'Customer 10', '1234567899', '1999-10-10', 0, 'Address 10', 'customer10@example.com', '123456780', 1, '2024-03-16', '2024-03-16');


INSERT INTO spct (id_chat_lieu, id_hinh_anh, id_hoa_tiet, id_kich_thuoc, id_kieu_dang, id_mau_sac, id_san_pham, id_thuong_hieu, ma_spct, so_luong, gia, mo_ta, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (1, 1, 1, 1, 1, 1, 1, 1, NEWID(), 10, 100.00, 'Description 1', 1, '2024-03-25', '2024-03-25'),
    (2, 2, 2, 2, 2, 2, 2, 2, NEWID(), 20, 200.00, 'Description 2', 1, '2024-03-24', '2024-03-24'),
    (3, 3, 3, 3, 3, 3, 3, 3, NEWID(), 30, 300.00, 'Description 3', 1, '2024-03-23', '2024-03-23'),
    (4, 4, 4, 4, 4, 4, 4, 4, NEWID(), 40, 400.00, 'Description 4', 1, '2024-03-22', '2024-03-22'),
    (5, 5, 5, 5, 5, 5, 5, 5, NEWID(), 50, 500.00, 'Description 5', 1, '2024-03-21', '2024-03-21'),
    (6, 6, 6, 6, 6, 6, 6, 6, NEWID(), 60, 600.00, 'Description 6', 1, '2024-03-20', '2024-03-20'),
    (7, 7, 7, 7, 7, 7, 7, 7, NEWID(), 70, 700.00, 'Description 7', 1, '2024-03-19', '2024-03-19'),
    (8, 8, 8, 8, 8, 8, 8, 8, NEWID(), 80, 800.00, 'Description 8', 1, '2024-03-18', '2024-03-18'),
    (9, 9, 9, 9, 9, 9, 9, 9, NEWID(), 90, 900.00, 'Description 9', 1, '2024-03-17', '2024-03-17'),
    (10, 10, 10, 10, 10, 10, 10, 10, NEWID(), 100, 1000.00, 'Description 10', 1, '2024-03-16', '2024-03-16');

INSERT INTO nhan_vien (ma_nhan_vien, ten_nhan_vien, mat_khau, chuc_vu, sdt, ngay_sinh, gioi_tinh, dia_chi, email, cccd, trang_thai, ngay_tao, ngay_sua)
VALUES
    ('NV001', N'Nhân viên 1', 'password1', 1, '1234567890', '1990-01-01', 1, N'Địa chỉ 1', 'nhanvien1@example.com', '123456789', 1, '2024-03-25', '2024-03-25'),
    ('NV002', N'Nhân viên 2', 'password2', 0, '1234567891', '1991-02-02', 0, N'Địa chỉ 2', 'nhanvien2@example.com', '123456788', 1, '2024-03-24', '2024-03-24'),
    ('NV003', N'Nhân viên 3', 'password3', 1, '1234567892', '1992-03-03', 1, N'Địa chỉ 3', 'nhanvien3@example.com', '123456787', 1, '2024-03-23', '2024-03-23'),
    ('NV004', N'Nhân viên 4', 'password4', 0, '1234567893', '1993-04-04', 0, N'Địa chỉ 4', 'nhanvien4@example.com', '123456786', 1, '2024-03-22', '2024-03-22'),
    ('NV005', N'Nhân viên 5', 'password5', 1, '1234567894', '1994-05-05', 1, N'Địa chỉ 5', 'nhanvien5@example.com', '123456785', 1, '2024-03-21', '2024-03-21'),
    ('NV006', N'Nhân viên 6', 'password6', 0, '1234567895', '1995-06-06', 0, N'Địa chỉ 6', 'nhanvien6@example.com', '123456784', 1, '2024-03-20', '2024-03-20'),
    ('NV007', N'Nhân viên 7', 'password7', 1, '1234567896', '1996-07-07', 1, N'Địa chỉ 7', 'nhanvien7@example.com', '123456783', 1, '2024-03-19', '2024-03-19'),
    ('NV008', N'Nhân viên 8', 'password8', 0, '1234567897', '1997-08-08', 0, N'Địa chỉ 8', 'nhanvien8@example.com', '123456782', 1, '2024-03-18', '2024-03-18'),
    ('NV009', N'Nhân viên 9', 'password9', 1, '1234567898', '1998-09-09', 1, N'Địa chỉ 9', 'nhanvien9@example.com', '123456781', 1, '2024-03-17', '2024-03-17'),
    ('NV010', N'Nhân viên 10', 'password10', 0, '1234567899', '1999-10-10', 0, N'Địa chỉ 10', 'nhanvien10@example.com', '123456780', 1, '2024-03-16', '2024-03-16');

INSERT INTO hoa_don (id_nhan_vien, id_khach_hang, id_phieu_giam_gia, ma_hoa_don, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (1, 1, 1, NEWID(), 1, '2024-03-25', '2024-03-25'),
    (2, 2, 2, NEWID(), 1, '2024-03-24', '2024-03-24'),
    (3, 3, 3, NEWID(), 1, '2024-03-23', '2024-03-23'),
    (4, 4, 4, NEWID(), 1, '2024-03-22', '2024-03-22'),
    (5, 5, 5, NEWID(), 1, '2024-03-21', '2024-03-21'),
    (6, 6, 6, NEWID(), 1, '2024-03-20', '2024-03-20'),
    (7, 7, 7, NEWID(), 1, '2024-03-19', '2024-03-19'),
    (8, 8, 8, NEWID(), 1, '2024-03-18', '2024-03-18'),
    (9, 9, 9, NEWID(), 1, '2024-03-17', '2024-03-17'),
    (10, 10, 10, NEWID(), 1, '2024-03-16', '2024-03-16');


INSERT INTO hoa_don_chi_tiet (id_hoa_don, id_spct, so_luong, don_gia, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (1, 1, 5, 100.00, 1, '2024-03-25', '2024-03-25'),
    (2, 2, 10, 200.00, 1, '2024-03-24', '2024-03-24'),
    (3, 3, 15, 300.00, 1, '2024-03-23', '2024-03-23'),
    (4, 4, 20, 400.00, 1, '2024-03-22', '2024-03-22'),
    (5, 5, 25, 500.00, 1, '2024-03-21', '2024-03-21'),
    (6, 6, 30, 600.00, 1, '2024-03-20', '2024-03-20'),
    (7, 7, 35, 700.00, 1, '2024-03-19', '2024-03-19'),
    (8, 8, 40, 800.00, 1, '2024-03-18', '2024-03-18'),
    (9, 9, 45, 900.00, 1, '2024-03-17', '2024-03-17'),
    (10, 10, 50, 1000.00, 1, '2024-03-16', '2024-03-16');

/* XOÁ DỮ LIỆU
DELETE FROM chat_lieu
DELETE FROM hinh_anh
DELETE FROM hoa_don
DELETE FROM hoa_don_chi_tiet
DELETE FROM hoa_tiet
DELETE FROM khach_hang
DELETE FROM kich_thuoc
DELETE FROM kieu_dang
DELETE FROM mau_sac
DELETE FROM nhan_vien
DELETE FROM phieu_giam_gia
DELETE FROM san_pham
DELETE FROM spct
DELETE FROM thuong_hieu
*/