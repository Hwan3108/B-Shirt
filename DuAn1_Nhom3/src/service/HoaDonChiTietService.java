package service;

import domainmodel.HoaDonChiTiet;
import java.util.List;
import view.model.GioHangViewModel;

public interface HoaDonChiTietService {
    List<HoaDonChiTiet> getAll();
    List<GioHangViewModel> getGioHang(int index);
    String add(HoaDonChiTiet hdct);
    String update(HoaDonChiTiet hdct, int id);
    void cancel(int id);
}
