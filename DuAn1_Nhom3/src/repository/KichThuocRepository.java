package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import model.KichThuoc;
/**
 *
 * @author Hwan
 */
public class KichThuocRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<KichThuoc> getAll() {
        sql = "SELECT * FROM KICHTHUOC ORDER BY id DESC";
        List<KichThuoc> listKT = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                KichThuoc kt = new KichThuoc(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getBoolean(5));
                listKT.add(kt);
            }
            return listKT;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public void add(KichThuoc kt) {
        sql = "INSERT INTO KICHTHUOC (id, ten, ngayTao, ngaySua, trangThai) VALUES (?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kt.getId());
            ps.setString(2, kt.getTen());
            ps.setObject(3, kt.getNgayTao());
            ps.setObject(4, kt.getNgaySua());
            ps.setBoolean(5, kt.isTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void update(KichThuoc kt) {
        sql = "UPDATE KICHTHUOC SET ten=?, ngayTao=?, ngaySua=?, trangThai=? WHERE id=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kt.getTen());
            ps.setObject(2, kt.getNgayTao());
            ps.setObject(3, kt.getNgaySua());
            ps.setBoolean(4, kt.isTrangThai());
            ps.setString(5, kt.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
