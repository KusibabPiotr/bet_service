package my.betservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueInfoDto {
    private Long id;
    private LeagueDto league;
    private CountryDto country;
    private List<SeasonDto> seasons = new ArrayList<>();
}
