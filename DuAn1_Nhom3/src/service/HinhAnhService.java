package service;

import java.util.List;
import model.HinhAnh;

public interface HinhAnhService {
    List<HinhAnh> getAll();
    void add(HinhAnh ha);
    void update(HinhAnh ha);
}
