package my.betservice.mapper.fixture;

import my.betservice.domain.fixture.FixtureInfo;
import my.betservice.dto.fixture.FixtureInfoDtoIn;
import my.betservice.dto.fixture.FixtureInfoDtoOut;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FixtureInfoMapper {

    public static FixtureInfo mapToFixtureInfo(final FixtureInfoDtoIn dto) {
        return FixtureInfo.builder()
                .fixtureId(dto.getFixture().getFixtureId())
                .referee(dto.getFixture().getReferee())
                .date(dto.getFixture().getDate())
                .venueId(dto.getFixture().getVenue().getVenueId())
                .venueName(dto.getFixture().getVenue().getName())
                .city(dto.getFixture().getVenue().getCity())
                .gameStatus(dto.getFixture().getStatus().getFullStatus())
                .leagueId(dto.getLeague().getLeagueId())
                .leagueName(dto.getLeague().getName())
                .logo(dto.getLeague().getLogo())
                .homeTeam(TeamMapper.mapToTeam(dto.getTeams().getHome()))
                .awayTeam(TeamMapper.mapToTeam(dto.getTeams().getAway()))
                .homeResult(dto.getGoals().getHome())
                .awayResult(dto.getGoals().getAway())
                .halftime(GoalsResultMapper.mapToGoalsResult(dto.getScore().getHalftime()))
                .fulltime(GoalsResultMapper.mapToGoalsResult(dto.getScore().getFulltime()))
                .extratime(GoalsResultMapper.mapToGoalsResult(dto.getScore().getExtratime()))
                .penalty(GoalsResultMapper.mapToGoalsResult(dto.getScore().getPenalty()))
                .build();
    }

    public static FixtureInfoDtoOut mapToFixtureDtoOutput(final FixtureInfo info) {
        return FixtureInfoDtoOut.builder()
                .id(info.getId())
                .fixtureId(info.getFixtureId())
                .referee(info.getReferee())
                .date(info.getDate())
                .venueId(info.getVenueId())
                .venueName(info.getVenueName())
                .city(info.getCity())
                .gameStatus(info.getGameStatus())
                .leagueId(info.getLeagueId())
                .leagueName(info.getLeagueName())
                .logo(info.getLogo())
                .homeTeam(TeamMapper.mapToTeamDto(info.getHomeTeam()))
                .awayTeam(TeamMapper.mapToTeamDto(info.getAwayTeam()))
                .homeResult(info.getHomeResult())
                .awayResult(info.getAwayResult())
                .halftime(GoalsResultMapper.mapToGoalsResultDto(info.getHalftime()))
                .fulltime(GoalsResultMapper.mapToGoalsResultDto(info.getFulltime()))
                .extratime(GoalsResultMapper.mapToGoalsResultDto(info.getExtratime()))
                .penalty(GoalsResultMapper.mapToGoalsResultDto(info.getPenalty()))
                .build();
    }


    public static List<FixtureInfoDtoOut> mapToFixtureInfoDtoList(final List<FixtureInfo> fixtures) {
        return fixtures.stream()
                .map(FixtureInfoMapper::mapToFixtureDtoOutput)
                .collect(toList());
    }

    public static List<FixtureInfo> mapToFixtureInfoList(final List<FixtureInfoDtoIn> dtos) {
        return dtos.stream()
                .map(FixtureInfoMapper::mapToFixtureInfo)
                .collect(toList());
    }
}
