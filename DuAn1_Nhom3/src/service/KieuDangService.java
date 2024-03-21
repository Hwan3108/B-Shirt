package service;

import java.util.List;
import model.KieuDang;

public interface KieuDangService {
    List<KieuDang> getALL();
    void Add(KieuDang kd);
    void Update(KieuDang kd);
}
