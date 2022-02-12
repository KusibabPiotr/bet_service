package my.betservice.controller.user;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.bet.BetCartDto;
import my.betservice.exception.NotEnoughMoneyOnAccountException;
import my.betservice.exception.UserNotFoundException;
import my.betservice.facade.BetCartFacade;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/betCarts")
@RequiredArgsConstructor
public class BetCartController {
    private final BetCartFacade betFacade;

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @GetMapping
    public List<BetCartDto> getAllUsersBetCards() {
        return betFacade.getAllUserBetCards();
    }

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @GetMapping(value = "/{id}")
    public BetCartDto getBetCardById(@PathVariable Long id) {
        return betFacade.getBetCardById(id);
    }

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PutMapping(value = "/{id}")
    public BetCartDto confirmBetCardTransaction(@PathVariable Long id, @RequestParam BigDecimal betCost)
            throws NotEnoughMoneyOnAccountException, UserNotFoundException {
        return betFacade.confirmBetCardTransaction(id, betCost);
    }
}
