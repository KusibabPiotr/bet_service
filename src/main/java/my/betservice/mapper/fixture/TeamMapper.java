package my.betservice.mapper.fixture;

import my.betservice.domain.fixture.Team;
import my.betservice.dto.fixture.TeamDto;

public class TeamMapper {

    public static Team mapToTeam(final TeamDto dto) {
        return Team.builder()
                .dbId(dto.getDbId())
                .teamId(dto.getTeamId())
                .name(dto.getName())
                .logo(dto.getLogo())
                .winner(dto.getWinner())
                .build();
    }

    public static TeamDto mapToTeamDto(final Team team) {
        return TeamDto.builder()
                .dbId(team.getDbId())
                .teamId(team.getTeamId())
                .name(team.getName())
                .logo(team.getLogo())
                .winner(team.getWinner())
                .build();
    }
}
