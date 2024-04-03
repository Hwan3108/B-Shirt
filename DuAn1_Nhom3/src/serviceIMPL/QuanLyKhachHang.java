/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceIMPL;

import domainmodel.KhachHang;
import repository.KhachHangRepository;
import java.util.ArrayList;
import java.util.List;
import service.KhachHangService;

/**
 *
 * @author TLC
 */
public class QuanLyKhachHang implements KhachHangService{

    KhachHangRepository hangRepository = new KhachHangRepository();

    @Override
    public ArrayList<KhachHang> getList() {
        return hangRepository.getAll();
    }

    @Override
    public String add(KhachHang kh) {
        if (hangRepository.add(kh) == true) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KhachHang kh) {
        if (hangRepository.update(kh) == true) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public ArrayList<KhachHang> search(int id) {
        return hangRepository.search(id);
    }

    @Override
    public ArrayList<KhachHang> listNam(ArrayList<KhachHang> list) {
        ArrayList<KhachHang> listNam = new ArrayList<>();
        for (KhachHang kh : listNam ) {
            if (kh.isGioiTinh() == true) {
                listNam.add(kh);
            } 
        }
        return listNam ;
    }

    @Override
    public int getKH(ArrayList<KhachHang> list, String sdt) {
        if(list == null || sdt == null) {
            throw new IllegalArgumentException("Dữ liệu đầu vào rỗng");
        }
        for (KhachHang kh: list) {
            if (kh.getSDT().equals(sdt)) {
                return kh.getId();
            }
        }
        return 0;
    }

    @Override
    public String getTenKH(ArrayList<KhachHang> list, String sdt) {
        if(list == null || sdt == null) {
            throw new IllegalArgumentException("Dữ liệu đầu vào rỗng");
        }
        for (KhachHang kh: list) {
            if (kh.getSDT().equals(sdt)) {
                return kh.getTen();
            }
        }
        return null;
    }
}
