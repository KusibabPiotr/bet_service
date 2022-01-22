package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.bet.BetCardDto;
import my.betservice.dto.bet.BetInfoDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BetCardProcessor {
    private final PaymentProcessor paymentProcessor;

    public BetCardDto processBetCard(final BetCardDto dto) {
        dto.setOddsValue(BigDecimal.valueOf(countOddsValue(dto)));
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

    private double countOddsValue(final BetCardDto dto) {
        return dto.getBetList()
                        .stream()
                        .mapToDouble(e -> Double.parseDouble(e.getBetValue().getValue()))
                        .sum();
    }
}
