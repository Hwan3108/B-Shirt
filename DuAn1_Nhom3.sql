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
/* SELECT DỮ LIỆU
SELECT * FROM chat_lieu
SELECT * FROM hinh_anh
SELECT * FROM hoa_don
SELECT * FROM hoa_don_chi_tiet
SELECT * FROM hoa_tiet
SELECT * FROM khach_hang
SELECT * FROM kich_thuoc
SELECT * FROM kieu_dang
SELECT * FROM mau_sac
SELECT * FROM nhan_vien
SELECT * FROM phieu_giam_gia
SELECT * FROM san_pham
SELECT * FROM spct
SELECT * FROM thuong_hieu
*/
SELECT * FROM hoa_don where trang_thai = 2
select DISTINCT ma_hoa_don, ten_nhan_vien, ten_khach_hang, phan_tram_giam, pttt, hoa_don.trang_thai, san_pham.ten_san_pham ,hoa_don.ngay_tao, hoa_don_chi_tiet.so_luong, don_gia from hoa_don inner join nhan_vien on hoa_don.id_nhan_vien = nhan_vien.id 
inner join khach_hang on hoa_don.id_khach_hang = khach_hang.id
inner join phieu_giam_gia on hoa_don.id_phieu_giam_gia = phieu_giam_gia.id
inner join hoa_don_chi_tiet on hoa_don.id = hoa_don_chi_tiet.id_hoa_don
inner join spct on spct.id = hoa_don_chi_tiet.id_spct
inner join san_pham on san_pham.id = spct.id_san_pham
where hoa_don.trang_thai = 1



