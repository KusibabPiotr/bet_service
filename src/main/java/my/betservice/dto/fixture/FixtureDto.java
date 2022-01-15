package my.betservice.dto.fixture;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import my.betservice.dto.league.LeagueDto;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureDto {
    private Long dbId;
    @JsonProperty("id")
    private Integer leagueId;
    private String referee;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    private VenueDto venue;
    private GameStatusDto status;
    private LeagueDto league;
    private TeamsDto teams;
    private GoalsResultDto goals;
    private PartitialScoreResultsDto score;
}
