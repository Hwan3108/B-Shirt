package serviceIMPL;

import java.util.List;
import model.MauSac;
import repository.MauSacRepository;
import service.MauSacService;

public class MauSacServiceIMPL implements MauSacService{
    MauSacRepository msRepo = new MauSacRepository();

    @Override
    public List<MauSac> getALL() {
        return msRepo.getAll();
    }
    
    @Override
    public void Add(MauSac ms) {
        msRepo.add(ms);
    }
    
    @Override
    public void Update(MauSac ms) {
       msRepo.update(ms);
    }
    
}
