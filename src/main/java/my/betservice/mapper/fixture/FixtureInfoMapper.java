package my.betservice.mapper.fixture;

import my.betservice.domain.fixture.FixtureInfo;
import my.betservice.dto.fixture.FixtureInfoDto;
import my.betservice.mapper.league.LeagueMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FixtureInfoMapper {

    public static FixtureInfo mapToFixtureInfo(final FixtureInfoDto dto) {
        return FixtureInfo.builder()
                .id(dto.getId())
                .fixture(FixtureMapper.mapToFixture(dto.getFixture()))
                .league(LeagueMapper.mapToLeague(dto.getLeague()))
                .teams(TeamsMapper.mapToTeams(dto.getTeams()))
                .goals(GoalsResultMapper.mapToGoalsResult(dto.getGoals()))
                .score(PartitialScoreResultsMapper.mapToScoreResult(dto.getScore()))
                .build();
    }

    public static FixtureInfoDto mapToFixtureInfoDto(final FixtureInfo fixtureInfo) {
        return FixtureInfoDto.builder()
                .id(fixtureInfo.getId())
                .fixture(FixtureMapper.mapToFixtureDto(fixtureInfo.getFixture()))
                .league(LeagueMapper.mapToLeagueDto(fixtureInfo.getLeague()))
                .teams(TeamsMapper.mapToTeamsDto(fixtureInfo.getTeams()))
                .goals(GoalsResultMapper.mapToGoalsResultDto(fixtureInfo.getGoals()))
                .score(PartitialScoreResultsMapper.mapToScoreResultDto(fixtureInfo.getScore()))
                .build();
    }

    public static List<FixtureInfoDto> mapToFixtureInfoDtoList(final List<FixtureInfo> fixtures) {
        return fixtures.stream()
                .map(FixtureInfoMapper::mapToFixtureInfoDto)
                .collect(toList());
    }
}
