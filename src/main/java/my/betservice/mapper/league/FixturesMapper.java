package my.betservice.mapper.league;

import my.betservice.domain.league.FixtureCoverage;
import my.betservice.dto.league.FixtureCoverageDto;

public class FixturesMapper {

    public static FixtureCoverage mapToFixture(final FixtureCoverageDto dto) {
        return FixtureCoverage.builder()
                .id(dto.getId())
                .events(dto.isEvents())
                .lineUps(dto.isLineUps())
                .statisticsFixtures(dto.isStatisticsFixtures())
                .statisticsPlayers(dto.isStatisticsPlayers())
                .build();
    }

    public static FixtureCoverageDto mapToFixtureDto(final FixtureCoverage fixtureCoverage) {
        return FixtureCoverageDto.builder()
                .id(fixtureCoverage.getId())
                .events(fixtureCoverage.isEvents())
                .lineUps(fixtureCoverage.isLineUps())
                .statisticsFixtures(fixtureCoverage.isStatisticsFixtures())
                .statisticsPlayers(fixtureCoverage.isStatisticsPlayers())
                .build();
    }
}
