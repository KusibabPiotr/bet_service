package my.betservice.mapper.fixture;

import my.betservice.domain.fixture.GoalsResult;
import my.betservice.dto.fixture.GoalsResultDtoInOut;

public class GoalsResultMapper {

    public static GoalsResult mapToGoalsResult(final GoalsResultDtoInOut dto) {
        return GoalsResult.builder()
                .home(dto.getHome())
                .away(dto.getAway())
                .build();
    }

    public static GoalsResultDtoInOut mapToGoalsResultDto(final GoalsResult goalsResult) {
        return GoalsResultDtoInOut.builder()
                .home(goalsResult.getHome())
                .away(goalsResult.getAway())
                .build();
    }
}
