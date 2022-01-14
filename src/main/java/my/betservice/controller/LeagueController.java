package my.betservice.controller;

import lombok.RequiredArgsConstructor;
import my.betservice.client.FootballClient;
import my.betservice.domain.LeagueInfoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/leagues")
@RequiredArgsConstructor
public class LeagueController {

    private final FootballClient footballClient;

    @GetMapping
    public List<LeagueInfoDto> getAvailableLeagues() {
        return List.of();
    }

    @GetMapping(value = "/{id}")
    public LeagueInfoDto getLeague(@PathVariable Long id) {
        return new LeagueInfoDto();
    }

}
