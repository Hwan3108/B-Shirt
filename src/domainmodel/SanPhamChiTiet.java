package domainmodel;

import java.math.BigDecimal;
import java.util.Date;

public class SanPhamChiTiet {
    private int id;
    private int idChatLieu;
    private int idHinhAnh;
    private int idHoaTiet;
    private int idKichThuoc;
    private int idKieuDang;
    private int idMauSac;
    private int idSanPham;
    private int idThuongHieu;
    private String ma;
    private int soLuong;
    private BigDecimal gia;
    private String moTa;
    private int trangThai;
    private Date ngayTao;
    private Date ngaySua;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(int id, int idChatLieu, int idHinhAnh, int idHoaTiet, int idKichThuoc, int idKieuDang, int idMauSac, int idSanPham, int idThuongHieu, String ma, int soLuong, BigDecimal gia, String moTa, int trangThai, Date ngayTao, Date ngaySua) {
        this.id = id;
        this.idChatLieu = idChatLieu;
        this.idHinhAnh = idHinhAnh;
        this.idHoaTiet = idHoaTiet;
        this.idKichThuoc = idKichThuoc;
        this.idKieuDang = idKieuDang;
        this.idMauSac = idMauSac;
        this.idSanPham = idSanPham;
        this.idThuongHieu = idThuongHieu;
        this.ma = ma;
        this.soLuong = soLuong;
        this.gia = gia;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public int getIdHinhAnh() {
        return idHinhAnh;
    }

    public void setIdHinhAnh(int idHinhAnh) {
        this.idHinhAnh = idHinhAnh;
    }

    public int getIdHoaTiet() {
        return idHoaTiet;
    }

    public void setIdHoaTiet(int idHoaTiet) {
        this.idHoaTiet = idHoaTiet;
    }

    public int getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(int idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public int getIdKieuDang() {
        return idKieuDang;
    }

    public void setIdKieuDang(int idKieuDang) {
        this.idKieuDang = idKieuDang;
    }

    public int getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(int idMauSac) {
        this.idMauSac = idMauSac;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(int idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }
    
}
