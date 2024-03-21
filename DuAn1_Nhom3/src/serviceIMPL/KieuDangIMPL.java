package serviceIMPL;

import java.util.List;
import model.KieuDang;
import repository.KieuDangRepository;
import service.KieuDangService;

public class KieuDangIMPL implements KieuDangService{
    KieuDangRepository kdRepo = new KieuDangRepository();

    @Override
    public List<KieuDang> getALL() {
        return kdRepo.getAll();
    }
    
    @Override
    public void Add(KieuDang kd) {
        kdRepo.add(kd);
    }
    
    @Override
    public void Update(KieuDang kd) {
       kdRepo.update(kd);
    }
    
}
