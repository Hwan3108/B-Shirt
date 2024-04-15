package repository;

import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import domainmodel.KhachHang;
import domainmodel.KhuyenMai;
import domainmodel.NhanVien;
import domainmodel.SanPham;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import view.model.GioHangViewModel;
import view.model.SPCTViewModel;
import java.sql.*;
public class HoaDonChiTietRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    SimpleDateFormat format = new SimpleDateFormat("MM-dd-YYYY");

    public List<HoaDonChiTiet> getAll() {
        sql = "SELECT * FROM hoa_don_chi_tiet";
        List<HoaDonChiTiet> list = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
             
                int id = rs.getInt(1);
                int field2 = rs.getInt(2);
                int field3 = rs.getInt(3);
                int field4 = rs.getInt(4);
                BigDecimal field5 = rs.getBigDecimal(5);
                Date field6 = (Date) Date.valueOf(rs.getString(7)); // Chuyển đổi từ chuỗi sang Date
                Date field7 = (Date) Date.valueOf(rs.getString(8)); // Chuyển đổi từ chuỗi sang Date
                boolean field8 = rs.getBoolean(6);

                HoaDonChiTiet hdct = new HoaDonChiTiet(id, field2, field3, field4, field5, field6, field7, field8);
                list.add(hdct);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
           
        }
         return list;
    }

    public List<GioHangViewModel> getGioHangView(int index) {
        sql = "SELECT hoa_don_chi_tiet.id_spct, spct.ma_spct, san_pham.ten_san_pham, SUM(hoa_don_chi_tiet.so_luong), spct.gia, hoa_don_chi_tiet.trang_thai FROM hoa_don_chi_tiet\n"
                + "INNER JOIN spct on spct.id = hoa_don_chi_tiet.id_spct \n"
                + "INNER JOIN san_pham on san_pham.id = spct.id_san_pham\n"
                + "WHERE hoa_don_chi_tiet.id_hoa_don = ?\n"
                + "GROUP BY hoa_don_chi_tiet.id_spct, spct.ma_spct, san_pham.ten_san_pham, spct.gia, hoa_don_chi_tiet.trang_thai";
        List<GioHangViewModel> listGioHang = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                GioHangViewModel gioHang = new GioHangViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBigDecimal(5), rs.getBoolean(6));
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

    public boolean delete(int idHD, int idSP) {
        sql = "UPDATE spct SET spct.so_luong += hoa_don_chi_tiet.so_luong FROM spct \n"
                + "INNER JOIN hoa_don_chi_tiet ON spct.id = hoa_don_chi_tiet.id_spct "
                + "WHERE hoa_don_chi_tiet.id_hoa_don = ? and hoa_don_chi_tiet.id_spct = ? \n"
                + "UPDATE hoa_don_chi_tiet SET id_hoa_don = NULL, id_spct = NULL, so_luong = NULL, "
                + "don_gia = NULL, trang_thai = 0, ngay_sua = GETDATE()"
                + "WHERE hoa_don_chi_tiet.id_hoa_don = ? and hoa_don_chi_tiet.id_spct = ? ";
        int check = 0;

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, idHD);
            ps.setObject(2, idSP);
            ps.setObject(3, idHD);
            ps.setObject(4, idSP);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean buy(SPCTViewModel spctv, int idHD) {
        sql = "INSERT INTO hoa_don_chi_tiet(id_hoa_don, id_spct, so_luong, don_gia, trang_thai, ngay_tao, ngay_sua) VALUES (?,?,1,?,1,GETDATE(),GETDATE())\n"
                + "UPDATE spct SET so_luong -= 1 WHERE id = ?";
        int check = 0;

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, idHD);
            ps.setObject(2, spctv.getId());
            ps.setObject(3, spctv.getGia());
            ps.setObject(4, spctv.getId());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean addMore(List<SPCTViewModel> list, int idSPCT, int soLuong, int idHD) {
        sql = "UPDATE spct SET so_luong -= ? WHERE id = ?\n"
                + "UPDATE hoa_don_chi_tiet SET so_luong += ? WHERE id_spct = ? and id_hoa_don = ?";
        int check = 0;

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, soLuong);
            ps.setObject(2, idSPCT);
            ps.setObject(3, soLuong);
            ps.setObject(4, idSPCT);
            ps.setObject(5, idHD);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean returnItem(List<SPCTViewModel> list, int idSPCT, int soLuong, int idHD) {
        sql = "UPDATE spct SET so_luong += ? WHERE id = ?\n"
                + "UPDATE hoa_don_chi_tiet SET so_luong -= ? WHERE id_spct = ? and id_hoa_don = ?";
        int check = 0;

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, soLuong);
            ps.setObject(2, idSPCT);
            ps.setObject(3, soLuong);
            ps.setObject(4, idSPCT);
            ps.setObject(5, idHD);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
