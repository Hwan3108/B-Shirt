/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panel;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import static com.lowagie.text.rtf.RtfWriter.paragraph;
import domainmodel.KhachHang_ThongKe;
import domainmodel.NhanVien_ThongKe;
import domainmodel.SanPham_ThongKe;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import repository.ThongKeRepository;
import repository.ThongKe_KhachHangRepository;
import repository.ThongKe_NhanVienRepository;
import repository.ThongKe_SanPhamRepository;

/**
 *
 * @author phtua
 */
public class ThongKePanel extends javax.swing.JPanel {

    ThongKeRepository sp = new ThongKeRepository();
    ThongKe_NhanVienRepository thongke_NhanVien = new ThongKe_NhanVienRepository();
    ThongKe_KhachHangRepository thongKe_KhachHang = new ThongKe_KhachHangRepository();
    ThongKe_SanPhamRepository thongKe_SanPham = new ThongKe_SanPhamRepository();

    /**
     * Creates new form ThongKePanel
     */
    public ThongKePanel() {
        initComponents();
        DoanhThuNgay();
        DoanhThuThang();
        DoanhThuNam();
        TongHoaDonHangHienTai();
        LoadTableNhanVien();
        LoadTableKhachHang();
        LoadTableSanPham();
    }

    public void LoadTableNhanVien() {
        DefaultTableModel dtm = new DefaultTableModel();
        ArrayList<NhanVien_ThongKe> list = thongke_NhanVien.getAll();
        dtm = (DefaultTableModel) tbNhanVien.getModel();
        dtm.setRowCount(0);
        for (NhanVien_ThongKe x : list) {
            dtm.addRow(new Object[]{
                x.getIdNhanVien(), x.getTenNhanVien(), x.getSoLuongBan(), x.getDoanhThu()
            });
        }

    }

    public void LoadTableKhachHang() {
        DefaultTableModel dtm = new DefaultTableModel();
        ArrayList<KhachHang_ThongKe> list = thongKe_KhachHang.getAll();
        dtm = (DefaultTableModel) tblKhachHang.getModel();
        dtm.setRowCount(0);
        for (KhachHang_ThongKe x : list) {
            dtm.addRow(new Object[]{
                x.getId(), x.getTenKhachHang(), x.getSoSanPhamMua(), x.getTongChiTieu()
            });
        }
    }

    public void LoadTableSanPham() {
        DefaultTableModel dtm = new DefaultTableModel();
        ArrayList<SanPham_ThongKe> list = thongKe_SanPham.getAll();
        dtm = (DefaultTableModel) tblSanPham.getModel();
        dtm.setRowCount(0);
        for (SanPham_ThongKe x : list) {
            dtm.addRow(new Object[]{
                x.getMaSP(), x.getTenSP(), x.getSoLuong(), x.getSoLuongBan(), x.getDoanhThu()
            });
        }
    }

    public void DoanhThuNgay() {
        LocalDate ngayHienTai = LocalDate.now();
        Float doanhThuNgay = sp.DoanhThuNgay(String.valueOf(ngayHienTai));
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String formattedNumber = currencyFormat.format(doanhThuNgay);
        txtTongDoanhThuNgay.setText(String.valueOf(formattedNumber));
    }

    public void DoanhThuThang() {
        LocalDate ngayHienTai = LocalDate.now();
        String ThangHienTai = ngayHienTai.format(DateTimeFormatter.ofPattern("yyyy-MM-%%"));
        Float doanhThuThang = sp.DoanhThuNgay(String.valueOf(ThangHienTai));
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String formattedNumber = currencyFormat.format(doanhThuThang);
        txtDoanhThuThang.setText(String.valueOf(formattedNumber));
    }

    public void DoanhThuNam() {
        LocalDate ngayHienTai = LocalDate.now();
        String namgHienTai = ngayHienTai.format(DateTimeFormatter.ofPattern("yyyy-%%-%%"));
        Float doanhThuNam = sp.DoanhThuNgay(String.valueOf(namgHienTai));
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String formattedNumber = currencyFormat.format(doanhThuNam);
        txtDoanhThuNam.setText(String.valueOf(formattedNumber));
    }

