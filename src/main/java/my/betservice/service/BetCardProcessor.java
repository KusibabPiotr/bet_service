package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.bet.BetCartDto;
import my.betservice.dto.bet.BetInfoDto;
import my.betservice.exception.NotEnoughMoneyOnAccountException;
import my.betservice.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BetCardProcessor {
    private final PaymentProcessor paymentProcessor;

    public BetCartDto processBetCard(final BetCartDto dto)
            throws NotEnoughMoneyOnAccountException, UserNotFoundException {
        BigDecimal cardToPayValue = BigDecimal.valueOf(countOddsValue(dto));
        if (!paymentProcessor.checkIfUserHasEnoughMoney(dto.getBetCost()))
            throw new NotEnoughMoneyOnAccountException();
        dto.setOddsValue(cardToPayValue);
        dto.setToWin(countToWinPrize(dto.getBetCost(), dto.getOddsValue()));
        dto.setBetConfirmedTime(LocalDateTime.now());
        dto.setLastMatchToPlay(findLastestMatchDate(dto.getBetList()));
        dto.setFinished(true);
        return dto;
    }

    private LocalDateTime findLastestMatchDate(final List<BetInfoDto> betList) {
        List<LocalDateTime> dateTimes = betList.stream()
                .map(BetInfoDto::getFixtureTime)
                .sorted()
                .collect(Collectors.toList());
        return dateTimes.get(dateTimes.size()-1);
    }

    private BigDecimal countToWinPrize(final BigDecimal betCost, final BigDecimal oddsValue) {
        return betCost.multiply(oddsValue).multiply(BigDecimal.valueOf(0.8));
    }

    private double countOddsValue(final BetCartDto dto) {
        return dto.getBetList()
                        .stream()
                        .mapToDouble(e -> Double.parseDouble(e.getBetValue().getValue()))
                        .sum();
    }
}
