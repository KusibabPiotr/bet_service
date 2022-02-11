package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.bet.BetCard;
import my.betservice.domain.bet.BetInfo;
import my.betservice.repository.BetCardRepository;
import my.betservice.repository.BetInfoRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BetService {
    private final BetCardRepository betCardRepository;
    private final BetInfoRepository betInfoRepository;
    private final CustomerService customerService;
    private static final Boolean IS_FINISHED = false;

    @Transactional
    public BetInfo addBetToBetListOfThisUser(final BetInfo betInfo) {
        BetCard betCard = betCardRepository.findByFinishedAndCustomer(IS_FINISHED,customerService.getCurrentLoggedInCustomer());
        betCard.getBetList().add(betInfo);
        betInfo.setBetCard(betCard);
        return betInfo;
    }

    public void deleteBetFromBetList(final Long id) {
        betInfoRepository.deleteById(id);
    }

}
