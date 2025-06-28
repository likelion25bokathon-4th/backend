package bokathon4th.core.service;

import bokathon4th.core.domain.GameDetail;
import bokathon4th.core.dto.response.GameDetailResponse;
import bokathon4th.core.dto.response.MainResponse;
import bokathon4th.core.repository.GameDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static bokathon4th.core.dto.response.MainResponse.*;

@Service
@RequiredArgsConstructor
public class MainService {

    private final GameDetailRepository gameDetailRepository;

    public MainResponse loadMainData() {
        List<Option> options = List.of(
                new Option("추천게임", "추천 게임 보기"),
                new Option("미니게임", "미니게임")
        );

        List<RecommendedGame> recommendedGames = gameDetailRepository.findRandom5()
                .stream()
                .map(game -> RecommendedGame.builder()
                        .id(game.getId())
                        .name(game.getName())
                        .imageUrl(game.getImageUrl())
                        .difficulty(game.getDifficulty())
                        .minPlayerCount(game.getMinPlayerCount())
                        .maxPlayerCount(game.getMaxPlayerCount())
                        .build())
                .collect(Collectors.toList());

        return MainResponse.builder()
                .bannerMessage("이달의 술게임 추천 🍻")
                .options(options)
                .recommendedGames(recommendedGames)
                .build();
    }

    public List<GameDetailResponse> searchGamesByKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return List.of();
        }

        // 공백 제거 및 소문자 처리
        String cleanedKeyword = keyword.replaceAll("\\s+", "").toLowerCase();

        return gameDetailRepository.findAll().stream()
                .filter(game -> game.getName().replaceAll("\\s+", "").toLowerCase().equals(cleanedKeyword))
                .map(GameDetailResponse::of)
                .collect(Collectors.toList());
    }

}
