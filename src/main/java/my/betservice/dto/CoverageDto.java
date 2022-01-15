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
public class CoverageDto {
    private Long id;
    private FixtureDto fixtures;
    private boolean standings;
    private boolean players;
    @JsonProperty("top_scorers")
    private boolean topScores;
    @JsonProperty("top_assists")
    private boolean topAssists;
    @JsonProperty("top_cards")
    private boolean topCards;
    private boolean injuries;
    private boolean predictions;
    private boolean odds;
}
