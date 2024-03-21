package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import model.ThuongHieu;
/**
 *
 * @author Hwan
 */
public class ThuongHieuRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<ThuongHieu> getAll() {
        sql = "SELECT * FROM THUONGHIEU ORDER BY id DESC";
        List<ThuongHieu> listTH = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                ThuongHieu th = new ThuongHieu(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getBoolean(5));
                listTH.add(th);
            }
            return listTH;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public void add(ThuongHieu th) {
        sql = "INSERT INTO THUONGHIEU (id, ten, ngayTao, ngaySua, trangThai) VALUES (?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, th.getId());
            ps.setString(2, th.getTen());
            ps.setObject(3, th.getNgayTao());
            ps.setObject(4, th.getNgaySua());
            ps.setBoolean(5, th.isTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void update(ThuongHieu th) {
        sql = "UPDATE THUONGHIEU SET ten=?, ngayTao=?, ngaySua=?, trangThai=? WHERE id=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, th.getTen());
            ps.setObject(2, th.getNgayTao());
            ps.setObject(3, th.getNgaySua());
            ps.setBoolean(4, th.isTrangThai());
            ps.setString(5, th.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
