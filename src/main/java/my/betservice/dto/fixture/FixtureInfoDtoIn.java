package my.betservice.dto.fixture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import my.betservice.dto.league.LeagueDtoIn;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureInfoDtoIn {
    private FixtureDtoIn fixture;
    private LeagueDtoIn league;
    private TeamsDtoIn teams;
    private GoalsResultDtoInOut goals;
    private PartitialScoreResultsDtoIn score;
}
