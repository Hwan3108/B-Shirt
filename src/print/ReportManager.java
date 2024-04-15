package print;

import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import domainmodel.KhachHang;
import domainmodel.KhuyenMai;
import domainmodel.NhanVien;
import domainmodel.SanPham;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import serviceIMPL.QuanLyHoaDon;

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
       
        QuanLyHoaDon qlhd = new QuanLyHoaDon();
        ArrayList<HoaDon> hoaDons = qlhd.getLichSu();
        Map para = new HashMap();
        SanPham sanPham = hd.getSanPham();
        KhuyenMai khuyenMai = hd.getKhuyenMai();
        NhanVien nhanVien = hd.getNhanVien();
        KhachHang khachHang = hd.getKhachHang();
        HoaDonChiTiet hdct = hd.getDonChiTiet();
        para.put("Mã Hóa Đơn", hd.getMaHoaDon());
        para.put("Tên Nhân Viên", nhanVien.getHoTen());
        para.put("Tên Khách Hàng", khachHang.getTen());
        para.put("Tên Sản Phẩm", sanPham.getTen());
        para.put("Giảm Giá", khuyenMai.getPhanTram());
        para.put("Số Lương", hdct.getSoLuong());
        para.put("Đơn Giá", hdct.getDonGia());
        para.put("Ngày Tạo", hd.getNgayTao());
        para.put("Phương Thức Thanh Toán", hd.layPTTT());
        para.put("Tổng Tiền", hdct.getTongTien());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(hoaDons);
        JasperPrint print = JasperFillManager.fillReport(reportPay, para, dataSource);
        view(print);

    }
    private void view(JasperPrint print) throws JRException{
        JasperViewer.viewReport(print, false);
    }

}
