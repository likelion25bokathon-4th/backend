package bokathon4th.core.service;

import bokathon4th.core.domain.MiniGame;
import bokathon4th.core.repository.MiniGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiniGameService {

    private final MiniGameRepository miniGameRepository;

    public List<MiniGame> getAllMiniGames() {
        return miniGameRepository.findAll();
    }
}
