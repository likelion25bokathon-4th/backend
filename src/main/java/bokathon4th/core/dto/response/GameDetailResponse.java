package bokathon4th.core.dto.response;

import bokathon4th.core.domain.GameDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GameDetailResponse {

    private final Long id;
    private final String name;
    private final int minPlayerCount;
    private final int maxPlayerCount;
    private final String description;
    private final String intro;
    private final String gameRule;
    private final int difficulty;
    private final String imageUrl;

    public static GameDetailResponse of(GameDetail gameDetail) {
        return GameDetailResponse.builder()
                .id(gameDetail.getId())
                .name(gameDetail.getName())
                .minPlayerCount(gameDetail.getMinPlayerCount())
                .maxPlayerCount(gameDetail.getMaxPlayerCount())
                .description(gameDetail.getDescription())
                .intro(gameDetail.getIntro())
                .gameRule(gameDetail.getGameRule())
                .difficulty(gameDetail.getDifficulty())
                .imageUrl(gameDetail.getImageUrl())
                .build();
    }
}
