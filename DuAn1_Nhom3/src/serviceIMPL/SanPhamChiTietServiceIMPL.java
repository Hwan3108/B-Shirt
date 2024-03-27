package serviceIMPL;

import java.util.List;
import domainmodel.SanPhamChiTiet;
import repository.SanPhamChiTietRepository;
import service.SanPhamChiTietService;
import view.model.SPCTViewModel;
import view.model.SanPhamViewModel;



public class SanPhamChiTietServiceIMPL implements SanPhamChiTietService{

    SanPhamChiTietRepository repo = new SanPhamChiTietRepository();
    
    @Override
    public List<SanPhamChiTiet> getAll() {
        return repo.getAll();
    }

    @Override
    public String add(SanPhamChiTiet spct) {
        if(repo.add(spct)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(SanPhamChiTiet spct, int id) {
        if(repo.update(spct, id)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public List<SanPhamViewModel> getSPView() {
        return repo.getSPView();
    }

    @Override
    public List<SPCTViewModel> getSPCTView() {
        return repo.getSPCTView();
    }
    
}
