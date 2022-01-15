package my.betservice.dto.fixture;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
public class GoalsResultDto {
    private Long id;
    private Integer home;
    private Integer away;
}
