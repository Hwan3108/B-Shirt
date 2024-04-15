/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ultilities.DBConnect;

/**
 *
 * @author phtua
 */
public class ThongKeRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    public float DoanhThuNgay(String ngay) {
        float doanhThuNgay = 0;
        sql = "SELECT SUM(so_luong * don_gia) AS doanhThuNgay FROM hoa_don_chi_tiet WHERE hoa_don_chi_tiet.ngay_tao like "
                + "?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ngay);
            rs = ps.executeQuery();
            while (rs.next()) {
                doanhThuNgay = rs.getFloat("doanhThuNgay");
            }
            return doanhThuNgay;
        } catch (Exception e) {

        }
        return doanhThuNgay;
    }
    public float DoanhThuTheoNgayBat_NgayKetThuc(String ngaybatDau, String NgayKetThuc) {
        float doanhThuNgay = 0;
        sql = "SELECT SUM(so_luong * don_gia) AS doanhThuTheoBatDau FROM hoa_don_chi_tiet WHERE hoa_don_chi_tiet.ngay_tao BETWEEN ? and ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ngaybatDau);
            ps.setString(2, NgayKetThuc);
            rs = ps.executeQuery();
            while (rs.next()) {
                doanhThuNgay = rs.getFloat("doanhThuTheoBatDau");
            }
            return doanhThuNgay;
        } catch (Exception e) {

        }
        return doanhThuNgay;
    }
    public float DoanhThuThang(String Thang) {
        float doanhThuThang = 0;
        sql = "SELECT SUM(so_luong * don_gia) AS doanhThuThang FROM hoa_don_chi_tiet WHERE hoa_don_chi_tiet.ngay_tao like "
                + "?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, Thang);
            rs = ps.executeQuery();
            while (rs.next()) {
                doanhThuThang = rs.getFloat("doanhThuNgay");
            }
            return doanhThuThang;
        } catch (Exception e) {

        }
        return doanhThuThang;
    }
    public float DoanhThuNam(String nam) {
        float doanhThuNam = 0;
        sql = "SELECT SUM(so_luong * don_gia) AS doanhThuThang FROM hoa_don_chi_tiet WHERE hoa_don_chi_tiet.ngay_tao like "
                + "?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nam);
            rs = ps.executeQuery();
            while (rs.next()) {
                doanhThuNam = rs.getFloat("doanhThuNgay");
            }
            return doanhThuNam;
        } catch (Exception e) {

        }
        return doanhThuNam;
    }
    public int TongDonHang(String ngayHomNay) {
        int tongDonHang = 0;
        sql = "SELECT COUNT(hoa_don_chi_tiet.trang_thai) AS so_luong_da_thanh_toan FROM hoa_don_chi_tiet where hoa_don_chi_tiet.ngay_tao like ? ";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ngayHomNay);
            rs = ps.executeQuery();
            while (rs.next()) {
                tongDonHang = rs.getInt("so_luong_da_thanh_toan");
            }
            return tongDonHang;
        } catch (Exception e) {

        }
        return tongDonHang;
    }
    public int TongDonHang_NgayBatDau_NgayKetThuc(String ngaybatDau, String NgayKetThuc) {
        int tongDonHang = 0;
        sql = "SELECT COUNT(hoa_don_chi_tiet.trang_thai) AS so_luong_da_thanh_toan FROM hoa_don_chi_tiet WHERE hoa_don_chi_tiet.ngay_tao BETWEEN ? and ? ";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ngaybatDau);
            ps.setString(2, NgayKetThuc);
            rs = ps.executeQuery();
            while (rs.next()) {
                tongDonHang = rs.getInt("so_luong_da_thanh_toan");
            }
            return tongDonHang;
        } catch (Exception e) {

        }
        return tongDonHang;
    }
    public int TongDonHangThanhCong_NgayBatDau_NgayKetThuc(String ngaybatDau, String NgayKetThuc) {
        int tongDonHang = 0;
        sql = "SELECT COUNT(*) AS so_luong_da_thanh_toan FROM hoa_don_chi_tiet WHERE trang_thai = 1 and hoa_don_chi_tiet.ngay_tao BETWEEN ? and ? ";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ngaybatDau);
            ps.setString(2, NgayKetThuc);
            rs = ps.executeQuery();
            while (rs.next()) {
                tongDonHang = rs.getInt("so_luong_da_thanh_toan");
            }
            return tongDonHang;
        } catch (Exception e) {

        }
        return tongDonHang;
    }
    public int TongDonHangHuy_NgayBatDau_NgayKetThuc(String ngaybatDau, String NgayKetThuc) {
        int tongDonHang = 0;
        sql = "SELECT COUNT(*) AS so_luong_da_thanh_toan FROM hoa_don_chi_tiet WHERE trang_thai = 0 and hoa_don_chi_tiet.ngay_tao BETWEEN ? and ? ";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ngaybatDau);
            ps.setString(2, NgayKetThuc);
            rs = ps.executeQuery();
            while (rs.next()) {
                tongDonHang = rs.getInt("so_luong_da_thanh_toan");
            }
            return tongDonHang;
        } catch (Exception e) {

        }
        return tongDonHang;
    }
    public int TongDonHangThanhCong(String ngayHomNay) {
        int tongDonHang = 0;
        sql = "SELECT COUNT(*) AS so_luong_da_thanh_toan FROM hoa_don_chi_tiet WHERE trang_thai = 1 and hoa_don_chi_tiet.ngay_tao like ? ";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ngayHomNay);
            rs = ps.executeQuery();
            while (rs.next()) {
                tongDonHang = rs.getInt("so_luong_da_thanh_toan");
            }
            return tongDonHang;
        } catch (Exception e) {

        }
        return tongDonHang;
    }
    public int TongDonHangHuy(String ngayHomNay) {
        int tongDonHang = 0;
        sql = "SELECT COUNT(*) AS so_luong_da_thanh_toan FROM hoa_don_chi_tiet WHERE trang_thai = 0 and hoa_don_chi_tiet.ngay_tao like ? ";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ngayHomNay);
            rs = ps.executeQuery();
            while (rs.next()) {
                tongDonHang = rs.getInt("so_luong_da_thanh_toan");
            }
            return tongDonHang;
        } catch (Exception e) {

        }
        return tongDonHang;
    }

}
