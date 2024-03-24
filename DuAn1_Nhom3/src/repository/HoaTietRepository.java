package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import model.HoaTiet;

public class HoaTietRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<HoaTiet> getAll() {
        sql = "SELECT * FROM hoa_tiet";
        List<HoaTiet> listHT = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                HoaTiet ht = new HoaTiet(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getDate(6));
                listHT.add(ht);
            }
            return listHT;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void add(HoaTiet ht) {
        sql = "INSERT INTO hoa_tiet(ma_hoa_tiet,ten_hoa_tiet,trang_thai,ngay_tao,ngay_sua) VALUES (NEWID(),?,?,GETDATE(),NULL)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ht.getTen());
            ps.setBoolean(2, ht.isTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
    public void update(HoaTiet ht) {
        sql = "UPDATE hoa_tiet SET ten_hoa_tiet = ?, ngay_sua = GETDATE(), trang_thai = ? WHERE id = ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ht.getTen());
            ps.setObject(2, ht.isTrangThai());
            ps.setObject(3, ht.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
