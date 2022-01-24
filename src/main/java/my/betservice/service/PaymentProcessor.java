package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.user.AppUser;
import my.betservice.exception.UserNotFoundException;
import my.betservice.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class PaymentProcessor {
    private final AppUserRepository appUserRepository;

    //insted of passing user id from from FETCH USER FROM SECURITY CONTEXT AND CHECK BALANCE<<
    public boolean checkIfUserHasEnoughMoney(final BigDecimal betCost, final Long userId)
            throws UserNotFoundException {
        AppUser appUser = fetchUser(userId);
        BigDecimal balanceAfterTransaction = appUser.getMoneyOnAccount().subtract(betCost);
        if (balanceAfterTransaction.compareTo(BigDecimal.ZERO) >= 0) {
            appUser.setMoneyOnAccount(balanceAfterTransaction);
            return true;
        } else {
            return false;
        }
    }

    private AppUser fetchUser(final Long userId)
            throws UserNotFoundException {
        return appUserRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }
}
