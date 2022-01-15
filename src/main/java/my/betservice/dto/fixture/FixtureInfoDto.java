package my.betservice.dto.fixture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import my.betservice.dto.league.LeagueDto;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureInfoDto {
    private Long id;
    private FixtureDto fixture;
    private LeagueDto league;
    private TeamsDto teams;
    private GoalsResultDto goals;
    private PartitialScoreResultsDto score;
}
