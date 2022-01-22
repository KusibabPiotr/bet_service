package my.betservice.dto.odd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OddInfoDtoOut {
    private Integer leagueId;
    private String leagueName;
    private String leagueLogo;
    private Integer fixtureId;
    private LocalDateTime date;
    private String bookmakerName;
    private String betName;
    private BetValueDtoInOut home;
    private BetValueDtoInOut draw;
    private BetValueDtoInOut away;
}
