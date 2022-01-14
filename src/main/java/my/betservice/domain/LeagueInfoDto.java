package my.betservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LeagueInfoDto {
    private Long id;
    private LeagueDto league;
    private CountryDto country;
    private List<SeasonDto> seasons = new ArrayList<>();
}
