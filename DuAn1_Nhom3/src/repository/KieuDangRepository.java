package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import model.KieuDang;
/**
 *
 * @author Hwan
 */
public class KieuDangRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<KieuDang> getAll() {
        sql = "SELECT * FROM KIEUDANG ORDER BY id DESC";
        List<KieuDang> listKD = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                KieuDang kd = new KieuDang(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getBoolean(5));
                listKD.add(kd);
            }
            return listKD;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public void add(KieuDang kd) {
        sql = "INSERT INTO KIEUDANG (id, ten, ngayTao, ngaySua, trangThai) VALUES (?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kd.getId());
            ps.setString(2, kd.getTen());
            ps.setObject(3, kd.getNgayTao());
            ps.setObject(4, kd.getNgaySua());
            ps.setBoolean(5, kd.isTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public void update(KieuDang kd) {
        sql = "UPDATE KIEUDANG SET ten=?, ngayTao=?, ngaySua=?, trangThai=? WHERE id=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kd.getTen());
            ps.setObject(2, kd.getNgayTao());
            ps.setObject(3, kd.getNgaySua());
            ps.setBoolean(4, kd.isTrangThai());
            ps.setString(5, kd.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
