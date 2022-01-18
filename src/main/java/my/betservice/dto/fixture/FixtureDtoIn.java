package my.betservice.dto.fixture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureDtoIn {
    @JsonProperty("id")
    private Integer fixtureId;
    private String referee;
    private String date;
    private VenueDtoIn venue;
    private GameStatusDtoIn status;
}
