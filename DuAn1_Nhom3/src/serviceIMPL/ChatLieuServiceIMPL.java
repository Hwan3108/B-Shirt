package serviceIMPL;

import java.util.List;
import model.ChatLieu;
import repository.ChatLieuRepository;
import service.ChatLieuService;

public class ChatLieuServiceIMPL implements ChatLieuService{
    ChatLieuRepository clRepo = new ChatLieuRepository();

    @Override
    public List<ChatLieu> getAll() {
        return clRepo.getAll();
    }
    
    @Override
    public void add(ChatLieu cl) {
        clRepo.add(cl);
    }

    @Override
    public void update(ChatLieu cl) {
       clRepo.update(cl);
    }

}
