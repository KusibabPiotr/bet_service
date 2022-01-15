package my.betservice.mapper.league;

import my.betservice.domain.league.Coverage;
import my.betservice.dto.league.CoverageDto;

public class CoverageMapper {

    public static Coverage mapToCoverage(final CoverageDto dto) {
        return Coverage.builder()
                .id(dto.getId())
                .fixtures(FixturesMapper.mapToFixture(dto.getFixtures()))
                .standings(dto.isStandings())
                .players(dto.isPlayers())
                .topScores(dto.isTopScores())
                .topAssists(dto.isTopAssists())
                .topCards(dto.isTopCards())
                .injuries(dto.isInjuries())
                .predictions(dto.isPredictions())
                .odds(dto.isOdds())
                .build();
    }

    public static CoverageDto mapToCoverageDto(final Coverage coverage) {
        return CoverageDto.builder()
                .id(coverage.getId())
                .fixtures(FixturesMapper.mapToFixtureDto(coverage.getFixtures()))
                .standings(coverage.isStandings())
                .players(coverage.isPlayers())
                .topScores(coverage.isTopScores())
                .topAssists(coverage.isTopAssists())
                .topCards(coverage.isTopCards())
                .injuries(coverage.isInjuries())
                .predictions(coverage.isPredictions())
                .odds(coverage.isOdds())
                .build();
    }
}
