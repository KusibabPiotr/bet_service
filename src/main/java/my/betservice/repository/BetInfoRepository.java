package my.betservice.repository;

import my.betservice.domain.bet.BetInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetInfoRepository extends JpaRepository<BetInfo, Long> {
}
