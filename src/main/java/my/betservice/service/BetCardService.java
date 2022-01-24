package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.bet.BetCard;
import my.betservice.dto.bet.BetCardDto;
import my.betservice.exception.BetCardNotFoundException;
import my.betservice.repository.BetCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BetCardService {
    private final BetCardRepository betCardRepository;

    //fetch user from security context and change method TO FETCH ALL BETCARDS BELONGS TO >>THIS<< USER
    public List<BetCard> getAllBetCards() {
        return betCardRepository.findAll();
    }

    public Optional<BetCard> getBetCardById(final Long id) {
        return betCardRepository.findById(id);
    }

    public BetCard confirmBetCardTransaction(final BetCardDto processed) {
        BetCard betCard = getBetCardById(processed.getId()).orElseThrow(BetCardNotFoundException::new);
        betCard.setOddsValue(processed.getOddsValue());
        betCard.setBetCost(processed.getBetCost());
        betCard.setToWin(processed.getToWin());
        betCard.setBetConfirmedTime(processed.getBetConfirmedTime());
        betCard.setLastMatchToPlay(processed.getLastMatchToPlay());
        betCard.setFinished(processed.isFinished());
        return betCard;
    }
}
