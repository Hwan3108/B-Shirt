/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author phtua
 */
public class NhanVien_ThongKe {
    private int idNhanVien;
    private String tenNhanVien;
    private int soLuongBan;
    private float doanhThu;

    public NhanVien_ThongKe() {
    }

    public NhanVien_ThongKe(int idNhanVien, String tenNhanVien, int soLuongBan, float doanhThu) {
        this.idNhanVien = idNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.soLuongBan = soLuongBan;
        this.doanhThu = doanhThu;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public float getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(float doanhThu) {
        this.doanhThu = doanhThu;
    }
    
}
