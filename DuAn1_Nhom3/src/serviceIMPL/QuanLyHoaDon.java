package serviceIMPL;

import model.HoaDon;
import repository.HoaDonRepository;
import java.util.ArrayList;
import service.HoaDonService;

public class QuanLyHoaDon implements HoaDonService{
    HoaDonRepository repository = new HoaDonRepository();
    
    @Override
    public ArrayList<HoaDon> getList(){
        return repository.getAll();
    }

    @Override
    public ArrayList<HoaDon> search(int id) {
        return repository.search(id);    }
}
