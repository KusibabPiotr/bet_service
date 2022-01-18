package my.betservice.mapper.fixture;

import my.betservice.domain.fixture.Team;
import my.betservice.dto.fixture.TeamDtoInOut;

public class TeamMapper {

    public static Team mapToTeam(final TeamDtoInOut dto) {
        return Team.builder()
                .teamId(dto.getTeamId())
                .name(dto.getName())
                .logo(dto.getLogo())
                .winner(dto.getWinner())
                .build();
    }

    public static TeamDtoInOut mapToTeamDto(final Team team) {
        return TeamDtoInOut.builder()
                .teamId(team.getTeamId())
                .name(team.getName())
                .logo(team.getLogo())
                .winner(team.getWinner())
                .build();
    }
}
