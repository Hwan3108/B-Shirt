package service;

import java.util.List;
import model.HoaTiet;

public interface HoaTietService {
    List<HoaTiet> getAll();
    void add(HoaTiet ht);
    void update(HoaTiet ht);
}
