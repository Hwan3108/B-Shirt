package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import model.MauSac;
/**
 *
 * @author Hwan
 */
public class MauSacRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<MauSac> getAll() {
        sql = "SELECT * FROM MAUSAC ORDER BY id DESC";
        List<MauSac> listMS = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                MauSac ms = new MauSac(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getBoolean(5));
                listMS.add(ms);
            }
            return listMS;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public void add(MauSac ms) {
        sql = "INSERT INTO MAUSAC (id, ten, ngayTao, ngaySua, trangThai) VALUES (?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ms.getId());
            ps.setString(2, ms.getTen());
            ps.setObject(3, ms.getNgayTao());
            ps.setObject(4, ms.getNgaySua());
            ps.setBoolean(5, ms.isTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public void update(MauSac ms) {
        sql = "UPDATE MAUSAC SET ten=?, ngayTao=?, ngaySua=?, trangThai=? WHERE id=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ms.getTen());
            ps.setObject(2, ms.getNgayTao());
            ps.setObject(3, ms.getNgaySua());
            ps.setBoolean(4, ms.isTrangThai());
            ps.setString(5, ms.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
