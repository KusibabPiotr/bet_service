package my.betservice.dto.fixture;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FixtureInfoDtoOut {
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
    private TeamDtoInOut homeTeam;
    private TeamDtoInOut awayTeam;
    private Integer homeResult;
    private Integer awayResult;
    private GoalsResultDtoInOut halftime;
    private GoalsResultDtoInOut fulltime;
    private GoalsResultDtoInOut extratime;
    private GoalsResultDtoInOut penalty;
}
