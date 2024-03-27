package service;

import java.util.List;
import domainmodel.ChatLieu;

public interface ChatLieuService {
    List<ChatLieu> getAll();
    void add(ChatLieu cl);
    void update(ChatLieu cl);
}
