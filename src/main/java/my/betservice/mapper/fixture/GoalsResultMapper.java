package my.betservice.mapper.fixture;

import my.betservice.domain.fixture.GoalsResult;
import my.betservice.dto.fixture.GoalsResultDto;

public class GoalsResultMapper {

    public static GoalsResult mapToGoalsResult(final GoalsResultDto dto) {
        return GoalsResult.builder()
                .id(dto.getId())
                .home(dto.getHome())
                .away(dto.getAway())
                .build();
    }

    public static GoalsResultDto mapToGoalsResultDto(final GoalsResult goalsResult) {
        return GoalsResultDto.builder()
                .id(goalsResult.getId())
                .home(goalsResult.getHome())
                .away(goalsResult.getAway())
                .build();
    }
}
