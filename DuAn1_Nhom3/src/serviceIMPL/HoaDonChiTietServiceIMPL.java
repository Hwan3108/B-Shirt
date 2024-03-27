package serviceIMPL;

import domainmodel.HoaDonChiTiet;
import java.util.List;
import repository.HoaDonChiTietRepository;
import service.HoaDonChiTietService;
import view.model.GioHangViewModel;

public class HoaDonChiTietServiceIMPL implements HoaDonChiTietService{

    HoaDonChiTietRepository repo = new HoaDonChiTietRepository();
    
    @Override
    public List<HoaDonChiTiet> getAll() {
        return repo.getAll();
    }

    @Override
    public List<GioHangViewModel> getGioHang(int index) {
        return repo.getGioHangView(index);
    }

    @Override
    public String add(HoaDonChiTiet hdct) {
        if(repo.add(hdct)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(HoaDonChiTiet hdct, int id) {
        if(repo.update(hdct, id)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public void cancel(int id) {
        repo.cancel(id);
    }
}
