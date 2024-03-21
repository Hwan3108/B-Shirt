package service;

import java.util.List;
import model.ChatLieu;

public interface ChatLieuService {
    List<ChatLieu> getAll();
    void Add(ChatLieu cl);
    void Update(ChatLieu cl);
}
