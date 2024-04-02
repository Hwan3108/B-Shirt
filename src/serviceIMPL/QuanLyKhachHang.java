/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceIMPL;

import model.KhachHang;
import repository.KhachHangRepository;
import java.util.ArrayList;
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

    @Override
    public ArrayList<KhachHang> search(int id) {
        return hangRepository.search(id);
    }

    @Override
    public ArrayList<KhachHang> getGt(int Gt) {
          return hangRepository.searchGT(Gt);
    }

    @Override
    public ArrayList<KhachHang> getLayTT(int tt) {
        return hangRepository.searchLayTT(tt);
    }
    
    
}
