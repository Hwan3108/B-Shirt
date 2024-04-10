package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import domainmodel.HinhAnh;
import java.awt.Image;
import javax.swing.ImageIcon;

public class HinhAnhRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<HinhAnh> getAll() {
        sql = "SELECT * FROM hinh_anh";
        List<HinhAnh> listHA = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HinhAnh ha = new HinhAnh(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getDate(6));
                listHA.add(ha);
            }
            return listHA;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(HinhAnh ha) {
        sql = "INSERT INTO hinh_anh(ma_hinh_anh,duong_dan,trang_thai,ngay_tao,ngay_sua) VALUES (NEWID(),?,?,GETDATE(),GETDATE())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ha.getDuongDan());
            ps.setBoolean(2, ha.isTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(HinhAnh ha) {
        sql = "UPDATE hinh_anh SET ten_hinh_anh = ?, ngay_sua = GETDATE(), trang_thai = ? WHERE id = ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ha.getDuongDan());
            ps.setObject(2, ha.isTrangThai());
            ps.setObject(3, ha.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<HinhAnh> getAnh(int id) {
        sql = "SELECT hinh_anh.duong_dan\n"
                + "FROM hinh_anh\n"
                + "JOIN spct ON hinh_anh.id = spct.id_hinh_anh\n"
                + "WHERE spct.id = "+id+";";
        List<HinhAnh> listHA = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String imagePath = rs.getString("duong_dan");
                ImageIcon  imageIcon = new ImageIcon(imagePath);
                HinhAnh ha = new HinhAnh(imagePath);
                listHA.add(ha);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return listHA;
    }

}
