package bokathon4th.core.dto.request;

import bokathon4th.core.domain.GameDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchGameRequest {
    private String name;

    public GameDetail toEntity(){
        return GameDetail.builder()
                .name(name)
                .build();

    }
}
