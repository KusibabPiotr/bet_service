package my.betservice.dto.bet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.betservice.dto.odd.BetValueDtoInOut;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BetInfoDto {
    private Long id;
    private LocalDateTime fixtureTime;
    private Integer fixtureId;
    private BetValueDtoInOut betValue;
}
