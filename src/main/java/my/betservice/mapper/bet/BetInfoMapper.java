package my.betservice.mapper.bet;

import my.betservice.domain.bet.BetInfo;
import my.betservice.dto.bet.BetInfoDtoInOut;
import my.betservice.dto.odd.BetValueDtoInOut;

import java.util.List;
import java.util.stream.Collectors;

public class BetInfoMapper {
    public static BetInfo mapToBetInfo(final BetInfoDtoInOut dto) {
        return BetInfo.builder()
                .fixtureId(dto.getFixtureId())
                .date(dto.getFixtureTime())
                .value(dto.getBetValue().getValue())
                .odd(dto.getBetValue().getOdd())
                .build();
    }

    public static BetInfoDtoInOut mapToBetInfoDto(final BetInfo info) {
        return BetInfoDtoInOut.builder()
                .fixtureId(info.getFixtureId())
                .betValue(new BetValueDtoInOut(info.getValue(), info.getOdd()))
                .build();
    }

    public static List<BetInfo> mapToBetInfoList(final List<BetInfoDtoInOut> dtoList) {
        return dtoList.stream()
                .map(BetInfoMapper::mapToBetInfo)
                .collect(Collectors.toList());
    }

    public static List<BetInfoDtoInOut> mapToBetInfoDtoList(final List<BetInfo> list) {
        return list.stream()
                .map(BetInfoMapper::mapToBetInfoDto)
                .collect(Collectors.toList());
    }
}
