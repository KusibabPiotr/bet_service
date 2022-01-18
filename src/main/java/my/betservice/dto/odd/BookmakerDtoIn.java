package my.betservice.dto.odd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookmakerDtoIn {
    @JsonProperty("id")
    private Integer bookmakerId;
    private String name;
    private BetDtoIn[] bets = new BetDtoIn[1];
}
