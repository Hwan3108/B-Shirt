package view;

import java.awt.Color;
import javax.swing.JComponent;
import view.panel.BanHangPanel;
import view.panel.HoaDonPanel;
import view.panel.KhachHangPanel;
import view.panel.NhanVienPanel;
import view.panel.PhieuGiamGiaPanel;
import view.panel.SanPhamPanel;
import view.panel.ThongKePanel;

public class Main extends javax.swing.JFrame {
    
    private BanHangPanel banHang;
    private SanPhamPanel sanPham;
    private HoaDonPanel hoaDon;
    private KhachHangPanel khachHang;
    private NhanVienPanel nhanVien;
    private ThongKePanel thongKe;
    private PhieuGiamGiaPanel phieuGiamGia;

    public Main() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        banHang = new BanHangPanel();
        sanPham = new SanPhamPanel();
        hoaDon = new HoaDonPanel();
        khachHang = new KhachHangPanel();
        nhanVien = new NhanVienPanel();
        thongKe = new ThongKePanel();
        phieuGiamGia = new PhieuGiamGiaPanel();
        menu.initMoving(Main.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if(index == 0) {
                    setForm(banHang);
                } else if (index == 1) {
                    setForm(sanPham);
                } else if (index == 2) {
                    setForm(hoaDon);
                } else if (index == 3) {
                    setForm(khachHang);
                } else if (index == 4) {
                    setForm(nhanVien);
                } else if (index == 5) {
                    setForm(thongKe);
                } else if (index == 6) {
                    setForm(phieuGiamGia);
                } else if (index == 7) {
                    System.exit(0);
                }
            }
        });
        setForm(banHang);
        
    }

    private void setForm(JComponent com) {
        mainPanel.remove(com);
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBorder = new view.PanelBorder();
        menu = new view.Menu();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelBorder.setBackground(new java.awt.Color(255, 255, 255));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setOpaque(false);
        mainPanel.setPreferredSize(new java.awt.Dimension(739, 540));
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout PanelBorderLayout = new javax.swing.GroupLayout(PanelBorder);
        PanelBorder.setLayout(PanelBorderLayout);
        PanelBorderLayout.setHorizontalGroup(
            PanelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBorderLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBorderLayout.setVerticalGroup(
            PanelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBorderLayout.createSequentialGroup()
                .addGroup(PanelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.PanelBorder PanelBorder;
    private javax.swing.JPanel mainPanel;
    private view.Menu menu;
    // End of variables declaration//GEN-END:variables
}
