package bokathon4th.core.repository;

import bokathon4th.core.domain.InitialGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InitialGameRepository extends JpaRepository<InitialGame, Long> {
    List<InitialGame> findByMiniGame_Id(Long miniGameId);
}
