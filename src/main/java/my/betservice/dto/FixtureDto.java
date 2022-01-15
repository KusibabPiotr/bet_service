package my.betservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureDto {
    private Long id;
    private boolean events;
    @JsonProperty("lineups")
    private boolean lineUps;
    @JsonProperty("statistics_fixtures")
    private boolean statisticsFixtures;
    @JsonProperty("statistics_players")
    private boolean statisticsPlayers;
}
