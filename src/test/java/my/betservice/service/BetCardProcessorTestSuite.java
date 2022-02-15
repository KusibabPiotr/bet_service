package my.betservice.service;

import my.betservice.dto.bet.BetCartDto;
import my.betservice.dto.bet.BetInfoDto;
import my.betservice.dto.odd.BetValueDtoInOut;
import my.betservice.exception.NotEnoughMoneyOnAccountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BetCardProcessorTestSuite {
    @InjectMocks
    private BetCartProcessor betCartProcessor;
    @Mock
    private PaymentProcessor paymentProcessor;

    @Test
    void shouldReturnBetCartDto() throws NotEnoughMoneyOnAccountException {
        //given
        BetInfoDto bet = BetInfoDto.builder()
                .betValue(new BetValueDtoInOut("5", "home"))
                .fixtureTime(LocalDateTime.now().plusMinutes(15))
                .build();
        BetCartDto betCart = BetCartDto.builder()
                .betCost(BigDecimal.TEN)
                .betList(List.of(bet))
                .build();
        when(paymentProcessor.checkIfUserHasEnoughMoney(any())).thenReturn(true);
        //when
        BetCartDto processedDto = betCartProcessor.processBetCard(betCart);
        //then
        assertThat(processedDto.isFinished()).isTrue();
        assertThat(processedDto.getOddsValue()).isEqualTo(BigDecimal.valueOf(5.0));
        assertThat(processedDto.getBetCost()).isEqualTo(BigDecimal.TEN);
        assertThat(processedDto.getToWin())
                .isEqualTo(BigDecimal.valueOf(5.0)
                        .multiply(BigDecimal.TEN)
                        .multiply(BigDecimal.valueOf(0.8)));
    }
}