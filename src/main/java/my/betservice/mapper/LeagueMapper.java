package my.betservice.mapper;

import my.betservice.domain.League;
import my.betservice.dto.LeagueDto;

public class LeagueMapper {

    public static League mapToLeague(final LeagueDto dto) {
        return League.builder()
                .dbId(dto.getDbId())
                .leagueId(dto.getLeagueId())
                .name(dto.getName())
                .logo(dto.getLogo())
                .type(dto.getType())
                .build();
    }

    public static LeagueDto mapToLeagueDto(final League league) {
        return LeagueDto.builder()
                .dbId(league.getDbId())
                .leagueId(league.getLeagueId())
                .name(league.getName())
                .logo(league.getLogo())
                .type(league.getType())
                .build();
    }
}
