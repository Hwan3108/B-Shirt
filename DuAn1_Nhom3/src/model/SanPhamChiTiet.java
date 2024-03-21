package model;

import java.util.Date;

public class SanPhamChiTiet {
    private String id;
    private String idChatLieu;
    private String idKichThuoc;
    private String idKieuDang;
    private String idMauSac;
    private String idThuongHieu;
    private boolean gioiTinh;
    private int soLuong;
    private double gia;
    private String moTa;
    private Date ngayTao;
    private Date ngaySua;
    private boolean trangThai;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(String id) {
        this.id = id;
    }

    public SanPhamChiTiet(String id, String idChatLieu, String idKichThuoc, String idKieuDang, String idMauSac, String idThuongHieu, boolean gioiTinh, int soLuong, double gia, String moTa, Date ngayTao, Date ngaySua, boolean trangThai) {
        this.id = id;
        this.idChatLieu = idChatLieu;
        this.idKichThuoc = idKichThuoc;
        this.idKieuDang = idKieuDang;
        this.idMauSac = idMauSac;
        this.idThuongHieu = idThuongHieu;
        this.gioiTinh = gioiTinh;
        this.soLuong = soLuong;
        this.gia = gia;
        this.moTa = moTa;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(String idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(String idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public String getIdKieuDang() {
        return idKieuDang;
    }

    public void setIdKieuDang(String idKieuDang) {
        this.idKieuDang = idKieuDang;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(String idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    public Object[] toDataRow() {
        return new Object[] {this.id,this.gioiTinh,this.soLuong,this.gia,this.moTa};
    }
    
}
