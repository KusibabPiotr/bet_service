package my.betservice.mapper.bet;

import my.betservice.domain.bet.BetInfo;
import my.betservice.dto.bet.BetInfoDto;
import my.betservice.dto.odd.BetValueDtoInOut;

import java.util.List;
import java.util.stream.Collectors;

public class BetInfoMapper {
    public static BetInfo mapToBetInfo(final BetInfoDto dto) {
        return BetInfo.builder()
                .fixtureId(dto.getFixtureId())
                .date(dto.getFixtureTime())
                .value(dto.getBetValue().getValue())
                .odd(dto.getBetValue().getOdd())
                .build();
    }

    public static BetInfoDto mapToBetInfoDto(final BetInfo info) {
        return BetInfoDto.builder()
                .fixtureId(info.getFixtureId())
                .betValue(new BetValueDtoInOut(info.getValue(), info.getOdd()))
                .build();
    }

    public static List<BetInfo> mapToBetInfoList(final List<BetInfoDto> dtoList) {
        return dtoList.stream()
                .map(BetInfoMapper::mapToBetInfo)
                .collect(Collectors.toList());
    }

    public static List<BetInfoDto> mapToBetInfoDtoList(final List<BetInfo> list) {
        return list.stream()
                .map(BetInfoMapper::mapToBetInfoDto)
                .collect(Collectors.toList());
    }
}
