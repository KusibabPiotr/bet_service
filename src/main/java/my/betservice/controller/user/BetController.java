package my.betservice.controller.user;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.bet.BetInfoDto;
import my.betservice.exception.BetNotFoundException;
import my.betservice.facade.BetFacade;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bets")
@RequiredArgsConstructor
public class BetController {
    private final BetFacade betFacade;

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PostMapping
    public BetInfoDto addBetToBetList(@RequestBody BetInfoDto betInfoDto) {
        return betFacade.addBetToBetList(betInfoDto);
    }

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @DeleteMapping(value = "/{id}")
    public void deleteBetFromBetList(@PathVariable Long id)
            throws BetNotFoundException {
        betFacade.deleteBetFromBetList(id);
    }
}
