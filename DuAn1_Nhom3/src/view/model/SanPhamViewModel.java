package view.model;

public class SanPhamViewModel {
    private int id;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private String chatLieu;
    private String kieuDang;
    private String thuongHieu;
    private String moTa;
    private boolean trangThai;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(int id, String maSP, String tenSP, int soLuong, String chatLieu, String kieuDang, String thuongHieu, String moTa, boolean trangThai) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.chatLieu = chatLieu;
        this.kieuDang = kieuDang;
        this.thuongHieu = thuongHieu;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    

    public Object[] toDataRow() {
        return new Object[] {this.id, this.maSP, this.tenSP, this.soLuong, this.chatLieu, this.kieuDang, this.thuongHieu, this.moTa};
    }
}
