package bokathon4th.core.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MainResponse {

    private String bannerMessage; // ex. 이달의 술게임 추천 🍻
    private List<Option> options;
    private List<RecommendedGame> recommendedGames;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Option {
        private String type;
        private String description;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class RecommendedGame {
        private Long id;
        private String name;
        private String imageUrl;
        private int difficulty;
        private int minPlayerCount;
        private int maxPlayerCount;
    }
}
