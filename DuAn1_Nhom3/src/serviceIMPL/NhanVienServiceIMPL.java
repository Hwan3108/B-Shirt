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
    List<NhanVien> list = repo.getAll();
    @Override
    public List<NhanVien> getAll() {
        return repo.getAll();
    }

    @Override
    public String add(NhanVien nv) {
        for (NhanVien vd: list) {
            if(vd.getSdt().equals(nv.getSdt())) {
                return "Số điện thoại đã tồn tại";
            } else if (vd.getEmail().equals(nv.getEmail())) {
                return "Email đã tồn tại";
            } else if (vd.getCccd().equals(nv.getCccd())) {
                return "CCCD đã tồn tại";
            }
        }
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
        for (NhanVien vd: list) {
            if(vd.getSdt().equals(nv.getSdt())) {
                return "Số điện thoại đã tồn tại";
            } else if (vd.getEmail().equals(nv.getEmail())) {
                return "Email đã tồn tại";
            } else if (vd.getCccd().equals(nv.getCccd())) {
                return "CCCD đã tồn tại";
            }
        }
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
        } else if (nv.getSdt().length() != 10) {
            return "Độ dài số điện thoại không hợp lệ";
        } else if (nv.getMatKhau().length() < 3 || nv.getMatKhau().length() > 20) {
            return "Độ dài mật khẩu quy định từ 3 - 20 ký tự";
        } else if (!nv.getEmail().contains("@")) {
            return "Email không hợp lệ";
        }else if(repo.update(nv, id)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }
    
}
