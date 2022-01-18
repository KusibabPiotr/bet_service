package my.betservice.dto.odd;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BetValueDtoInOut {
    private String value;
    private String odd;
}
