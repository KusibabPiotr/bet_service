package my.betservice.service;

import my.betservice.domain.user.Customer;
import my.betservice.registration.AppUserRole;
import my.betservice.registration.domain.AppUser;
import my.betservice.registration.service.AppUserService;
import my.betservice.repository.CustomerRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        @Test
        void shouldJoinAppUserWithCustomerAndSaveAndReturnCreatedCustomer() {
            //given
            AppUser appUser = AppUser.builder()
                    .enabled(true)
                    .username("kruk@kruk.pl")
                    .password("password")
                    .appUserRole(AppUserRole.USER)
                    .build();
            Customer customer = Customer.builder()
                    .betCarts(new ArrayList<>())
                    .moneyOnAccount(BigDecimal.TEN)
                    .build();
            given(appUserService.getCurrentLoggedInAppUser())
                    .willReturn(appUser);
            given(customerRepository.save(customer))
                    .willReturn(customer);
            //when
            Customer savedCustomer = customerService.createCustomer(customer);
            //then
            assertThat(savedCustomer.getAppUser().getUsername())
                    .isEqualTo("kruk@kruk.pl");
            verify(customerRepository,times(1)).save(customer);
        }

        @Test
        void shouldThrowNullPointerException() {
            //given
            Customer customer = null;
            AppUser appUser = AppUser.builder()
                    .enabled(true)
                    .username("kruk@kruk.pl")
                    .password("password")
                    .appUserRole(AppUserRole.USER)
                    .build();
            given(appUserService.getCurrentLoggedInAppUser())
                    .willReturn(appUser);
            //when & then
            assertThatThrownBy(() -> customerService.createCustomer(customer))
                    .isInstanceOf(NullPointerException.class);
        }
    }

}