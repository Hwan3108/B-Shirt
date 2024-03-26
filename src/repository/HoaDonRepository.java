package repository;

import model.HoaDon;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.*;

public class HoaDonRepository {
    DBconnection dBconnection;
    SimpleDateFormat format = new SimpleDateFormat("MM-dd-YYYY");
    
    
     public ArrayList<HoaDon> getAll() {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select * from HoaDon";
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
        String sql = "select * from HoaDon where id='"+idHD+"'";
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

}
