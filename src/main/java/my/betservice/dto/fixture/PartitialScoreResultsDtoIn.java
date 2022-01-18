package my.betservice.dto.fixture;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PartitialScoreResultsDtoIn {
    private GoalsResultDtoInOut halftime;
    private GoalsResultDtoInOut fulltime;
    private GoalsResultDtoInOut extratime;
    private GoalsResultDtoInOut penalty;
}
