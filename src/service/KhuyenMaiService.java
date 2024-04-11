package service;

import java.util.List;
import domainmodel.KhuyenMai;

public interface KhuyenMaiService {
    List<KhuyenMai> getAll();
    void add(KhuyenMai khuyenMai);
    KhuyenMai getById(int id);
    void update(KhuyenMai khuyenMai, int id);
    public void updateTrangThai();
    public List<KhuyenMai> getByMa(String ma);
    public List<KhuyenMai> getByTrangThai(int choice);
    int getKM(List<KhuyenMai> list, String ma);
    Double getDiscount(List<KhuyenMai> list, String ma);
    List<KhuyenMai> maKhuyenMais();
//    public List<KhuyenMai> layPhanTram(String ma);
}
