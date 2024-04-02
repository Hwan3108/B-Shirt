
package model;

import java.util.Date;



public class KhachHang {
    private Integer id;
    private String maKH;
    private String ten;
    private String SDT;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String diaChi;
    private String email;
    private String cccd;
    private Date ngayTao;
    private Date ngaySua;
    private boolean trangThai;
    

    public KhachHang() {
    }

    public KhachHang(String ten, String SDT, Date ngaySinh, boolean gioiTinh, String diaChi, String email, String cccd, boolean trangThai) {
        this.ten = ten;
        this.SDT = SDT;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.email = email;
        this.cccd = cccd;
        this.trangThai = trangThai;
    }
    
    

    public KhachHang(int id, String maKH, String ten, String SDT, Date ngaySinh, boolean gioiTinh, String diaChi, String email, String cccd, Date ngayTao, Date ngaySua, boolean trangThai) {
        this.id = id;
        this.maKH = maKH;
        this.ten = ten;
        this.SDT = SDT;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.email = email;
        this.cccd = cccd;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
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

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", maKH=" + maKH + ", ten=" + ten + ", SDT=" + SDT + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", email=" + email + ", cccd=" + cccd + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", trangThai=" + trangThai + '}';
    }

    
    public String layGT(){
        if(gioiTinh == true){
            return "Nam";          
        }else{
            return "Nữ";
        }
    }
     public String layTrangThai(){
        if(trangThai == true){
            return "Đang hoạt động";          
        }else{
            return "Ngừng hoạt động";
        }
    }
     public int layGTView(){
        if(gioiTinh == true){
            return 1;          
        }else{
            return 2;
        }
    }
}
