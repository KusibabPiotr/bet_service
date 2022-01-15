package my.betservice.repository;

import my.betservice.domain.league.LeagueInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueInfoRepository extends JpaRepository<LeagueInfo, Long> {
}
