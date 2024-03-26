package service;

import java.util.ArrayList;
import model.HoaDon;

public interface HoaDonService {
    ArrayList<HoaDon> getList();
    ArrayList<HoaDon> search(int id);
}
