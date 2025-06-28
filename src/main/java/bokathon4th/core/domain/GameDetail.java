package bokathon4th.core.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;

@Entity
@Getter
@Setter
@Check(constraints = "difficulty >= 1 AND difficulty <= 5")
public class GameDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 게임 아이디 (Primary Key)

    @Column(nullable = false)
    private String name;  // 게임 이름

    @Column(nullable = false)
    private Integer realSuggestNumPlayer;  // 가장 적정 인원

    @Column(nullable = false)
    private Integer minPlayerCount;  // 적정 인원 최소

    @Column(nullable = false)
    private Integer maxPlayerCount;  // 적정 인원 최대

    @Column(nullable = false, length = 100)
    private String description;  // 한 줄 게임 설명

    @Column(nullable = false, length = 100)
    private String intro;  // 인트로

    @Column(nullable = false, columnDefinition = "TEXT")
    private String gameRule;  // 게임 규칙

    @Column(nullable = false)
    private Integer difficulty;  // 난이도

    @Column(nullable = false)
    private String imageUrl;  // 이미지 URL
}
