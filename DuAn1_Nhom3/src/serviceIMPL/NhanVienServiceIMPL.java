/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceIMPL;

import java.util.ArrayList;
import java.util.Calendar;
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
        Calendar calendar = Calendar.getInstance();
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
        } else if (nv.getSdt().length() != 10) {
            return "Độ dài số điện thoại không hợp lệ";
        } else if (nv.getMatKhau().length() < 3 || nv.getMatKhau().length() > 20) {
            return "Độ dài mật khẩu quy định từ 3 - 20 ký tự";
        } else if (!nv.getEmail().contains("@")) {
            return "Email không hợp lệ";
        }else if(repo.add(nv)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(NhanVien nv, int id) {
        if (nv.getHoTen().isEmpty()) {
            return "Không được để trống tên";
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
