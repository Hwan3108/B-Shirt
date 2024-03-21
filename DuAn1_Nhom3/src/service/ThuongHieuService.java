package service;

import java.util.List;
import model.ThuongHieu;

public interface ThuongHieuService {
    List<ThuongHieu> getALL();
    void Add(ThuongHieu th);
    void Update(ThuongHieu th);
}
