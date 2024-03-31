package serviceIMPL;

import domainmodel.HoaDon;
import repository.HoaDonRepository;
import java.util.ArrayList;
import java.util.List;
import service.HoaDonService;
import view.model.HoaDonViewModel;

public class QuanLyHoaDon implements HoaDonService{
    HoaDonRepository repository = new HoaDonRepository();
    
    @Override
    public ArrayList<HoaDon> getList(){
        return repository.getAll();
    }

    @Override
    public ArrayList<HoaDon> search(int id) {
        return repository.search(id);    }

    @Override
    public void create() {
        repository.create();
    }

    @Override
    public void cancel(int id) {
        repository.cancel(id);
    }

    @Override
    public String checkout(HoaDon hd, int id) {
        if (hd.getIdNhanVien() == 0) {
            return "Không được để trống id nhân viên";
        }
        else if(repository.checkout(hd, id)) {
            return "Thanh toán thành công";
        } else {
            return "Không thể thanh toán hoá đơn";
        }
    }

    @Override
    public List<HoaDonViewModel> getBHView() {
        return repository.getBHView();
    }

    @Override
    public List<HoaDonViewModel> locTrangThai(List<HoaDonViewModel> list, int index) {
        List<HoaDonViewModel> listSearch = new ArrayList<>();
        for (HoaDonViewModel view: list) {
            if(view.getTrangThai() == index) {
                listSearch.add(view);
            }
        }
        return listSearch;
    }

    @Override
    public String khachLe(HoaDon hd, int id) {
        if (hd.getIdNhanVien() == 0) {
            return "Không được để trống id nhân viên";
        }
        else if(repository.khachLe(hd, id)) {
            return "Thanh toán thành công";
        } else {
            return "Không thể thanh toán hoá đơn";
        }
    }
}
