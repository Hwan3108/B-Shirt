package view.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class SPCTViewModel {
    private int id;
    private int idSP;
    private String maSPCT;
    private String kichThuoc;
    private String mauSac;
    private int soLuong;
    private BigDecimal gia;
    private int trangThai;

    public SPCTViewModel() {
    }

    public SPCTViewModel(int id) {
        this.id = id;
    }

    public SPCTViewModel(int id, BigDecimal gia) {
        this.id = id;
        this.gia = gia;
    }

    public SPCTViewModel(int id, int idSP, String maSPCT, String kichThuoc, String mauSac, int soLuong, BigDecimal gia, int trangThai) {
        this.id = id;
        this.idSP = idSP;
        this.maSPCT = maSPCT;
        this.kichThuoc = kichThuoc;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
    
    public Object[] toDataRow() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        return new Object[] {this.id, this.maSPCT, this.kichThuoc, this.mauSac, this.soLuong, decimalFormat.format(this.gia)};
    }
}
