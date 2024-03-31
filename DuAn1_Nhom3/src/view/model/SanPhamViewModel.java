package view.model;

public class SanPhamViewModel {
    private int id;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private String chatLieu;
    private String kieuDang;
    private String hoaTiet;
    private String thuongHieu;
    private boolean trangThai;

    public SanPhamViewModel() {
    }
    
    

    public SanPhamViewModel(int id, String maSP, String tenSP, int soLuong, String chatLieu, String kieuDang, String hoaTiet, String thuongHieu, boolean trangThai) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.chatLieu = chatLieu;
        this.kieuDang = kieuDang;
        this.hoaTiet = hoaTiet;
        this.thuongHieu = thuongHieu;
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

    public String getHoaTiet() {
        return hoaTiet;
    }

    public void setHoaTiet(String hoaTiet) {
        this.hoaTiet = hoaTiet;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Object[] toDataRow() {
        return new Object[] {this.id, this.maSP, this.tenSP, this.soLuong, this.chatLieu, this.kieuDang, this.hoaTiet, this.thuongHieu};
    }
}
