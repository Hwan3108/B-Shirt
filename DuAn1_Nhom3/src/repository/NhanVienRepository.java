/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import model.NhanVien;
import ultilities.DBConnect;
/**
 *
 * @author Hwan
 */
public class NhanVienRepository {
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    
    public List<NhanVien> getAll() {
        sql =   "SELECT id, matKhau, ten, chucVu, SDT, ngaySinh, gioiTinh, diaChi, ngayTao, ngaySua, trangThai FROM NHANVIEN";
        List<NhanVien> listNV = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getDate(6), rs.getBoolean(7), rs.getString(8), rs.getDate(9), rs.getDate(10), rs.getBoolean(11));
                listNV.add(nv);
            }
            return listNV;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            }
        return null;
    }
    
    public boolean add(NhanVien nv) {
        sql = "INSERT INTO NHANVIEN (id, matKhau, ten, chucVu, SDT, ngaySinh, gioiTinh, diaChi) VALUES (?,?,?,?,?,?,?,?)";
        int check = 0;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getId());
            ps.setObject(2, nv.getMatKhau());
            ps.setObject(3, nv.getTen());
            ps.setObject(4, nv.isChucVu());
            ps.setObject(5, nv.getSDT());
            ps.setObject(6, nv.getNgaySinh());
            ps.setObject(7, nv.isGioiTinh());
            ps.setObject(8, nv.getDiaChi());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(NhanVien nv, String id) {
        sql = "UPDATE NHANVIEN SET matKhau = ?, ten = ?, chucVu = ?, SDT = ?, ngaySinh = ?, gioiTinh = ?, diaChi = ?, trangThai=? WHERE id=?";
        int check = 0;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getMatKhau());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.isChucVu());
            ps.setObject(4, nv.getSDT());
            ps.setObject(5, nv.getNgaySinh());
            ps.setObject(6, nv.isGioiTinh());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.isTrangThai());
            ps.setObject(9, id);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
}
