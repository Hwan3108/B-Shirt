package service;

import java.util.List;
import model.SanPhamChiTiet;



public interface SanPhamChiTietService {
    List<SanPhamChiTiet> getAll();
    String add(SanPhamChiTiet spct);
    String update(SanPhamChiTiet spct, int id);
}
