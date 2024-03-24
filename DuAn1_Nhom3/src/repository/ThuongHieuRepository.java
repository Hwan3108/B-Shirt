package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import model.ThuongHieu;

public class ThuongHieuRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<ThuongHieu> getAll() {
        sql = "SELECT * FROM thuong_hieu";
        List<ThuongHieu> listTH = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                ThuongHieu th = new ThuongHieu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getDate(6));
                listTH.add(th);
            }
            return listTH;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void add(ThuongHieu th) {
        sql = "INSERT INTO thuong_hieu(ma_mau,ten_mau,trang_thai,ngay_tao,ngay_sua) VALUES (NEWID(),?,?,GETDATE(),NULL)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, th.getTen());
            ps.setBoolean(2, th.isTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
    public void update(ThuongHieu th) {
        sql = "UPDATE thuong_hieu SET ten_mau = ?, ngay_sua = GETDATE(), trang_thai = ? WHERE id = ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, th.getTen());
            ps.setObject(2, th.isTrangThai());
            ps.setObject(3, th.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
