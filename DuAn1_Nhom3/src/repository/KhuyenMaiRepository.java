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
import model.KhuyenMai;
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
                String moTa = rs.getString(5);
                Date ngayBatDau = rs.getDate(6);
                Date ngayKetThuc = rs.getDate(7);
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
                String moTa = rs.getString(5);
                Date ngayBatDau = rs.getDate(6);
                Date ngayKetThuc = rs.getDate(7);
                int trangThai = rs.getInt(8);
                Date ngayTao = rs.getDate(9);
                Date ngaySua = rs.getDate(10);

                km = new KhuyenMai(maKhuyenMai, tenKhuyenMai, phanTram, moTa, ngayBatDau, ngayKetThuc, trangThai, ngayTao, ngaySua);
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
            sql = "select * from phieu_giam_gia where id like '" + ma + "%'";
            this.connectionAndPrepareStatement();
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String maKhuyenMai = rs.getString(2);
                String tenKhuyenMai = rs.getString(3);
                double phanTram = rs.getDouble(4);
                String moTa = rs.getString(5);
                Date ngayBatDau = rs.getDate(6);
                Date ngayKetThuc = rs.getDate(7);
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
                sql = "select * from phieu_giam_gia where ? between ngaybatdau and ngayketthuc";
                break;
            case 1:
                sql = "select * from phieu_giam_gia where ngayketthuc < ?";
                break;
            default:
                sql = "select * from phieu_giam_gia where ngaybatdau > ?";
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
                String moTa = rs.getString(5);
                Date ngayBatDau = rs.getDate(6);
                Date ngayKetThuc = rs.getDate(7);
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
            sql = "insert into phieu_giam_gia (ma_khuyen_mai, phan_tram_giam, mo_ta, ngay_bat_dau, ngay_ket_thuc, trang_thai, ngay_tao, ngay_sua) values (NEWID(), ?, ?, ?, ?, ?, ?) ";
            this.connectionAndPrepareStatement();
            ps.setString(1, khuyenMai.getMaKhuyenMai());
            ps.setDouble(2, khuyenMai.getPhanTram());
            ps.setString(3, khuyenMai.getMoTa());
            ps.setDate(4, khuyenMai.getNgayBatDau());
            ps.setDate(5, khuyenMai.getNgayKetThuc());
            ps.setInt(6, khuyenMai.getTrangThai());
            ps.setDate(7, this.getCurrentDate());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    public void update(KhuyenMai khuyenMai, int id) {
        try {
            sql = "update phieu_giam_gia set phantram=?, mota=?, ngaybatdau=?, ngayketthuc=?, trangthai=?, ngaysua=? where id=?";
            this.connectionAndPrepareStatement();
            ps.setDouble(1, khuyenMai.getPhanTram());
            ps.setString(2, khuyenMai.getMoTa());
            ps.setDate(3, khuyenMai.getNgayBatDau());
            ps.setDate(4, khuyenMai.getNgayKetThuc());
            ps.setInt(5, khuyenMai.getTrangThai());
            ps.setDate(6, this.getCurrentDate());
            ps.setInt(7, id);

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
                    sql = "update phieu_giam_gia set trangthai=? where id=?";
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

    public static void main(String[] args) {
        KhuyenMaiRepository kmr = new KhuyenMaiRepository();
        List<KhuyenMai> listKM = kmr.getByTrangThai(0);

        for (KhuyenMai khuyenMai : listKM) {
            System.out.println(khuyenMai.toString());
        }
    }

    private Date getCurrentDate() {
        String currentDate = LocalDate.now().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return java.sql.Date.valueOf(LocalDate.parse(currentDate, formatter));
    }

}
