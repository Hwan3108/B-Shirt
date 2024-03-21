package serviceIMPL;

import java.util.List;
import model.ThuongHieu;
import repository.ThuongHieuRepository;
import service.ThuongHieuService;

public class ThuongHieuServiceIMPL implements ThuongHieuService{
    ThuongHieuRepository thRepo = new ThuongHieuRepository();

    @Override
    public List<ThuongHieu> getALL() {
        return thRepo.getAll();
    }
    
    @Override
    public void Add(ThuongHieu th) {
        thRepo.add(th);
    }
    
    @Override
    public void Update(ThuongHieu th) {
       thRepo.update(th);
    }
    
}
