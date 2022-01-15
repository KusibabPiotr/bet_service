package my.betservice.domain.fixture;

import lombok.*;
import my.betservice.domain.league.League;

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
    @OneToOne(cascade = CascadeType.ALL)
    private League league;
    @OneToOne(cascade = CascadeType.ALL)
    private Teams teams;
    @OneToOne(cascade = CascadeType.ALL)
    private GoalsResult goals;
    @OneToOne(cascade = CascadeType.ALL)
    private PartitialScoreResults score;
}
