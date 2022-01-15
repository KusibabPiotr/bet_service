package my.betservice.mapper.league;

import my.betservice.domain.league.LeagueInfo;
import my.betservice.dto.league.LeagueInfoDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LeagueInfoMapper {

    public static LeagueInfo mapToLeagueInfo(final LeagueInfoDto dto) {
        return LeagueInfo.builder()
                .id(dto.getId())
                .league(LeagueMapper.mapToLeague(dto.getLeague()))
                .country(CountryMapper.mapToCountry(dto.getCountry()))
                .seasons(SeasonMapper.mapToSeasonList(dto.getSeasons()))
                .build();
    }

    public static LeagueInfoDto mapToLeagueInfoDto(final LeagueInfo info) {
        return LeagueInfoDto.builder()
                .id(info.getId())
                .league(LeagueMapper.mapToLeagueDto(info.getLeague()))
                .country(CountryMapper.mapToCountryDto(info.getCountry()))
                .seasons(SeasonMapper.mapToSeasonDtoList(info.getSeasons()))
                .build();
    }

    public static List<LeagueInfoDto> mapToLeagueInfoDtoList(final List<LeagueInfo> infos) {
        return infos.stream()
                .map(LeagueInfoMapper::mapToLeagueInfoDto)
                .collect(toList());
    }
}
