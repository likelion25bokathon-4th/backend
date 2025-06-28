package bokathon4th.core.service;

import bokathon4th.core.domain.InitialGame;
import bokathon4th.core.repository.InitialGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class InitialGameService {

    private final InitialGameRepository initialGameRepository;

    public String getRandomInitial(Long miniGameId) {
        List<InitialGame> list = initialGameRepository.findByMiniGame_Id(miniGameId);
        if (list.isEmpty()) throw new IllegalStateException("초성 데이터가 없습니다.");

        return list.get(new Random().nextInt(list.size())).getTwoInitialWords();
    }
}
