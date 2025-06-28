package bokathon4th.core.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InitialGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // 글자 ID

    @Column(nullable = false)
    private String twoInitialWords;  // 두 글자 초성 (예: "ㅅㄱ")
}
