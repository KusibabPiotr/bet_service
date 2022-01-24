package my.betservice.controller.user;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.bet.BetCardDto;
import my.betservice.exception.NotEnoughMoneyOnAccountException;
import my.betservice.exception.UserNotFoundException;
import my.betservice.facade.BetCardFacade;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/api/betCards")
@RequiredArgsConstructor
public class BetCardController {
    private final BetCardFacade betFacade;

    @GetMapping
    public List<BetCardDto> getAllBetCards() {
        return betFacade.getAllBetCards();
    }

    @GetMapping(value = "/{id}")
    public BetCardDto getBetCardById(@PathVariable Long id) {
        return betFacade.getBetCardById(id);
    }

    @PutMapping(value = "/{id}")
    public BetCardDto confirmBetCardTransaction(@PathVariable Long id, @RequestParam BigDecimal betCost)
            throws NotEnoughMoneyOnAccountException, UserNotFoundException {
        return betFacade.confirmBetCardTransaction(id, betCost);
    }
}
