package my.betservice.repository;

import my.betservice.domain.fixture.FixtureInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FixtureInfoRepository extends JpaRepository<FixtureInfo, Long> {
    List<FixtureInfo> findByLeagueId(Integer leagueId);
    List<FixtureInfo> findByLeagueIdAndGameStatus(Integer leagueId, String gameStatus);
    Optional<FixtureInfo> findByFixtureId(Integer fixtureId);
}
