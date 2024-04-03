package serviceIMPL;

import domainmodel.HoaTiet;
import java.util.List;
import repository.HoaTietRepository;
import service.HoaTietService;

public class HoaTietServiceIMPL implements HoaTietService{
    
    HoaTietRepository repo = new HoaTietRepository();

    @Override
    public List<HoaTiet> getAll() {
        return repo.getAll();
    }

    @Override
    public void add(HoaTiet ht) {
        repo.add(ht);
    }

    @Override
    public void update(HoaTiet ht) {
        repo.update(ht);
    }
}
