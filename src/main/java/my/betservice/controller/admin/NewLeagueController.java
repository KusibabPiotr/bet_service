package my.betservice.controller.admin;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.league.LeagueInfoDtoOut;
import my.betservice.exception.ClientFetchException;
import my.betservice.facade.LeagueFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/fetch/leagues")
@RequiredArgsConstructor
public class NewLeagueController {
    private final LeagueFacade leagueFacade;

    @GetMapping(value = "/{leagueId}")
    public LeagueInfoDtoOut fetchNewLeagueToApp(@PathVariable Long leagueId)
            throws ClientFetchException {
        return leagueFacade.fetchNewLeagueToApp(leagueId);
    }
}
