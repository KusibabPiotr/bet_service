package my.betservice.dto.fixture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureInfoDto {
    private Long id;
    private FixtureDto fixture;
}
