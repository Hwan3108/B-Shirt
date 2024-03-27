package service;

import java.util.List;
import domainmodel.KichThuoc;

public interface KichThuocService {
    List<KichThuoc> getALL();
    void add(KichThuoc kt);
    void update(KichThuoc kt);
}
