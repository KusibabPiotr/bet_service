package my.betservice.dto.fixture;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
public class TeamDto {
    private Long dbId;
    @JsonProperty(value = "id")
    private Integer teamId;
    private String name;
    private String logo;
    private Boolean winner;
}
