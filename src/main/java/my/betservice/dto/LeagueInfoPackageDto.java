package my.betservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueInfoPackageDto {
    @JsonProperty("response")
    private LeagueInfoDto[] leagueInfoDto = new LeagueInfoDto[1];
}
