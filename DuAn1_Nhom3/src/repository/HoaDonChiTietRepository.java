package repository;

import domainmodel.HoaDonChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import view.model.GioHangViewModel;

public class HoaDonChiTietRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<HoaDonChiTiet> getAll() {
        sql = "SELECT * FROM hoa_don_chi_tiet";
        List<HoaDonChiTiet> list = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5), rs.getDate(6), rs.getDate(7), rs.getBoolean(8));
                list.add(hdct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<GioHangViewModel> getGioHangView(int index) {
        sql =   "SELECT hoa_don_chi_tiet.id, san_pham.ma_san_pham, san_pham.ten_san_pham,\n" +
                "hoa_don_chi_tiet.so_luong, spct.gia, hoa_don_chi_tiet.trang_thai FROM hoa_don_chi_tiet\n" +
                "INNER JOIN spct on spct.id = hoa_don_chi_tiet.id_spct\n" +
                "INNER JOIN san_pham on san_pham.id = spct.id_san_pham\n" +
                "WHERE hoa_don_chi_tiet.id_hoa_don = ?";
        List<GioHangViewModel> listGioHang = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, index);
            rs = ps.executeQuery();
            while(rs.next()) {
                GioHangViewModel gioHang = new GioHangViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getBoolean(6));
                listGioHang.add(gioHang);
            }
            return listGioHang;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean add(HoaDonChiTiet hdct) {
        sql = "INSERT INTO hoa_don_chi_tiet (id_hoa_don, id_spct, so_luong, don_gia, trang_thai, ngay_tao, ngay_sua) VALUES (?, ?, ?, ?, ?, GETDATE(), GETDATE())";
        int check = 0;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hdct.getIdHoaDon());
            ps.setObject(2, hdct.getIdSPCT());
            ps.setObject(3, hdct.getSoLuong());
            ps.setObject(4, hdct.getDonGia());
            ps.setObject(5, hdct.isTrangThai());
             
            check = ps.executeUpdate();
        } catch (Exception e) {
             e.printStackTrace();
        }
        return check > 0;
     }
     
    public boolean update(HoaDonChiTiet hdct, int id) {
        sql = "UPDATE hoa_don_chi_tiet SET id_hoa_don = ?, id_spct = ?, so_luong = ?, don_gia = ?, trang_thai = ?, ngay_sua = GETDATE() WHERE id = ?";
        int check = 0;
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hdct.getIdHoaDon());
            ps.setObject(1, hdct.getIdHoaDon());
            ps.setObject(1, hdct.getIdHoaDon());
            ps.setObject(1, hdct.getIdHoaDon());
            ps.setObject(1, hdct.getIdHoaDon());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
    public boolean cancel(int id) {
        sql = "UPDATE hoa_don_chi_tiet SET trang_thai = 0, ngay_sua = GETDATE() WHERE id = ?";
        int check = 0;
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
