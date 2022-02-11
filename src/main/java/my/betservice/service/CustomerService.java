package my.betservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.betservice.domain.user.Customer;
import my.betservice.registration.domain.AppUser;
import my.betservice.registration.service.AppUserService;
import my.betservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AppUserService appUserService;

    @Transactional
    public Customer createCustomer(final Customer customer) {
        AppUser appUser = appUserService.getCurrentLoggedInAppUser();
        appUser.setCustomer(customer);
        customer.setAppUser(appUser);
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer getCurrentLoggedInCustomer() {
        AppUser appUser = appUserService.getCurrentLoggedInAppUser();
        return customerRepository.findByAppUser(appUser);
    }
}
