package bokathon4th.core.controller;

import bokathon4th.core.dto.request.SearchGameRequest;
import bokathon4th.core.dto.response.ApiResponse;
import bokathon4th.core.dto.response.GameDetailResponse;
import bokathon4th.core.dto.response.MainResponse;
import bokathon4th.core.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private final MainService mainService;

    // 메인 화면: 추천 게임 + 버튼 + 배너
    @GetMapping
    public ResponseEntity<ApiResponse<MainResponse>> getMainPage() {
        try {
            MainResponse response = mainService.loadMainData();
            return ResponseEntity.ok(new ApiResponse<>(true, "S200", "메인 화면 데이터 로드 성공", response));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponse<>(false, "E500", "서버 내부 오류가 발생했습니다.", null));
        }
    }

    // 검색: 정확한 이름으로만 검색됨
    @PostMapping("/search")
    public ResponseEntity<ApiResponse<List<GameDetailResponse>>> searchGames(@RequestBody SearchGameRequest request) {
        List<GameDetailResponse> results = mainService.searchGamesByKeyword(request.getName());

        if (results.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse<>(false, "E404", "일치하는 게임이 없습니다.", results));
        }

        return ResponseEntity.ok(new ApiResponse<>(true, "S200", "게임 검색 성공", results));
    }
}
