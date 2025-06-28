package bokathon4th.core.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MiniGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // 미니게임 ID

    @Column(nullable = false)
    private String name;  // 미니게임 이름

    @Column(nullable = false)
    private String url;  // 이미지 URL
}