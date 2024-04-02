package view.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class GioHangViewModel {
    private int id;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private BigDecimal donGia;
    private boolean trangThai;

    public GioHangViewModel() {
    }

    public GioHangViewModel(int id, String maSP, String tenSP, int soLuong, BigDecimal donGia, boolean trangThai) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    public Object[] toDataRow() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        return new Object[] {this.id, this.maSP, this.tenSP, this.soLuong, decimalFormat.format(this.donGia), decimalFormat.format(this.donGia.multiply(BigDecimal.valueOf(this.soLuong)))};
    }
}
