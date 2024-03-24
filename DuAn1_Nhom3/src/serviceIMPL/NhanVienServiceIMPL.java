/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceIMPL;

import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import repository.NhanVienRepository;
import service.NhanVienService;

/**
 *
 * @author Hwan
 */
public class NhanVienServiceIMPL implements NhanVienService{
    NhanVienRepository repo = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return repo.getAll();
    }

    @Override
    public String add(NhanVien nv) {
        if (nv.getHoTen().isEmpty()) {
            return "Không được để trống tên";
        } else if (nv.getMatKhau().isEmpty()) {
            return "Không được để trống mật khẩu";
        } else if (nv.getDiaChi().isEmpty()) {
            return "Không được để trống địa chỉ";
        } else if (nv.getSdt().isEmpty()) {
            return "Không được để trống SĐT";
        } else if (nv.getNgaySinh() == null) {
            return "Không được để trống ngày sinh";
        } else if (nv.getEmail().isEmpty()) {
            return "Không được để trống Email";
        } else if (nv.getCccd().isEmpty()) {
            return "Không được để trống Căn cước công dân";
        } else if(repo.add(nv)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(NhanVien nv, int id) {
        if (nv.getHoTen().isEmpty()) {
            return "Không được để trống tên";
        } else if (nv.getMatKhau().isEmpty()) {
            return "Không được để trống mật khẩu";
        } else if (nv.getDiaChi().isEmpty()) {
            return "Không được để trống địa chỉ";
        } else if (nv.getSdt().isEmpty()) {
            return "Không được để trống SĐT";
        } else if (nv.getNgaySinh() == null) {
            return "Không được để trống ngày sinh";
        } else if (nv.getEmail().isEmpty()) {
            return "Không được để trống Email";
        } else if (nv.getCccd().isEmpty()) {
            return "Không được để trống Căn cước công dân";
        } else if(repo.update(nv, id)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }
    
}
