/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceIMPL;

import domainmodel.HinhAnh;
import java.util.List;
import repository.HinhAnhRepository;

/**
 *
 * @author TLC
 */
public class HinhAnhService implements service.HinhAnhService{

    HinhAnhRepository hinhAnhRepository = new HinhAnhRepository();
    @Override
    public List<HinhAnh> getAll() {
        return hinhAnhRepository.getAll();
    }

    @Override
    public void add(HinhAnh ha) {
        hinhAnhRepository.add(ha);
    }

    @Override
    public void update(HinhAnh ha) {
        hinhAnhRepository.update(ha);
    }

    @Override
    public List<HinhAnh> getHA(int id) {
        return hinhAnhRepository.getAnh(id);
    }
    
}
