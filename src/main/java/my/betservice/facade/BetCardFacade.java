package my.betservice.facade;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.bet.BetCardDto;
import my.betservice.exception.NotEnoughMoneyOnAccountException;
import my.betservice.exception.UserNotFoundException;
import my.betservice.mapper.bet.BetCardMapper;
import my.betservice.service.BetCardProcessor;
import my.betservice.service.BetCardService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BetCardFacade {
    private final BetCardService betCardService;
    private final BetCardProcessor betCardProcessor;

    public List<BetCardDto> getAllUserBetCards() {
        return BetCardMapper.mapToBetCardDtoList(betCardService.getAllUserBetCards());
    }

    public BetCardDto getBetCardById(final Long id) {
        return BetCardMapper.mapToBetCardDto(betCardService.getBetCardById(id));
    }

    @Transactional
    public BetCardDto confirmBetCardTransaction(final Long id, final BigDecimal betCost)
            throws NotEnoughMoneyOnAccountException, UserNotFoundException {
        BetCardDto betCardDto = BetCardMapper.mapToBetCardDto(betCardService
                .getBetCardById(id));
        betCardDto.setBetCost(betCost);
        BetCardDto processed = betCardProcessor.processBetCard(betCardDto);
        return BetCardMapper.mapToBetCardDto(betCardService.confirmBetCardTransaction(processed));
    }
}
