package service;

import java.util.List;
import domainmodel.SanPham;
import view.model.SanPhamViewModel;

public interface SanPhamService {
    List<SanPham> getAll();
    boolean add(SanPham sp);
    boolean update(SanPham sp);
    List<SanPhamViewModel> search(List<SanPhamViewModel> list, String ma, String ten, String cl, String kd, String ht, String th);
}
