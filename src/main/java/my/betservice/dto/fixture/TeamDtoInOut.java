package my.betservice.dto.fixture;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamDtoInOut {
    @JsonProperty(value = "id")
    private Integer teamId;
    private String name;
    private String logo;
    private Boolean winner;
}
