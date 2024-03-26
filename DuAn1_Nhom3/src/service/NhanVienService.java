package service;

import java.util.List;
import model.NhanVien;

public interface NhanVienService {
    List<NhanVien> getAll();
    
    String add(NhanVien nv);
    
    String update(NhanVien nv, int id);
    
    List<NhanVien> searchNV(List<NhanVien> listNV, String hoTen, String sdt, String cccd, String email);
    
    List<NhanVien> searchChucVu(List<NhanVien> listNV, String chucVu);
    
    List<NhanVien> searchTrangThai(List<NhanVien> listNV, String trangThai);
}
