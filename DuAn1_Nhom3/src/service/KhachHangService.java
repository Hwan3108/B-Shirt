package service;

import java.util.ArrayList;
import domainmodel.KhachHang;

public interface KhachHangService {
    ArrayList<KhachHang> getList();
    String add(KhachHang kh);
    String update(KhachHang kh);
    ArrayList<KhachHang> search(int id);
    ArrayList<KhachHang> listNam(ArrayList<KhachHang> list);
    int getKH(ArrayList<KhachHang> list, String sdt);
    String getTenKH(ArrayList<KhachHang> list, String sdt);
}