    public void TongHoaDonHangHienTai() {
        LocalDate ngayHienTai = LocalDate.now();
        String tongDonHangHomNay = String.valueOf(sp.TongDonHang(String.valueOf(ngayHienTai)));
        String tongBiThanhCongNgayHomNay = String.valueOf(sp.TongDonHangThanhCong(String.valueOf(ngayHienTai)));
        String tongBiHuyNgayHomNay = String.valueOf(sp.TongDonHangHuy(String.valueOf(ngayHienTai)));
        txtTongDonHang.setText(tongDonHangHomNay + " Tổng Đơn Hàng");
        txtTongDonHangThanhCong.setText(tongBiThanhCongNgayHomNay + " Thành Công");
        txtTongDonHanghuy.setText(tongBiHuyNgayHomNay + " Bị Hủy");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTongDonHangThanhCong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTongDonHang = new javax.swing.JTextField();
        txtTongDonHanghuy = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtTongDoanhThuNgay = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtDoanhThuThang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtDoanhThuNam = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnLamMoi = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        labengayBatDau = new javax.swing.JLabel();
        labeNgayKetThuc = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbbLoai = new javax.swing.JComboBox<>();
        btnxuat = new javax.swing.JButton();
        dateNgayBatDau = new com.toedter.calendar.JDateChooser();
        dateNgayKetThuc = new com.toedter.calendar.JDateChooser();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        txtTongDonHangThanhCong.setEditable(false);
        txtTongDonHangThanhCong.setBackground(new java.awt.Color(204, 255, 255));
        txtTongDonHangThanhCong.setText("0");
        txtTongDonHangThanhCong.setBorder(null);

        jLabel4.setText("Tổng Đơn Hàng");

        txtTongDonHang.setEditable(false);
        txtTongDonHang.setBackground(new java.awt.Color(204, 255, 255));
        txtTongDonHang.setText("0");
        txtTongDonHang.setBorder(null);

        txtTongDonHanghuy.setEditable(false);
        txtTongDonHanghuy.setBackground(new java.awt.Color(204, 255, 255));
        txtTongDonHanghuy.setText("0");
        txtTongDonHanghuy.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTongDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTongDonHanghuy, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTongDonHangThanhCong, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtTongDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtTongDonHangThanhCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTongDonHanghuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        txtTongDoanhThuNgay.setEditable(false);
        txtTongDoanhThuNgay.setBackground(new java.awt.Color(204, 255, 255));
        txtTongDoanhThuNgay.setText("0");
        txtTongDoanhThuNgay.setBorder(null);

        jLabel5.setText("Tổng Doanh Thu Ngày");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtTongDoanhThuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTongDoanhThuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));

        txtDoanhThuThang.setEditable(false);
        txtDoanhThuThang.setBackground(new java.awt.Color(204, 255, 255));
        txtDoanhThuThang.setText("0");
        txtDoanhThuThang.setBorder(null);

        jLabel6.setText("Doanh Thu Tháng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDoanhThuThang, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDoanhThuThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        txtDoanhThuNam.setEditable(false);
        txtDoanhThuNam.setBackground(new java.awt.Color(204, 255, 255));
        txtDoanhThuNam.setText("0");
        txtDoanhThuNam.setBorder(null);

        jLabel7.setText("Doanh Thu Năm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtDoanhThuNam, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDoanhThuNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jTabbedPane1.setBackground(new java.awt.Color(204, 255, 204));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setForeground(new java.awt.Color(255, 51, 51));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", "2", "2", "2", null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sản Phẩm", "Tên Sản Phẩm", "Số lượng", "Số lượng bán", "Doanh Thu"
            }
        ));
        jScrollPane3.setViewportView(tblSanPham);

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnLamMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLamMoi)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel6);

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Nhan Vien", "Tên Nhân Viên", "Số lượng đã bán", "Doanh Thu"
            }
        ));
        jScrollPane1.setViewportView(tbNhanVien);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 265, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Nhân Viên", jPanel7);

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "mã khách Hàng", "Tên Khách Hàng", "Số sản phẩm mua", "Tổng chi tiêu"
            }
        ));
        jScrollPane4.setViewportView(tblKhachHang);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 270, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Khách Hàng", jPanel8);

        labengayBatDau.setText("Ngày bắt đầu");

        labeNgayKetThuc.setText("Ngày kết thúc");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel3.setText("Loại");

        cbbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hôm Nay", "Theo Ngày" }));
        cbbLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbLoaiMouseClicked(evt);
            }
        });
        cbbLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiActionPerformed(evt);
            }
        });

        btnxuat.setText("xuất pdf");
        btnxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(134, 134, 134)
                                .addComponent(labengayBatDau)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labeNgayKetThuc)
                                .addGap(50, 50, 50))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(dateNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(dateNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(btnxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(313, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labengayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labeNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnxuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnTimKiem)
                        .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateNgayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        Date dateBatDau = dateNgayBatDau.getDate();
        Date dateKetThuc = dateNgayKetThuc.getDate();

        if (dateBatDau != null && dateKetThuc != null) {
            LocalDate ngayBatDau = dateBatDau.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate ngayKetThuc = dateKetThuc.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (ngayBatDau.isAfter(ngayKetThuc)) {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải trước ngày kết thúc");
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formatNgayBatDau = ngayBatDau.format(formatter);
                String formatNgayKetThuc = ngayKetThuc.format(formatter);
                // doanh thu ngay
                float doanhThuNgay = sp.DoanhThuTheoNgayBat_NgayKetThuc(formatNgayBatDau, formatNgayKetThuc);
                txtTongDoanhThuNgay.setText(String.valueOf(doanhThuNgay) + "VND");
                //tong don hang
                int tongHangNgay = sp.TongDonHang_NgayBatDau_NgayKetThuc(formatNgayBatDau, formatNgayKetThuc);
                txtTongDonHang.setText(String.valueOf(tongHangNgay) + "Tổng Đơn Hàng");
                // don hang thanh cong
                int tongDonHangThanhCong = sp.TongDonHangThanhCong_NgayBatDau_NgayKetThuc(formatNgayBatDau, formatNgayKetThuc);
                txtTongDonHangThanhCong.setText(String.valueOf(tongDonHangThanhCong) + "Thành Công");
                // don hang huy
                int tongDonHangHuy = sp.TongDonHangHuy_NgayBatDau_NgayKetThuc(formatNgayBatDau, formatNgayKetThuc);
                txtTongDonHanghuy.setText(String.valueOf(tongDonHangHuy) + "Bị Hủy");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống thời gian");
        }

    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cbbLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiActionPerformed
        String loai = (String) cbbLoai.getSelectedItem();
        if (loai.equalsIgnoreCase("Hôm Nay")) {
            labengayBatDau.setVisible(false);
            labeNgayKetThuc.setVisible(false);
            btnTimKiem.setVisible(false);
            dateNgayBatDau.setVisible(false);
            dateNgayKetThuc.setVisible(false);
        } else {
            labengayBatDau.setVisible(true);
            labeNgayKetThuc.setVisible(true);
            btnTimKiem.setVisible(true);
            dateNgayBatDau.setVisible(true);
            dateNgayKetThuc.setVisible(true);
        }
    }//GEN-LAST:event_cbbLoaiActionPerformed

    private void cbbLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbLoaiMouseClicked
        String loai = (String) cbbLoai.getSelectedItem();
        if (loai.equalsIgnoreCase("Hôm Nay")) {
            labengayBatDau.setVisible(false);
            labeNgayKetThuc.setVisible(false);
            btnTimKiem.setVisible(false);
            dateNgayBatDau.setVisible(false);
            dateNgayKetThuc.setVisible(false);
            DoanhThuNgay();
            TongHoaDonHangHienTai();
        } else {
            labengayBatDau.setVisible(true);
            labeNgayKetThuc.setVisible(true);
            btnTimKiem.setVisible(true);
            dateNgayBatDau.setVisible(true);
            dateNgayKetThuc.setVisible(true);
        }
    }//GEN-LAST:event_cbbLoaiMouseClicked

    private void btnxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxuatActionPerformed
        
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        Phrase phrase = new Phrase();
        Document doc = new Document();
        try {     
            String filePath = path + File.separator + "abc123.pdf";
            PdfWriter.getInstance(doc, new FileOutputStream(filePath));
            doc.open();
            doc.add(new Paragraph("doanh thu ngay : " + txtTongDoanhThuNgay.getText()));
            doc.add(new Paragraph("doanh thu thang : " + txtDoanhThuThang.getText()));
            doc.add(new Paragraph("doanh thu nam : " + txtDoanhThuNam.getText() + "\n"));
            doc.add(new Paragraph("bang doanh thu san pham \n"));
            doc.add(new Paragraph("\n"));
            PdfPTable tbl = new PdfPTable(5);
            tbl.addCell("mã sản phẩm");
            tbl.addCell("tên sản phẩm");
            tbl.addCell("số lượng");
            tbl.addCell("số luong ban");
            tbl.addCell("Doanh thu");

            for (int i = 0; i < tblSanPham.getRowCount();i++) {
                String ma = tblSanPham.getValueAt(i, 0).toString();
                String ten = tblSanPham.getValueAt(i, 1).toString();
                int soluong = (int )tblSanPham.getValueAt(i, 2);
                int spluongban = (int )tblSanPham.getValueAt(i, 3);
                float doanhthu = (float)tblSanPham.getValueAt(i, 4);
                tbl.addCell(ma);
                tbl.addCell(ten);
                tbl.addCell(String.valueOf(soluong));
                tbl.addCell(String.valueOf(spluongban));
                tbl.addCell(String.valueOf(doanhthu));
            }

            doc.add(tbl);
            
            // table bán hàng
            doc.add(new Paragraph("bang nhan Vien\n"));
            doc.add(new Paragraph("\n"));
            PdfPTable tbnhanvien = new PdfPTable(4);
            tbnhanvien.addCell("ID Nhan Vien");
            tbnhanvien.addCell("Ten Nhan Vien");
            tbnhanvien.addCell("So Luong Da Ban");
            tbnhanvien.addCell("Doanh Thu");           
            for (int i = 0; i < tbNhanVien.getRowCount();i++) {
                String nhanVien = tbNhanVien.getValueAt(i, 0).toString();
                String tenNhanVien = tbNhanVien.getValueAt(i, 1).toString();
                int soLuongDaBan = (int)tbNhanVien.getValueAt(i, 2);
                Float DoanhThu = (float)tbNhanVien.getValueAt(i, 3);
                tbnhanvien.addCell(nhanVien);
                tbnhanvien.addCell(tenNhanVien);
                tbnhanvien.addCell(String.valueOf(soLuongDaBan));
                tbnhanvien.addCell(String.valueOf(DoanhThu));
            }
            doc.add(tbnhanvien);
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("bang khach hang\n"));
            PdfPTable tbkhachHang = new PdfPTable(4);
            tbkhachHang.addCell("ma khách hàng");
            tbkhachHang.addCell("tên khách hàng");
            tbkhachHang.addCell("số sản phẩm mua");
            tbkhachHang.addCell("tổng chi tiêu");           
            for (int i = 0; i < tblKhachHang.getRowCount();i++) {
                String maKhachHAng = tblKhachHang.getValueAt(i, 0).toString();
                String tenKhachHAng = tblKhachHang.getValueAt(i, 1).toString();
                int soSanPhamMua = (int)tblKhachHang.getValueAt(i, 2);
                Float TongChiTieu = (float)tblKhachHang.getValueAt(i, 3);
                tbkhachHang.addCell(maKhachHAng);
                tbkhachHang.addCell(tenKhachHAng);
                tbkhachHang.addCell(String.valueOf(soSanPhamMua));
                tbkhachHang.addCell(String.valueOf(TongChiTieu));
            }
            doc.add(tbkhachHang);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ThongKePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ThongKePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThongKePanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (doc.isOpen()) {
                doc.close();
            }
        }


    }//GEN-LAST:event_btnxuatActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        DoanhThuNgay();
        DoanhThuThang();
        DoanhThuNam();
        TongHoaDonHangHienTai();
//        LoadTableNhanVien();
//        LoadTableKhachHang();
//        LoadTableSanPham();
    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnxuat;
    private javax.swing.JComboBox<String> cbbLoai;
    private com.toedter.calendar.JDateChooser dateNgayBatDau;
    private com.toedter.calendar.JDateChooser dateNgayKetThuc;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labeNgayKetThuc;
    private javax.swing.JLabel labengayBatDau;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtDoanhThuNam;
    private javax.swing.JTextField txtDoanhThuThang;
    private javax.swing.JTextField txtTongDoanhThuNgay;
    private javax.swing.JTextField txtTongDonHang;
    private javax.swing.JTextField txtTongDonHangThanhCong;
    private javax.swing.JTextField txtTongDonHanghuy;
    // End of variables declaration//GEN-END:variables
}
