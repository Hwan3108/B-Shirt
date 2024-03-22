package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanVien {
    private String id;
    private String matKhau;
    private String ten;
    private boolean chucVu;
    private String SDT;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String diaChi;
    private Date ngayTao;
    private Date ngaySua;
    private boolean trangThai;

    public NhanVien() {
    }

    public NhanVien(String id, String matKhau, String ten, boolean chucVu, String SDT, Date ngaySinh, boolean gioiTinh, String diaChi, boolean trangThai) {
        this.id = id;
        this.matKhau = matKhau;
        this.ten = ten;
        this.chucVu = chucVu;
        this.SDT = SDT;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }
    
    

    public NhanVien(String id, String matKhau, String ten, boolean chucVu, String SDT, Date ngaySinh, boolean gioiTinh, String diaChi, Date ngayTao, Date ngaySua, boolean trangThai) {
        this.id = id;
        this.matKhau = matKhau;
        this.ten = ten;
        this.chucVu = chucVu;
        this.SDT = SDT;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
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

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isChucVu() {
        return chucVu;
    }

    public void setChucVu(boolean chucVu) {
        this.chucVu = chucVu;
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

    public String layChucVu() {
        if(chucVu == true) {
            return "Nhân viên";
        } else if (chucVu == false) {
            return "Quản lý";
        } else {
            return null;
        }
    }
    
    public String layGioiTinh() {
        if(gioiTinh == true) {
            return "Nam";
        } else if (chucVu == false) {
            return "Nữ";
        } else {
            return null;
        }
    }

    public String layTrangThai() {
        if(trangThai == true) {
            return "Đi làm";
        } else if (trangThai == false) {
            return "Nghỉ việc";
        } else {
            return null;
        }
    }
    
    public Object[] toDataRow() {
        SimpleDateFormat SDF = new SimpleDateFormat("dd-mm-yyyy");
        return new Object[] {this.id, this.ten, this.matKhau, layChucVu(), this.SDT, SDF.format(this.ngaySinh), layGioiTinh(), this.diaChi, layTrangThai()};
    }
    
}
