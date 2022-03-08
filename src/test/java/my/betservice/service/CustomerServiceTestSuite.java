package my.betservice.service;

import my.betservice.domain.bet.BetCart;
import my.betservice.domain.user.Customer;
import my.betservice.exception.CustomerNotFoundException;
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
import java.util.List;

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
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

    @Nested
    class TestUpdateCustomerPersonalDetails {

//        @Test
//        void shouldThrowNullPointerException() {
//            Customer customer = Customer.builder()
//                    .personalDetails(new PersonalDetails())
//                    .build();
//            //given
//            given(customerRepository.findById(1L))
//                    .willReturn(ofNullable(customer));
//            //when $ then
//            assertThatThrownBy(() -> customerService.updateCustomerPersonalDetails(null,1L))
//                    .isInstanceOf(NullPointerException.class);
//        }
//        @Test
//        void shouldUpdateCustomerFromDbWithGivenDetails() {
//            PersonalDetails build = PersonalDetails.builder()
//                    .firstName("Marcin")
//                    .lastName("Kruk")
//                    .build();
//            Customer customer = Customer.builder()
//                    .personalDetails(build)
//                    .build();
//            Customer customerFromDb = Customer.builder()
//                    .id(1L)
//                    .personalDetails(new PersonalDetails())
//                    .build();
//            //given
//            given(customerRepository.findById(1L))
//                    .willReturn(ofNullable(customerFromDb));
//            //when
//            Customer updatedAndSaved = customerService.updateCustomerPersonalDetails(customer, 1L);
//            //then
//            assertThat(updatedAndSaved.getPersonalDetails().getFirstName())
//                    .isEqualTo("Marcin");
//            assertThat(updatedAndSaved.getPersonalDetails().getLastName())
//                    .isEqualTo("Kruk");
//        }
    }
    @Nested
    class TestGetCurrentLoggedInCustomer {
        @Test
        void shouldReturnCustomerFromDb() {
            //given
            AppUser appUser = AppUser.builder()
                    .username("kruku@gmail.com")
                    .enabled(true)
                    .password("password")
                    .build();
            Customer customer = Customer.builder()
                    .betCarts(List.of())
                    .moneyOnAccount(BigDecimal.TEN)
                    .appUser(appUser)
                    .build();
            given(appUserService.getCurrentLoggedInAppUser())
                    .willReturn(appUser);
            given(customerRepository.findByAppUser(appUser))
                    .willReturn(ofNullable(customer));
            //when
            Customer loggedInCustomer = customerService.getCurrentLoggedInCustomer();
            //then
            assertThat(loggedInCustomer.getAppUser().getUsername())
                    .isEqualTo("kruku@gmail.com");
            assertThat(loggedInCustomer.getMoneyOnAccount())
                    .isEqualTo(BigDecimal.TEN);
        }
        @Test
        void shouldThrowCustomerNotFoundException() {
            //given
            AppUser appUser = AppUser.builder()
                    .username("kruku@gmail.com")
                    .enabled(true)
                    .password("password")
                    .build();
            given(appUserService.getCurrentLoggedInAppUser())
                    .willReturn(appUser);
            given(customerRepository.findByAppUser(appUser))
                    .willThrow(new CustomerNotFoundException());
            //when & then
            assertThatThrownBy(() -> customerService.getCurrentLoggedInCustomer())
                    .isInstanceOf(CustomerNotFoundException.class);
        }
    }
    @Nested
    class TestCreateNewBetCart {
        @Test
        void shouldReturnBetCartConnectedWithGivenCustomer() {
            //given
            Customer customer = Customer.builder()
                    .betCarts(List.of())
                    .moneyOnAccount(BigDecimal.TEN)
                    .build();
            //when
            BetCart newBetCart = customerService.createNewBetCart(customer);
            //then
            assertThat(newBetCart.getCustomer().getMoneyOnAccount())
                    .isEqualTo(BigDecimal.TEN);
            assertThat(newBetCart.isFinished())
                    .isFalse();
        }
    }

}