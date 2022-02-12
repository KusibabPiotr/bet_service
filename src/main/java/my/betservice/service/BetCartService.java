package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.bet.BetCart;
import my.betservice.domain.user.Customer;
import my.betservice.dto.bet.BetCartDto;
import my.betservice.exception.BetCardNotFoundException;
import my.betservice.repository.BetCartRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BetCartService {
    private final BetCartRepository betCartRepository;
    private final CustomerService customerService;

    public List<BetCart> getAllUserBetCards() {
        return betCartRepository.findAllByCustomer(customerService.getCurrentLoggedInCustomer());
    }

    public BetCart getBetCardById(final Long id) {
        return betCartRepository.findById(id).orElseThrow(BetCardNotFoundException::new);
    }

    @Transactional
    public BetCart confirmBetCardTransaction(final BetCartDto processed) {
        addNewBetCartToCustomerCarts();
        BetCart betCart = getBetCardById(processed.getId());
        betCart.setOddsValue(processed.getOddsValue());
        betCart.setBetCost(processed.getBetCost());
        betCart.setToWin(processed.getToWin());
        betCart.setBetConfirmedTime(processed.getBetConfirmedTime());
        betCart.setLastMatchToPlay(processed.getLastMatchToPlay());
        betCart.setFinished(processed.isFinished());
        return betCart;
    }

    private void addNewBetCartToCustomerCarts() {
        Customer currentCustomer = customerService.getCurrentLoggedInCustomer();
        BetCart newBetCart = createNewBetCart(currentCustomer);
        newBetCart.setCustomer(currentCustomer);
        currentCustomer.getBetCarts().add(newBetCart);
    }

    public BetCart createNewBetCart(final Customer customer) {
        return BetCart.builder()
                .customer(customer)
                .finished(false)
                .build();
    }
}
