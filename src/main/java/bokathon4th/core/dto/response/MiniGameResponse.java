package bokathon4th.core.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MiniGameResponse {
    private Integer id;
    private String name;
    private String url;
}
