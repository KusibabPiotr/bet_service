package my.betservice.dto.league;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class 
LeagueInfoDtoOut {
    private Long id;
    private Integer leagueId;
    private String leagueName;
    private String leagueLogo;
    private String countryName;
    private String countryFlag;
}
