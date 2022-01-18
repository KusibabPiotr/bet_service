package my.betservice.dto.odd;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BetDtoIn {
    @JsonProperty("id")
    private Integer betId;
    private String name;
    @JsonProperty("values")
    private BetValueDtoInOut[] betValues = new BetValueDtoInOut[1];
}
