package serviceIMPL;

import java.util.List;
import domainmodel.ThuongHieu;
import repository.ThuongHieuRepository;
import service.ThuongHieuService;

public class ThuongHieuServiceIMPL implements ThuongHieuService{
    ThuongHieuRepository thRepo = new ThuongHieuRepository();

    @Override
    public List<ThuongHieu> getALL() {
        return thRepo.getAll();
    }
    
    @Override
    public void add(ThuongHieu th) {
        thRepo.add(th);
    }
    
    @Override
    public void update(ThuongHieu th) {
       thRepo.update(th);
    }
    
}
