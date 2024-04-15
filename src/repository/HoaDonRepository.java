package repository;

import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import domainmodel.KhachHang;
import domainmodel.KhuyenMai;
import domainmodel.NhanVien;
import domainmodel.SanPham;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import ultilities.DBConnect;
import view.model.HoaDonViewModel;

public class HoaDonRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    DBConnect dBconnection;
    SimpleDateFormat format = new SimpleDateFormat("MM-dd-YYYY");

    public ArrayList<HoaDon> getAll() {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select * from hoa_don";
        try (Connection con = dBconnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idKH = rs.getInt("id_khach_hang");
                int idNV = rs.getInt("id_nhan_vien");
                int idPhieuGiamGia = rs.getInt("id_phieu_giam_gia");
                String maHoaDon = rs.getString("ma_hoa_don");
                boolean PTTT = rs.getBoolean("pttt");
                Date ngayTao = (Date) Date.valueOf(rs.getString("ngay_tao"));
                Date ngaySua = (Date) Date.valueOf(rs.getString("ngay_sua"));
                int trangThai = rs.getInt("trang_thai");

                HoaDon hd = new HoaDon(id, idNV, idKH, idPhieuGiamGia, maHoaDon, PTTT, ngayTao, ngaySua, trangThai);
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDon> search(int idHD) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select * from hoa_don where id='" + idHD + "'";
        try (Connection con = dBconnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idNV = rs.getInt("id_nhan_vien");
                int idKH = rs.getInt("id_khach_hang");
                int idPhieuGiamGia = rs.getInt("id_phieu_giam_gia");
                String maHoaDon = rs.getString("ma_hoa_don");
                boolean pttt = rs.getBoolean("pttt");
                Date ngayTao = (Date) Date.valueOf(rs.getString("ngay_tao"));
                Date ngaySua = (Date) Date.valueOf(rs.getString("ngay_sua"));
                int trangThai = rs.getInt("trang_thai");

                HoaDon hd = new HoaDon(id, idNV, idKH, idPhieuGiamGia, maHoaDon, pttt, ngayTao, ngaySua, trangThai);
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<HoaDonViewModel> getBHView() {
        sql = "SELECT id, ma_hoa_don, ngay_tao, trang_thai FROM hoa_don ORDER BY id DESC";
        List<HoaDonViewModel> listView = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModel hdview = new HoaDonViewModel(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4));
                listView.add(hdview);
            }
            return listView;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void create(String ma) {
        sql = "INSERT INTO hoa_don (ma_hoa_don,trang_thai,ngay_tao,ngay_sua)\n"
                + "VALUES (?,2,GETDATE(),GETDATE())";
        try {
            con = dBconnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancel(int id) {
        sql = "UPDATE hoa_don SET trang_thai = 3, ngay_sua = GETDATE() WHERE id = ?\n"
                + "UPDATE spct SET spct.so_luong += hoa_don_chi_tiet.so_luong FROM spct\n"
                + "INNER JOIN hoa_don_chi_tiet ON spct.id = hoa_don_chi_tiet.id_spct\n"
                + "WHERE hoa_don_chi_tiet.id_hoa_don = ? and hoa_don_chi_tiet.id_spct = spct.id\n"
                + "UPDATE hoa_don_chi_tiet SET id_hoa_don = NULL, id_spct = NULL, so_luong = NULL,"
                + "don_gia = NULL, trang_thai = 0, ngay_sua = GETDATE() WHERE id_hoa_don = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            ps.setObject(2, id);
            ps.setObject(3, id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkout(HoaDon hd, int id) {
        sql = "UPDATE hoa_don SET id_nhan_vien = ?, id_khach_hang = ?, id_phieu_giam_gia = ?, pttt = ?, trang_thai = 1, ngay_sua = GETDATE() WHERE id = ?";
        int check = 0;

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hd.getIdNhanVien());
            ps.setObject(2, hd.getIdKhachHang());
            ps.setObject(3, hd.getIdPhieuGiamGia());
            ps.setBoolean(4, hd.isPTTT());
            ps.setInt(5, id);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean khachLe(HoaDon hd, int id) {
        sql = "UPDATE hoa_don SET id_nhan_vien = ?, id_phieu_giam_gia = ?, pttt = ?, trang_thai = 1, ngay_sua = GETDATE() WHERE id = ?";
        int check = 0;

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hd.getIdNhanVien());
            ps.setObject(2, hd.getIdPhieuGiamGia());
            ps.setObject(3, hd.isPTTT());
            ps.setObject(4, id);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean nullKM(HoaDon hd, int id) {
        sql = "UPDATE hoa_don SET id_nhan_vien = ?, pttt = ?, trang_thai = 1, ngay_sua = GETDATE() WHERE id = ?";
        int check = 0;

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hd.getIdNhanVien());
            ps.setObject(2, hd.isPTTT());
            ps.setObject(3, id);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public ArrayList<HoaDon> getLichSu() {
        ArrayList<HoaDon> list = new ArrayList<>();
       
        String sql = "select DISTINCT ma_hoa_don, ten_nhan_vien, khach_hang.ten_khach_hang, phan_tram_giam, pttt, "
                + "hoa_don.trang_thai, san_pham.ten_san_pham ,hoa_don.ngay_tao, hoa_don_chi_tiet.so_luong, "
                + "don_gia, (hoa_don_chi_tiet.so_luong * don_gia) - ((hoa_don_chi_tiet.so_luong * don_gia)*phan_tram_giam/100) as tongtien from hoa_don "
                + "inner join nhan_vien on hoa_don.id_nhan_vien = nhan_vien.id \n"
                + "inner join khach_hang on hoa_don.id_khach_hang = khach_hang.id\n"
                + "inner join phieu_giam_gia on hoa_don.id_phieu_giam_gia = phieu_giam_gia.id\n"
                + "inner join hoa_don_chi_tiet on hoa_don.id = hoa_don_chi_tiet.id_hoa_don\n"
                + "inner join spct on spct.id = hoa_don_chi_tiet.id_spct\n"
                + "inner join san_pham on san_pham.id = spct.id_san_pham\n"
                + "where hoa_don.trang_thai = 1";
        try (Connection con = dBconnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //hóa đon
                HoaDon hoaDon = new HoaDon();    
//                String maHD = rs.getString("ma_hoa_don");
                hoaDon.setMaHoaDon(rs.getString("ma_hoa_don"));
                hoaDon.setPTTT(rs.getBoolean("pttt"));
                hoaDon.setTrangThai(rs.getInt("trang_thai"));
                hoaDon.setNgayTao((Date) Date.valueOf(rs.getString("ngay_tao")));
                
                NhanVien nhanVien = new NhanVien();
                nhanVien.setHoTen(rs.getString("ten_nhan_vien"));
                hoaDon.setNhanVien(nhanVien);
                
                KhachHang kh = new KhachHang();
                kh.setTen(rs.getString("ten_khach_hang"));
                hoaDon.setKhachHang(kh);
                
                KhuyenMai khuyenMai = new KhuyenMai();
                khuyenMai.setPhanTram(rs.getDouble("phan_tram_giam"));
                hoaDon.setKhuyenMai(khuyenMai);
                
                SanPham sanPham = new SanPham();
                sanPham.setTen(rs.getString("ten_san_pham"));
                hoaDon.setSanPham(sanPham);
                
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setSoLuong(rs.getInt("so_luong"));
                hdct.setDonGia(rs.getBigDecimal("don_gia"));
                hdct.setTongTien(rs.getBigDecimal("tongtien"));
                hoaDon.setDonChiTiet(hdct);
                
                
                list.add(hoaDon);                         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
