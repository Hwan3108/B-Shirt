package domainmodel;

import java.util.Date;

public class HinhAnh {
    private int id;
    private String ma;
    private String duongDan;
    private boolean trangThai;
    private Date ngayTao;
    private Date ngaySua;

    public HinhAnh() {
    }

    public HinhAnh(int id, String ma, String duongDan, boolean trangThai, Date ngayTao, Date ngaySua) {
        this.id = id;
        this.ma = ma;
        this.duongDan = duongDan;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public HinhAnh(String duongDan) {
        this.duongDan = duongDan;
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

    public String getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
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
    
}
