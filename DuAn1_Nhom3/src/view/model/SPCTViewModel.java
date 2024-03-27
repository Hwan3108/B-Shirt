package view.model;

public class SPCTViewModel {
    private int id;
    private String maSPCT;
    private String kichThuoc;
    private String mauSac;
    private String hinhAnh;
    private String hoaTiet;
    private int soLuong;
    private Double gia;

    public SPCTViewModel() {
    }

    public SPCTViewModel(int id, String maSPCT, String kichThuoc, String mauSac, String hinhAnh, String hoaTiet, int soLuong, Double gia) {
        this.id = id;
        this.maSPCT = maSPCT;
        this.kichThuoc = kichThuoc;
        this.mauSac = mauSac;
        this.hinhAnh = hinhAnh;
        this.hoaTiet = hoaTiet;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getHoaTiet() {
        return hoaTiet;
    }

    public void setHoaTiet(String hoaTiet) {
        this.hoaTiet = hoaTiet;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    
    
    public Object[] toDataRow() {
        return new Object[] {this.id, this.maSPCT, this.kichThuoc, this.mauSac, this.hinhAnh, this.hoaTiet, this.soLuong, this.gia};
    }
}
