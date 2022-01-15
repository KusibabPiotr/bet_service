package my.betservice.repository;

import my.betservice.domain.fixture.FixtureInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixtureInfoRepository extends JpaRepository<FixtureInfo, Long> {
}
