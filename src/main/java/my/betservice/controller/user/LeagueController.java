package my.betservice.controller.user;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.league.LeagueInfoDto;
import my.betservice.exception.LeagueNotFoundException;
import my.betservice.facade.LeagueFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/leagues")
@RequiredArgsConstructor
public class LeagueController {
    private final LeagueFacade leagueFacade;

    @GetMapping
    public List<LeagueInfoDto> getAvailableLeaguesInfo() {
        return leagueFacade.getAvailableLeaguesInfo();
    }

    @GetMapping(value = "/{id}")
    public LeagueInfoDto getLeagueInfoById(@PathVariable Long id)
    throws LeagueNotFoundException {
        return leagueFacade.getLeagueInfoById(id);
    }

}
