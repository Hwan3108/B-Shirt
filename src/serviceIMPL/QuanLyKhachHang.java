/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceIMPL;

import domainmodel.KhachHang;
import repository.KhachHangRepository;
import java.util.ArrayList;
import service.KhachHangService;

/**
 *
 * @author TLC
 */
public class QuanLyKhachHang implements KhachHangService {

    KhachHangRepository hangRepository = new KhachHangRepository();

    @Override
    public ArrayList<KhachHang> getList() {
        return hangRepository.getAll();
    }

    @Override
    public String add(KhachHang kh) {
        if (hangRepository.add(kh) == true) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    @Override
    public String update(KhachHang kh) {
        if (hangRepository.update(kh) == true) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

//    @Override
//    public ArrayList<KhachHang> search(int id) {
//        return hangRepository.search(id);
//    }
    @Override
    public ArrayList<KhachHang> getGt(int Gt) {
        return hangRepository.searchGT(Gt);
    }

    @Override
    public ArrayList<KhachHang> getLayTT(int tt) {
        return hangRepository.searchLayTT(tt);
    }

    @Override
    public int getKH(ArrayList<KhachHang> list, String sdt) {
        if (list == null || sdt == null) {
            throw new IllegalArgumentException("Dữ liệu đầu vào rỗng");
        }
        for (KhachHang kh : list) {
            if (kh.getSDT().equals(sdt)) {
                return kh.getId();
            }
        }
        return 0;
    }

    @Override
    public String getTenKH(ArrayList<KhachHang> list, String sdt) {
        if (list == null || sdt == null) {
            throw new IllegalArgumentException("Dữ liệu đầu vào rỗng");
        }
        for (KhachHang kh : list) {
            if (kh.getSDT().equals(sdt)) {
                return kh.getTen();
            }
        }
        return null;
    }
    
    @Override
    public ArrayList<KhachHang> searchKH(ArrayList<KhachHang> list, String maKH, String tenKH, String SDT, String email, String cccd) {
        ArrayList<KhachHang> listSearch = new ArrayList<>();
        for (KhachHang khachHang : list) {
            if (khachHang.getMaKH().equals(maKH) || khachHang.getTen().equals(tenKH) || khachHang.getSDT().equals(SDT) || khachHang.getEmail().equals(email) || khachHang.getCccd().equals(cccd)) {
                listSearch.add(khachHang);
            }
        }
        return listSearch;
    }

    @Override
    public ArrayList<KhachHang> getSDT(String ten) {
        return hangRepository.laySDT(ten);
    }

    @Override
    public ArrayList<KhachHang> layTen() {
        return hangRepository.layTen();
    }

}
