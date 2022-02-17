package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.bet.BetCart;
import my.betservice.domain.user.Customer;
import my.betservice.exception.CustomerNotFoundException;
import my.betservice.registration.domain.AppUser;
import my.betservice.registration.service.AppUserService;
import my.betservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

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
        customer.getBetCarts().add(createNewBetCart(customer));
        return customerRepository.save(customer);
    }

    public Customer updateCustomerPersonalDetails(final Customer customer, final Long id) {
        Customer customerFromDb = customerRepository.findById(id)
                .orElseThrow(CustomerNotFoundException::new);
        customerFromDb.setPersonalDetails(customer.getPersonalDetails());
        return customerFromDb;
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
                .finished(false)
                .build();
    }
}
