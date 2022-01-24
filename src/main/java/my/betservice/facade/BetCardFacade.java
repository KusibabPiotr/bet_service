package my.betservice.facade;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.bet.BetCardDto;
import my.betservice.exception.BetCardNotFoundException;
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

    public List<BetCardDto> getAllBetCards() {
        return BetCardMapper.mapToBetCardDtoList(betCardService.getAllBetCards());
    }

    public BetCardDto getBetCardById(final Long id) {
        return BetCardMapper.mapToBetCardDto(betCardService.getBetCardById(id).orElseThrow(BetCardNotFoundException::new));
    }

    @Transactional
    public BetCardDto confirmBetCardTransaction(final Long id, final BigDecimal betCost)
            throws NotEnoughMoneyOnAccountException, UserNotFoundException {
        BetCardDto betCardDto = BetCardMapper.mapToBetCardDto(betCardService
                .getBetCardById(id)
                .orElseThrow(BetCardNotFoundException::new));
        betCardDto.setBetCost(betCost);
        BetCardDto processed = betCardProcessor.processBetCard(betCardDto);
        return BetCardMapper.mapToBetCardDto(betCardService.confirmBetCardTransaction(processed));
    }
}
