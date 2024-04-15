package print;

import domainmodel.HoaDon;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class ReportManager {

    private static ReportManager instance;
    private JasperReport reportPay;

    public static ReportManager getInstance() {
        if (instance == null) {
            instance = new ReportManager();
        }
        return instance;
    }

    public ReportManager() {
    }

    public void compileReport() throws JRException {
        reportPay = JasperCompileManager.compileReport(getClass().getResourceAsStream("/print/report_pay.jrxml"));
    }

    public void printReportPayment(HoaDon hd) throws JRException {
        try {
            Map para = new HashMap();
            para.put("mahoadon", hd.getMaHoaDon());
            para.put("tenNhanVien", hd.getNhanVien().getHoTen());
            para.put("tenKhachHang", hd.getKhachHang().getTen());
            para.put("tenSanPham", hd.getSanPham().getTen());
            para.put("giamGia", hd.getKhuyenMai().getPhanTram());
            para.put("soLuong", hd.getDonChiTiet().getSoLuong());
            para.put("donGia", hd.getDonChiTiet().getDonGia());
            para.put("ngayMua", hd.getNgayTao());
            para.put("phuongTTT", hd.layPTTT());
            para.put("tongTien", hd.getDonChiTiet().getTongTien());        
            if (reportPay == null) {
                compileReport();
            }

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList(hd.getListLS()));
            JasperPrint print = JasperFillManager.fillReport(reportPay, para, dataSource);
            view(print);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }

}
