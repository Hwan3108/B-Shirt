package view.panel;

import domainmodel.HoaDon;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import serviceIMPL.HoaDonChiTietServiceIMPL;
import serviceIMPL.KhuyenMaiServiceIMPL;
import serviceIMPL.NhanVienServiceIMPL;
import serviceIMPL.QuanLyHoaDon;
import serviceIMPL.QuanLyKhachHang;
import serviceIMPL.SanPhamChiTietServiceIMPL;
import serviceIMPL.SanPhamServiceIMPL;
import view.model.GioHangViewModel;
import view.model.HoaDonViewModel;
import view.model.SanPhamViewModel;
import view.popup.*;

public class BanHangPanel extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    QuanLyHoaDon HoaDonService = new QuanLyHoaDon();
    HoaDonChiTietServiceIMPL HDCTService = new HoaDonChiTietServiceIMPL();
    SanPhamChiTietServiceIMPL SPCTService = new SanPhamChiTietServiceIMPL();
    SanPhamServiceIMPL SPService = new SanPhamServiceIMPL();
    NhanVienServiceIMPL NVService = new NhanVienServiceIMPL();
    QuanLyKhachHang KHService = new QuanLyKhachHang();
    KhuyenMaiServiceIMPL KMService = new KhuyenMaiServiceIMPL();
    List<HoaDonViewModel> listHD = new ArrayList<>();
    List<GioHangViewModel> listGH = new ArrayList<>();
    List<SanPhamViewModel> listSPView = SPCTService.getSPView();
    private int index;
    private int HoaDonID;
    private String trangThaiHD;
    private static String regexName = "^[a-zA-Z\\p{L}\\s]+$";
    private DecimalFormat decimalFormat = new DecimalFormat("#,###");
    private Double discount = 0.00;
    private BigDecimal value = BigDecimal.ZERO;
    private BigDecimal discountValue = BigDecimal.ZERO;
    private int count = HoaDonService.getBHView().get(0).getId();
    private int counter = 0;
    
    public BanHangPanel() {
        initComponents();
        List<HoaDonViewModel> listHD = HoaDonService.getBHView();
        this.fillTableHD(listHD);
        this.fillTableSP(listSPView);
        btnHuyHD.setEnabled(false);
        btnXoaSP.setEnabled(false);
        btnThanhToan.setEnabled(false);
        txtTienNhan.setEditable(false);
        rdoTienMat.setEnabled(false);
        rdoChuyenKhoan.setEnabled(false);
        txtKhachHang.setEditable(false);
        txtNhanVien.setEditable(false);
        txtKhuyenMai.setEditable(false);
        txtThanhToan.setEditable(false);
        for (int i=0; i<HoaDonService.getBHView().size();i++) {
            if (HoaDonService.getBHView().get(i).getTrangThai() == 2) {
                counter ++;
            }
        }
        if (counter >= 10) {
            btnTaoHD.setEnabled(false);
        }
    }
    
    public void fillTableHD(List<HoaDonViewModel> list) {
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        for (HoaDonViewModel x: list) {
            model.addRow(x.toDataRow());
        }
    }
    
    public void fillTableGH(List<GioHangViewModel> list) {
        model = (DefaultTableModel) tblGioHang.getModel();
        model.setRowCount(0);
        for (GioHangViewModel x: list) {
            if(x.isTrangThai() == true) {
                model.addRow(x.toDataRow());
            }
        }
    }
    
    public void fillTableSP(List<SanPhamViewModel> list) {
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (SanPhamViewModel x: list) {
            model.addRow(x.toDataRow());
        }
    }
    
    void fillData(int index) {
        txtHoaDon.setText((String)tblHoaDon.getValueAt(index, 1));
        HoaDonID = (int)tblHoaDon.getValueAt(index, 0);
    }
    
    String genMa() {
        count++;
        return "HD" + String.format("%05d", count);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTrangThai = new javax.swing.ButtonGroup();
        btnPTTT = new javax.swing.ButtonGroup();
        panelThanhToan = new javax.swing.JPanel();
        lblMaHoaDon = new javax.swing.JLabel();
        lblTenKhachHang = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        lblMaKhuyenMai = new javax.swing.JLabel();
        lblThanhToan = new javax.swing.JLabel();
        lblTienNhan = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        txtHoaDon = new javax.swing.JTextField();
        txtKhachHang = new javax.swing.JTextField();
        txtKhuyenMai = new javax.swing.JTextField();
        txtNhanVien = new javax.swing.JTextField();
        txtTienNhan = new javax.swing.JTextField();
        txtThanhToan = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        lblPTTT = new javax.swing.JLabel();
        rdoTienMat = new javax.swing.JRadioButton();
        rdoChuyenKhoan = new javax.swing.JRadioButton();
        lblTenKhachHang1 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        panelHoaDon = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTaoHD = new javax.swing.JButton();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoChoThanhToan = new javax.swing.JRadioButton();
        rdoDaThanhToan = new javax.swing.JRadioButton();
        rdoDaHuy = new javax.swing.JRadioButton();
        btnHuyHD = new javax.swing.JButton();
        panelGioHang = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoaSP = new javax.swing.JButton();
        panelSanPham = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtTimSP = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(965, 657));
        setMinimumSize(new java.awt.Dimension(965, 657));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(965, 657));

        panelThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        panelThanhToan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204), new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204)));

        lblMaHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMaHoaDon.setText("Mã hóa đơn:");

        lblTenKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenKhachHang.setText("SĐT Khách hàng");

        lblTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenNhanVien.setText("Mã nhân viên");

        lblMaKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMaKhuyenMai.setText("Mã khuyến mãi:");

        lblThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblThanhToan.setText("Thanh toán:");

        lblTienNhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTienNhan.setText("Tiền nhận:");

        lblTienThua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTienThua.setText("Tiền thừa");

        txtHoaDon.setEditable(false);

        txtKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachHangKeyReleased(evt);
            }
        });

        txtKhuyenMai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhuyenMaiKeyReleased(evt);
            }
        });

        txtTienNhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienNhanKeyReleased(evt);
            }
        });

        txtTienThua.setEditable(false);

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        lblPTTT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPTTT.setText("PTTT");

        btnPTTT.add(rdoTienMat);
        rdoTienMat.setText("Tiền mặt");

        btnPTTT.add(rdoChuyenKhoan);
        rdoChuyenKhoan.setText("Chuyển khoản");

        lblTenKhachHang1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenKhachHang1.setText("Tên khách hàng");

        txtHoTen.setEditable(false);

        javax.swing.GroupLayout panelThanhToanLayout = new javax.swing.GroupLayout(panelThanhToan);
        panelThanhToan.setLayout(panelThanhToanLayout);
        panelThanhToanLayout.setHorizontalGroup(
            panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenKhachHang)
                    .addComponent(lblMaHoaDon)
                    .addComponent(lblMaKhuyenMai)
                    .addComponent(lblThanhToan)
                    .addComponent(lblTienNhan)
                    .addComponent(lblTienThua)
                    .addComponent(lblTenNhanVien)
                    .addComponent(lblPTTT)
                    .addComponent(lblTenKhachHang1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelThanhToanLayout.createSequentialGroup()
                        .addComponent(rdoTienMat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoChuyenKhoan))
                    .addGroup(panelThanhToanLayout.createSequentialGroup()
                        .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(txtTienNhan)
                            .addComponent(txtThanhToan)
                            .addComponent(txtHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(txtNhanVien, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtKhuyenMai)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen)
                            .addComponent(txtKhachHang))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelThanhToanLayout.setVerticalGroup(
            panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThanhToanLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHoaDon)
                    .addComponent(txtHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenKhachHang)
                    .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenKhachHang1)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenNhanVien)
                    .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaKhuyenMai)
                    .addComponent(txtKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThanhToan)
                    .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTienNhan)
                    .addComponent(txtTienNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTienThua)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPTTT)
                    .addComponent(rdoTienMat)
                    .addComponent(rdoChuyenKhoan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        panelHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        panelHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204), new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204)), "Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Mã hóa đơn", "Ngày tạo", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.getTableHeader().setReorderingAllowed(false);
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        btnTaoHD.setText("Tạo mới");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        btnTrangThai.add(rdoTatCa);
        rdoTatCa.setSelected(true);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        btnTrangThai.add(rdoChoThanhToan);
        rdoChoThanhToan.setText("Chờ thanh toán");
        rdoChoThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChoThanhToanActionPerformed(evt);
            }
        });

        btnTrangThai.add(rdoDaThanhToan);
        rdoDaThanhToan.setText("Đã thanh toán");
        rdoDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaThanhToanActionPerformed(evt);
            }
        });

        btnTrangThai.add(rdoDaHuy);
        rdoDaHuy.setText("Đã hủy");
        rdoDaHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaHuyActionPerformed(evt);
            }
        });

        btnHuyHD.setText("Huỷ");
        btnHuyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHoaDonLayout = new javax.swing.GroupLayout(panelHoaDon);
        panelHoaDon.setLayout(panelHoaDonLayout);
        panelHoaDonLayout.setHorizontalGroup(
            panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelHoaDonLayout.createSequentialGroup()
                        .addComponent(btnTaoHD)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuyHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoTatCa)
                        .addGap(18, 18, 18)
                        .addComponent(rdoChoThanhToan)
                        .addGap(18, 18, 18)
                        .addComponent(rdoDaThanhToan)
                        .addGap(18, 18, 18)
                        .addComponent(rdoDaHuy)
                        .addGap(58, 58, 58)))
                .addContainerGap())
        );
        panelHoaDonLayout.setVerticalGroup(
            panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHoaDonLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHD)
                    .addComponent(rdoTatCa)
                    .addComponent(rdoChoThanhToan)
                    .addComponent(rdoDaThanhToan)
                    .addComponent(rdoDaHuy)
                    .addComponent(btnHuyHD))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelGioHang.setBackground(new java.awt.Color(255, 255, 255));
        panelGioHang.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204), new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204)), "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.getTableHeader().setReorderingAllowed(false);
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        btnXoaSP.setText("Xóa");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGioHangLayout = new javax.swing.GroupLayout(panelGioHang);
        panelGioHang.setLayout(panelGioHangLayout);
        panelGioHangLayout.setHorizontalGroup(
            panelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGioHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelGioHangLayout.createSequentialGroup()
                        .addComponent(btnXoaSP)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelGioHangLayout.setVerticalGroup(
            panelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGioHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXoaSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSanPham.setBackground(new java.awt.Color(255, 255, 255));
        panelSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204), new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204)), "Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã SP", "Tên SP", "Số lượng", "Chất liệu", "Kiểu dáng", "Hoạ tiết", "Thương hiệu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.getTableHeader().setReorderingAllowed(false);
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPham);

        txtTimSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimSPKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelSanPhamLayout = new javax.swing.GroupLayout(panelSanPham);
        panelSanPham.setLayout(panelSanPhamLayout);
        panelSanPhamLayout.setHorizontalGroup(
            panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelSanPhamLayout.setVerticalGroup(
            panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        try {
            txtKhachHang.setEditable(true);
            txtNhanVien.setEditable(true);
            txtKhuyenMai.setEditable(true);
            btnHuyHD.setEnabled(true);
            txtTienNhan.setEditable(true);
            HoaDonService.create(genMa());
            counter++;
            if (counter >= 10) {
                btnTaoHD.setEnabled(false);
            } else {
                btnTaoHD.setEnabled(true);
            }
            fillTableHD(HoaDonService.getBHView());
            rdoTatCa.setSelected(true);
            tblHoaDon.setRowSelectionInterval(0, 0);
            fillData(0);
            fillTableGH(HDCTService.getGioHang(0));
            txtTienNhan.setText("");
            txtTienThua.setText("");
            BigDecimal thanhToan = new BigDecimal(BigInteger.ZERO);
            txtThanhToan.setText(decimalFormat.format(thanhToan));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void btnHuyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHDActionPerformed
        try {
            txtKhachHang.setEditable(false);
            txtNhanVien.setEditable(false);
            txtKhuyenMai.setEditable(false);
            btnHuyHD.setEnabled(false);
            index = tblHoaDon.getSelectedRow();
            fillData(index);
            if (tblHoaDon.getValueAt(index, 3).equals("Chờ thanh toán")) {
                HoaDonService.cancel(HoaDonID);
                counter--;
            }
            if (counter >= 10) {
                btnTaoHD.setEnabled(false);
            } else {
                btnTaoHD.setEnabled(true);
            }
            listHD = HoaDonService.getBHView();
            List<HoaDonViewModel> listDaThanhToan = HoaDonService.locTrangThai(listHD, 1);
            List<HoaDonViewModel> listChoThanhToan = HoaDonService.locTrangThai(listHD, 2);
            List<HoaDonViewModel> listDaHuy = HoaDonService.locTrangThai(listHD, 3);
            if(rdoTatCa.isSelected()) {
                fillTableHD(HoaDonService.getBHView());
            } else if (rdoChoThanhToan.isSelected()) {
                fillTableHD(listChoThanhToan);
            } else if (rdoDaThanhToan.isSelected()) {
                fillTableHD(listDaThanhToan);
            } else if (rdoDaHuy.isSelected()) {
                fillTableHD(listDaHuy);
            }
            txtHoaDon.setText("");
            fillTableSP(SPCTService.getSPView());
            fillTableGH(HDCTService.getGioHang(0));
            BigDecimal thanhToan = new BigDecimal(BigInteger.ZERO);
            txtThanhToan.setText(decimalFormat.format(thanhToan));
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(this, "Chọn lại bảng hoá đơn");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnHuyHDActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        try {
            index = tblHoaDon.getSelectedRow();
            if (tblHoaDon.getValueAt(index, 3).equals("Chờ thanh toán")) {
                btnHuyHD.setEnabled(true);
            } else {
                btnHuyHD.setEnabled(false);
            }
            txtTienNhan.setEditable(true);
            fillData(index);
            List<GioHangViewModel> listGH = HDCTService.getGioHang(HoaDonID);
            fillTableGH(listGH);
            fillTableSP(SPCTService.getSPView());
            trangThaiHD = (String)tblHoaDon.getValueAt(index, 3);
            BigDecimal thanhToan = new BigDecimal(BigInteger.ZERO);
            model = (DefaultTableModel) tblGioHang.getModel();
            for (int i=0;i<model.getRowCount();i++) {
                String str = (String)model.getValueAt(i, 5);
                String clean = str.replaceAll("[,\\$\\€\\£]", "");
                BigDecimal thanhTien = new BigDecimal(clean);
                thanhToan = thanhToan.add(thanhTien);
            }
            discountValue = thanhToan.multiply(value).divide(new BigDecimal("100"));
            thanhToan = thanhToan.subtract(discountValue);
            txtThanhToan.setText(decimalFormat.format(thanhToan));
            if(index != -1 && trangThaiHD.equals("Chờ thanh toán")) {
                rdoTienMat.setEnabled(true);
                rdoChuyenKhoan.setEnabled(true);
                txtTienNhan.setEditable(true);
                txtKhachHang.setEditable(true);
                txtNhanVien.setEditable(true);
                txtKhuyenMai.setEditable(true);
            } else {
                txtKhachHang.setEditable(false);
                txtNhanVien.setEditable(false);
                txtKhuyenMai.setEditable(false);
                txtTienNhan.setEditable(false);
                rdoTienMat.setEnabled(false);
                rdoChuyenKhoan.setEnabled(false);
            }
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            JOptionPane.showMessageDialog(this, "Chọn lại hoá đơn");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
        try {
            fillTableHD(HoaDonService.getBHView());
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(this, "Hoá đơn rỗng");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void rdoChoThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChoThanhToanActionPerformed
        try {
            List<HoaDonViewModel> listHD = HoaDonService.getBHView();
            List<HoaDonViewModel> listSearch = HoaDonService.locTrangThai(listHD, 2);
            fillTableHD(listSearch);
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(this, "Hoá đơn rỗng");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rdoChoThanhToanActionPerformed

    private void rdoDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaThanhToanActionPerformed
        try {
            List<HoaDonViewModel> listHD = HoaDonService.getBHView();
            List<HoaDonViewModel> listSearch = HoaDonService.locTrangThai(listHD, 1);
            fillTableHD(listSearch);
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(this, "Hoá đơn rỗng");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rdoDaThanhToanActionPerformed

    private void rdoDaHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaHuyActionPerformed
        try {
            List<HoaDonViewModel> listHD = HoaDonService.getBHView();
            List<HoaDonViewModel> listSearch = HoaDonService.locTrangThai(listHD, 3);
            fillTableHD(listSearch);
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(this, "Hoá đơn rỗng");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rdoDaHuyActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        try {
            btnXoaSP.setEnabled(false);
            index = tblGioHang.getSelectedRow();        
            GioHangViewModel gh = HDCTService.getGioHang(HoaDonID).get(index);
            HDCTService.delete(HoaDonID, gh.getId());
            listGH = HDCTService.getGioHang(HoaDonID);
            fillTableGH(listGH);
            fillTableSP(SPCTService.getSPView());
        } catch (NullPointerException | IndexOutOfBoundsException ne) {
            JOptionPane.showMessageDialog(this, "Chọn lại sản phẩm trong bảng giỏ hàng");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        try {
            int GHrow = tblHoaDon.getSelectedRow();
            if(GHrow != -1 && trangThaiHD.equals("Chờ thanh toán")) {
                int row = tblSanPham.getSelectedRow();
                index = (int)tblSanPham.getValueAt(row, 0);
                ArrayList<Integer> listSPGH = new ArrayList<>();
                model = (DefaultTableModel) tblGioHang.getModel();
                for (int i = 0;i < model.getRowCount();i++) {
                    listSPGH.add((int)model.getValueAt(i, 0));
                }
                SanPhamPU SPpu = new SanPhamPU(index, HoaDonID, listSPGH);
                SPpu.setVisible(true);
            }
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(this, "Chọn lại hoá đơn");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        try {
            if (tblGioHang.getSelectedColumn() == 3) {
            index = tblGioHang.getSelectedRow();
            int idSPCT = (int)tblGioHang.getValueAt(index, 0);
            String soLuong = JOptionPane.showInputDialog(this, "Nhập số lượng muốn thay đổi");
            int soLuongNow = (int)tblGioHang.getValueAt(index, 3);
            try {
                if(soLuong.matches(regexName)) {
                    JOptionPane.showMessageDialog(this, "Số lượng phải là số");
                } else if (Integer.parseInt(soLuong) <= 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng mới phải > 0");
                } else if (soLuongNow > Integer.parseInt(soLuong)) {
                    JOptionPane.showMessageDialog(this, HDCTService.returnItem(SPCTService.getSPCTView(), idSPCT, soLuongNow - Integer.parseInt(soLuong), HoaDonID));
                    BigDecimal thanhToan = new BigDecimal(BigInteger.ZERO);
                    model = (DefaultTableModel) tblGioHang.getModel();
                    for (int i=0;i<model.getRowCount();i++) {
                        String str = (String)model.getValueAt(i, 5);
                        String clean = str.replaceAll("[,\\$\\€\\£]", "");
                        BigDecimal thanhTien = new BigDecimal(clean);
                        thanhToan = thanhToan.add(thanhTien);
                    }
                    discountValue = thanhToan.multiply(value).divide(new BigDecimal("100"));
                    thanhToan = thanhToan.subtract(discountValue);
                    txtThanhToan.setText(decimalFormat.format(thanhToan));
                } else if (soLuongNow < Integer.parseInt(soLuong)) {
                    JOptionPane.showMessageDialog(this, HDCTService.addMore(SPCTService.getSPCTView(), idSPCT, Integer.parseInt(soLuong) - soLuongNow, HoaDonID));
                    BigDecimal thanhToan = new BigDecimal(BigInteger.ZERO);
                    model = (DefaultTableModel) tblGioHang.getModel();
                    for (int i=0;i<model.getRowCount();i++) {
                        String str = (String)model.getValueAt(i, 5);
                        String clean = str.replaceAll("[,\\$\\€\\£]", "");
                        BigDecimal thanhTien = new BigDecimal(clean);
                        thanhToan = thanhToan.add(thanhTien);
                    }
                    discountValue = thanhToan.multiply(value).divide(new BigDecimal("100"));
                    thanhToan = thanhToan.subtract(discountValue);
                    txtThanhToan.setText(decimalFormat.format(thanhToan));
                } else if (soLuongNow == Integer.parseInt(soLuong)) {
                    JOptionPane.showMessageDialog(this, "Số lượng không thay đổi");
                }    
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên");
            } catch (NullPointerException ne) {
                JOptionPane.showMessageDialog(this, "Không được để trống số lượng");
            }
            fillTableGH(HDCTService.getGioHang(HoaDonID));
            } else {
                btnXoaSP.setEnabled(true);
            }
            fillTableSP(SPCTService.getSPView());
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(this, "Chọn lại sản phẩm trong bảng giỏ hàng");
        } catch (HeadlessException e) {
        }
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        try {
            String ma = txtHoaDon.getText();
            String khachHang = txtKhachHang.getText();
            String khuyenMai = txtKhuyenMai.getText();
            String nhanVien = txtNhanVien.getText();
            boolean pttt = true;
            if(rdoTienMat.isSelected()) {
                pttt = true;
            } else if (rdoTienMat.isSelected()) {
                pttt= false;
            }
            if (tblGioHang.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không thể thanh toán hoá đơn rỗng");
            } else if (txtHoTen.getText().isBlank() && khuyenMai.isBlank()) {
                HoaDon hd = new HoaDon(HoaDonID, NVService.getNV(NVService.getAll(), nhanVien), ma, pttt);
                JOptionPane.showMessageDialog(this, HoaDonService.nullKM(hd, HoaDonID));
                counter--;
            } else if (txtHoTen.getText().isBlank()) {
                HoaDon hd = new HoaDon(HoaDonID, NVService.getNV(NVService.getAll(), nhanVien), KMService.getKM(KMService.getAll(), khuyenMai), ma, pttt);
                JOptionPane.showMessageDialog(this, HoaDonService.khachLe(hd, HoaDonID));
                counter--;
            } else {
                HoaDon hd = new HoaDon(HoaDonID, NVService.getNV(NVService.getAll(), nhanVien), KHService.getKH(KHService.getList(), khachHang), KMService.getKM(KMService.getAll(), khuyenMai), ma, pttt);
                JOptionPane.showMessageDialog(this, HoaDonService.checkout(hd, HoaDonID));
                counter--;
            }
            fillTableHD(HoaDonService.getBHView());
            BigDecimal thanhToan = new BigDecimal(BigInteger.ZERO);
            txtThanhToan.setText(decimalFormat.format(thanhToan));
            txtTienNhan.setText("");
            txtTienThua.setText("");
            txtKhachHang.setText("");
            txtKhuyenMai.setText("");
            txtHoTen.setText("");
            btnThanhToan.setEnabled(false);
        } catch (HeadlessException e) {
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienNhanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienNhanKeyReleased
        try {
            String formattedText = String.format("%,d", Long.valueOf(txtTienNhan.getText().replaceAll(",", "")));
            txtTienNhan.setText(formattedText);
            index = tblHoaDon.getSelectedRow();
            String strTN = txtTienNhan.getText();
            String cleanTN = strTN.replaceAll("[,\\$\\€\\£]", "");
            BigDecimal tienNhan = new BigDecimal(cleanTN);
            String strTT = txtThanhToan.getText();
            String cleanTT = strTT.replaceAll("[,\\$\\€\\£]", "");
            BigDecimal thanhToan = new BigDecimal(cleanTT);
            if (txtTienNhan.getText().isBlank()) {
                txtTienThua.setText("");
            } else if(tienNhan.subtract(thanhToan).compareTo(BigDecimal.ZERO) >= 0) {
                if (tblHoaDon.getValueAt(index, 3).equals("Chờ thanh toán")) {
                    btnThanhToan.setEnabled(true);
                }
                txtTienThua.setText(decimalFormat.format(tienNhan.subtract(thanhToan)));
            } else {
                btnThanhToan.setEnabled(false);
                txtTienThua.setText("");
            }
        } catch (NumberFormatException number) {
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtTienNhanKeyReleased

    private void txtKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachHangKeyReleased
        txtHoTen.setText(KHService.getTenKH(KHService.getList(), txtKhachHang.getText()));
    }//GEN-LAST:event_txtKhachHangKeyReleased

    private void txtTimSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimSPKeyReleased
        try {
            String ma = txtTimSP.getText();
            String ten = txtTimSP.getText();
            String cl = txtTimSP.getText();
            String kd = txtTimSP.getText();
            String ht = txtTimSP.getText();
            String th = txtTimSP.getText();
            List<SanPhamViewModel> listSearch = SPService.search(SPCTService.getSPView(), ma, ten, cl, kd, ht, th);
            if (txtTimSP.getText().isBlank()) {
                fillTableSP(SPCTService.getSPView());
            } else {
                fillTableSP(listSearch);
            }
        } catch (NullPointerException ne) {
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtTimSPKeyReleased

    private void txtKhuyenMaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhuyenMaiKeyReleased
        try {
            discount = KMService.getDiscount(KMService.getAll(), txtKhuyenMai.getText());
            value = new BigDecimal(discount);
            BigDecimal thanhToan = new BigDecimal(BigInteger.ZERO);
            model = (DefaultTableModel) tblGioHang.getModel();
            for (int i=0;i<model.getRowCount();i++) {
                String str = (String)model.getValueAt(i, 5);
                String clean = str.replaceAll("[,\\$\\€\\£]", "");
                BigDecimal thanhTien = new BigDecimal(clean);
                thanhToan = thanhToan.add(thanhTien);
            }
            discountValue = thanhToan.multiply(value).divide(new BigDecimal("100"));
            thanhToan = thanhToan.subtract(discountValue);
            txtThanhToan.setText(decimalFormat.format(thanhToan));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtKhuyenMaiKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyHD;
    private javax.swing.ButtonGroup btnPTTT;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup btnTrangThai;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblMaKhuyenMai;
    private javax.swing.JLabel lblPTTT;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JLabel lblTenKhachHang1;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblThanhToan;
    private javax.swing.JLabel lblTienNhan;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JPanel panelGioHang;
    private javax.swing.JPanel panelHoaDon;
    private javax.swing.JPanel panelSanPham;
    private javax.swing.JPanel panelThanhToan;
    private javax.swing.JRadioButton rdoChoThanhToan;
    private javax.swing.JRadioButton rdoChuyenKhoan;
    private javax.swing.JRadioButton rdoDaHuy;
    private javax.swing.JRadioButton rdoDaThanhToan;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JRadioButton rdoTienMat;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtHoaDon;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtKhuyenMai;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtThanhToan;
    private javax.swing.JTextField txtTienNhan;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimSP;
    // End of variables declaration//GEN-END:variables
}
