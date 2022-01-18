package my.betservice.dto.fixture;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VenueDtoIn {
    @JsonProperty(value = "id")
    private Integer venueId;
    private String name;
    private String city;
}
