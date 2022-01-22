package my.betservice.mapper.odd;

import my.betservice.dto.odd.OddInfoDtoIn;
import my.betservice.dto.odd.OddInfoDtoOut;

import java.time.LocalDateTime;

public class OddInfoMapper {

    public static OddInfoDtoOut mapToOutDto(final OddInfoDtoIn in) {
        return OddInfoDtoOut.builder()
                .leagueId(in.getLeague().getLeagueId())
                .leagueName(in.getLeague().getName())
                .leagueLogo(in.getLeague().getLogo())
                .fixtureId(in.getFixture().getFixtureId())
                .date(convertTime(in.getFixture().getDate()))
                .bookmakerName(in.getBookmakers()[0].getName())
                .betName(in.getBookmakers()[0].getBets()[0].getName())
                .home(in.getBookmakers()[0].getBets()[0].getBetValues()[0])
                .draw(in.getBookmakers()[0].getBets()[0].getBetValues()[1])
                .away(in.getBookmakers()[0].getBets()[0].getBetValues()[2])
                .build();
    }
    private static LocalDateTime convertTime(final String time) {
        return LocalDateTime.parse(time);
    }
}
