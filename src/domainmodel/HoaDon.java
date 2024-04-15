package domainmodel;

import java.util.Date;
import java.util.List;

public class HoaDon {

    private int id;
    private int idNhanVien;
    private int idKhachHang;
    private int idPhieuGiamGia;
    private String maHoaDon;
    private boolean PTTT;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;
    private SanPham sanPham;
    private NhanVien nhanVien;
    private HoaDonChiTiet donChiTiet;
    private KhachHang khachHang;
    private KhuyenMai khuyenMai;
    List<HoaDon> listLS;

    public List<HoaDon> getListLS() {
        return listLS;
    }

    public void setListLS(List<HoaDon> listLS) {
        this.listLS = listLS;
    }
    

    public HoaDon() {
    }

    public HoaDon(int id, int idNhanVien, String maHoaDon, boolean PTTT) {
        this.id = id;
        this.idNhanVien = idNhanVien;
        this.maHoaDon = maHoaDon;
        this.PTTT = PTTT;
    }

    public HoaDon(int id, int idNhanVien, int idPhieuGiamGia, String maHoaDon, boolean PTTT) {
        this.id = id;
        this.idNhanVien = idNhanVien;
        this.idPhieuGiamGia = idPhieuGiamGia;
        this.maHoaDon = maHoaDon;
        this.PTTT = PTTT;
    }

    public HoaDon(int id, int idNhanVien, int idKhachHang, int idPhieuGiamGia, String maHoaDon, boolean PTTT) {
        this.id = id;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.idPhieuGiamGia = idPhieuGiamGia;
        this.maHoaDon = maHoaDon;
        this.PTTT = PTTT;
    }

    public HoaDon(int id, int idNhanVien, int idKhachHang, int idPhieuGiamGia, String maHoaDon, boolean PTTT, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.idPhieuGiamGia = idPhieuGiamGia;
        this.maHoaDon = maHoaDon;
        this.PTTT = PTTT;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdPhieuGiamGia() {
        return idPhieuGiamGia;
    }

    public void setIdPhieuGiamGia(int idPhieuGiamGia) {
        this.idPhieuGiamGia = idPhieuGiamGia;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public boolean isPTTT() {
        return PTTT;
    }

    public void setPTTT(boolean PTTT) {
        this.PTTT = PTTT;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public HoaDonChiTiet getDonChiTiet() {
        return donChiTiet;
    }

    public void setDonChiTiet(HoaDonChiTiet donChiTiet) {
        this.donChiTiet = donChiTiet;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    
    
    public String layTrangThaiHD() {
        if (trangThai == 1) {
            return "Đã thanh toán";
        } else if (trangThai == 2) {
            return "Chờ thanh toán";
        } else {
            return "Huỷ";
        }
    }

    public String layPTTT() {
        if (PTTT == true) {
            return "Tiền mặt";
        } else {
            return "Chuyển khoản";
        }
    }

 
}
