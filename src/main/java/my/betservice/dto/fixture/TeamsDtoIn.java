package my.betservice.dto.fixture;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamsDtoIn {
    private TeamDtoInOut home;
    private TeamDtoInOut away;
}
