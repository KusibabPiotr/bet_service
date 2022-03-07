package my.betservice.scheduler;

import lombok.RequiredArgsConstructor;
import my.betservice.client.FootballClient;
import my.betservice.domain.fixture.FixtureInfo;
import my.betservice.mapper.fixture.FixtureInfoMapper;
import my.betservice.service.FixtureService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LeagueFixturesUpdateScheduler {
    private final FixtureService fixtureService;
    private final FootballClient footballClient;

    @Scheduled(cron = "0 0 23 * * *", zone = "CET")
    public void updateFixturesStatuses() {
        List<FixtureInfo> fixtureInfos = FixtureInfoMapper.mapToFixtureInfoList(footballClient.updatePremierLeagueFixturesStatus());
        fixtureService.updateFixturesStatuses(fixtureInfos);
    }
}
