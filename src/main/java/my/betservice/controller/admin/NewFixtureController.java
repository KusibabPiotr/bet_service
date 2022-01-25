package my.betservice.controller.admin;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.fixture.FixtureInfoDtoOut;
import my.betservice.facade.FixtureFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fetch/fixtures")
@RequiredArgsConstructor
public class NewFixtureController {
    private final FixtureFacade fixtureFacade;

    @GetMapping(value = "/{leagueId}")
    public List<FixtureInfoDtoOut> fetchNewFixtureToApp(@PathVariable Long leagueId,
                                                        @RequestParam(defaultValue = "2021") Integer season ) {
        return fixtureFacade.fetchNewFixturesToApp(leagueId, season);
    }
}
