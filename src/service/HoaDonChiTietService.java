package service;

import domainmodel.HoaDonChiTiet;
import java.util.List;
import view.model.GioHangViewModel;
import view.model.SPCTViewModel;

public interface HoaDonChiTietService {
    List<HoaDonChiTiet> getAll();
    List<GioHangViewModel> getGioHang(int index);
    List<HoaDonChiTiet> searchGioHang(List<HoaDonChiTiet> list, int id);
    String add(HoaDonChiTiet hdct);
    String update(HoaDonChiTiet hdct, int id);
    void delete(int idHD, int idSP);
    void buy(SPCTViewModel spctv, int idHD);
    String addMore(List<SPCTViewModel> listSPCT, int idSPCT, int soLuong, int idHD);
    String returnItem(List<SPCTViewModel> listSPCT, int idSPCT, int soLuong, int idHD);
}
