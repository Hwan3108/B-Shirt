/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author phtua
 */
public class KhachHang_ThongKe {
    private int id;
    private String tenKhachHang;
    private int soSanPhamMua;
    private Float tongChiTieu;

    public KhachHang_ThongKe() {
    }

    public KhachHang_ThongKe(int id, String tenKhachHang, int soSanPhamMua, Float tongChiTieu) {
        this.id = id;
        this.tenKhachHang = tenKhachHang;
        this.soSanPhamMua = soSanPhamMua;
        this.tongChiTieu = tongChiTieu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public int getSoSanPhamMua() {
        return soSanPhamMua;
    }

    public void setSoSanPhamMua(int soSanPhamMua) {
        this.soSanPhamMua = soSanPhamMua;
    }

    public Float getTongChiTieu() {
        return tongChiTieu;
    }

    public void setTongChiTieu(Float tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }
    
}
