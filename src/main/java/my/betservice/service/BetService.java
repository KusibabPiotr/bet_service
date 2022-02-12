package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.bet.BetCart;
import my.betservice.domain.bet.BetInfo;
import my.betservice.exception.FixtureNotFoundException;
import my.betservice.repository.BetCartRepository;
import my.betservice.repository.BetInfoRepository;
import my.betservice.repository.FixtureInfoRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class BetService {
    private final BetCartRepository betCartRepository;
    private final BetInfoRepository betInfoRepository;
    private final FixtureInfoRepository fixtureInfoRepository;
    private final CustomerService customerService;
    private static final Boolean IS_FINISHED = false;

    @Transactional
    public BetInfo addBetToBetListOfThisUser(final BetInfo betInfo) {
        BetCart betCart = betCartRepository.findByFinishedAndCustomer(IS_FINISHED,customerService.getCurrentLoggedInCustomer());
        String date = getFixtureTimeFromDb(betInfo.getFixtureId());
        betInfo.setDate(convertToLocalDateTime(date));
        betCart.getBetList().add(betInfo);
        betInfo.setBetCart(betCart);
        return betInfoRepository.save(betInfo);
    }

    public void deleteBetFromBetList(final Long id) {
        betInfoRepository.deleteById(id);
    }

    private String getFixtureTimeFromDb(final Integer fixtureId) {
        return fixtureInfoRepository.findByFixtureId(fixtureId)
                .orElseThrow(FixtureNotFoundException::new)
                .getDate();
    }

    private LocalDateTime convertToLocalDateTime(final String zonedTime) {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(zonedTime);
        ZoneId londonZone = ZoneId.of("Europe/Zurich");
        ZonedDateTime swissZoned = zonedDateTime.withZoneSameInstant(londonZone);
        return swissZoned.toLocalDateTime();
    }

}
