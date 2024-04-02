package service;

import java.util.ArrayList;
import model.KhachHang;

public interface KhachHangService {
    ArrayList<KhachHang> getList();
    String add(KhachHang kh);
    String update(KhachHang kh);
    ArrayList<KhachHang> search(int id);
    ArrayList<KhachHang> getGt(int Gt);
    ArrayList<KhachHang> getLayTT(int tt);
}
