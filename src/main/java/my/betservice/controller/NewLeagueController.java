package my.betservice.controller;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.LeagueInfoDto;
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

    @GetMapping(value = "/{id}")
    public LeagueInfoDto fetchNewLeagueToApp(@PathVariable Long id) {
        return leagueFacade.fetchNewLeagueToApp(id);
    }
}
