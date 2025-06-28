package bokathon4th.core.service;

import bokathon4th.core.domain.GameDetail;
import bokathon4th.core.dto.response.GameDetailResponse;
import bokathon4th.core.repository.GameDetailRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameDetailService {

    private final GameDetailRepository gameDetailRepository;

    public GameDetailResponse getGameDetailById(Long id) {
        GameDetail game = gameDetailRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 게임 정보를 찾을 수 없습니다. ID: " + id));
        return GameDetailResponse.of(game);
    }
}
