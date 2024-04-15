/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.SanPham_ThongKe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ultilities.DBConnect;

/**
 *
 * @author phtua
 */
public class ThongKe_SanPhamRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    ArrayList<SanPham_ThongKe> list = new ArrayList<>();

    public ArrayList<SanPham_ThongKe> getAll() {
        sql = "SELECT TOP(5) "
                + "SUM(hoa_don_chi_tiet.so_luong) AS soluongban, "
                + "san_pham.ma_san_pham, "
                + "san_pham.ten_san_pham, "
                + "spct.so_luong, "
                + "SUM(hoa_don_chi_tiet.so_luong * spct.gia) AS doanhthu "
                + "FROM hoa_don "
                + "INNER JOIN hoa_don_chi_tiet ON hoa_don.id = hoa_don_chi_tiet.id_hoa_don "
                + "INNER JOIN spct ON hoa_don_chi_tiet.id_spct = spct.id "
                + "INNER JOIN san_pham ON san_pham.id = spct.id_san_pham "
                + "GROUP BY san_pham.ma_san_pham, san_pham.ten_san_pham, spct.so_luong "
                + "ORDER BY doanhthu DESC;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham_ThongKe sanPham_thongKe = new SanPham_ThongKe(
                        rs.getString("ma_san_pham"),
                        rs.getString("ten_san_pham"),
                        rs.getInt("so_luong"), 
                        rs.getInt("soluongban"),
                        rs.getFloat("doanhthu"));

                list.add(sanPham_thongKe);
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để xem có gì không ổn    
        }
        return list;
    }

}
