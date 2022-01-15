package my.betservice.dto.fixture;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
public class PartitialScoreResultsDto {
    private Long id;
    private GoalsResultDto halftime;
    private GoalsResultDto fulltime;
    private GoalsResultDto extratime;
    private GoalsResultDto penalty;
}
