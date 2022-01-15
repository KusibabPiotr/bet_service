package my.betservice;

import my.betservice.domain.LeagueInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueInfoRepository extends JpaRepository<LeagueInfo, Long> {
}
