package bokathon4th.core.repository;

import bokathon4th.core.domain.GameDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GameDetailRepository extends JpaRepository<GameDetail, Long> {

    @Query("SELECT g FROM GameDetail g WHERE :people BETWEEN g.minPlayerCount AND g.maxPlayerCount")
    List<GameDetail> findPlayableGamesByPeople(@Param("people") int people);

    Optional<GameDetail> findByName(String name);

    @Query(value = "SELECT * FROM GAME_DETAIL ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<GameDetail> findRandom5();

}
