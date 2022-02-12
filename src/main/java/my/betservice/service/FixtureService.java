package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.fixture.FixtureInfo;
import my.betservice.exception.FixtureNotFoundException;
import my.betservice.repository.FixtureInfoRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FixtureService {
    private final FixtureInfoRepository fixtureInfoRepository;
    private static final String NOT_STARTED = "Not Started";

    public List<FixtureInfo> saveNewFixturesInfo(final List<FixtureInfo> fixtureInfo) {
        fixtureInfo.forEach(fixtureInfoRepository::save);
        return fixtureInfo;
    }

    @Transactional
    public void updateFixturesStatuses(final List<FixtureInfo> fixtureInfo) {
        fixtureInfo
                .forEach(e -> {
                    FixtureInfo fixtureFromDb = fixtureInfoRepository
                            .findByFixtureId(e.getFixtureId())
                            .orElseThrow(FixtureNotFoundException::new);
                    fixtureFromDb.setGameStatus(e.getGameStatus());
                    fixtureFromDb.setHomeResult(e.getHomeResult());
                    fixtureFromDb.setAwayResult(e.getAwayResult());
                    fixtureFromDb.setHalftime(e.getHalftime());
                    fixtureFromDb.setFulltime(e.getFulltime());
                    fixtureFromDb.setExtratime(e.getExtratime());
                    fixtureFromDb.setPenalty(e.getPenalty());
                    fixtureInfoRepository.save(fixtureFromDb);
                });
    }

    public FixtureInfo getFixtureInfoById(final Long id) {
        return fixtureInfoRepository.findById(id)
                .orElseThrow(FixtureNotFoundException::new);
    }

    public List<FixtureInfo> getAvailableFixturesInfoByLeagueId(final Integer leagueId,final Boolean allMatches) {
        List<FixtureInfo> matches;
        if (allMatches) matches = fixtureInfoRepository.findByLeagueId(leagueId);
        else matches = fixtureInfoRepository.findByLeagueIdAndGameStatus(leagueId, NOT_STARTED);
        return matches;
    }
}
