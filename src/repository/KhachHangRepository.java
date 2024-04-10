/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;


import domainmodel.KhachHang;
import java.util.ArrayList;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import ultilities.DBConnect;

/**
 *
 * @author TLC
 */
public class KhachHangRepository {

    DBConnect dBconnection;
    SimpleDateFormat format = new SimpleDateFormat("MM-dd-YYYY");

    public ArrayList<KhachHang> getAll() {
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "select * from khach_hang";
        try (Connection con = dBconnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String maKH = rs.getString("ma_khach_hang");
                String ten = rs.getString("ten_khach_hang");
                String SDT = rs.getString("sdt");
                String diaChi = rs.getString("dia_chi");
                boolean gioiTinh = rs.getBoolean("gioi_tinh");
                Date ngaySinh = (Date) Date.valueOf(rs.getString("ngay_sinh"));
                String email = rs.getString("email");
                String cccd = rs.getString("cccd");
                Date ngayTao = (Date) Date.valueOf(rs.getString("ngay_tao"));
                Date ngaySua = (Date) Date.valueOf(rs.getString("ngay_sua"));
                boolean trangThai = rs.getBoolean("trang_thai");
                KhachHang khachHang = new KhachHang(id, maKH, ten, SDT, ngaySinh, gioiTinh, diaChi, email, cccd, ngayTao, ngaySua, trangThai);
                list.add(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean add(KhachHang kh) {
        String sql = "INSERT INTO khach_hang (ma_khach_hang, ten_khach_hang, sdt, ngay_sinh, gioi_tinh, dia_chi, email, cccd, trang_thai, ngay_tao, ngay_sua)\n"
                + "VALUES (NEWID(), ?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), GETDATE())";
        try (Connection con = dBconnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, kh.getTen());
            pst.setString(2, kh.getSDT());
            pst.setString(3, format.format(kh.getNgaySinh()));
            pst.setBoolean(4, kh.isGioiTinh());
            pst.setString(5, kh.getDiaChi());
            pst.setString(6, kh.getEmail());
            pst.setString(7, kh.getCccd());
            pst.setBoolean(8, kh.isTrangThai());

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(KhachHang kh) {
        String sql = "update khach_hang set ten_khach_hang=?, sdt=?, ngay_sinh=?, gioi_tinh=?, dia_chi=?, email=?, cccd=?,trang_thai=?,ngay_sua = GETDATE() where id=?";
        try (Connection con = dBconnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, kh.getTen());
            pst.setString(2, kh.getSDT());
            pst.setString(3, format.format(kh.getNgaySinh()));
            pst.setObject(4, kh.isGioiTinh());
            pst.setString(5, kh.getDiaChi());
            pst.setString(6, kh.getEmail());
            pst.setString(7, kh.getCccd());
            pst.setBoolean(8, kh.isTrangThai());
            pst.setInt(9, kh.getId());

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<KhachHang> searchGT(int gt) {
        String sql = "select * from khach_hang where gioi_tinh ="+gt+" ";
        ArrayList<KhachHang> list = new ArrayList<>();

        try (Connection con = dBconnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
         
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String maKH = rs.getString("ma_khach_hang");
                String ten = rs.getString("ten_khach_hang");
                String SDT = rs.getString("sdt");
                String diaChi = rs.getString("dia_chi");
                boolean gioiTinh = rs.getBoolean("gioi_tinh");
                Date ngaySinh = (Date) Date.valueOf(rs.getString("ngay_sinh"));
                String email = rs.getString("email");
                String cccd = rs.getString("cccd");
                Date ngayTao = (Date) Date.valueOf(rs.getString("ngay_tao"));
                Date ngaySua = (Date) Date.valueOf(rs.getString("ngay_sua"));
                boolean trangThai = rs.getBoolean("trang_thai");
                KhachHang khachHang = new KhachHang(id, maKH, ten, SDT, ngaySinh, gioiTinh, diaChi, email, cccd, ngayTao, ngaySua, trangThai);
                list.add(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<KhachHang> searchLayTT(int tt) {
        String sql = "select * from khach_hang where trang_thai ="+tt+" ";
        ArrayList<KhachHang> list = new ArrayList<>();
        try (Connection con = dBconnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {        
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String maKH = rs.getString("ma_khach_hang");
                String ten = rs.getString("ten_khach_hang");
                String SDT = rs.getString("sdt");
                String diaChi = rs.getString("dia_chi");
                boolean gioiTinh = rs.getBoolean("gioi_tinh");
                Date ngaySinh = (Date) Date.valueOf(rs.getString("ngay_sinh"));
                String email = rs.getString("email");
                String cccd = rs.getString("cccd");
                Date ngayTao = (Date) Date.valueOf(rs.getString("ngay_tao"));
                Date ngaySua = (Date) Date.valueOf(rs.getString("ngay_sua"));
                boolean trangThai = rs.getBoolean("trang_thai");
                KhachHang khachHang = new KhachHang(id, maKH, ten, SDT, ngaySinh, gioiTinh, diaChi, email, cccd, ngayTao, ngaySua, trangThai);
                list.add(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

     public ArrayList<KhachHang> laySDT(String tenKH) {
        ArrayList<KhachHang> list = new ArrayList<>();
       String sql = "select sdt from khach_hang where ten_khach_hang like N'%"+tenKH+"%'";
        try (Connection con = dBconnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {          
                String SDT = rs.getString("sdt");             
                KhachHang khachHang = new KhachHang(SDT);
                list.add(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
      public ArrayList<KhachHang> layTen() {
        ArrayList<KhachHang> list = new ArrayList<>();
       String sql = "select ten_khach_hang from khach_hang";
        try (Connection con = dBconnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {          
                String ten = rs.getString("ten_khach_hang");             
                KhachHang khachHang = new KhachHang(ten, null, null, true, null, null, null, true);
                list.add(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
