package my.betservice.controller.user;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.odd.OddInfoDtoOut;
import my.betservice.exception.ClientFetchException;
import my.betservice.facade.OddFacade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/odds")
@RequiredArgsConstructor
public class OddController {
    private final OddFacade oddFacade;

    @GetMapping(value = "/{fixtureId}")
    public OddInfoDtoOut getOddInfoByFixtureAndBetId(@PathVariable Integer fixtureId,
                                                     @RequestParam Integer betId)
            throws ClientFetchException {
        return oddFacade.getOddInfoByFixtureAndBetId(fixtureId, betId);
    }
}
