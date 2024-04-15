/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

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
public class ThongKe_NhanVienRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    ArrayList<NhanVien_ThongKe> list = new ArrayList<>();

    public ArrayList<NhanVien_ThongKe> getAll() {
        sql = "SELECT TOP(5) "
                + "SUM(hoa_don_chi_tiet.so_luong * hoa_don_chi_tiet.don_gia) AS doanhthu, "
                + "SUM(hoa_don_chi_tiet.so_luong) as soluongban, "
                + "hoa_don.id_nhan_vien, "
                + "nhan_vien.ten_nhan_vien "
                + "FROM hoa_don "
                + "INNER JOIN hoa_don_chi_tiet ON hoa_don.id = hoa_don_chi_tiet.id_hoa_don "
                + "INNER JOIN nhan_vien ON nhan_vien.id = hoa_don.id_nhan_vien "
                + "GROUP BY hoa_don.id_nhan_vien, nhan_vien.ten_nhan_vien "
                + "ORDER BY doanhthu DESC;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien_ThongKe nhanVien_ThongKe = new NhanVien_ThongKe(rs.getInt("id_nhan_vien"), rs.getString("ten_nhan_vien"),
                        rs.getInt("soluongban"), rs.getFloat("doanhthu"));

                list.add(nhanVien_ThongKe);
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để xem có gì không ổn    
        }
        return list;
    }

}
