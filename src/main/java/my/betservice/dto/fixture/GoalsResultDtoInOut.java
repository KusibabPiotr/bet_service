package my.betservice.dto.fixture;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GoalsResultDtoInOut {
    private Integer home;
    private Integer away;
}
