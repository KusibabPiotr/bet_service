package my.betservice.repository;

import my.betservice.domain.bet.BetCart;
import my.betservice.domain.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BetCartRepository extends JpaRepository<BetCart, Long> {
    BetCart findByFinishedAndCustomer(boolean isFinished, Customer customer);
    List<BetCart> findAllByCustomer(Customer customer);
}
