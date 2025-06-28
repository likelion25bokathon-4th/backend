package bokathon4th.core.repository;

import bokathon4th.core.domain.MiniGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniGameRepository extends JpaRepository<MiniGame, Integer> {
}
