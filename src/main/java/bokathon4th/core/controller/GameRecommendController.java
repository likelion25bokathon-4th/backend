package bokathon4th.core.controller;


import bokathon4th.core.dto.response.ApiResponse;
import bokathon4th.core.dto.response.GameDetailResponse;
import bokathon4th.core.dto.response.GameRecommendResponse;
import bokathon4th.core.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recommend")
public class GameRecommendController {
    private final GameService gameService;

    // ✅ 1. 인원 수 기반 게임 추천 리스트
    @GetMapping
    public ResponseEntity<?> recommendGames(@RequestParam int people) {
        if (people < 1) {
            return ResponseEntity.badRequest().body(
                    new ApiResponse<>(false, "E400", "유효한 인원 수를 입력해주세요.", null));
        }

        List<GameRecommendResponse> games = gameService.getRecommendedGames(people);

        if (games.isEmpty()) {
            return ResponseEntity.status(404).body(
                    new ApiResponse<>(false, "E404", "추천할 수 있는 게임이 없습니다.", null));
        }

        return ResponseEntity.ok(
                new ApiResponse<>(true, "R200", "게임 추천 목록 조회 성공", games));
    }

    // ✅ 2. ID로 게임 상세 정보 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> getGameDetail(@PathVariable Long id) {
        GameDetailResponse detail = gameService.getGameDetail(id);

        if (detail == null) {
            return ResponseEntity.status(404).body(
                    new ApiResponse<>(false, "E404", "해당 게임 정보를 찾을 수 없습니다.", null));
        }

        return ResponseEntity.ok(
                new ApiResponse<>(true, "R200", "게임 상세 정보 조회 성공", detail));
    }
}
