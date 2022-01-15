package my.betservice.dto.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueInfoDto {
    private Long id;
    private LeagueDto league;
    private CountryDto country;
    private List<SeasonDto> seasons = new ArrayList<>();
}
