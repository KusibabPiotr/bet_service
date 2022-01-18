package my.betservice.dto.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueInfoPackageDtoIn {
    @JsonProperty("response")
    private LeagueInfoDtoIn[] leagueInfoDtoIn = new LeagueInfoDtoIn[1];
}
