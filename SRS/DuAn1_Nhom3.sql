CREATE DATABASE DuAn1_Nhom3
GO
USE DuAn1_Nhom3;
GO
CREATE TABLE chat_lieu (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_chat_lieu VARCHAR(255),
	ten_chat_lieu NVARCHAR(255),
	trang_thai BIT,
	ngay_tao DATE,
	ngay_sua DATE,
)

CREATE TABLE hinh_anh (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_hinh_anh VARCHAR(255),
	duong_dan NVARCHAR(255),
	trang_thai BIT,
	ngay_tao DATE,
	ngay_sua DATE,
)

CREATE TABLE hoa_tiet (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_hoa_tiet VARCHAR(255),
	ten_hoa_tiet NVARCHAR(255),
	trang_thai BIT,
	ngay_tao DATE,
	ngay_sua DATE,
)

CREATE TABLE kich_thuoc (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_kich_thuoc VARCHAR(255),
	ten_kich_thuoc NVARCHAR(255),
	trang_thai BIT,
	ngay_tao DATE,
	ngay_sua DATE,
)

CREATE TABLE kieu_dang (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_kieu_dang VARCHAR(255),
	ten_kieu_dang NVARCHAR(255),
	trang_thai BIT,
	ngay_tao DATE,
	ngay_sua DATE,
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
	ma_san_pham VARCHAR(255),
	ten_san_pham NVARCHAR(255),
	trang_thai BIT,
	ngay_tao DATE,
	ngay_sua DATE,
)

CREATE TABLE thuong_hieu (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_thuong_hieu VARCHAR(255),
	ten_thuong_hieu NVARCHAR(255),
	trang_thai BIT,
	ngay_tao DATE,
	ngay_sua DATE,
)

CREATE TABLE phieu_giam_gia(
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_phieu VARCHAR(255),
	ten_phieu NVARCHAR(255),
	phan_tram_giam DECIMAL(5,2),
	ngay_bat_dau DATE,
	ngay_ket_thuc DATE,
	trang_thai INT,
	ngay_tao DATE,
	ngay_sua DATE
)
CREATE TABLE khach_hang(
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_khach_hang VARCHAR(255),
	ten_khach_hang NVARCHAR(255),
	sdt NVARCHAR(10),
	ngay_sinh DATE,
	gioi_tinh BIT,
	dia_chi NVARCHAR(255),
	email VARCHAR(255),
	cccd VARCHAR(255),
	trang_thai BIT,
	ngay_tao DATE,
	ngay_sua DATE,
)

CREATE TABLE nhan_vien(
	id INT IDENTITY(1,1) PRIMARY KEY,
	ma_nhan_vien VARCHAR(255),
	ten_nhan_vien NVARCHAR(255),
	mat_khau VARCHAR(20),
	chuc_vu BIT,
	sdt NVARCHAR(10),
	ngay_sinh DATE,
	gioi_tinh BIT,
	dia_chi NVARCHAR(255),
	email VARCHAR(255),
	cccd VARCHAR(255),
	trang_thai INT,
	ngay_tao DATE,
	ngay_sua DATE,
)

CREATE TABLE spct(
	id INT IDENTITY(1,1) PRIMARY KEY,
	id_chat_lieu INT,
	id_hinh_anh INT,
	id_hoa_tiet INT,
	id_kich_thuoc INT,
	id_kieu_dang INT,
	id_mau_sac INT,
	id_san_pham INT,
	id_thuong_hieu INT,
	ma_spct VARCHAR(255),
	so_luong INT,
	gia DECIMAL(18,2),
	mo_ta NVARCHAR(255),
	trang_thai INT,
	ngay_tao DATE,
	ngay_sua DATE,
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
	id_nhan_vien INT,
	id_khach_hang INT,
	id_phieu_giam_gia INT,
	ma_hoa_don VARCHAR(255),
	trang_thai INT,
	ngay_tao DATE,
	ngay_sua DATE
	CONSTRAINT fk_nhan_vien FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_khach_hang FOREIGN KEY (id_khach_hang) REFERENCES khach_hang(id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_phieu_giam_gia FOREIGN KEY (id_phieu_giam_gia) REFERENCES phieu_giam_gia(id) ON UPDATE CASCADE ON DELETE CASCADE
)

CREATE TABLE hoa_don_chi_tiet(
	id INT IDENTITY(1,1) PRIMARY KEY,
	id_hoa_don INT,
	id_spct INT,
	so_luong INT,
	don_gia DECIMAL(18, 2),
	trang_thai BIT,
	ngay_tao DATE,
	ngay_sua DATE
	CONSTRAINT fk_hoa_don FOREIGN KEY (id_hoa_don) REFERENCES hoa_don(id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_spct FOREIGN KEY (id_spct) REFERENCES spct(id) ON UPDATE CASCADE ON DELETE CASCADE
)
