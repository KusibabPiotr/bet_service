package my.betservice.dto.league;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonDto {
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate start;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate end;
    private CoverageDto coverage;
}
