package my.betservice.dto.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureCoverageDto {
    private Long id;
    private boolean events;
    @JsonProperty("lineups")
    private boolean lineUps;
    @JsonProperty("statistics_fixtures")
    private boolean statisticsFixtures;
    @JsonProperty("statistics_players")
    private boolean statisticsPlayers;
}
