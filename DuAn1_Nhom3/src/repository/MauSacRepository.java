package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import model.MauSac;

public class MauSacRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<MauSac> getAll() {
        sql = "SELECT * FROM mau_sac";
        List<MauSac> listMS = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                MauSac ms = new MauSac(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getDate(6));
                listMS.add(ms);
            }
            return listMS;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void add(MauSac ms) {
        sql = "INSERT INTO mau_sac(ma_mau,ten_mau,trang_thai,ngay_tao,ngay_sua) VALUES (NEWID(),?,?,GETDATE(),GETDATE())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ms.getTen());
            ps.setBoolean(2, ms.isTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
    public void update(MauSac ms) {
        sql = "UPDATE mau_sac SET ten_mau = ?, ngay_sua = GETDATE(), trang_thai = ? WHERE id = ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ms.getTen());
            ps.setObject(2, ms.isTrangThai());
            ps.setObject(3, ms.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
