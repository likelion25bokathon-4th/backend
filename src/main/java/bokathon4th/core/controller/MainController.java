package bokathon4th.core.controller;

import bokathon4th.core.dto.request.SearchGameRequest;
import bokathon4th.core.dto.response.ApiResponse;
import bokathon4th.core.dto.response.GameDetailResponse;
import bokathon4th.core.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MainController {
    private MainService mainService;

    //검색
    @GetMapping()
    public ResponseEntity<ApiResponse> searchGame(@RequestBody SearchGameRequest request){
        GameDetailResponse response = mainService.searchGame(request);
        return ResponseEntity.ok(new ApiResponse(true, "R200","검색 성공",response));
    }
}