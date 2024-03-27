package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import domainmodel.KhuyenMai;
import ultilities.DBConnect;

public class KhuyenMaiRepository {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    private List<KhuyenMai> listKM = null;

    public List<KhuyenMai> getAll() {

        try {
            listKM = new ArrayList<>();
            sql = "select * from phieu_giam_gia";
            this.connectionAndPrepareStatement();
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String maKhuyenMai = rs.getString(2);
                String tenKhuyenMai = rs.getString(3);
                double phanTram = rs.getDouble(4);
                Date ngayBatDau = rs.getDate(5);
                Date ngayKetThuc = rs.getDate(6);
                String moTa = rs.getString(7);
                int trangThai = rs.getInt(8);
                Date ngayTao = rs.getDate(9);
                Date ngaySua = rs.getDate(10);

                KhuyenMai km = new KhuyenMai(id, maKhuyenMai, tenKhuyenMai, phanTram, moTa, ngayBatDau, ngayKetThuc, trangThai, ngayTao, ngaySua);
                listKM.add(km);
            }

            return listKM;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            this.closeAll();
        }

    }

    public KhuyenMai getById(int id) {
        try {
            KhuyenMai km = null;
            listKM = new ArrayList<>();
            sql = "select * from phieu_giam_gia where id=?";
            this.connectionAndPrepareStatement();
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maKhuyenMai = rs.getString(2);
                String tenKhuyenMai = rs.getString(3);
                double phanTram = rs.getDouble(4);
                Date ngayBatDau = rs.getDate(5);
                Date ngayKetThuc = rs.getDate(6);
                String moTa = rs.getString(7);
                int trangThai = rs.getInt(8);
                Date ngayTao = rs.getDate(9);
                Date ngaySua = rs.getDate(10);

                km = new KhuyenMai(id, maKhuyenMai, tenKhuyenMai, phanTram, moTa, ngayBatDau, ngayKetThuc, trangThai, ngayTao, ngaySua);
            }
            return km;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            this.closeAll();
        }
    }

    public List<KhuyenMai> getByMa(String ma) {
        try {
            listKM = new ArrayList<>();
            sql = "select * from phieu_giam_gia where ma_phieu like '" + ma + "%'";
            this.connectionAndPrepareStatement();
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String tenKhuyenMai = rs.getString(2);
                String maKhuyenMai = rs.getString(3);
                double phanTram = rs.getDouble(4);
                Date ngayBatDau = rs.getDate(5);
                Date ngayKetThuc = rs.getDate(6);
                String moTa = rs.getString(7);
                int trangThai = rs.getInt(8);
                Date ngayTao = rs.getDate(9);
                Date ngaySua = rs.getDate(10);

                KhuyenMai km = new KhuyenMai(id, maKhuyenMai, tenKhuyenMai, phanTram, moTa, ngayBatDau, ngayKetThuc, trangThai, ngayTao, ngaySua);
                listKM.add(km);
            }

            return listKM;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            this.closeAll();
        }
    }

    public List<KhuyenMai> getByTrangThai(int choice) {
        switch (choice) {
            case 0:
                sql = "select * from phieu_giam_gia where ? between ngay_bat_dau and ngay_ket_thuc";
                break;
            case 1:
                sql = "select * from phieu_giam_gia where ngay_ket_thuc < ?";
                break;
            default:
                sql = "select * from phieu_giam_gia where ngay_bat_dau > ?";
                break;
        }
        try {
            listKM = new ArrayList<>();
            this.connectionAndPrepareStatement();
            ps.setDate(1, this.getCurrentDate());
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String maKhuyenMai = rs.getString(2);
                String tenKhuyenMai = rs.getString(3);
                double phanTram = rs.getDouble(4);
                Date ngayBatDau = rs.getDate(5);
                Date ngayKetThuc = rs.getDate(6);
                String moTa = rs.getString(7);
                int trangThai = rs.getInt(8);
                Date ngayTao = rs.getDate(9);
                Date ngaySua = rs.getDate(10);

                KhuyenMai km = new KhuyenMai(id, maKhuyenMai, tenKhuyenMai, phanTram, moTa, ngayBatDau, ngayKetThuc, trangThai, ngayTao, ngaySua);
                listKM.add(km);
            }

            return listKM;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            this.closeAll();
        }

    }

    public void insert(KhuyenMai khuyenMai) {
        try {
            sql = "insert into phieu_giam_gia (ma_phieu, ten_phieu, phan_tram_giam, mo_ta, ngay_bat_dau, ngay_ket_thuc, trang_thai, ngay_tao, ngay_sua) values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            this.connectionAndPrepareStatement();
            ps.setString(1, khuyenMai.getMaKhuyenMai());
            ps.setString(2,khuyenMai.getTenKhuyenMai());
            ps.setDouble(3, khuyenMai.getPhanTram());
            ps.setString(4, khuyenMai.getMoTa());
            ps.setDate(5, khuyenMai.getNgayBatDau());
            ps.setDate(6, khuyenMai.getNgayKetThuc());
            ps.setInt(7, khuyenMai.getTrangThai());
            ps.setDate(8, this.getCurrentDate());
            ps.setDate(9, this.getCurrentDate());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    public void update(KhuyenMai khuyenMai, int id) {
        try {
            sql = "update phieu_giam_gia set ten_phieu=?, phan_tram_giam=?, mo_ta=?, ngay_bat_dau=?, ngay_ket_thuc=?, trang_thai=?, ngay_sua=? where id=?";
            this.connectionAndPrepareStatement();
            ps.setString(1, khuyenMai.getTenKhuyenMai());
            ps.setDouble(2, khuyenMai.getPhanTram());
            ps.setString(3, khuyenMai.getMoTa());
            ps.setDate(4, khuyenMai.getNgayBatDau());
            ps.setDate(5, khuyenMai.getNgayKetThuc());
            ps.setInt(6, khuyenMai.getTrangThai());
            ps.setDate(7, this.getCurrentDate());
            ps.setInt(8, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeAll();
        }
    }

    public void updateTrangThai() {
        listKM = this.getAll();
        Date today = this.getCurrentDate();
        for (KhuyenMai khuyenMai : listKM) {
            Date ngayKetThuc = khuyenMai.getNgayKetThuc();
            if (today.after(ngayKetThuc) && khuyenMai.getTrangThai() == 1) {
                try {
                    sql = "update phieu_giam_gia set trang_thai=? where id=?";
                    this.connectionAndPrepareStatement();
                    ps.setInt(1, 0);
                    ps.setInt(2, khuyenMai.getId());
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    this.closeAll();
                }
            }
        }

    }

    private void connectionAndPrepareStatement() throws SQLException {
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
    }

    private void closeAll() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Date getCurrentDate() {
        String currentDate = LocalDate.now().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return java.sql.Date.valueOf(LocalDate.parse(currentDate, formatter));
    }

}
