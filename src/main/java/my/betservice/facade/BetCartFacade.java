package my.betservice.facade;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.bet.BetCart;
import my.betservice.dto.bet.BetCartDto;
import my.betservice.exception.NotEnoughMoneyOnAccountException;
import my.betservice.exception.UserNotFoundException;
import my.betservice.mapper.bet.BetCardMapper;
import my.betservice.service.BetCartProcessor;
import my.betservice.service.BetCartService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BetCartFacade {
    private final BetCartService betCartService;
    private final BetCartProcessor betCartProcessor;

    public List<BetCartDto> getAllUserBetCards() {
        return BetCardMapper.mapToBetCardDtoList(betCartService.getAllUserBetCards());
    }

    public BetCartDto getBetCardById(final Long id) {
        return BetCardMapper.mapToBetCardDto(betCartService.getBetCardById(id));
    }

    @Transactional
    public BetCartDto confirmBetCardTransaction(final Long id, final BigDecimal betCost)
            throws NotEnoughMoneyOnAccountException, UserNotFoundException {
        BetCartDto betCartDto = BetCardMapper.mapToBetCardDto(betCartService
                .getBetCardById(id));
        betCartDto.setBetCost(betCost);
        BetCart processed = BetCardMapper.mapToBetCard(betCartProcessor.processBetCard(betCartDto));
        return BetCardMapper.mapToBetCardDto(betCartService.confirmBetCardTransaction(processed));
    }
}
