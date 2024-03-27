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
    public void cancel(String ma) {
        repository.cancel(ma);
    }

    @Override
    public void checkout(HoaDon hd, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
}
