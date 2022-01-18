package my.betservice.dto.fixture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameStatusDtoIn {
    @JsonProperty(value = "long")
    private String fullStatus;
    @JsonProperty(value = "short")
    private String shortStatus;
    private Integer elapsed;
}
