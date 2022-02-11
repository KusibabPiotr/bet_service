package my.betservice.repository;

import my.betservice.domain.bet.BetCard;
import my.betservice.domain.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BetCardRepository extends JpaRepository<BetCard, Long> {
    BetCard findByFinishedAndCustomer(boolean isFinished, Customer customer);
    List<BetCard> findAllByCustomer(Customer customer);
}
