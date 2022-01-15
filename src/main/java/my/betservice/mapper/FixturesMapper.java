package my.betservice.mapper;

import my.betservice.domain.Fixture;
import my.betservice.dto.FixtureDto;

public class FixturesMapper {

    public static Fixture mapToFixture(final FixtureDto dto) {
        return Fixture.builder()
                .id(dto.getId())
                .events(dto.isEvents())
                .lineUps(dto.isLineUps())
                .statisticsFixtures(dto.isStatisticsFixtures())
                .statisticsPlayers(dto.isStatisticsPlayers())
                .build();
    }

    public static FixtureDto mapToFixtureDto(final Fixture fixture) {
        return FixtureDto.builder()
                .id(fixture.getId())
                .events(fixture.isEvents())
                .lineUps(fixture.isLineUps())
                .statisticsFixtures(fixture.isStatisticsFixtures())
                .statisticsPlayers(fixture.isStatisticsPlayers())
                .build();
    }
}
