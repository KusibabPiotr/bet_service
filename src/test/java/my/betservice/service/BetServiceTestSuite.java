package my.betservice.service;

import my.betservice.domain.bet.BetCart;
import my.betservice.domain.bet.BetInfo;
import my.betservice.domain.fixture.FixtureInfo;
import my.betservice.domain.user.Customer;
import my.betservice.exception.FixtureNotFoundException;
import my.betservice.repository.BetCartRepository;
import my.betservice.repository.BetInfoRepository;
import my.betservice.repository.FixtureInfoRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BetServiceTestSuite {
    @InjectMocks
    private BetService betService;
    @Mock
    private BetCartRepository betCartRepository;
    @Mock
    private BetInfoRepository betInfoRepository;
    @Mock
    private FixtureInfoRepository fixtureInfoRepository;
    @Mock
    private CustomerService customerService;

    @Nested
    class TestDeleteBetFromList {
        @Test
        void shouldDeleteBetInfoById() {
            //when
            betService.deleteBetFromBetList(1L);
            //then
            verify(betInfoRepository,times(1)).deleteById(1L);
        }

        @Test
        void shouldThrowIllegalArgExceptionWithIdNull() {
            //given
            doThrow(new IllegalArgumentException()).when(betInfoRepository).deleteById(null);
            //when
            assertThatThrownBy(()->betService.deleteBetFromBetList(null))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
    @Nested
    class TestAddBetToBetListOfThisUser {
        @Test
        void shouldAddBetToUserCartAndReturnAddedBet() {
            //given
            BetInfo bet = BetInfo.builder()
                    .date(LocalDateTime.now())
                    .fixtureId(1234)
                    .odd("home")
                    .value("5.0")
                    .build();
            BetCart betCart = BetCart.builder()
                    .id(1L)
                    .finished(false)
                    .betList(new ArrayList<>())
                    .build();
            given(fixtureInfoRepository.findByFixtureId(any())).willReturn(
                    Optional.of(FixtureInfo.builder().date("2007-12-03T10:15:30+01:00[Europe/Paris]").build()));
            given(customerService.getCurrentLoggedInCustomer()).willReturn(new Customer());
            given(betCartRepository.findByFinishedAndCustomer(anyBoolean(),any()))
                    .willReturn(betCart);
            given(betInfoRepository.save(bet)).willReturn(bet);
            //when
            BetInfo betInfo = betService.addBetToBetListOfThisUser(bet);
            //then
            assertThat(betInfo.getFixtureId()).isEqualTo(1234);
            assertThat(betInfo.getValue()).isEqualTo("5.0");
            assertThat(betInfo.getBetCart().getId()).isEqualTo(1L);
            assertThat(betCart.getBetList().size()).isEqualTo(1);
        }

        @Test
        void shouldThrowFixtureNotFoundException() {
            //given
            BetInfo bet = BetInfo.builder()
                    .date(LocalDateTime.now())
                    .fixtureId(1234)
                    .odd("home")
                    .value("5.0")
                    .build();
            BetCart betCart = BetCart.builder()
                    .id(1L)
                    .finished(false)
                    .betList(new ArrayList<>())
                    .build();
            given(customerService.getCurrentLoggedInCustomer()).willReturn(new Customer());
            given(betCartRepository.findByFinishedAndCustomer(anyBoolean(),any()))
                    .willReturn(betCart);
            //when
            assertThatThrownBy(() -> betService.addBetToBetListOfThisUser(bet))
                    .isInstanceOf(FixtureNotFoundException.class);
        }

        @Test
        void shouldThrowDateTimeParseException() {
            //given
            BetInfo bet = BetInfo.builder()
                    .date(LocalDateTime.now())
                    .fixtureId(1234)
                    .odd("home")
                    .value("5.0")
                    .build();
            BetCart betCart = BetCart.builder()
                    .id(1L)
                    .finished(false)
                    .betList(new ArrayList<>())
                    .build();
            given(customerService.getCurrentLoggedInCustomer()).willReturn(new Customer());
            given(betCartRepository.findByFinishedAndCustomer(anyBoolean(),any()))
                    .willReturn(betCart);
            given(fixtureInfoRepository.findByFixtureId(any())).willReturn(
                    Optional.of(FixtureInfo.builder().date("").build()));
            //when
            assertThatThrownBy(() -> betService.addBetToBetListOfThisUser(bet))
                    .isInstanceOf(DateTimeParseException.class);
        }
    }
}