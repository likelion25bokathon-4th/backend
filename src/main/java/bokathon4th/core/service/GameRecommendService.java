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

    public List<GameRecommendResponse> getRecommendedGames(Integer people) {
        List<GameDetail> games;

        if (people == null) {
            games = gameDetailRepository.findAll();
        } else {
            games = gameDetailRepository.findPlayableGamesByPeople(people);
        }

        return games.stream()
                .map(GameRecommendResponse::from)
                .toList();
    }
}
