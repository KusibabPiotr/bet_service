package my.betservice.dto.fixture;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
public class VenueDto {
    private Long dbId;
    @JsonProperty(value = "id")
    private Integer venueId;
    private String name;
    private String city;
}
