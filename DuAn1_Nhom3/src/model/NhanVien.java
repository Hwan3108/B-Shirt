package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanVien {
    private int id;
    private String ma;
    private String hoTen;
    private String matKhau;
    private boolean chucVu;
    private String sdt;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String diaChi;
    private String email;
    private String cccd;
    private int trangThai;
    private Date ngayTao;
    private Date ngaySua;

    public NhanVien() {
    }

    public NhanVien(String hoTen, String matKhau, boolean chucVu, String sdt, Date ngaySinh, boolean gioiTinh, String diaChi, String email, String cccd, int trangThai) {
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.email = email;
        this.cccd = cccd;
        this.trangThai = trangThai;
    }

    
    
    public NhanVien(int id, String ma, String hoTen, String matKhau, boolean chucVu, String sdt, Date ngaySinh, boolean gioiTinh, String diaChi, String email, String cccd, int trangThai, Date ngayTao, Date ngaySua) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.email = email;
        this.cccd = cccd;
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

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isChucVu() {
        return chucVu;
    }

    public void setChucVu(boolean chucVu) {
        this.chucVu = chucVu;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
        } else if (gioiTinh == false) {
            return "Nữ";
        } else {
            return null;
        }
    }

    public String layTrangThai() {
        if(trangThai == 1) {
            return "Đi làm";
        } else if (trangThai == 2) {
            return "Nghỉ phép";
        } else if (trangThai == 3) {
            return "Thôi việc";
        }else {
            return null;
        }
    }
    
    public Object[] toDataRow() {
        return new Object[] {this.id, this.hoTen, layChucVu(), this.sdt, new SimpleDateFormat("dd-MM-yyyy").format(this.ngaySinh), layGioiTinh(), this.diaChi, this.email, layTrangThai(), new SimpleDateFormat("dd-MM-yyyy").format(this.ngayTao),new SimpleDateFormat("dd-MM-yyyy").format(this.ngaySua)};
    }
    
}
