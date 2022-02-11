package my.betservice.facade;

import lombok.RequiredArgsConstructor;
import my.betservice.client.FootballClient;
import my.betservice.domain.fixture.FixtureInfo;
import my.betservice.dto.fixture.FixtureInfoDtoOut;
import my.betservice.exception.FixtureNotFoundException;
import my.betservice.mapper.fixture.FixtureInfoMapper;
import my.betservice.service.FixtureService;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FixtureFacade {
    private final FixtureService fixtureService;
    private final FootballClient footballClient;

    public List<FixtureInfoDtoOut> fetchNewFixturesToApp(final Long id,
                                                         final Integer season) {
        List<FixtureInfo> fixtureInfoList =
                FixtureInfoMapper.mapToFixtureInfoList(footballClient.getFixtureInfo(id, season));
        return FixtureInfoMapper.mapToFixtureInfoDtoList(
                fixtureService.saveNewFixturesInfo(fixtureInfoList));
    }

    public FixtureInfoDtoOut getFixtureInfoById(final Long id) {
        return FixtureInfoMapper.mapToFixtureDtoOutput(
                fixtureService.getFixtureInfoById(id)
                .orElseThrow(FixtureNotFoundException::new));
    }

    public List<FixtureInfoDtoOut> getAvailableFixturesInfoByLeagueId(Integer leagueId, Boolean allMatches) {
        return FixtureInfoMapper.mapToFixtureInfoDtoList(fixtureService.getAvailableFixturesInfoByLeagueId(leagueId, allMatches));
    }
}
