package my.betservice.facade;

import lombok.RequiredArgsConstructor;
import my.betservice.client.FootballClient;
import my.betservice.domain.fixture.FixtureInfo;
import my.betservice.dto.fixture.FixtureInfoDto;
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

    public FixtureInfoDto fetchNewFixtureToApp(final Long id,
                                               final Integer season) {
        FixtureInfo fixtureInfo =
                FixtureInfoMapper.mapToFixtureInfo(footballClient.getFixtureInfo(id, season));
        return FixtureInfoMapper.mapToFixtureInfoDto(
                fixtureService.saveNewFixtureInfo(fixtureInfo));
    }

    public List<FixtureInfoDto> getAvailableFixturesInfo() {
        return FixtureInfoMapper.mapToFixtureInfoDtoList(fixtureService.getAvailableFixturesInfo());
    }

    public FixtureInfoDto getFixtureInfoById(final Long id) {
        return FixtureInfoMapper.mapToFixtureInfoDto(
                fixtureService.getFixtureInfoById(id)
                .orElseThrow(FixtureNotFoundException::new));
    }
}
