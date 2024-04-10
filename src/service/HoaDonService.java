package service;

import java.util.ArrayList;
import domainmodel.HoaDon;
import java.util.List;
import view.model.HoaDonViewModel;

public interface HoaDonService {
    ArrayList<HoaDon> getList();
    ArrayList<HoaDon> search(int id);
    void create(String ma);
    void cancel(int id);
    String khachLe(HoaDon hd, int id);
    String checkout(HoaDon hd, int id);
    String nullKM(HoaDon hd, int id);
    List<HoaDonViewModel> getBHView();
    List<HoaDonViewModel> locTrangThai(List<HoaDonViewModel> list, int index);
}
