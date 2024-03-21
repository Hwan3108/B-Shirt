/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilities.DBConnect;
import model.ChatLieu;
/**
 *
 * @author Hwan
 */
public class ChatLieuRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<ChatLieu> getAll() {
        sql = "SELECT * FROM CHATLIEU";
        List<ChatLieu> listCL = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                ChatLieu cl = new ChatLieu(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getBoolean(5));
                listCL.add(cl);
            }
            return listCL;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public void add(ChatLieu cl) {
        sql = "INSERT INTO CHATLIEU (id, ten, ngayTao, ngaySua, trangThai) VALUES (?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getId());
            ps.setString(2, cl.getTen());
            ps.setObject(3, cl.getNgayTao());
            ps.setObject(4, cl.getNgaySua());
            ps.setBoolean(5, cl.isTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
      
    public void update(ChatLieu cl) {
        sql = "UPDATE CHATLIEU SET ten=?, ngayTao=?, ngaySua=?, trangThai=? WHERE id=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getTen());
            ps.setObject(2, cl.getNgayTao());
            ps.setObject(3, cl.getNgaySua());
            ps.setBoolean(4, cl.isTrangThai());
            ps.setString(5, cl.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
