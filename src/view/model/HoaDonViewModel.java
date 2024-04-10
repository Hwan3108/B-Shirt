package view.model;

import java.util.Date;

public class HoaDonViewModel {
    private int id;
    private String maHoaDon;
    private Date ngayTao;
    private int trangThai;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(int id, String maHoaDon, Date ngayTao, int trangThai) {
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }
    
    public String layTrangThai() {
        if(trangThai == 1) {
            return "Đã thanh toán";
        }
        if(trangThai == 2) {
            return "Chờ thanh toán";
        }
        if(trangThai == 3) {
            return "Huỷ";
        } else {
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
    public Object[] toDataRow() {
        return new Object[] {this.id, this.maHoaDon, this.ngayTao, layTrangThai()};
    }
}
