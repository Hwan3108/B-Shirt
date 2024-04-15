package service;

import domainmodel.KhachHang;
import java.util.ArrayList;


public interface KhachHangService {
    ArrayList<KhachHang> getList();
    String add(KhachHang kh);
    String update(KhachHang kh);
//    ArrayList<KhachHang> search(int id);
    ArrayList<KhachHang> getGt(int Gt);
    ArrayList<KhachHang> getLayTT(int tt);
    ArrayList<KhachHang> getSDT(String sdt);
    ArrayList<KhachHang> layTen();
    int getKH(ArrayList<KhachHang> list, String sdt);
    String getTenKH(ArrayList<KhachHang> list, String sdt);
    public ArrayList<KhachHang> searchKH(ArrayList<KhachHang> list, String maKH, String tenKH, String SDT, String email, String cccd);
 
}
