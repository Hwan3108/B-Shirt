/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.KhachHang_ThongKe;
import domainmodel.NhanVien_ThongKe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ultilities.DBConnect;

/**
 *
 * @author phtua
 */
public class ThongKe_KhachHangRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    ArrayList<KhachHang_ThongKe> list = new ArrayList<>();

    public ArrayList<KhachHang_ThongKe> getAll() {
        sql = "SELECT TOP(5) SUM(hoa_don_chi_tiet.so_luong * hoa_don_chi_tiet.don_gia) AS doanhthu, "
                + "SUM(hoa_don_chi_tiet.so_luong) AS soluongmua, "
                + "hoa_don.id_khach_hang, "
                + "khach_hang.ten_khach_hang "
                + "FROM hoa_don "
                + "INNER JOIN hoa_don_chi_tiet ON hoa_don.id = hoa_don_chi_tiet.id_hoa_don "
                + "INNER JOIN khach_hang ON khach_hang.id = hoa_don.id_khach_hang "
                + "GROUP BY hoa_don.id_khach_hang, khach_hang.ten_khach_hang "
                + "ORDER BY doanhthu DESC;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang_ThongKe khachHang_ThongKe = new KhachHang_ThongKe(
                        rs.getInt("id_khach_hang"),
                        rs.getString("ten_khach_hang"),
                        rs.getInt("soluongmua"),
                        rs.getFloat("doanhthu"));

                list.add(khachHang_ThongKe);
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để xem có gì không ổn    
        }
        return list;
    }

}
