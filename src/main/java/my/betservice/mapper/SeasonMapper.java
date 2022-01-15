package my.betservice.mapper;

import my.betservice.domain.Season;
import my.betservice.dto.SeasonDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SeasonMapper {

    private static Season mapToSeason(final SeasonDto dto) {
        return Season.builder()
                .id(dto.getId())
                .start(dto.getStart())
                .end(dto.getEnd())
                .coverage(CoverageMapper.mapToCoverage(dto.getCoverage()))
                .build();
    }

    private static SeasonDto mapToSeasonDto(final Season season) {
        return SeasonDto.builder()
                .id(season.getId())
                .start(season.getStart())
                .end(season.getEnd())
                .coverage(CoverageMapper.mapToCoverageDto(season.getCoverage()))
                .build();
    }

    public static List<Season> mapToSeasonList(final List<SeasonDto> dtos) {
        return dtos.stream()
                .map(SeasonMapper::mapToSeason)
                .collect(toList());
    }

    public static List<SeasonDto> mapToSeasonDtoList(final List<Season> seasons) {
        return seasons.stream()
                .map(SeasonMapper::mapToSeasonDto)
                .collect(toList());
    }
}
