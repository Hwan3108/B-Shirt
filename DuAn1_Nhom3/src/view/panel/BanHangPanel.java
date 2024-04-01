package view.panel;

import domainmodel.HoaDon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import serviceIMPL.HoaDonChiTietServiceIMPL;
import serviceIMPL.QuanLyHoaDon;
import serviceIMPL.SanPhamChiTietServiceIMPL;
import view.model.GioHangViewModel;
import view.model.HoaDonViewModel;
import view.model.SPCTViewModel;
import view.model.SanPhamViewModel;
import view.popup.*;

public class BanHangPanel extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    QuanLyHoaDon HoaDonService = new QuanLyHoaDon();
    HoaDonChiTietServiceIMPL HDCTService = new HoaDonChiTietServiceIMPL();
    SanPhamChiTietServiceIMPL SPCTService = new SanPhamChiTietServiceIMPL();
    List<HoaDonViewModel> listHD = new ArrayList<>();
    List<GioHangViewModel> listGH = new ArrayList<>();
    List<SanPhamViewModel> listSPView = SPCTService.getSPView();
    List<SPCTViewModel> listSPCT = SPCTService.getSPCTView();
    HoaDonViewModel modelHoaDon = new HoaDonViewModel();
    KhachHangPU KHpu = new KhachHangPU();
    NhanVienPU NVpu = new NhanVienPU();
    PhieuGiamGiaPU KMpu = new PhieuGiamGiaPU();
    HoaDonChiTietPU HDCTpu = new HoaDonChiTietPU();
    private int index;
    private int HoaDonID;
    private String trangThaiHD;
    
    public BanHangPanel() {
        initComponents();
        List<HoaDonViewModel> listHD = HoaDonService.getBHView();
        this.fillTableHD(listHD);
        this.fillTableSP(listSPView);
        btnHuyHD.setEnabled(false);
        btnXoaSP.setEnabled(false);
        btnThanhToan.setEnabled(false);
        txtTienNhan.setEditable(false);
    }
    
    void fillTableHD(List<HoaDonViewModel> list) {
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        for (HoaDonViewModel x: list) {
            model.addRow(x.toDataRow());
        }
    }
    
    void fillTableGH(List<GioHangViewModel> list) {
        model = (DefaultTableModel) tblGioHang.getModel();
        model.setRowCount(0);
        for (GioHangViewModel x: list) {
            if(x.isTrangThai() == true) {
                model.addRow(x.toDataRow());
            }
        }
    }
    
    void fillTableSP(List<SanPhamViewModel> list) {
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (SanPhamViewModel x: list) {
            model.addRow(x.toDataRow());
        }
    }
    
    public void fillData(int index) {
        if (rdoTatCa.isSelected()) {
            HoaDonViewModel hdview = HoaDonService.getBHView().get(index);
            txtHoaDon.setText(hdview.getMaHoaDon());
            HoaDonID = hdview.getId();
        } else if (rdoChoThanhToan.isSelected()) {
            HoaDonViewModel hdview = HoaDonService.locTrangThai(listHD, 2).get(index);
            txtHoaDon.setText(hdview.getMaHoaDon());
            HoaDonID = hdview.getId();
        } else if (rdoDaThanhToan.isSelected()) {
            HoaDonViewModel hdview = HoaDonService.locTrangThai(listHD, 1).get(index);
            txtHoaDon.setText(hdview.getMaHoaDon());
            HoaDonID = hdview.getId();
        } else if (rdoDaHuy.isSelected()) {
            HoaDonViewModel hdview = HoaDonService.locTrangThai(listHD, 3).get(index);
            txtHoaDon.setText(hdview.getMaHoaDon());
            HoaDonID = hdview.getId();
        }
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
        btnNhanVien = new javax.swing.JButton();
        btnKhuyenMai = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        lblPTTT = new javax.swing.JLabel();
        rdoTienMat = new javax.swing.JRadioButton();
        rdoChuyenKhoan = new javax.swing.JRadioButton();
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
        panelQR = new javax.swing.JPanel();

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
        lblTenKhachHang.setText("Tên khách hàng:");

        lblTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenNhanVien.setText("Tên nhân viên:");

        lblMaKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMaKhuyenMai.setText("Mã khuyến mãi:");

        lblThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblThanhToan.setText("Thanh toán:");

        lblTienNhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTienNhan.setText("Tiền nhận:");

        lblTienThua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTienThua.setText("Tiền thừa");

        txtHoaDon.setEditable(false);

        txtTienNhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienNhanKeyReleased(evt);
            }
        });

        txtTienThua.setEditable(false);

        btnNhanVien.setText("Chọn");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnKhuyenMai.setText("Chọn");
        btnKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnKhachHang.setText("Chọn");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        lblPTTT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPTTT.setText("PTTT");

        btnPTTT.add(rdoTienMat);
        rdoTienMat.setText("Tiền mặt");

        btnPTTT.add(rdoChuyenKhoan);
        rdoChuyenKhoan.setText("Chuyển khoản");

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
                    .addComponent(lblPTTT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelThanhToanLayout.createSequentialGroup()
                        .addComponent(rdoTienMat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoChuyenKhoan))
                    .addGroup(panelThanhToanLayout.createSequentialGroup()
                        .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTienThua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addComponent(txtTienNhan, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtThanhToan, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panelThanhToanLayout.createSequentialGroup()
                                    .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNhanVien, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txtHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelThanhToanLayout.setVerticalGroup(
            panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThanhToanLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHoaDon)
                    .addComponent(txtHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenKhachHang)
                    .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhachHang))
                .addGap(27, 27, 27)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenNhanVien)
                    .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhanVien))
                .addGap(28, 28, 28)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaKhuyenMai)
                    .addComponent(txtKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhuyenMai))
                .addGap(31, 31, 31)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThanhToan)
                    .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTienNhan)
                    .addComponent(txtTienNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTienThua)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPTTT)
                    .addComponent(rdoTienMat)
                    .addComponent(rdoChuyenKhoan))
                .addGap(8, 8, 8)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPham);

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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        panelQR.setBackground(new java.awt.Color(255, 255, 255));
        panelQR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204), new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout panelQRLayout = new javax.swing.GroupLayout(panelQR);
        panelQR.setLayout(panelQRLayout);
        panelQRLayout.setHorizontalGroup(
            panelQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelQRLayout.setVerticalGroup(
            panelQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelQR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 320, Short.MAX_VALUE))
                .addContainerGap(2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelQR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        btnHuyHD.setEnabled(true);
        txtTienNhan.setEditable(true);
        HoaDonService.create();
        fillTableHD(HoaDonService.getBHView());
        rdoTatCa.setSelected(true);
        tblHoaDon.setRowSelectionInterval(0, 0);
        fillData(0);
        fillTableGH(HDCTService.getGioHang(0));
        txtTienNhan.setText("");
        txtTienThua.setText("");
        Double tienGH = 0.00;
        for (int i=0;i<tblGioHang.getRowCount();i++) {
            tienGH += (Double)tblGioHang.getValueAt(i, 5);
        }
        txtThanhToan.setText(String.valueOf(tienGH));
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void btnHuyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHDActionPerformed
        btnHuyHD.setEnabled(false);
        index = tblHoaDon.getSelectedRow();
        fillData(index);
        HoaDonService.cancel(HoaDonID);
        //Thêm xoá giỏ hàng vào đây
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
    }//GEN-LAST:event_btnHuyHDActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        btnHuyHD.setEnabled(true);
        txtTienNhan.setEditable(true);
        index = tblHoaDon.getSelectedRow();
        fillData(index);
        List<GioHangViewModel> listGH = HDCTService.getGioHang(HoaDonID);
        fillTableGH(listGH);
        trangThaiHD = (String)tblHoaDon.getValueAt(index, 3);
        Double tienGH = 0.00;
        for (int i=0;i<tblGioHang.getRowCount();i++) {
            tienGH += (Double)tblGioHang.getValueAt(i, 5);
        }
        txtThanhToan.setText(String.valueOf(tienGH));
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
        fillTableHD(HoaDonService.getBHView());
    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void rdoChoThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChoThanhToanActionPerformed
        List<HoaDonViewModel> listHD = HoaDonService.getBHView();
        List<HoaDonViewModel> listSearch = HoaDonService.locTrangThai(listHD, 2);
        fillTableHD(listSearch);
    }//GEN-LAST:event_rdoChoThanhToanActionPerformed

    private void rdoDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaThanhToanActionPerformed
        List<HoaDonViewModel> listHD = HoaDonService.getBHView();
        List<HoaDonViewModel> listSearch = HoaDonService.locTrangThai(listHD, 1);
        fillTableHD(listSearch);
    }//GEN-LAST:event_rdoDaThanhToanActionPerformed

    private void rdoDaHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaHuyActionPerformed
        List<HoaDonViewModel> listHD = HoaDonService.getBHView();
        List<HoaDonViewModel> listSearch = HoaDonService.locTrangThai(listHD, 3);
        fillTableHD(listSearch);
    }//GEN-LAST:event_rdoDaHuyActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        btnXoaSP.setEnabled(false);
        index = tblGioHang.getSelectedRow();        
        GioHangViewModel gh = HDCTService.getGioHang(HoaDonID).get(index);
        HDCTService.delete(HoaDonID, gh.getId());
        listGH = HDCTService.getGioHang(HoaDonID);
        fillTableGH(listGH);
        fillTableSP(SPCTService.getSPView());
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        KHpu.setVisible(true);
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        NVpu.setVisible(true);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuyenMaiActionPerformed
        KMpu.setVisible(true);
    }//GEN-LAST:event_btnKhuyenMaiActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
            int GHrow = tblHoaDon.getSelectedRow();
            if(GHrow != -1 && trangThaiHD.equals("Chờ thanh toán")) {
                int row = tblSanPham.getSelectedRow();
                index = (int)tblSanPham.getValueAt(row, 0);
                SanPhamPU SPpu = new SanPhamPU(index, HoaDonID);
                SPpu.setVisible(true);
                fillTableGH(HDCTService.getGioHang(HoaDonID));
            }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        btnXoaSP.setEnabled(true);
        index = tblGioHang.getSelectedRow();
        int idSPCT = (int)tblGioHang.getValueAt(index, 0);
        String soLuong = JOptionPane.showInputDialog(this, "Nhập số lượng muốn THÊM");
        if (soLuong != null) {
            JOptionPane.showMessageDialog(this, HDCTService.addMore(SPCTService.getSPCTView(), idSPCT, Integer.parseInt(soLuong), HoaDonID));
        }
        fillTableGH(HDCTService.getGioHang(HoaDonID));
        fillTableSP(SPCTService.getSPView());
        Double tienGH = 0.00;
        for (int i=0;i<tblGioHang.getRowCount();i++) {
            tienGH += (Double)tblGioHang.getValueAt(i, 5);
        }
        txtThanhToan.setText(String.valueOf(tienGH));
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
            String ma = txtHoaDon.getText();
            int nhanVien = Integer.parseInt(txtNhanVien.getText());
            boolean pttt = true;
            if(rdoTienMat.isSelected()) {
                pttt = true;
            }
            if (rdoTienMat.isSelected()) {
                pttt= false;
            }
            if (txtKhachHang.getText().isBlank()) {
                int phieuGiamGia = Integer.parseInt(txtKhuyenMai.getText());
                HoaDon hd = new HoaDon(HoaDonID, nhanVien, phieuGiamGia, ma, pttt);
                JOptionPane.showMessageDialog(this, HoaDonService.khachLe(hd, HoaDonID));
            } else {
                int khachHang = Integer.parseInt(txtKhachHang.getText());
                int phieuGiamGia = Integer.parseInt(txtKhuyenMai.getText());
                HoaDon hd = new HoaDon(HoaDonID, nhanVien, khachHang, phieuGiamGia, ma, pttt);
                JOptionPane.showMessageDialog(this, HoaDonService.checkout(hd, HoaDonID));
            }
            fillTableHD(HoaDonService.getBHView());
            txtThanhToan.setText("0.00");
            txtTienNhan.setText("");
            txtTienThua.setText("");
            txtKhachHang.setText("");
            txtKhuyenMai.setText("");
            btnThanhToan.setEnabled(false);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienNhanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienNhanKeyReleased
        index = tblHoaDon.getSelectedRow();
        if (txtTienNhan.getText().isBlank()) {
            txtTienThua.setText("");
        } else if(Double.parseDouble(txtTienNhan.getText()) - Double.parseDouble(txtThanhToan.getText()) >= 0) {
            if (tblHoaDon.getValueAt(index, 3).equals("Chờ thanh toán")) {
                btnThanhToan.setEnabled(true);
            }
            txtTienThua.setText(String.valueOf(Double.parseDouble(txtTienNhan.getText()) - Double.parseDouble(txtThanhToan.getText())));
        } else {
            btnThanhToan.setEnabled(false);
            txtTienThua.setText("");
        }
    }//GEN-LAST:event_txtTienNhanKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyHD;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnNhanVien;
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
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblThanhToan;
    private javax.swing.JLabel lblTienNhan;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JPanel panelGioHang;
    private javax.swing.JPanel panelHoaDon;
    private javax.swing.JPanel panelQR;
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
