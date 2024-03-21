/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.NhanVien;

/**
 *
 * @author Hwan
 */
public interface NhanVienService {
    List<NhanVien> getAll();
    
    String add(NhanVien nv);
    
    String update(NhanVien nv, String id);
}
