package my.betservice.mapper.bet;

import my.betservice.domain.bet.BetCard;
import my.betservice.dto.bet.BetCardDto;

import java.util.List;
import java.util.stream.Collectors;

public class BetCardMapper {

    public static BetCard mapToBetCard(final BetCardDto dto) {
        return BetCard.builder()
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

    public static BetCardDto mapToBetCardDto(final BetCard betCard) {
        return BetCardDto.builder()
                .id(betCard.getId())
                .userId(betCard.getCustomer().getId())
                .betList(BetInfoMapper.mapToBetInfoDtoList(betCard.getBetList()))
                .oddsValue(betCard.getOddsValue())
                .betCost(betCard.getBetCost())
                .toWin(betCard.getToWin())
                .betConfirmedTime(betCard.getBetConfirmedTime())
                .lastMatchToPlay(betCard.getLastMatchToPlay())
                .finished(betCard.isFinished())
                .finalWin(betCard.getFinalWin())
                .build();
    }

    public static List<BetCardDto> mapToBetCardDtoList(final List<BetCard> list) {
        return list.stream()
                .map(BetCardMapper::mapToBetCardDto)
                .collect(Collectors.toList());
    }

    public static List<BetCard> mapToBetCardList(final List<BetCardDto> dtos) {
        return dtos.stream()
                .map(BetCardMapper::mapToBetCard)
                .collect(Collectors.toList());
    }
}
