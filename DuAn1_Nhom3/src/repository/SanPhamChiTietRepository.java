package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SanPhamChiTiet;
import ultilities.DBConnect;

public class SanPhamChiTietRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<SanPhamChiTiet> getAll() {
        sql =   "SELECT SPCT.*, CL.ten_chat_lieu, HA.duong_dan, HT.ten_hoa_tiet, KT.ten_kich_thuoc,"
                + "KD.ten_kieu_dang, MS.ten_mau, SP.ten_san_pham, TH.ten_thuong_hieu FROM spct\n" +
                "INNER JOIN chat_lieu CL ON CL.id = SPCT.id_chat_lieu "
                + "INNER JOIN hinh_anh HA ON HA.id = SPCT.id_hinh_anh "
                + "INNER JOIN hoa_tiet HT ON HT.id = SPCT.id_hoa_tiet\n" +
                "INNER JOIN kich_thuoc KT ON KT.id = SPCT.id_kich_thuoc "
                + "INNER JOIN kieu_dang KD ON KD.id = SPCT.id_kieu_dang "
                + "INNER JOIN mau_sac MS ON MS.id = SPCT.id_mau_sac\n" +
                "INNER JOIN san_pham SP ON SP.id = SPCT.id_san_pham "
                + "INNER JOIN thuong_hieu TH ON TH.id = SPCT.id_thuong_hieu";
        List<SanPhamChiTiet> listSPCT = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                SanPhamChiTiet spct = new SanPhamChiTiet(rs.getInt(1),rs.getInt(2),rs.getInt(3),
                        rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),
                        rs.getInt(8),rs.getInt(9),rs.getString(10),rs.getInt(11),rs.getDouble(12),
                        rs.getString(13),rs.getInt(14),rs.getDate(15),rs.getDate(16));
                listSPCT.add(spct);
            }
            return listSPCT;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean add(SanPhamChiTiet spct) {
        sql =   "INSERT INTO spct (id_chat_lieu, id_hinh_anh, id_hoa_tiet, id_kich_thuoc, id_kieu_dang, id_mau_sac, id_san_pham, id_thuong_hieu, ma_spct, so_luong, gia, mo_ta, trang_thai, ngay_tao, ngay_sua)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, NEWID(), ?, ?, ?, ?, GETDATE(), GETDATE())";
        int check = 0;
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, spct.getIdChatLieu());
            ps.setObject(2, spct.getIdHinhAnh());
            ps.setObject(3, spct.getIdHoaTiet());
            ps.setObject(4, spct.getIdKichThuoc());
            ps.setObject(5, spct.getIdKieuDang());
            ps.setObject(6, spct.getIdMauSac());
            ps.setObject(7, spct.getIdSanPham());
            ps.setObject(8, spct.getIdThuongHieu());
            ps.setObject(9, spct.getSoLuong());
            ps.setObject(10, spct.getGia());
            ps.setObject(11, spct.getMoTa());
            ps.setObject(12, spct.getTrangThai());
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
    public boolean update(SanPhamChiTiet spct, int id) {
        sql =   "UPDATE hoa_don_chi_tiet \n" +
                "SET \n" +
                "    id_chat_lieu = ?,\n" +
                "    id_hinh_anh = ?,\n" +
                "    id_hoa_tiet = ?,\n" +
                "    id_kich_thuoc = ?,\n" +
                "    id_kieu_dang = ?,\n" +
                "    id_mau_sac = ?,\n" +
                "    id_san_pham = ?,\n" +
                "    id_thuong_hieu = ?,\n" +
                "    ma_spct = ?,\n" +
                "    so_luong = ?,\n" +
                "    gia = ?,\n" +
                "    mo_ta = ?,\n" +
                "    trang_thai = ?,\n" +
                "    ngay_sua = GETDATE()";
        int check = 0;
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, spct.getIdChatLieu());
            ps.setObject(2, spct.getIdHinhAnh());
            ps.setObject(3, spct.getIdHoaTiet());
            ps.setObject(4, spct.getIdKichThuoc());
            ps.setObject(5, spct.getIdKieuDang());
            ps.setObject(6, spct.getIdMauSac());
            ps.setObject(7, spct.getIdSanPham());
            ps.setObject(8, spct.getIdThuongHieu());
            ps.setObject(9, spct.getMa());
            ps.setObject(10, spct.getSoLuong());
            ps.setObject(11, spct.getGia());
            ps.setObject(12, spct.getMoTa());
            ps.setObject(13, spct.getTrangThai());
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
