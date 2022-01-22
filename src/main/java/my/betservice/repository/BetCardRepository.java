package my.betservice.repository;

import my.betservice.domain.bet.BetCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetCardRepository extends JpaRepository<BetCard, Long> {
    BetCard findByFinished(boolean finished);
}
