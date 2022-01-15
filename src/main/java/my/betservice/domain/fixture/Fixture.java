package my.betservice.domain.fixture;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "FIXTURES")
public class Fixture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer fixtureId;
    private String referee;
    private LocalDateTime date;
    @OneToOne(cascade = CascadeType.ALL)
    private Venue venue;
    @OneToOne(cascade = CascadeType.ALL)
    private GameStatus status;
}
