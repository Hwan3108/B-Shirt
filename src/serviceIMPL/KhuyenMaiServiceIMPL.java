package serviceIMPL;

import java.util.List;
import domainmodel.KhuyenMai;
import repository.KhuyenMaiRepository;
import service.KhuyenMaiService;

public class KhuyenMaiServiceIMPL implements KhuyenMaiService{
    
    private KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
    List<KhuyenMai> listKM = khuyenMaiRepository.getAll();
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

    @Override
    public int getKM(List<KhuyenMai> list, String ma) {
        if (list == null || ma == null) {
            throw new IllegalArgumentException("Dữ liệu đầu vào rỗng");
        }
        for (KhuyenMai km: list) {
            if (km.getMaKhuyenMai().equals(ma) && km.getMaKhuyenMai() != null) {
                return km.getId();
            }
        }
        return 0;
    }

    @Override
    public Double getDiscount(List<KhuyenMai> list, String ma) {
        if (list == null || ma == null) {
            throw new IllegalArgumentException("Dữ liệu đầu vào rỗng");
        }
        for (KhuyenMai km: list) {
            if (km.getMaKhuyenMai().equals(ma) && km.getMaKhuyenMai() != null) {
                return km.getPhanTram();
            }
        }
        return 0.00;
    }

    @Override
    public List<KhuyenMai> maKhuyenMais() {
        return khuyenMaiRepository.maKhuyenMai();
    }
    
//    @Override
//    public List<KhuyenMai> layPhanTram(String ma){
//        return khuyenMaiRepository.getPhanTram(ma);
//    } 
}
