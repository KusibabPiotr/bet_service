package my.betservice.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.betservice.client.FootballClient;
import my.betservice.domain.LeagueInfo;
import my.betservice.dto.LeagueInfoDto;
import my.betservice.exception.LeagueNotFoundException;
import my.betservice.mapper.LeagueInfoMapper;
import my.betservice.service.LeagueService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LeagueFacade {
    private final LeagueService leagueService;
    private final FootballClient footballClient;

    public LeagueInfoDto getLeagueInfo(final Long id)
            throws LeagueNotFoundException {
        return LeagueInfoMapper.mapToLeagueInfoDto(
                leagueService.getLeagueInfo(id)
                        .orElseThrow(LeagueNotFoundException::new));
    }

    public List<LeagueInfoDto> getAvailableLeaguesInfo() {
        return LeagueInfoMapper.mapToLeagueInfoDtoList(leagueService.getAvailableLeaguesInfo());
    }

    public LeagueInfoDto fetchNewLeagueToApp(final Long id) {
        LeagueInfo leagueInfo = LeagueInfoMapper.mapToLeagueInfo(footballClient.getLeagueInfo(id));
        return LeagueInfoMapper.mapToLeagueInfoDto(leagueService.saveNewLeagueInfo(leagueInfo));
    }
}
