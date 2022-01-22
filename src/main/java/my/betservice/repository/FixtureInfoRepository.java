package my.betservice.repository;

import my.betservice.domain.fixture.FixtureInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FixtureInfoRepository extends JpaRepository<FixtureInfo, Long> {
    List<FixtureInfo> findByLeagueId(Integer leagueId);
    List<FixtureInfo> findByLeagueIdAndGameStatus(Integer leagueId, String gameStatus);
}
