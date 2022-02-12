package my.betservice.facade;

import lombok.RequiredArgsConstructor;
import my.betservice.client.FootballClient;
import my.betservice.domain.league.LeagueInfo;
import my.betservice.dto.league.LeagueInfoDtoOut;
import my.betservice.exception.ClientFetchException;
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

    public LeagueInfoDtoOut getLeagueInfoById(final Long leagueId)
            throws LeagueNotFoundException {
        return LeagueInfoMapper.mapToLeagueInfoDto(
                leagueService.getLeagueInfoById(leagueId));
    }

    public List<LeagueInfoDtoOut> getAvailableLeaguesInfo() {
        return LeagueInfoMapper.mapToLeagueInfoDtoList(leagueService.getAvailableLeaguesInfo());
    }

    public LeagueInfoDtoOut fetchNewLeagueToApp(final Long leagueId)
            throws ClientFetchException {
        LeagueInfo leagueInfo =
                LeagueInfoMapper.mapToLeagueInfo(footballClient.getLeagueInfo(leagueId));
        return LeagueInfoMapper.mapToLeagueInfoDto(
                leagueService.saveNewLeagueInfo(leagueInfo));
    }
}
