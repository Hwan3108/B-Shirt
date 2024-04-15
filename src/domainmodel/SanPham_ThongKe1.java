/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author phtua
 */
public class SanPham_ThongKe1 {
    private String maSP;
    private String TenSP;
    private int SoLuong;
    private int SoLuongBan;
    private float DoanhThu;

    public SanPham_ThongKe1() {
    }

    public SanPham_ThongKe1(String maSP, String TenSP, int SoLuong, int SoLuongBan, float DoanhThu) {
        this.maSP = maSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.SoLuongBan = SoLuongBan;
        this.DoanhThu = DoanhThu;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getSoLuongBan() {
        return SoLuongBan;
    }

    public void setSoLuongBan(int SoLuongBan) {
        this.SoLuongBan = SoLuongBan;
    }

    public float getDoanhThu() {
        return DoanhThu;
    }

    public void setDoanhThu(float DoanhThu) {
        this.DoanhThu = DoanhThu;
    }           
}
