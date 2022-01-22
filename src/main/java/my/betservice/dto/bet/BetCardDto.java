package my.betservice.dto.bet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BetCardDto {
    private Long id;
    private Long userId;
    private List<BetInfoDto> betList;
    private BigDecimal oddsValue;
    private BigDecimal betCost;
    private BigDecimal toWin;
    private LocalDateTime betConfirmedTime;
    private LocalDateTime lastMatchToPlay;
    private boolean finished;
}
