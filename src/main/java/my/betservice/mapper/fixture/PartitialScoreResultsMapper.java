package my.betservice.mapper.fixture;

import my.betservice.domain.fixture.PartitialScoreResults;
import my.betservice.dto.fixture.PartitialScoreResultsDto;

public class PartitialScoreResultsMapper {

    public static PartitialScoreResults mapToScoreResult(final PartitialScoreResultsDto dto) {
        return PartitialScoreResults.builder()
                .id(dto.getId())
                .halftime(GoalsResultMapper.mapToGoalsResult(dto.getHalftime()))
                .fulltime(GoalsResultMapper.mapToGoalsResult(dto.getFulltime()))
                .extratime(GoalsResultMapper.mapToGoalsResult(dto.getExtratime()))
                .penalty(GoalsResultMapper.mapToGoalsResult(dto.getPenalty()))
                .build();
    }

    public static PartitialScoreResultsDto mapToScoreResultDto(final PartitialScoreResults scoreResults) {
        return PartitialScoreResultsDto.builder()
                .id(scoreResults.getId())
                .halftime(GoalsResultMapper.mapToGoalsResultDto(scoreResults.getHalftime()))
                .fulltime(GoalsResultMapper.mapToGoalsResultDto(scoreResults.getFulltime()))
                .extratime(GoalsResultMapper.mapToGoalsResultDto(scoreResults.getExtratime()))
                .penalty(GoalsResultMapper.mapToGoalsResultDto(scoreResults.getPenalty()))
                .build();
    }
}
