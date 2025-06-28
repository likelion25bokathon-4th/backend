package bokathon4th.core.dto.response;

import bokathon4th.core.domain.GameDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameRecommendResponse {
    private Integer id;
    private String name;
    private int minPlayerCount;
    private int maxPlayerCount;
    private String imageUrl;

    public static GameRecommendResponse from(GameDetail game) {
        return new GameRecommendResponse(
                game.getId(),
                game.getName(),
                game.getMinPlayerCount(),
                game.getMaxPlayerCount(),
                game.getImageUrl()
        );
    }
}
