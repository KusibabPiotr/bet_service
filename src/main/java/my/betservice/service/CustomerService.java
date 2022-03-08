package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.bet.BetCart;
import my.betservice.domain.user.Customer;
import my.betservice.domain.user.PersonalDetails;
import my.betservice.exception.CustomerNotFoundException;
import my.betservice.registration.domain.AppUser;
import my.betservice.registration.service.AppUserService;
import my.betservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AppUserService appUserService;
    @Value("${start_money_amount}")
    private BigDecimal startMoney;

    @Transactional
    public Customer createCustomer(final Customer customer) {
        AppUser appUser = appUserService.getCurrentLoggedInAppUser();
        appUser.setCustomer(customer);
        customer.setAppUser(appUser);
        customer.setMoneyOnAccount(startMoney);
        customer.getBetCarts().add(createNewBetCart(customer));
        return customerRepository.save(customer);
    }

    public Customer updateCustomerPersonalDetails(final PersonalDetails details) {
        Customer customer = getCurrentLoggedInCustomer();
        Long id = customer.getPersonalDetails().getId();
        customer.setPersonalDetails(details);
        customer.getPersonalDetails().setId(id);
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer getCurrentLoggedInCustomer() {
        AppUser appUser = appUserService.getCurrentLoggedInAppUser();
        return customerRepository.findByAppUser(appUser)
                .orElseThrow(CustomerNotFoundException::new);
    }

    public BetCart createNewBetCart(final Customer customer) {
        return BetCart.builder()
                .customer(customer)
                .betList(new ArrayList<>())
                .finished(false)
                .build();
    }
}
