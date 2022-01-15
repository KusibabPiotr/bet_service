package my.betservice.mapper.fixture;

import my.betservice.domain.fixture.Venue;
import my.betservice.dto.fixture.VenueDto;

public class VenueMapper {

    public static Venue mapToVenue(final VenueDto dto) {
        return Venue.builder()
                .id(dto.getDbId())
                .venueId(dto.getVenueId())
                .name(dto.getName())
                .city(dto.getCity())
                .build();
    }

    public static VenueDto mapToVenueDto(final Venue venue) {
        return VenueDto.builder()
                .dbId(venue.getId())
                .venueId(venue.getVenueId())
                .name(venue.getName())
                .city(venue.getCity())
                .build();
    }
}
