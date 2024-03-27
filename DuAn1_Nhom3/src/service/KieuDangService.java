package service;

import java.util.List;
import domainmodel.KieuDang;

public interface KieuDangService {
    List<KieuDang> getALL();
    void add(KieuDang kd);
    void update(KieuDang kd);
}
