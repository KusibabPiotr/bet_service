package my.betservice.mapper.fixture;

import my.betservice.domain.fixture.Fixture;
import my.betservice.dto.fixture.FixtureDto;

public class FixtureMapper {

    public static Fixture mapToFixture(final FixtureDto dto) {
        return Fixture.builder()
                .id(dto.getDbId())
                .fixtureId(dto.getFixtureId())
                .referee(dto.getReferee())
                .date(dto.getDate())
                .venue(VenueMapper.mapToVenue(dto.getVenue()))
                .status(GameStatusMapper.mapToGameStatus(dto.getStatus()))
                .build();
    }

    public static FixtureDto mapToFixtureDto(final Fixture fixture) {
        return FixtureDto.builder()
                .dbId(fixture.getId())
                .fixtureId(fixture.getFixtureId())
                .referee(fixture.getReferee())
                .date(fixture.getDate())
                .venue(VenueMapper.mapToVenueDto(fixture.getVenue()))
                .status(GameStatusMapper.mapToGameStatusDto(fixture.getStatus()))
                .build();
    }
}
