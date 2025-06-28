package bokathon4th.core.controller;

import bokathon4th.core.dto.response.GameDetailResponse;
import bokathon4th.core.dto.response.ApiResponse;
import bokathon4th.core.service.GameDetailService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recommend")
public class GameDetailController {

    private final GameDetailService gameDetailService;

    @GetMapping("/{id}")
    public ApiResponse<GameDetailResponse> getGameDetail(@PathVariable Long id) {
        try {
            GameDetailResponse response = gameDetailService.getGameDetailById(id);
            return new ApiResponse<>(true, "R200", "게임 상세 정보 조회 성공", response);

        } catch (EntityNotFoundException e) {
            return new ApiResponse<>(false, "E404", e.getMessage(), null);

        } catch (Exception e) {
            return new ApiResponse<>(false, "E500", "서버 내부 오류가 발생했습니다.", null);
        }
    }
}
