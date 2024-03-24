package service;

import java.util.List;
import model.SanPham;

public interface SanPhamService {
    List<SanPham> getAll();
    void add(SanPham sp);
    void update(SanPham sp);
}
