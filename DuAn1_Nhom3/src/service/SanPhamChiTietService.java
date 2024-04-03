package service;

import java.util.List;
import domainmodel.SanPhamChiTiet;
import view.model.SPCTViewModel;
import view.model.SanPhamViewModel;



public interface SanPhamChiTietService {
    List<SanPhamChiTiet> getAll();
    String add(SanPhamChiTiet spct);
    String update(SanPhamChiTiet spct, int id);
    List<SanPhamViewModel> getSPView();
    List<SPCTViewModel> getSPCTView();
    List<SPCTViewModel> search(List<SPCTViewModel> list, String ms, String kt);
}
