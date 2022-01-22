package my.betservice.controller.user;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.bet.BetInfoDtoInOut;
import my.betservice.facade.BetFacade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/bets")
@RequiredArgsConstructor
public class BetController {
    private final BetFacade betFacade;

    @PostMapping
    public BetInfoDtoInOut addBetToBetList(@RequestBody BetInfoDtoInOut betInfoDto) {
        return betFacade.addBetToBetList(betFacade.addBetToBetList(betInfoDto));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBetFromBetList(@PathVariable Long id) {
        betFacade.deleteBetFromBetList(id);
    }
}
