package my.betservice.dto.bet;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fixtureTime;
    private Integer fixtureId;
    private BetValueDtoInOut betValue;
    private Long betCardId;
}
