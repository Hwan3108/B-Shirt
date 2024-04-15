package view.panel;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import print.ReportManager;
import serviceIMPL.HoaDonChiTietServiceIMPL;
import serviceIMPL.NhanVienServiceIMPL;
import serviceIMPL.QuanLyHoaDon;

public class HoaDonView extends javax.swing.JPanel {

    SimpleDateFormat format = new SimpleDateFormat("MM-dd-YYYY");
    DefaultTableModel defaultTableModel;
    QuanLyHoaDon qlhd = new QuanLyHoaDon();//Của Hóa Đơn
    HoaDonChiTietServiceIMPL hoaDonChiTietServiceIMPL = new HoaDonChiTietServiceIMPL();
    NhanVienServiceIMPL nhanVienServiceIMPL = new NhanVienServiceIMPL();
    ArrayList<HoaDon> listLSHD = qlhd.getLichSu();

    public HoaDonView() {
        initComponents();
        ArrayList<HoaDon> list = qlhd.getList();
        List<HoaDonChiTiet> listHDCT = hoaDonChiTietServiceIMPL.getAll();
        ArrayList<HoaDon> listLSHD = qlhd.getLichSu();
        loadData(list);
        loadDataHDCT(listHDCT);
        loadLichSuHD(listLSHD);
        tblHoaDon.setDefaultEditor(Object.class, null);
        tblHoaDonChiTiet.setDefaultEditor(Object.class, null);
        tblLichSu.setDefaultEditor(Object.class, null);
        try {
            ReportManager.getInstance().compileReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loadData(ArrayList<HoaDon> list) {
        defaultTableModel = (DefaultTableModel) tblHoaDon.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDon hd : list) {
            defaultTableModel.addRow(new Object[]{
                hd.getId(),
                hd.getIdNhanVien(),
                hd.getIdKhachHang(),
                hd.getIdPhieuGiamGia(),
                hd.getMaHoaDon(),
                hd.layPTTT(),
                hd.getNgayTao(),
                hd.getNgaySua(),
                hd.layTrangThaiHD()
            });
        }
    }

    void loadDataHDCT(List<HoaDonChiTiet> list) {
        defaultTableModel = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDonChiTiet hdct : list) {
            defaultTableModel.addRow(new Object[]{
                hdct.getId(),
                hdct.getIdHoaDon(),
                hdct.getIdSPCT(),
                hdct.getSoLuong(),
                hdct.getDonGia(),
                hdct.layTT(),
                hdct.getNgayTao(),
                hdct.getNgaySua(),});
        }
    }

    void loadLichSuHD(ArrayList<HoaDon> list) {
        try {
            defaultTableModel = (DefaultTableModel) tblLichSu.getModel();
            defaultTableModel.setRowCount(0);
            for (HoaDon hd : list) {
                defaultTableModel.addRow(new Object[]{
                    hd.getMaHoaDon(),
                    hd.getNhanVien().getHoTen(),
                    hd.getKhachHang().getTen(),
                    hd.getSanPham().getTen(),
                    hd.getKhuyenMai().getPhanTram(),
                    hd.layPTTT(),
                    hd.getDonChiTiet().getSoLuong(),
                    hd.getDonChiTiet().getDonGia(),
                    hd.getNgayTao(),
                    hd.getDonChiTiet().getTongTien(),
                    hd.layTrangThaiHD()

                });

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLichSu = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(965, 657));
        setMinimumSize(new java.awt.Dimension(965, 657));
        setPreferredSize(new java.awt.Dimension(965, 657));

        jLabel1.setText("Tìm:");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID Nhân viên", "ID Khách hàng", "ID Voucher", "Mã hoá đơn", "PTTT", "Ngày tạo", "Ngày sửa", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thông Tin Hóa Đơn", jPanel1);

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID Hóa Đon", "ID Sản Phẩm CT", "Số lượng", "Đơn giá", "Trạng Thái", "Ngày tạo", "Ngày sửa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblHoaDonChiTiet);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Hóa Đơn Chi Tiết", jPanel2);

        tblLichSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Tên Nhân Viên", "Tên Khách hàng", "Tên Sản Phẩm", "Giảm Giá", "PTTT", "Số Lượng", "Đơn Giá", "Ngày tạo", "Tổng Tiền", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblLichSu);

        btnPrint.setText("Xuất Hóa Đơn");
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrint)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch Sử Hóa Đơn", jPanel3);

        btnTim.setText("Tìm");
        btnTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tìm Hóa Đơn");

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLamMoiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnTim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim)
                    .addComponent(btnLamMoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimMouseClicked
        // TODO add your handling code here:
        if(validateForm()){
        int tim = Integer.parseInt(txtTim.getText());
        ArrayList<HoaDon> listKQ = qlhd.search(tim);
        loadData(listKQ);
        }
    }//GEN-LAST:event_btnTimMouseClicked

    private void btnLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiMouseClicked
        // TODO add your handling code here:
        loadData(qlhd.getList());
        loadDataHDCT(hoaDonChiTietServiceIMPL.getAll());
        loadLichSuHD(qlhd.getLichSu());
    }//GEN-LAST:event_btnLamMoiMouseClicked

    private void btnPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseClicked
        try {
            int row = tblLichSu.getSelectedRow();
            ReportManager.getInstance().printReportPayment(qlhd.getLichSu().get(row));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnPrintMouseClicked
    boolean validateForm(){
        if(txtTim.getText().equals("") && txtTim.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return false;
                    
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTable tblLichSu;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
