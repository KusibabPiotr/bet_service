package my.betservice.domain.fixture;

import lombok.*;
import my.betservice.domain.league.League;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "FIXTURES_INFO")
public class FixtureInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Fixture fixture;
    @OneToOne(cascade = CascadeType.ALL)
    private League league;
    @OneToOne(cascade = CascadeType.ALL)
    private Teams teams;
    @OneToOne(cascade = CascadeType.ALL)
    private GoalsResult goals;
    @OneToOne(cascade = CascadeType.ALL)
    private PartitialScoreResults score;
}
