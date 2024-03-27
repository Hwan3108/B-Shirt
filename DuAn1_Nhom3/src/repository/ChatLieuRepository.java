package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import domainmodel.ChatLieu;

public class ChatLieuRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<ChatLieu> getAll() {
        sql = "SELECT * FROM chat_lieu";
        List<ChatLieu> listCL = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                ChatLieu cl = new ChatLieu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getDate(6));
                listCL.add(cl);
            }
            return listCL;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void add(ChatLieu cl) {
        sql = "INSERT INTO chat_lieu(ma_chat_lieu,ten_chat_lieu,trang_thai,ngay_tao,ngay_sua) VALUES (NEWID(),?,?,GETDATE(),GETDATE())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getTen());
            ps.setBoolean(2, cl.isTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
    public void update(ChatLieu cl) {
        sql = "UPDATE chat_lieu SET ten_chat_lieu = ?, ngay_sua = GETDATE(), trang_thai = ? WHERE id = ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, cl.getTen());
            ps.setObject(2, cl.isTrangThai());
            ps.setObject(3, cl.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
