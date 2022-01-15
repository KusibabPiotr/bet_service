package my.betservice.mapper.fixture;

import my.betservice.domain.fixture.Teams;
import my.betservice.dto.fixture.TeamsDto;

public class TeamsMapper {

    public static Teams mapToTeams(final TeamsDto dto) {
        return Teams.builder()
                .id(dto.getId())
                .home(TeamMapper.mapToTeam(dto.getHome()))
                .away(TeamMapper.mapToTeam(dto.getAway()))
                .build();
    }

    public static TeamsDto mapToTeamsDto(final Teams teams) {
        return TeamsDto.builder()
                .id(teams.getId())
                .home(TeamMapper.mapToTeamDto(teams.getHome()))
                .away(TeamMapper.mapToTeamDto(teams.getAway()))
                .build();
    }
}
