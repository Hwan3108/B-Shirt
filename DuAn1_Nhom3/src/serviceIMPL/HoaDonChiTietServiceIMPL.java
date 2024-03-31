package serviceIMPL;

import domainmodel.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import repository.HoaDonChiTietRepository;
import service.HoaDonChiTietService;
import view.model.GioHangViewModel;
import view.model.SPCTViewModel;

public class HoaDonChiTietServiceIMPL implements HoaDonChiTietService{

    HoaDonChiTietRepository repo = new HoaDonChiTietRepository();
    
    @Override
    public List<HoaDonChiTiet> getAll() {
        return repo.getAll();
    }

    @Override
    public List<GioHangViewModel> getGioHang(int index) {
        return repo.getGioHangView(index);
    }

    @Override
    public String add(HoaDonChiTiet hdct) {
        if(repo.add(hdct)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(HoaDonChiTiet hdct, int id) {
        if(repo.update(hdct, id)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public void delete(int idHD, int idSP) {
        repo.delete(idHD,idSP);
    }

    @Override
    public List<HoaDonChiTiet> searchGioHang(List<HoaDonChiTiet> list, int id) {
        List<HoaDonChiTiet> listSearch = new ArrayList<>();
        for (HoaDonChiTiet x: list) {
            if (x.getIdHoaDon() == id) {
                listSearch.add(x);
            }
        }
        return listSearch;
    }

    @Override
    public void buy(SPCTViewModel spctv, int idHD) {
        repo.buy(spctv, idHD);
    }

    @Override
    public String addMore(List<SPCTViewModel> listSPCT, int idSPCT, int soLuong, int idHD) {
        List<SPCTViewModel> list = new ArrayList<>();
        for (SPCTViewModel x: list) {
            if (x.getId() == idSPCT) {
                if(x.getSoLuong() < soLuong) {
                    return "Không đủ hàng để mua, vui lòng nhập số lượng nhỏ hơn " + x.getSoLuong();
                }
            }
        }
        if(soLuong <= 1) {
            return "Số lượng không được nhỏ hơn 1";
        } else if (repo.addMore(listSPCT, idSPCT, soLuong, idHD)) {
            return "Cập nhật sản phẩm trong giỏ hàng thành công";
        } else {
            return "Không thể cho sản phẩm vào giỏ hàng";
        }
    }

}
