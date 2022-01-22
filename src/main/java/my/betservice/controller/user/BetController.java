package my.betservice.controller.user;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.bet.BetInfoDto;
import my.betservice.facade.BetFacade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/bets")
@RequiredArgsConstructor
public class BetController {
    private final BetFacade betFacade;

    @PostMapping
    public BetInfoDto addBetToBetList(@RequestBody BetInfoDto betInfoDto) {
        return betFacade.addBetToBetList(betFacade.addBetToBetList(betInfoDto));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBetFromBetList(@PathVariable Long id) {
        betFacade.deleteBetFromBetList(id);
    }
}