select duong_dan from hinh_anh where ma_hinh_anh = ''
select ma_phieu from phieu_giam_gia where trang_thai = 1
SELECT ma_nhan_vien FROM nhan_vien
select sdt from khach_hang where ten_khach_hang like N'%Lê Anh%'
select * from khach_hang where ma_khach_hang like N'%Lê Anh%' or ten_khach_hang like N'%Nguyễn Thị Bình%' or sdt like '%%' or email like '%%' or cccd like '%%'
SELECT hinh_anh.duong_dan
FROM hinh_anh
JOIN spct ON hinh_anh.id = spct.id_hinh_anh
WHERE spct.id = 1;
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
	mo_ta NVARCHAR(255) NULL,
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
ALTER TABLE spct ADD CONSTRAINT check_so_luong CHECK (so_luong >= 0);
CREATE TABLE hoa_don(
	id INT IDENTITY(1,1) PRIMARY KEY,
	id_nhan_vien INT NULL,
	id_khach_hang INT NULL,
	id_phieu_giam_gia INT NULL,
	ma_hoa_don VARCHAR(255) NULL,
	pttt BIT NULL,
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

INSERT INTO chat_lieu (ma_chat_lieu, ten_chat_lieu, trang_thai, ngay_tao, ngay_sua)
VALUES 
    ('CL001', N'Lụa', 1, '2024-03-01', '2024-03-01'),
    ('CL002', N'Len', 1, '2024-03-02', '2024-03-02'),
    ('CL003', N'Bông', 1, '2024-03-03', '2024-03-03'),
    ('CL004', N'Da lộn', 1, '2024-03-04', '2024-03-04'),
    ('CL005', N'Vải bông', 1, '2024-03-05', '2024-03-05'),
    ('CL006', N'Nỉ', 1, '2024-03-06', '2024-03-06'),
    ('CL007', N'Cashmere', 1, '2024-03-07', '2024-03-07'),
    ('CL008', N'Jean', 1, '2024-03-08', '2024-03-08'),
    ('CL009', N'Satin', 1, '2024-03-09', '2024-03-09'),
    ('CL010', N'Organza', 1, '2024-03-10', '2024-03-10');
    
INSERT INTO hinh_anh (ma_hinh_anh, duong_dan, trang_thai, ngay_tao, ngay_sua)
VALUES 
    ('HA001', N'/images/image1.jpg', 1, '2024-03-30', '2024-03-30'),
    ('HA002', N'/images/image2.jpg', 1, '2024-03-30', '2024-03-30'),
    ('HA003', N'/images/image3.jpg', 1, '2024-03-30', '2024-03-30'),
    ('HA004', N'/images/image4.jpg', 1, '2024-03-30', '2024-03-30'),
    ('HA005', N'/images/image5.jpg', 1, '2024-03-30', '2024-03-30'),
    ('HA006', N'/images/image6.jpg', 1, '2024-03-30', '2024-03-30'),
    ('HA007', N'/images/image7.jpg', 1, '2024-03-30', '2024-03-30'),
    ('HA008', N'/images/image8.jpg', 1, '2024-03-30', '2024-03-30'),
    ('HA009', N'/images/image9.jpg', 1, '2024-03-30', '2024-03-30'),
    ('HA010', N'/images/image10.jpg', 1, '2024-03-30', '2024-03-30');

INSERT INTO hoa_tiet (ma_hoa_tiet, ten_hoa_tiet, trang_thai, ngay_tao, ngay_sua)
VALUES 
    ('HT001', N'Hoa cúc', 1, '2024-03-01', '2024-03-01'),
    ('HT002', N'Đường kẻ', 1, '2024-03-02', '2024-03-02'),
    ('HT003', N'Hoạ tiết họa tiết', 1, '2024-03-03', '2024-03-03'),
    ('HT004', N'Chấm bi', 1, '2024-03-04', '2024-03-04'),
    ('HT005', N'Hoa lá', 1, '2024-03-05', '2024-03-05'),
    ('HT006', N'Cọ', 1, '2024-03-06', '2024-03-06'),
    ('HT007', N'Dáng vẽ', 1, '2024-03-07', '2024-03-07'),
    ('HT008', N'Chấm đường', 1, '2024-03-08', '2024-03-08'),
    ('HT009', N'Sọc', 1, '2024-03-09', '2024-03-09'),
    ('HT010', N'Hoạ tiết họa tiết', 1, '2024-03-10', '2024-03-10');

INSERT INTO kich_thuoc (ma_kich_thuoc, ten_kich_thuoc, trang_thai, ngay_tao, ngay_sua)
VALUES 
    ('KT001', N'S', 1, '2024-03-01', '2024-03-01'),
    ('KT002', N'M', 1, '2024-03-02', '2024-03-02'),
    ('KT003', N'L', 1, '2024-03-03', '2024-03-03'),
    ('KT004', N'XL', 1, '2024-03-04', '2024-03-04'),
    ('KT005', N'XXL', 1, '2024-03-05', '2024-03-05'),
    ('KT006', N'XXXL', 1, '2024-03-06', '2024-03-06'),
    ('KT007', N'34', 1, '2024-03-07', '2024-03-07'),
    ('KT008', N'36', 1, '2024-03-08', '2024-03-08'),
    ('KT009', N'38', 1, '2024-03-09', '2024-03-09'),
    ('KT010', N'40', 1, '2024-03-10', '2024-03-10');

INSERT INTO kieu_dang (ma_kieu_dang, ten_kieu_dang, trang_thai, ngay_tao, ngay_sua) 
VALUES 
	('KD001', N'Cổ V', 1, '2024-03-01', '2024-03-01'),
	('KD002', N'Cổ thuyền', 0, '2024-03-02', '2024-03-02'),
	('KD003', N'Cổ tim', 1, '2024-03-03', '2024-03-03'),
	('KD004', N'Có nón', 0, '2024-03-04', '2024-03-04'),
	('KD005', N'Áo polo', 1, '2024-03-05', '2024-03-05'),
	('KD006', N'Hình in', 0, '2024-03-06', '2024-03-06'),
	('KD007', N'Tay dài', 1, '2024-03-07', '2024-03-07'),
	('KD008', N'Có nút', 0, '2024-03-08', '2024-03-08'),
	('KD009', N'Áo ba lỗ', 1, '2024-03-09', '2024-03-09'),
	('KD010', N'Áo thun cổ tròn, có nút', 0, '2024-03-10', '2024-03-10');

INSERT INTO mau_sac (ma_mau, ten_mau, trang_thai, ngay_tao, ngay_sua) 
VALUES 
	('MS001', N'Đỏ', 1, '2024-03-01', '2024-03-01'),
	('MS002', N'Xanh dương', 0, '2024-03-02', '2024-03-02'),
	('MS003', N'Lục', 1, '2024-03-03', '2024-03-03'),
	('MS004', N'Vàng', 0, '2024-03-04', '2024-03-04'),
	('MS005', N'Tím', 1, '2024-03-05', '2024-03-05'),
	('MS006', N'Cam', 0, '2024-03-06', '2024-03-06'),
	('MS007', N'Hồng', 1, '2024-03-07', '2024-03-07'),
	('MS008', N'Nâu', 0, '2024-03-08', '2024-03-08'),
	('MS009', N'Đen', 1, '2024-03-09', '2024-03-09'),
	('MS010', N'Trắng', 0, '2024-03-10', '2024-03-10');

INSERT INTO san_pham (ma_san_pham, ten_san_pham, trang_thai, ngay_tao, ngay_sua) 
VALUES 
	('SP001', N'Áo thun cổ V trơn cotton Uniqlo', 1, '2024-03-01', '2024-03-01'),
	('SP002', N'Áo polo sọc đứng Lacoste', 0, '2024-03-02', '2024-03-02'),
	('SP003', N'Áo sơ mi dài tay kẻ caro Zara', 1, '2024-03-03', '2024-03-03'),
	('SP004', N'Áo hoodie logo Nike', 0, '2024-03-04', '2024-03-04'),
	('SP005', N'Áo thun graphic Uniqlo', 1, '2024-03-05', '2024-03-05'),
	('SP006', N'Áo sơ mi chambray Mango', 0, '2024-03-06', '2024-03-06'),
	('SP007', N'Áo len dáng dài H&M', 1, '2024-03-07', '2024-03-07'),
	('SP008', N'Áo khoác đơn giản phối màu Gap', 0, '2024-03-08', '2024-03-08'),
	('SP009', N'Áo tank top nữ form rộng Adidas', 1, '2024-03-09', '2024-03-09'),
	('SP010', N'Áo hoodie nam in hình Puma', 0, '2024-03-10', '2024-03-10');

INSERT INTO thuong_hieu (ma_thuong_hieu, ten_thuong_hieu, trang_thai, ngay_tao, ngay_sua) 
VALUES 
	('TH001', N'Uniqlo', 1, '2024-03-01', '2024-03-01'),
	('TH002', N'Lacoste', 0, '2024-03-02', '2024-03-02'),
	('TH003', N'Zara', 1, '2024-03-03', '2024-03-03'),
	('TH004', N'Nike', 0, '2024-03-04', '2024-03-04'),
	('TH005', N'Mango', 1, '2024-03-05', '2024-03-05'),
	('TH006', N'H&M', 0, '2024-03-06', '2024-03-06'),
	('TH007', N'Gap', 1, '2024-03-07', '2024-03-07'),
	('TH008', N'Adidas', 0, '2024-03-08', '2024-03-08'),
	('TH009', N'Puma', 1, '2024-03-09', '2024-03-09'),
	('TH010', N'Converse', 0, '2024-03-10', '2024-03-10');

INSERT INTO phieu_giam_gia (ma_phieu, ten_phieu, phan_tram_giam, ngay_bat_dau, ngay_ket_thuc, mo_ta, trang_thai, ngay_tao, ngay_sua)
VALUES 
    ('123-456-78901', N'Lễ Tết Nguyên Đán', 10.00, '2024-02-01', '2024-02-15', N'Mô tả 1', 1, '2024-02-01', '2024-02-01'),
    ('987-654-32109', N'Ngày Quốc tế Phụ nữ', 15.00, '2024-03-08', '2024-03-08', N'Mô tả 2', 1, '2024-03-08', '2024-03-08'),
    ('456-789-01234', N'Ngày của Mẹ', 20.00, '2024-05-12', '2024-05-12', N'Mô tả 3', 1, '2024-05-12', '2024-05-12'),
    ('234-567-89012', N'Lễ Quốc tế lao động', 25.00, '2024-05-01', '2024-05-01', N'Mô tả 4', 1, '2024-05-01', '2024-05-01'),
    ('567-890-12345', N'Ngày Thể thao Việt Nam', 30.00, '2024-03-27', '2024-03-27', N'Mô tả 5', 1, '2024-03-27', '2024-03-27'),
    ('890-123-45678', N'Ngày Quốc tế Thiếu nhi', 35.00, '2024-06-01', '2024-06-01', N'Mô tả 6', 1, '2024-06-01', '2024-06-01'),
    ('345-678-90123', N'Ngày Halloween', 40.00, '2024-10-31', '2024-10-31', N'Mô tả 7', 1, '2024-10-31', '2024-10-31'),
    ('678-901-23456', N'Black Friday', 45.00, '2024-11-29', '2024-11-29', N'Mô tả 8', 1, '2024-11-29', '2024-11-29'),
    ('901-234-56789', N'Giáng Sinh', 49.00, '2024-12-25', '2024-12-25', N'Mô tả 9', 1, '2024-12-25', '2024-12-25'),
    ('012-345-67890', N'Lễ Tết Dương lịch', 48.00, '2025-01-01', '2025-01-01', N'Mô tả 10', 1, '2025-01-01', '2025-01-01');

INSERT INTO khach_hang (ma_khach_hang, ten_khach_hang, sdt, ngay_sinh, gioi_tinh, dia_chi, email, cccd, trang_thai, ngay_tao, ngay_sua)
VALUES 
    ('LeAnhKH00001', N'Lê Anh', '0987654321', '1990-01-15', 1, N'123 Đường Lê Lợi, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh', 'LeAnhKH00001@gmail.com', '0012-3456-7890', 1, '2024-03-30', '2024-03-30'),
    ('NguyenThiBKH00002', N'Nguyễn Thị Bình', '0987654321', '1995-05-20', 0, N'456 Đường Nguyễn Huệ, Phường Đa Kao, Quận 1, Thành phố Hồ Chí Minh', 'NguyenThiBKH00002@gmail.com', '0023-4567-8901', 1, '2024-03-30', '2024-03-30'),
    ('TranVanCKH00003', N'Trần Văn Cường', '0987654321', '1988-09-10', 1, N'789 Đường Võ Văn Tần, Phường 3, Quận 3, Thành phố Hồ Chí Minh', 'TranVanCKH00003@gmail.com', '0034-5678-9012', 1, '2024-03-30', '2024-03-30'),
    ('PhamThiDanhKH00004', N'Phạm Thị Duyên', '0987654321', '1982-07-05', 0, N'101 Đường Lê Đức Thọ, Phường Mỹ Đình, Quận Nam Từ Liêm, Thành phố Hà Nội', 'PhamThiDanhKH00004@gmail.com', '0045-6789-0123', 1, '2024-03-30', '2024-03-30'),
    ('VuDucEKH00005', N'Vũ Đức Eo', '0987654321', '1993-11-25', 1, N'204 Đường Nguyễn Trãi, Phường Thanh Xuân Trung, Quận Thanh Xuân, Thành phố Hà Nội', 'VuDucEKH00005@gmail.com', '0056-7890-1234', 1, '2024-03-30', '2024-03-30'),
    ('TranGiaFKH00006', N'Trần Gia Ghi', '0987654321', '1997-03-18', 0, N'303 Đường Hoàng Quốc Việt, Phường Cầu Giấy, Quận Cầu Giấy, Thành phố Hà Nội', 'TranGiaFKH00006@gmail.com', '0067-8901-2345', 1, '2024-03-30', '2024-03-30'),
    ('HoangHaiGHKH00007', N'Hoàng Hải Hữu', '0987654321', '1980-12-30', 1, N'888 Đường Hùng Vương, Phường An Lạc, Quận Bình Tân, Thành phố Hồ Chí Minh', 'HoangHaiGHKH00007@gmail.com', '0078-9012-3456', 1, '2024-03-30', '2024-03-30'),
    ('LeVanHHKH00008', N'Lê Văn Hồng', '0987654321', '1984-08-12', 0, N'777 Đường Nguyễn Văn Cừ, Phường An Hòa, Thành phố Hải Phòng', 'LeVanHHKH00008@gmail.com', '0089-0123-4567', 1, '2024-03-30', '2024-03-30'),
    ('NguyenDinhINKH00009', N'Nguyễn Đình Ích', '0987654321', '1990-05-25', 1, N'505 Đường Trần Phú, Phường Lê Lợi, Thành phố Đà Nẵng', 'NguyenDinhINKH00009@gmail.com', '0090-1234-5678', 1, '2024-03-30', '2024-03-30'),
    ('PhanXuanJKH00010', N'Phan Xuân Khoa', '0987654321', '1993-11-25', 1, N'999 Đường Lê Hồng Phong, Phường Phước Hải, Thành phố Nha Trang', 'PhanXuanJKH00010@gmail.com', '0010-2345-6789', 1, '2024-03-30', '2024-03-30');
    
INSERT INTO nhan_vien (ma_nhan_vien, ten_nhan_vien, mat_khau, chuc_vu, sdt, ngay_sinh, gioi_tinh, dia_chi, email, cccd, trang_thai, ngay_tao, ngay_sua)
VALUES 
    ('NguyenAL1', N'Nguyễn Anh Lâm', 'sa', 1, '0987654321', '1990-01-15', 1, N'123 Đường Lê Lợi, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh', 'NguyenALVNV00001@gmail.com', '0012-3456-7890', 1, '2024-03-30', '2024-03-30'),
    ('TranTNB2', N'Trần Thị Ngọc Bích', 'sa', 0, '0987654321', '1995-05-20', 0, N'456 Đường Nguyễn Huệ, Phường Đa Kao, Quận 1, Thành phố Hồ Chí Minh', 'TranTNBKH00002@gmail.com', '0023-4567-8901', 1, '2024-03-31', '2024-03-31'),
    ('LeTVC3', N'Lê Thị Vân Chi', 'sa', 1, '0987654321', '1988-09-10', 1, N'789 Đường Võ Văn Tần, Phường 3, Quận 3, Thành phố Hồ Chí Minh', 'LeTVCKH00003@gmail.com', '0034-5678-9012', 1, '2024-04-01', '2024-04-01'),
    ('PhamTDH4', N'Phạm Thị Diệu Hương', 'sa', 0, '0987654321', '1982-07-05', 0, N'101 Đường Lê Đức Thọ, Phường Mỹ Đình, Quận Nam Từ Liêm, Thành phố Hà Nội', 'PhamTDHKH00004@gmail.com', '0045-6789-0123', 1, '2024-04-02', '2024-04-02'),
    ('VuDE5', N'Vũ Đức Eo', 'sa', 1, '0987654321', '1993-11-25', 1, N'204 Đường Nguyễn Trãi, Phường Thanh Xuân Trung, Quận Thanh Xuân, Thành phố Hà Nội', 'VuDEKH00005@gmail.com', '0056-7890-1234', 1, '2024-04-03', '2024-04-03'),
    ('TranGG6', N'Trần Gia Ghi', 'sa', 0, '0987654321', '1997-03-18', 0, N'303 Đường Hoàng Quốc Việt, Phường Cầu Giấy, Quận Cầu Giấy, Thành phố Hà Nội', 'TranGGKH00006@gmail.com', '0067-8901-2345', 1, '2024-04-04', '2024-04-04'),
    ('HoangHH7', N'Hoàng Hải Hữu', 'sa', 1, '0987654321', '1980-12-30', 1, N'888 Đường Hùng Vương, Phường An Lạc, Quận Bình Tân, Thành phố Hồ Chí Minh', 'HoangHHHCH00007@gmail.com', '0078-9012-3456', 1, '2024-04-05', '2024-04-05'),
    ('DoMQ8', N'Dỗ Mạnh Quân', 'sa', 0, '0987654321', '1989-04-08', 1, N'99 Đường Nguyễn Chí Thanh, Phường Cẩm Phả, Quận Hồng Bàng, Thành phố Hải Phòng', 'DoMQKH00008@gmail.com', '0089-0123-4567', 1, '2024-04-06', '2024-04-06'),
    ('NguyenDM9', N'Nguyễn Đức Minh Tâm', 'sa', 1, '0987654321', '1998-08-14', 1, N'79 Đường Hồ Tùng Mậu, Phường An Hải Đông, Quận Sơn Trà, Thành phố Đà Nẵng', 'NguyenDMTTH00009@gmail.com', '0090-1234-5678', 1, '2024-04-07', '2024-04-07'),
    ('HoLV10', N'Hồ Lê Vân', 'sa', 0, '0987654321', '1991-02-28', 0, N'25 Đường Bạch Đằng, Phường Quán Thánh, Quận Ba Đình, Thành phố Hà Nội', 'HoLVKH00010@gmail.com', '0101-2345-6789', 1, '2024-04-08', '2024-04-08');

INSERT INTO spct (id_chat_lieu, id_hinh_anh, id_hoa_tiet, id_kich_thuoc, id_kieu_dang, id_mau_sac, id_san_pham, id_thuong_hieu, ma_spct, so_luong, gia, mo_ta, trang_thai, ngay_tao, ngay_sua)
VALUES
    (3, 8, 2, 5, 1, 7, 9, 4, 'Black.Large.T-Shirt', 30, 150000, 'Good quality', 1, '2024-03-01', '2024-03-02'),
    (2, 9, 6, 4, 7, 8, 3, 1, 'White.Medium.Polo', 25, 200000, 'Casual style', 1, '2024-03-03', '2024-03-04'),
    (1, 5, 7, 3, 2, 8, 6, 9, 'Blue.Small.Jacket', 20, 300000, 'Warm and trendy', 1, '2024-03-05', '2024-03-06'),
    (3, 7, 2, 3, 1, 2, 9, 4, 'Red.Large.Hoodie', 35, 250000, 'Comfortable fit', 1, '2024-03-07', '2024-03-08'),
    (2, 5, 3, 1, 6, 4, 8, 7, 'Green.Medium.Sweater', 40, 180000, 'Soft fabric', 1, '2024-03-09', '2024-03-10'),
    (3, 2, 2, 6, 1, 1, 9, 4, 'Yellow.Large.Shirt', 45, 220000, 'Bright and vibrant', 1, '2024-03-11', '2024-03-12'),
    (8, 5, 6, 3, 1, 4, 2, 9, 'Orange.Medium.Jeans', 50, 350000, 'Classic denim', 1, '2024-03-13', '2024-03-14'),
    (2, 2, 3, 5, 6, 1, 8, 7, 'Purple.Small.Dress', 45, 280000, 'Elegant design', 1, '2024-03-15', '2024-03-16'),
    (1, 9, 7, 1, 2, 2, 6, 9, 'Brown.Large.Coat', 30, 400000, 'Winter essential', 1, '2024-03-17', '2024-03-18'),
    (4, 1, 9, 2, 3, 8, 7, 5, 'Pink.Medium.Skirt', 20, 220000, 'Flirty and fun', 1, '2024-03-19', '2024-03-20');

INSERT INTO hoa_don (id_nhan_vien, id_khach_hang, id_phieu_giam_gia, ma_hoa_don, pttt, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (1, 1, 1, 'HD1', 1, 1, '2024-03-01', '2024-03-01'),
    (2, 2, 2, 'HD2', 0, 2, '2024-03-02', '2024-03-02'),
    (3, 3, 3, 'HD3', 1, 1, '2024-03-03', '2024-03-03'),
    (4, 4, 4, 'HD4', 0, 1, '2024-03-04', '2024-03-04'),
    (5, NULL, 5, 'HD5', 1, 2, '2024-03-05', '2024-03-05'),
    (6, NULL, 6, 'HD6', 0, 1, '2024-03-06', '2024-03-06'),
    (7, NULL, 7, 'HD7', 1, 2, '2024-03-07', '2024-03-07'),
    (8, NULL, 8, 'HD8', 0, 1, '2024-03-08', '2024-03-08'),
    (9, NULL, 9, 'HD9', 1, 2, '2024-03-09', '2024-03-09'),
    (10, NULL, 10, 'HD10', 0, 1, '2024-03-10', '2024-03-10');

INSERT INTO hoa_don_chi_tiet (id_hoa_don, id_spct, so_luong, don_gia, trang_thai, ngay_tao, ngay_sua)
VALUES 
    (1, 1, 20, 100.00, 1, '2024-03-30', '2024-03-30'),
    (2, 2, 25, 150.00, 1, '2024-03-29', '2024-03-29'),
    (3, 3, 30, 200.00, 1, '2024-03-28', '2024-03-28'),
    (4, 4, 35, 250.00, 1, '2024-03-27', '2024-03-27'),
    (5, 5, 40, 300.00, 1, '2024-03-26', '2024-03-26'),
    (6, 6, 45, 350.00, 1, '2024-03-25', '2024-03-25'),
    (7, 7, 50, 400.00, 1, '2024-03-24', '2024-03-24'),
    (8, 8, 20, 100.00, 1, '2024-03-23', '2024-03-23'),
    (9, 9, 25, 150.00, 1, '2024-03-22', '2024-03-22'),
    (10, 10, 30, 200.00, 1, '2024-03-21', '2024-03-21'),
    (1, 10, 35, 250.00, 1, '2024-03-20', '2024-03-20'),
    (2, 8, 40, 300.00, 1, '2024-03-19', '2024-03-19'),
    (3, 8, 45, 350.00, 1, '2024-03-18', '2024-03-18'),
    (4, 8, 50, 400.00, 1, '2024-03-17', '2024-03-17'),
    (5, 6, 20, 100.00, 1, '2024-03-16', '2024-03-16'),
    (6, 6, 25, 150.00, 1, '2024-03-15', '2024-03-15'),
    (7, 6, 30, 200.00, 1, '2024-03-14', '2024-03-14'),
    (8, 3, 35, 250.00, 1, '2024-03-13', '2024-03-13'),
    (9, 3, 40, 300.00, 1, '2024-03-12', '2024-03-12'),
    (10, 3, 45, 350.00, 1, '2024-03-11', '2024-03-11');