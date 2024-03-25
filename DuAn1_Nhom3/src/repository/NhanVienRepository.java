package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import ultilities.DBConnect;

public class NhanVienRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<NhanVien> getAll() {
        sql = "SELECT * FROM nhan_vien";
        List<NhanVien> listNV = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                NhanVien nv = new NhanVien(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getBoolean(5),rs.getString(6),rs.getDate(7),
                        rs.getBoolean(8),rs.getString(9),rs.getString(10),rs.getString(11),
                        rs.getInt(12),rs.getDate(13),rs.getDate(14));
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean add(NhanVien nv) {
        sql =   "INSERT INTO nhan_vien(ma_nhan_vien,ten_nhan_vien,mat_khau,chuc_vu,sdt,ngay_sinh,"
                + "gioi_tinh,dia_chi,email,cccd,trang_thai,ngay_tao,ngay_sua)\n" +
                "VALUES (NEWID(),?,?,?,?,?,?,?,?,?,?,GETDATE(),GETDATE())";
        int check = 0;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getHoTen());
            ps.setObject(2, nv.getMatKhau());
            ps.setObject(3, nv.isChucVu());
            ps.setObject(4, nv.getSdt());
            ps.setObject(5, nv.getNgaySinh());
            ps.setObject(6, nv.isGioiTinh());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getEmail());
            ps.setObject(9, nv.getCccd());
            ps.setObject(10, nv.getTrangThai());
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    public boolean update(NhanVien nv, int id) {
        sql =   "UPDATE nhan_vien SET ten_nhan_vien = ?, mat_khau = ?, chuc_vu = ?, sdt = ? , ngay_sinh = ?,"
                + "gioi_tinh = ?, dia_chi = ?, email = ?, cccd = ?, trang_thai = ?, ngay_sua = GETDATE() WHERE id = ?";
        int check = 0;
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getHoTen());
            ps.setObject(2, nv.getMatKhau());
            ps.setObject(3, nv.isChucVu());
            ps.setObject(4, nv.getSdt());
            ps.setObject(5, nv.getNgaySinh());
            ps.setObject(6, nv.isGioiTinh());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getEmail());
            ps.setObject(9, nv.getCccd());
            ps.setObject(10, nv.getTrangThai());
            ps.setObject(11, id);
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
