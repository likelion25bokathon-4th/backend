package bokathon4th.core.service;

import bokathon4th.core.domain.GameDetail;
import bokathon4th.core.dto.response.GameDetailResponse;
import bokathon4th.core.dto.response.GameRecommendResponse;
import bokathon4th.core.repository.GameDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameRecommendService {

    private final GameDetailRepository gameDetailRepository;

    // 인원 수 기반 추천
    public List<GameRecommendResponse> getRecommendedGames(int people) {
        List<GameDetail> games = gameDetailRepository
                .findPlayableGamesByPeople(people);

        return games.stream()
                .map(GameRecommendResponse::from)
                .toList();
    }
}
