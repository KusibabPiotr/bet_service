package my.betservice.mapper.league;

import my.betservice.domain.league.LeagueInfo;
import my.betservice.dto.league.LeagueInfoDtoIn;
import my.betservice.dto.league.LeagueInfoDtoOut;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LeagueInfoMapper {

    public static LeagueInfo mapToLeagueInfo(final LeagueInfoDtoIn dto) {
        return LeagueInfo.builder()
                .leagueId(dto.getLeague().getLeagueId())
                .leagueName(dto.getLeague().getName())
                .leagueLogo(dto.getLeague().getLogo())
                .countryName(dto.getCountry().getName())
                .countryFlag(dto.getCountry().getFlag())
                .build();
    }

    public static LeagueInfoDtoOut mapToLeagueInfoDto(final LeagueInfo info) {
        return LeagueInfoDtoOut.builder()
                .id(info.getId())
                .leagueId(info.getLeagueId())
                .leagueName(info.getLeagueName())
                .leagueLogo(info.getLeagueLogo())
                .countryName(info.getCountryName())
                .countryFlag(info.getCountryFlag())
                .build();
    }

    public static List<LeagueInfoDtoOut> mapToLeagueInfoDtoList(final List<LeagueInfo> infos) {
        return infos.stream()
                .map(LeagueInfoMapper::mapToLeagueInfoDto)
                .collect(toList());
    }
}
