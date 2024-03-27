package service;

import java.util.List;
import domainmodel.SanPham;

public interface SanPhamService {
    List<SanPham> getAll();
    boolean add(SanPham sp);
    boolean update(SanPham sp);
}
