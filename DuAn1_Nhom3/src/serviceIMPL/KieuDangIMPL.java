package serviceIMPL;

import java.util.List;
import domainmodel.KieuDang;
import repository.KieuDangRepository;
import service.KieuDangService;

public class KieuDangIMPL implements KieuDangService{
    KieuDangRepository kdRepo = new KieuDangRepository();

    @Override
    public List<KieuDang> getALL() {
        return kdRepo.getAll();
    }
    
    @Override
    public void add(KieuDang kd) {
        kdRepo.add(kd);
    }
    
    @Override
    public void update(KieuDang kd) {
       kdRepo.update(kd);
    }
    
}
