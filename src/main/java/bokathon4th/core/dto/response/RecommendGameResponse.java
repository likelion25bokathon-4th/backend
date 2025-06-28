package bokathon4th.core.dto.response;

import bokathon4th.core.domain.GameDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RecommendGameResponse {
    private Integer id;
    private String name;
    private int minPlayerCount;
    private int maxPlayerCount;
    private String imageUrl;

    public static RecommendGameResponse from(GameDetail game) {
        return new RecommendGameResponse(
                game.getId(),
                game.getName(),
                game.getMinPlayerCount(),
                game.getMaxPlayerCount(),
                game.getImageUrl()
        );
    }
}
