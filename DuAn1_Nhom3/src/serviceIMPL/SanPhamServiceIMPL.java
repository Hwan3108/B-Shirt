package serviceIMPL;

import java.util.List;
import model.SanPham;
import repository.SanPhamRepository;
import service.SanPhamService;

public class SanPhamServiceIMPL implements SanPhamService{
    
    SanPhamRepository repo = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return repo.getAll();
    }

    @Override
    public boolean add(SanPham sp) {
        return repo.add(sp);
    }

    @Override
    public boolean update(SanPham sp) {
        return repo.update(sp);
    }
    
}
