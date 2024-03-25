package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import model.KichThuoc;

public class KichThuocRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<KichThuoc> getAll() {
        sql = "SELECT * FROM kich_thuoc";
        List<KichThuoc> listKT = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                KichThuoc kt = new KichThuoc(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getDate(6));
                listKT.add(kt);
            }
            return listKT;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void add(KichThuoc kt) {
        sql = "INSERT INTO kich_thuoc(ma_kich_thuoc,ten_kich_thuoc,trang_thai,ngay_tao,ngay_sua) VALUES (NEWID(),?,?,GETDATE(),GETDATE())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kt.getTen());
            ps.setBoolean(2, kt.isTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
    public void update(KichThuoc kt) {
        sql = "UPDATE kich_thuoc SET ten_kich_thuoc = ?, ngay_sua = GETDATE(), trang_thai = ? WHERE id = ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kt.getTen());
            ps.setObject(2, kt.isTrangThai());
            ps.setObject(3, kt.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
