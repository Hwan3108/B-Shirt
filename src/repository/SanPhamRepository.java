package repository;

import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import domainmodel.KhachHang;
import domainmodel.KhuyenMai;
import domainmodel.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import domainmodel.SanPham;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.text.DateFormat;

public class SanPhamRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
      SimpleDateFormat format = new SimpleDateFormat("MM-dd-YYYY");

    public List<SanPham> getAll() {
        sql = "SELECT * FROM san_pham";
        List<SanPham> listSP = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                SanPham sp = new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getDate(6));
                listSP.add(sp);
            }
            return listSP;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean add(SanPham sp) {
        sql = "INSERT INTO san_pham(ma_san_pham,ten_san_pham,trang_thai,ngay_tao,ngay_sua) VALUES (NEWID(),?,?,GETDATE(),GETDATE())";
        int check = 0;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sp.getTen());
            ps.setBoolean(2, sp.isTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
      
    public boolean update(SanPham sp) {
        sql = "UPDATE san_pham SET ten_san_pham = ?, ngay_sua = GETDATE(), trang_thai = ? WHERE id = ?;";
        int check = 0;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getTen());
            ps.setObject(2, sp.isTrangThai());
            ps.setObject(3, sp.getId());
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
