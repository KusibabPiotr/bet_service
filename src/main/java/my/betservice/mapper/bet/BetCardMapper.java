package my.betservice.mapper.bet;

import my.betservice.domain.bet.BetCart;
import my.betservice.dto.bet.BetCartDto;
import java.util.List;
import java.util.stream.Collectors;

public class BetCardMapper {

    public static BetCart mapToBetCard(final BetCartDto dto) {
        return BetCart.builder()
                .id(dto.getId())
                .betList(BetInfoMapper.mapToBetInfoList(dto.getBetList()))
                .oddsValue(dto.getOddsValue())
                .betCost(dto.getBetCost())
                .toWin(dto.getToWin())
                .betConfirmedTime(dto.getBetConfirmedTime())
                .lastMatchToPlay(dto.getLastMatchToPlay())
                .finished(dto.isFinished())
                .finalWin(dto.getFinalWin())
                .build();
    }

    public static BetCartDto mapToBetCardDto(final BetCart betCart) {
        return BetCartDto.builder()
                .id(betCart.getId())
                .userId(betCart.getCustomer().getId())
                .betList(BetInfoMapper.mapToBetInfoDtoList(betCart.getBetList()))
                .oddsValue(betCart.getOddsValue())
                .betCost(betCart.getBetCost())
                .toWin(betCart.getToWin())
                .betConfirmedTime(betCart.getBetConfirmedTime())
                .lastMatchToPlay(betCart.getLastMatchToPlay())
                .finished(betCart.isFinished())
                .finalWin(betCart.getFinalWin())
                .build();
    }

    public static List<BetCartDto> mapToBetCardDtoList(final List<BetCart> list) {
        return list.stream()
                .map(BetCardMapper::mapToBetCardDto)
                .collect(Collectors.toList());
    }

    public static List<BetCart> mapToBetCardList(final List<BetCartDto> dtos) {
        return dtos.stream()
                .map(BetCardMapper::mapToBetCard)
                .collect(Collectors.toList());
    }
}
