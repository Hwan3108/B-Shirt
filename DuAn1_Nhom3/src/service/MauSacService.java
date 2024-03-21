package service;

import java.util.List;
import model.MauSac;

public interface MauSacService {
    List<MauSac> getALL();
    void Add(MauSac ms);
    void Update(MauSac ms);
}
