package service;

import java.util.List;
import domainmodel.HinhAnh;

public interface HinhAnhService {
    List<HinhAnh> getAll();
    void add(HinhAnh ha);
    void update(HinhAnh ha);
    List<HinhAnh> getHA(int id);
}
