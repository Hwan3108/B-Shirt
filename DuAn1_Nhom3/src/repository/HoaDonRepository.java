package repository;

import model.HoaDon;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.*;
import ultilities.DBConnect;

public class HoaDonRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";
    
    DBConnect dBconnection;
    SimpleDateFormat format = new SimpleDateFormat("MM-dd-YYYY");
    
    
     public ArrayList<HoaDon> getAll() {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select * from hoa_don";
        try (Connection con = dBconnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idKH = rs.getInt("id_khach_hang");
                int idNV = rs.getInt("id_nhan_vien");
                int idPhieuGiamGia = rs.getInt("id_phieu_giam_gia");
                String maHoaDon = rs.getString("ma_hoa_don");
                boolean PTTT = rs.getBoolean("pttt");
                Date ngayTao = (Date) Date.valueOf(rs.getString("ngay_tao"));
                Date ngaySua = (Date) Date.valueOf(rs.getString("ngay_sua"));
                int trangThai = rs.getInt("trang_thai");
                
                HoaDon hd = new HoaDon(id, idNV, idKH, idPhieuGiamGia, maHoaDon, PTTT, ngayTao, ngaySua, trangThai);
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<HoaDon> search(int idHD) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select * from hoa_don where id='"+idHD+"'";
        try (Connection con = dBconnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idNV = rs.getInt("id_nhan_vien");
                int idKH = rs.getInt("id_khach_hang");
                int idPhieuGiamGia = rs.getInt("id_phieu_giam_gia");
                String maHoaDon = rs.getString("ma_hoa_don");
                boolean pttt = rs.getBoolean("pttt");
                Date ngayTao = (Date) Date.valueOf(rs.getString("ngay_tao"));
                Date ngaySua = (Date) Date.valueOf(rs.getString("ngay_sua"));               
                int trangThai = rs.getInt("trang_thai");
               
                HoaDon hd = new HoaDon(id, idNV, idKH, idPhieuGiamGia, maHoaDon, pttt, ngayTao, ngaySua, trangThai);
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
        
    public void create() {
        sql =   "INSERT INTO hoa_don (ma_hoa_don,trang_thai,ngay_tao,ngay_sua)\n" +
                "VALUES (NEWID(),2,GETDATE(),GETDATE())";
        try {
            con = dBconnection.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cancel(int id) {
        sql = "UPDATE hoa_don SET trang_thai = 3 WHERE id = ?";
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkout(HoaDon hd, int id) {
        sql =   "UPDATE hoa_don SET id_khach_hang = ?, id_phieu_giam_gia = ?, pttt = ?, trang_thai = 1,"
                + "ngay_sua = GETDATE() WHERE id = ?";
        int check = 0;
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hd.getIdKhachHang());
            ps.setObject(2, hd.getIdPhieuGiamGia());
            ps.setObject(3, hd.isPTTT());
            ps.setObject(4, id);
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
