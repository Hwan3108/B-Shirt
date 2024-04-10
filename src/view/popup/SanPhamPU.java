package view.popup;

import domainmodel.HinhAnh;
import domainmodel.KichThuoc;
import domainmodel.MauSac;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import serviceIMPL.ChatLieuServiceIMPL;
import serviceIMPL.HinhAnhService;
import serviceIMPL.HoaDonChiTietServiceIMPL;
import serviceIMPL.HoaTietServiceIMPL;
import serviceIMPL.KichThuocServiceIMPL;
import serviceIMPL.MauSacServiceIMPL;
import serviceIMPL.SanPhamChiTietServiceIMPL;
import view.model.SPCTViewModel;
import view.panel.BanHangPanel;

public class SanPhamPU extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    List<SPCTViewModel> listSP = new ArrayList<>();
    SanPhamChiTietServiceIMPL service = new SanPhamChiTietServiceIMPL();
    HoaDonChiTietServiceIMPL HDservice = new HoaDonChiTietServiceIMPL();
    KichThuocServiceIMPL KTservice = new KichThuocServiceIMPL();
    MauSacServiceIMPL MSservice = new MauSacServiceIMPL();
    private BanHangPanel parentForm;
    private int index;
    private int HoaDonId;
    List<Integer> listSPGH = new ArrayList<>();
    HinhAnhService qlha = new HinhAnhService();

    public SanPhamPU(int index, int HoaDonId, List<Integer> listSPGH) {
        initComponents();
        this.listSPGH = listSPGH;
        this.index = index;
        this.HoaDonId = HoaDonId;
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        parentForm = new BanHangPanel();
        HinhAnhService qlAnhService = new HinhAnhService();
        List<SPCTViewModel> listSP = service.getSPCTView();
        List<MauSac> listMS = MSservice.getALL();
        List<KichThuoc> listKT = KTservice.getALL();
        this.fillTable(listSP);
        this.fillMS(listMS);
        this.fillKT(listKT);
        btnThem.setEnabled(false);

    }

    private SanPhamPU() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    void fillTable(List<SPCTViewModel> list) {
        try {
            int row = tblSPCT.getSelectedRow();
            model = (DefaultTableModel) tblSPCT.getModel();
            model.setRowCount(0);
            for (SPCTViewModel x : list) {
                if (x.getTrangThai() == 1 && x.getIdSP() == index && !listSPGH.contains(x.getId()) && x.getSoLuong() != 0) {
                    model.addRow(x.toDataRow());
                    List<HinhAnh> listHA = qlha.getHA(row);
                    if (!listHA.isEmpty()) {
                        HinhAnh firstImage = listHA.get(row); // Lấy ảnh đầu tiên từ danh sách
                        String imageURL = firstImage.getDuongDan();

                        // Hiển thị hình ảnh trong label lbHA
                        ImageIcon imageIcon = new ImageIcon(imageURL);
                        Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // Thay đổi kích thước hình ảnh theo nhu cầu
                        lbHA.setIcon(new ImageIcon(scaledImage));
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void fillMS(List<MauSac> list) {
        for (MauSac x : list) {
            cbbMauSac.addItem(x.getTen());
        }
    }

    void fillKT(List<KichThuoc> list) {
        for (KichThuoc x : list) {
            cbbKichThuoc.addItem(x.getTen());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSPCT = new javax.swing.JTable();
        lblTen = new javax.swing.JLabel();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbKichThuoc = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        lbHA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(854, 480));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(854, 480));
        jPanel1.setMinimumSize(new java.awt.Dimension(854, 480));
        jPanel1.setName(""); // NOI18N

        tblSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null,  new Boolean(true)},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã", "Kích thước", "Màu sắc", "Số lượng", "Giá", "Thao tác"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSPCT.getTableHeader().setReorderingAllowed(false);
        tblSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSPCT);

        lblTen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTen.setText("DANH SÁCH SẢN PHẨM CHI TIẾT");

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbbMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauSacActionPerformed(evt);
            }
        });

        cbbKichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbbKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKichThuocActionPerformed(evt);
            }
        });

        jLabel3.setText("Kích thước");

        jLabel5.setText("Màu sắc");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnHuy.setText("Huỷ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        lbHA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)
                        .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(81, 81, 81)
                .addComponent(btnHuy)
                .addGap(81, 81, 81)
                .addComponent(lbHA, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(lblTen)
                .addContainerGap(405, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnHuy)
                            .addComponent(jLabel3)
                            .addComponent(cbbKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbHA, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            int id;
            model = (DefaultTableModel) tblSPCT.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                Object value = model.getValueAt(i, 6);
                if (value != null && value instanceof Boolean && (Boolean) value) {
                    id = (Integer) model.getValueAt(i, 0);
                    String str = (String) model.getValueAt(i, 5);
                    String clean = str.replaceAll("[,\\$\\€\\£]", "");
                    BigDecimal gia = new BigDecimal(clean);
                    SPCTViewModel spctv = new SPCTViewModel(id, gia);
                    HDservice.buy(spctv, HoaDonId);
                }
            }
            dispose();
        } catch (NullPointerException ne) {
            ne.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPCTMouseClicked
        try {
            model = (DefaultTableModel) tblSPCT.getModel();
            int rowCount = model.getRowCount();
            boolean containsTrue = false;
            boolean containsFalse = false;

            for (int i = 0; i < rowCount; i++) {
                Boolean value = (Boolean) tblSPCT.getValueAt(i, 6);

                if (value != null) {
                    if (value) {
                        containsTrue = true;
                    } else {
                        containsFalse = true;
                    }
                }
            }

            if (containsTrue) {
                btnThem.setEnabled(true);
            } else if (containsFalse) {
                btnThem.setEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblSPCTMouseClicked

    private void cbbMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauSacActionPerformed
        List<SPCTViewModel> listSearch = service.search(service.getSPCTView(), (String) cbbMauSac.getSelectedItem(), (String) cbbKichThuoc.getSelectedItem());
        if (cbbKichThuoc.getSelectedItem().equals("Tất cả") && cbbMauSac.getSelectedItem().equals("Tất cả")) {
            fillTable(service.getSPCTView());
        } else {
            fillTable(listSearch);
        }
    }//GEN-LAST:event_cbbMauSacActionPerformed

    private void cbbKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKichThuocActionPerformed
        List<SPCTViewModel> listSearch = service.search(service.getSPCTView(), (String) cbbMauSac.getSelectedItem(), (String) cbbKichThuoc.getSelectedItem());
        if (cbbKichThuoc.getSelectedItem().equals("Tất cả") && cbbMauSac.getSelectedItem().equals("Tất cả")) {
            fillTable(service.getSPCTView());
        } else {
            fillTable(listSearch);
        }
    }//GEN-LAST:event_cbbKichThuocActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SanPhamPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SanPhamPU().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbbKichThuoc;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbHA;
    private javax.swing.JLabel lblTen;
    private javax.swing.JTable tblSPCT;
    // End of variables declaration//GEN-END:variables
}
