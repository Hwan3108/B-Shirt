package service;

import java.util.List;
import model.KichThuoc;

public interface KichThuocService {
    List<KichThuoc> getALL();
    void Add(KichThuoc kt);
    void Update(KichThuoc kt);
}
