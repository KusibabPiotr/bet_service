package my.betservice.dto.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDto {
    private Long id;
    private String name;
    private String code;
    private String flag;
}
