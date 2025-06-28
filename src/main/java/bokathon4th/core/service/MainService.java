package bokathon4th.core.service;

import bokathon4th.core.domain.GameDetail;
import bokathon4th.core.dto.request.SearchGameRequest;
import bokathon4th.core.dto.response.GameDetailResponse;
import bokathon4th.core.repository.GameDetailRepository;
import bokathon4th.core.repository.MiniGameRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {
    private final GameDetailRepository gameDetailRepository;
    private final MiniGameRepository miniGameRepository;

    //검색

    public GameDetailResponse searchGame(SearchGameRequest request){
        GameDetail gameDetail=gameDetailRepository.findByName(request.getName())
                .orElseThrow(()->new EntityNotFoundException("검색 결과가 없습니다."));

        return GameDetailResponse.of(gameDetail);

    }

//추천 or 미니게임 선택
