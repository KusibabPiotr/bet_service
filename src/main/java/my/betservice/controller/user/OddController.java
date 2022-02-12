package my.betservice.controller.user;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.odd.OddInfoDtoOut;
import my.betservice.exception.ClientFetchException;
import my.betservice.facade.OddFacade;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/odds")
@RequiredArgsConstructor
public class OddController {
    private final OddFacade oddFacade;

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @GetMapping(value = "/{fixtureId}")
    public OddInfoDtoOut getOddInfoByFixture(@PathVariable Integer fixtureId)
            throws ClientFetchException {
        return oddFacade.getOddInfoByFixture(fixtureId);
    }
}
