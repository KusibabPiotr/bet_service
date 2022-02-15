package my.betservice.service;

import my.betservice.registration.service.AppUserService;
import my.betservice.repository.CustomerRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTestSuite {
    @InjectMocks
    private CustomerService customerService;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private AppUserService appUserService;

    @Nested
    class TestCreateCustomer {

    }

}