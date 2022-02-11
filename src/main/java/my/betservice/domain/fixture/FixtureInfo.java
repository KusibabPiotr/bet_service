package my.betservice.domain.fixture;

import lombok.*;
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
    private Integer fixtureId;
    private String referee;
    private String date;
    private Integer venueId;
    private String venueName;
    private String city;
    private String gameStatus;
    private Integer leagueId;
    private String leagueName;
    private String logo;
    @ManyToOne(
                cascade = {CascadeType.PERSIST,
                            CascadeType.MERGE})
    private Team homeTeam;
    @ManyToOne(
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private Team awayTeam;
    private Integer homeResult;
    private Integer awayResult;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HALFTIME_RESULT_ID")
    private GoalsResult halftime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FULLTIME_RESULT_ID")
    private GoalsResult fulltime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EXTRATIME_RESULT_ID")
    private GoalsResult extratime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PENALTY_RESULT_ID")
    private GoalsResult penalty;
}
