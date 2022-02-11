package my.betservice.controller.user;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.bet.BetCardDto;
import my.betservice.exception.NotEnoughMoneyOnAccountException;
import my.betservice.exception.UserNotFoundException;
import my.betservice.facade.BetCardFacade;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/betCards")
@RequiredArgsConstructor
public class BetCardController {
    private final BetCardFacade betFacade;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<BetCardDto> getAllBetCards() {
        return betFacade.getAllBetCards();
    }

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @GetMapping(value = "/{id}")
    public BetCardDto getBetCardById(@PathVariable Long id) {
        return betFacade.getBetCardById(id);
    }

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PutMapping(value = "/{id}")
    public BetCardDto confirmBetCardTransaction(@PathVariable Long id, @RequestParam BigDecimal betCost)
            throws NotEnoughMoneyOnAccountException, UserNotFoundException {
        return betFacade.confirmBetCardTransaction(id, betCost);
    }
}
