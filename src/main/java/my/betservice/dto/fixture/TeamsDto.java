package my.betservice.dto.fixture;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
public class TeamsDto {
    private Long id;
    private TeamDto home;
    private TeamDto away;
}
