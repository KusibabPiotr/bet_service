package my.betservice.service;

import my.betservice.domain.bet.BetCart;
import my.betservice.domain.bet.BetInfo;
import my.betservice.domain.user.Customer;
import my.betservice.exception.BetCardNotFoundException;
import my.betservice.registration.domain.AppUser;
import my.betservice.repository.BetCartRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BetCartServiceTest {
    @InjectMocks
    private BetCartService betCartService;
    @Mock
    private BetCartRepository betCartRepository;
    @Mock
    private CustomerService customerService;

    @Nested
    class GetAllUserBetCarts {
        @Test
        void returnEmptyList() {
            //given
            Customer customer = Customer.builder()
                    .appUser(new AppUser())
                    .betCarts(List.of())
                    .build();
            when(customerService.getCurrentLoggedInCustomer()).thenReturn(customer);
            when(betCartRepository.findAllByCustomer(customer)).thenReturn(List.of());
            //when
            List<BetCart> list = betCartService.getAllUserBetCards();
            //then
            assertThat(list).isEmpty();
        }

        @Test
        void returnTwoElementList() {
            //given
            Customer customer = Customer.builder()
                    .appUser(new AppUser())
                    .betCarts(List.of())
                    .build();
            BetCart cart = BetCart.builder()
                    .customer(customer)
                    .finished(false)
                    .build();
            BetCart cart2 = BetCart.builder()
                    .customer(customer)
                    .finished(true)
                    .build();
            when(customerService.getCurrentLoggedInCustomer()).thenReturn(customer);
            when(betCartRepository.findAllByCustomer(customer)).thenReturn(List.of(cart, cart2));
            //when
            List<BetCart> list = betCartService.getAllUserBetCards();
            //then
            assertThat(list.size()).isEqualTo(2);
        }
    }

    @Nested
    class GetBetCartById {
        @Test
        void shouldThrowBetCardNotFoundException () {
            //given
            long id = 1L;
            when(betCartRepository.findById(id)).thenThrow(new BetCardNotFoundException());
            //when & then
            assertThatThrownBy(() -> betCartService.getBetCardById(id))
                    .isInstanceOf(BetCardNotFoundException.class);
        }

        @Test
        void shouldThrowIllegalArgumentException () {
            //given
            Long id = null;
            when(betCartRepository.findById(id)).thenThrow(new IllegalArgumentException());
            //when & then
            assertThatThrownBy(() -> betCartService.getBetCardById(id))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void shouldReturnSavedBetCart() {
            //given
            BetCart cart = BetCart.builder()
                    .id(1L)
                    .finished(true)
                    .toWin(BigDecimal.TEN)
                    .build();
            when(betCartRepository.findById(1L)).thenReturn(Optional.ofNullable(cart));
            //when
            BetCart betCart = betCartService.getBetCardById(1L);
            //then
            assertThat(betCart.getId()).isEqualTo(1L);
            assertThat(betCart.isFinished()).isTrue();
            assertThat(betCart.getToWin()).isEqualTo(BigDecimal.TEN);
        }
    }

    @Nested
    class ConfirmBetCardTransaction {
        @Test
        void shouldReturnSavedCart() {
            //given
            BetCart betCart = BetCart.builder()
                    .id(1L)
                    .toWin(BigDecimal.TEN)
                    .finished(true)
                    .betList(List.of(new BetInfo()))
                    .build();
            List<BetCart> carts = new ArrayList<>();
            carts.add(betCart);
            Customer customer = Customer.builder()
                    .betCarts(carts)
                    .appUser(new AppUser())
                    .build();
            when(betCartRepository.findById(1L)).thenReturn(Optional.ofNullable(betCart));
            when(customerService.getCurrentLoggedInCustomer()).thenReturn(customer);
            when(betCartRepository.save(betCart)).thenReturn(betCart);
            //when
            BetCart returned = betCartService.confirmBetCardTransaction(betCart);
            //then
            assertThat(returned.getId()).isEqualTo(1L);
            assertThat(returned.getToWin()).isEqualTo(BigDecimal.TEN);
            assertThat(returned.isFinished()).isTrue();
            assertThat(returned.getBetList().size()).isEqualTo(1);
            verify(betCartRepository,times(1)).save(betCart);
        }

        @Test
        void shouldThrowNullPointerException() {
            //when & then
            assertThatThrownBy(() -> betCartService.confirmBetCardTransaction(null))
                    .isInstanceOf(NullPointerException.class);
        }
    }
}