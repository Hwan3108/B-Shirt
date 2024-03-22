package serviceIMPL;

import java.util.List;
import model.KichThuoc;
import repository.KichThuocRepository;
import service.KichThuocService;

public class KichThuocServiceIMPL implements KichThuocService{
    KichThuocRepository ktRepo = new KichThuocRepository();

    @Override
    public List<KichThuoc> getALL() {
        return ktRepo.getAll();
    }
    
    @Override
    public void Add(KichThuoc kt) {
        ktRepo.add(kt);
    }
    
    @Override
    public void Update(KichThuoc kt) {
       ktRepo.update(kt);
    }
    
}