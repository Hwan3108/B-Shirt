package serviceIMPL;

import java.util.List;
import domainmodel.SanPham;
import java.util.ArrayList;
import repository.SanPhamRepository;
import service.SanPhamService;
import view.model.SanPhamViewModel;

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

    @Override
    public List<SanPhamViewModel> search(List<SanPhamViewModel> list, String ma, String ten, String cl, String kd, String ht, String th) {
        List<SanPhamViewModel> listSearch = new ArrayList<>();
        for (SanPhamViewModel x: list) {
            if (x.getMaSP().equals(ma) || x.getTenSP().equals(ten) || x.getChatLieu().equals(cl) || x.getKieuDang().equals(kd) || x.getHoaTiet().equals(ht) || x.getThuongHieu().equals(th)) {
                listSearch.add(x);
            }
        }
        return listSearch;
    }
    
}
