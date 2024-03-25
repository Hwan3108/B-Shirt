package view.panel;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NhanVien;
import serviceIMPL.NhanVienServiceIMPL;

public class NhanVienPanel extends javax.swing.JPanel {
    
    NhanVienServiceIMPL service = new NhanVienServiceIMPL();
    DefaultTableModel model = new DefaultTableModel();
    NhanVien nv = new NhanVien();
    private int index = -1;

    
    public NhanVienPanel() {
        initComponents();
        List<NhanVien> listNV = service.getAll();
        this.fillTable(listNV);
    }
    
    void fillTable (List<NhanVien> list) {
        model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        for (NhanVien x: list) {
            model.addRow(x.toDataRow());
        }
    }
    
    public void fillData(int index) {
        NhanVien nv = service.getAll().get(index);
        lblID.setText(String.valueOf(nv.getId()));
        txtHoTen.setText(nv.getHoTen());
        if(nv.isChucVu() == true) {
            rdoNhanVien.setSelected(true);
        } else {
            rdoQuanLy.setSelected(true);
        }
        txtSDT.setText(nv.getSdt());
        txtNgaySinh.setText(new SimpleDateFormat("dd-MM-yyyy").format(nv.getNgaySinh()));
        if(nv.isGioiTinh() == true) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtDiaChi.setText(nv.getDiaChi());
        txtEmail.setText(nv.getEmail());
        txtCCCD.setText(nv.getCccd());
        if(nv.getTrangThai()== 1) {
            rdoDiLam.setSelected(true);
        }
        if(nv.getTrangThai()== 2) {
            rdoNghiPhep.setSelected(true);
        }
        if(nv.getTrangThai()== 3) {
            rdoThoiViec.setSelected(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnChucVu = new javax.swing.ButtonGroup();
        btnGioiTinh = new javax.swing.ButtonGroup();
        btnTrangThai = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblHoTen = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        lblChucVu = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblNgaySinh = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblCCCD = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        rdoNhanVien = new javax.swing.JRadioButton();
        rdoQuanLy = new javax.swing.JRadioButton();
        txtSDT = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        rdoNghiPhep = new javax.swing.JRadioButton();
        rdoThoiViec = new javax.swing.JRadioButton();
        rdoDiLam = new javax.swing.JRadioButton();
        lblQuetMa = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        panelQuetMa = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        lblTimKiem = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        lblNV = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblHoTen.setText("Họ tên:");

        lblMatKhau.setText("Mật khẩu");

        lblChucVu.setText("Chức vụ");

        lblSDT.setText("Số điện thoại");

        lblNgaySinh.setText("Ngày sinh");

        lblGioiTinh.setText("Giới tính");

        lblDiaChi.setText("Địa chỉ");

        lblEmail.setText("Email");

        lblCCCD.setText("CCCD/CMND");

        lblTrangThai.setText("Trạng thái");

        btnChucVu.add(rdoNhanVien);
        rdoNhanVien.setText("Nhân viên");

        btnChucVu.add(rdoQuanLy);
        rdoQuanLy.setText("Quản lý");

        btnGioiTinh.add(rdoNam);
        rdoNam.setText("Nam");

        btnGioiTinh.add(rdoNu);
        rdoNu.setText("Nữ");

        btnTrangThai.add(rdoNghiPhep);
        rdoNghiPhep.setText("Nghỉ phép");

        btnTrangThai.add(rdoThoiViec);
        rdoThoiViec.setText("Thôi việc");

        btnTrangThai.add(rdoDiLam);
        rdoDiLam.setText("Đi làm");

        lblQuetMa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblQuetMa.setText("Quét CCCD/CMND");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        panelQuetMa.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelQuetMaLayout = new javax.swing.GroupLayout(panelQuetMa);
        panelQuetMa.setLayout(panelQuetMaLayout);
        panelQuetMaLayout.setHorizontalGroup(
            panelQuetMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        panelQuetMaLayout.setVerticalGroup(
            panelQuetMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnExport.setText("Export");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHoTen)
                            .addComponent(lblChucVu)
                            .addComponent(lblNgaySinh)
                            .addComponent(lblDiaChi))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoNhanVien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoQuanLy))
                            .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txtNgaySinh)
                            .addComponent(txtDiaChi)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCCCD)
                        .addGap(18, 18, 18)
                        .addComponent(txtCCCD)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSDT)
                            .addComponent(lblMatKhau))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txtSDT)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGioiTinh)
                            .addComponent(lblEmail)
                            .addComponent(lblTrangThai))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdoNam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoNu))
                                    .addComponent(rdoNghiPhep)
                                    .addComponent(rdoThoiViec)
                                    .addComponent(rdoDiLam))
                                .addGap(0, 76, Short.MAX_VALUE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lblQuetMa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelQuetMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem)
                            .addComponent(btnLamMoi)
                            .addComponent(btnSua)
                            .addComponent(btnImport)
                            .addComponent(btnExport))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHoTen)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMatKhau)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblQuetMa))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelQuetMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblChucVu)
                                    .addComponent(rdoNhanVien)
                                    .addComponent(rdoQuanLy)
                                    .addComponent(lblSDT)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNgaySinh)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGioiTinh)
                                    .addComponent(rdoNam)
                                    .addComponent(rdoNu))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDiaChi)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmail)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addComponent(rdoDiLam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCCCD)
                                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTrangThai)
                                    .addComponent(rdoNghiPhep))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoThoiViec))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnLamMoi)
                                .addGap(18, 18, 18)
                                .addComponent(btnImport)
                                .addGap(18, 18, 18)
                                .addComponent(btnExport)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("NHÂN VIÊN");

        lblTimKiem.setText("Tìm kiếm");

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lý" }));
        cbbChucVu.setToolTipText("");

        jLabel3.setText("Chức vụ");

        jLabel4.setText("Trạng thái");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đi làm", "Nghỉ phép", "Thôi việc" }));

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ tên", "Chức vụ", "SĐT", "Ngày sinh", "Giới tính", "Địa chỉ", "Email", "Trạng thái", "Ngày tạo", "Ngày sửa"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNhanVien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimKiem)
                    .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblNV.setText("ID nhân viên:");

        lblID.setText("number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblID)
                .addGap(296, 296, 296)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNV)
                            .addComponent(lblID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String hoTen = txtHoTen.getText().trim();
        String matKhau = txtMatKhau.getText().trim();
        boolean chucVu = true;
        if (rdoNhanVien.isSelected()) {
            chucVu = true;
        }
        if (rdoQuanLy.isSelected()) {
            chucVu = false;
        }
        String SDT = txtSDT.getText().trim();
        
        String ngaySinh = txtNgaySinh.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(ngaySinh, formatter);
        java.sql.Date ngaySinhs = java.sql.Date.valueOf(localDate);
        
        boolean gioiTinh = true;
        if (rdoNam.isSelected()) {
           gioiTinh = true;
        }
        if (rdoNu.isSelected()) {
            gioiTinh = false;
        }
        String diaChi = txtDiaChi.getText().trim();
        String email = txtEmail.getText().trim();
        String cccd = txtCCCD.getText().trim();
        int trangThai;
        if (rdoDiLam.isSelected()) {
           trangThai = 1;
        }
        if (rdoNghiPhep.isSelected()) {
            trangThai = 2;
        } else {
            trangThai = 3;
        }
        nv = new NhanVien(hoTen, matKhau, chucVu, SDT, ngaySinhs, gioiTinh, diaChi, email, cccd, trangThai);
        JOptionPane.showMessageDialog(this, service.add(nv));
        fillTable(service.getAll());
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int id = Integer.parseInt(lblID.getText());
        nv.setHoTen(txtHoTen.getText());
        if(rdoNhanVien.isSelected()) {
            nv.setChucVu(true);
        } else {
            nv.setChucVu(false);
        }
        nv.setSdt(txtSDT.getText());
        String ngaySinh = txtNgaySinh.getText();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(ngaySinh, formatter);
        java.sql.Date ngaySinhs = java.sql.Date.valueOf(localDate);
        nv.setNgaySinh(ngaySinhs);
        
        if(rdoNam.isSelected()) {
            nv.setGioiTinh(true);
        } else {
            nv.setGioiTinh(false);
        }
        nv.setDiaChi(txtDiaChi.getText());
        nv.setEmail(txtEmail.getText());
        nv.setCccd(txtCCCD.getText());
        if(rdoDiLam.isSelected()) {
            nv.setTrangThai(1);
        }
        if(rdoNghiPhep.isSelected()) {
            nv.setTrangThai(2);
        } else {
            nv.setTrangThai(3);
        }
        JOptionPane.showMessageDialog(this, service.update(nv, id));
        fillTable(service.getAll());
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed

    }//GEN-LAST:event_btnImportActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtHoTen.setText("");
        txtMatKhau.setText("");
        rdoNhanVien.setSelected(false);
        rdoQuanLy.setSelected(false);
        txtSDT.setText("");
        txtNgaySinh.setText("");
        rdoNam.setSelected(false);
        rdoNu.setSelected(false);
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtCCCD.setText("");
        rdoDiLam.setSelected(false);
        rdoNghiPhep.setSelected(false);
        rdoThoiViec.setSelected(false);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        index = tblNhanVien.getSelectedRow();
        fillData(index);
    }//GEN-LAST:event_tblNhanVienMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnChucVu;
    private javax.swing.JButton btnExport;
    private javax.swing.ButtonGroup btnGioiTinh;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup btnTrangThai;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCCCD;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblNV;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblQuetMa;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel panelQuetMa;
    private javax.swing.JRadioButton rdoDiLam;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNghiPhep;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoQuanLy;
    private javax.swing.JRadioButton rdoThoiViec;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
