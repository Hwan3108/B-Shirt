package service;

import java.util.List;
import model.NhanVien;

public interface NhanVienService {
    List<NhanVien> getAll();
    
    String add(NhanVien nv);
    
    String update(NhanVien nv, int id);
}
