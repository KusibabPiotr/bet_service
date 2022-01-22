package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.bet.BetCard;
import my.betservice.domain.bet.BetInfo;
import my.betservice.repository.BetCardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BetService {
    private final BetCardRepository betCardRepository;
    private static final Boolean IS_FINISHED = false;

    @Transactional
    public BetInfo addBetToBetList(final BetInfo betInfo) {
        BetCard betCard = betCardRepository.findByFinished(IS_FINISHED);
        betCard.getBetList().add(betInfo);
        return betInfo;
    }

    public void deleteBetFromBetList(final Long id) {
        betCardRepository.deleteById(id);
    }
}
