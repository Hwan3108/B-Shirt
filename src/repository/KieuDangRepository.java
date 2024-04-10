package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import domainmodel.KieuDang;

public class KieuDangRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<KieuDang> getAll() {
        sql = "SELECT * FROM kieu_dang";
        List<KieuDang> listKD = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                KieuDang kd = new KieuDang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getDate(6));
                listKD.add(kd);
            }
            return listKD;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void add(KieuDang kd) {
        sql = "INSERT INTO kieu_dang(ma_kieu_dang,ten_kieu_dang,trang_thai,ngay_tao,ngay_sua) VALUES (NEWID(),?,?,GETDATE(),GETDATE())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kd.getTen());
            ps.setBoolean(2, kd.isTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
    public void update(KieuDang kd) {
        sql = "UPDATE kieu_dang SET ten_kieu_dang = ?, ngay_sua = GETDATE(), trang_thai = ? WHERE id = ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kd.getTen());
            ps.setObject(2, kd.isTrangThai());
            ps.setObject(3, kd.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
