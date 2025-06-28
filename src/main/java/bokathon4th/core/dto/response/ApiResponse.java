package bokathon4th.core.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String code;
    private String message;
    private T data;

    public ApiResponse(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

}
