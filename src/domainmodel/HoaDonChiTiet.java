package domainmodel;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HoaDonChiTiet {

    SimpleDateFormat format = new SimpleDateFormat("MM-dd-YYYY");
    private int id;
    private int idHoaDon;
    private int idSPCT;
    private int soLuong;
    private BigDecimal donGia;
    private Date ngayTao;
    private Date ngaySua;
    private boolean trangThai;
    private BigDecimal tongTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int id, int idHoaDon, int idSPCT, int soLuong, BigDecimal donGia, Date ngayTao, Date ngaySua, boolean trangThai) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idSPCT = idSPCT;
        this.soLuong = soLuong;
        this.donGia = donGia;
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

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(int idSPCT) {
        this.idSPCT = idSPCT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
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
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return new Object[]{this.id, this.idHoaDon, this.idSPCT, this.soLuong, decimalFormat.format(this.donGia), decimalFormat.format(this.donGia.multiply(BigDecimal.valueOf(this.soLuong)))};
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "format=" + format + ", id=" + id + ", idHoaDon=" + idHoaDon + ", idSPCT=" + idSPCT + ", soLuong=" + soLuong + ", donGia=" + donGia + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", trangThai=" + trangThai + '}';
    }

    public String layTT() {
        if (trangThai == true) {
            return "Chờ thanh toán";
        } else {
            return "Đã thanh toán";
        }
    }
}
