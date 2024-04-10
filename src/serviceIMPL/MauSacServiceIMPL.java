package serviceIMPL;

import java.util.List;
import domainmodel.MauSac;
import java.util.ArrayList;
import repository.MauSacRepository;
import service.MauSacService;

public class MauSacServiceIMPL implements MauSacService{
    MauSacRepository msRepo = new MauSacRepository();

    @Override
    public List<MauSac> getALL() {
        return msRepo.getAll();
    }
    
    @Override
    public void add(MauSac ms) {
        msRepo.add(ms);
    }
    
    @Override
    public void update(MauSac ms) {
       msRepo.update(ms);
    }
//    
//    @Override
//    public List<MauSac> search(List<MauSac> list, String ten) {
//        List<MauSac> listSearch = new ArrayList<>();
//        for (MauSac x: list) {
//            if (x.getTen().equals(ten)) {
//                listSearch.add(x);
//            }
//        }
//        return listSearch;
//    }
}
