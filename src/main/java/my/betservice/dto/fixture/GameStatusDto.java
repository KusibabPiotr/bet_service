package my.betservice.dto.fixture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameStatusDto {
    private Long id;
    @JsonProperty(value = "long")
    private String fullStatus;
    @JsonProperty(value = "short")
    private String shortStatus;
    private Integer elapsed;
}
