package my.betservice.facade;

import lombok.RequiredArgsConstructor;
import my.betservice.client.FootballClient;
import my.betservice.domain.league.LeagueInfo;
import my.betservice.dto.league.LeagueInfoDto;
import my.betservice.exception.LeagueNotFoundException;
import my.betservice.mapper.league.LeagueInfoMapper;
import my.betservice.service.LeagueService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LeagueFacade {
    private final LeagueService leagueService;
    private final FootballClient footballClient;

    public LeagueInfoDto getLeagueInfoById(final Long id)
            throws LeagueNotFoundException {
        return LeagueInfoMapper.mapToLeagueInfoDto(
                leagueService.getLeagueInfoById(id)
                        .orElseThrow(LeagueNotFoundException::new));
    }

    public List<LeagueInfoDto> getAvailableLeaguesInfo() {
        return LeagueInfoMapper.mapToLeagueInfoDtoList(leagueService.getAvailableLeaguesInfo());
    }

    public LeagueInfoDto fetchNewLeagueToApp(final Long id) {
        LeagueInfo leagueInfo =
                LeagueInfoMapper.mapToLeagueInfo(footballClient.getLeagueInfo(id));
        return LeagueInfoMapper.mapToLeagueInfoDto(
                leagueService.saveNewLeagueInfo(leagueInfo));
    }
}
