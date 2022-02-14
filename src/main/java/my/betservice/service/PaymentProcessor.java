package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.user.Customer;
import my.betservice.registration.domain.AppUser;
import my.betservice.registration.service.AppUserService;
import my.betservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class PaymentProcessor {
    private final CustomerRepository customerRepository;
    private final AppUserService appUserService;

    public boolean checkIfUserHasEnoughMoney(final BigDecimal betCost) {
        boolean result = false;
        AppUser appUser = appUserService.getCurrentLoggedInAppUser();
        Customer customer = customerRepository.findByAppUser(appUser);
        BigDecimal balanceAfterTransaction = customer.getMoneyOnAccount().subtract(betCost);
        if (balanceAfterTransaction.compareTo(BigDecimal.ZERO) >= 0) {
            customer.setMoneyOnAccount(balanceAfterTransaction);
            result = true;
        }
        return result;
    }
}
