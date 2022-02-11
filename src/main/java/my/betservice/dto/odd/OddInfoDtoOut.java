package my.betservice.dto.odd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OddInfoDtoOut {
    private Integer leagueId;
    private String leagueName;
    private String leagueLogo;
    private Integer fixtureId;
    private String date;
    private String bookmakerName;
    private String betName;
    private BetValueDtoInOut home;
    private BetValueDtoInOut draw;
    private BetValueDtoInOut away;
}
