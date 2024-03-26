package serviceIMPL;

import java.util.List;
import model.KhuyenMai;
import repository.KhuyenMaiRepository;
import service.KhuyenMaiService;

public class KhuyenMaiServiceIMPL implements KhuyenMaiService{
    
    private KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
    
    @Override
    public List<KhuyenMai> getAll() {
        return khuyenMaiRepository.getAll();
    }

    @Override
    public void add(KhuyenMai khuyenMai) {
        khuyenMaiRepository.insert(khuyenMai);
    }

    @Override
    public KhuyenMai getById(int id) {
        return khuyenMaiRepository.getById(id);
    }

    @Override
    public void update(KhuyenMai khuyenMai, int id) {
        khuyenMaiRepository.update(khuyenMai, id);
    }

    @Override
    public void updateTrangThai() {
        khuyenMaiRepository.updateTrangThai();
    }

    @Override
    public List<KhuyenMai> getByMa(String ma) {
      return khuyenMaiRepository.getByMa(ma);
    }

    @Override
    public List<KhuyenMai> getByTrangThai(int choice) {
        return khuyenMaiRepository.getByTrangThai(choice);
    }
    
}
