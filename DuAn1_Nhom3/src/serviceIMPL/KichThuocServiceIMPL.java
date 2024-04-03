package serviceIMPL;

import java.util.List;
import domainmodel.KichThuoc;
import java.util.ArrayList;
import repository.KichThuocRepository;
import service.KichThuocService;

public class KichThuocServiceIMPL implements KichThuocService{
    KichThuocRepository ktRepo = new KichThuocRepository();

    @Override
    public List<KichThuoc> getALL() {
        return ktRepo.getAll();
    }
    
    @Override
    public void add(KichThuoc kt) {
        ktRepo.add(kt);
    }
    
    @Override
    public void update(KichThuoc kt) {
       ktRepo.update(kt);
    }
    
//    @Override
//    public List<KichThuoc> search(List<KichThuoc> list, String ten) {
//        List<KichThuoc> listSearch = new ArrayList<>();
//        for (KichThuoc x: list) {
//            if (x.getTen().equals(ten)) {
//                listSearch.add(x);
//            }
//        }
//        return listSearch;
//    }
    
}
