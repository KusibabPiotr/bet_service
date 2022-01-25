package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.user.Customer;
import my.betservice.exception.UserNotFoundException;
import my.betservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class PaymentProcessor {
    private final CustomerRepository customerRepository;

    //insted of passing user id from from FETCH USER FROM SECURITY CONTEXT AND CHECK BALANCE<<
    public boolean checkIfUserHasEnoughMoney(final BigDecimal betCost, final Long userId)
            throws UserNotFoundException {
        Customer customer = fetchUser(userId);
        BigDecimal balanceAfterTransaction = customer.getMoneyOnAccount().subtract(betCost);
        if (balanceAfterTransaction.compareTo(BigDecimal.ZERO) >= 0) {
            customer.setMoneyOnAccount(balanceAfterTransaction);
            return true;
        } else {
            return false;
        }
    }

    private Customer fetchUser(final Long userId)
            throws UserNotFoundException {
        return customerRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }
}
