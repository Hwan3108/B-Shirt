package service;

import java.util.List;
import model.MauSac;

public interface MauSacService {
    List<MauSac> getALL();
    void add(MauSac ms);
    void update(MauSac ms);
}
