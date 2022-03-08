package my.betservice.client;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FootballClientInfo {
    @Value("${bet_win_match}")
    private final Integer betWinMatch = 1;
    @Value("${bet365_bookmaker_id}")
    private final Integer bookmakerBet365 = 7;
    @Value("${football.api.key}")
    private String apiKeyValue;
    @Value("${football.api.endpoint}")
    private String apiEndpointValue;
    @Value("${football.api.host}")
    private String apiHostValue;
    @Value("${premier_league_id}")
    private Long premierLeagueId;
    @Value("${actual_season}")
    private Integer actualSeason;
}
