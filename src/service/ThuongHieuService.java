package service;

import java.util.List;
import domainmodel.ThuongHieu;

public interface ThuongHieuService {
    List<ThuongHieu> getALL();
    void add(ThuongHieu th);
    void update(ThuongHieu th);
}
