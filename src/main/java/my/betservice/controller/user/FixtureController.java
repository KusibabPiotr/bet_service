package my.betservice.controller.user;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.fixture.FixtureInfoDtoOut;
import my.betservice.exception.FixtureNotFoundException;
import my.betservice.facade.FixtureFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/fixtures")
@RequiredArgsConstructor
public class FixtureController {
    private final FixtureFacade fixtureFacade;

//    @GetMapping
//    public List<FixtureInfoDtoOut> getAvailableFixturesInfo() {
//        return fixtureFacade.getAvailableFixturesInfo();
//    }

    @GetMapping
    public List<FixtureInfoDtoOut> getAvailableFixturesInfoByLeagueId(@RequestParam(defaultValue = "39") Integer leagueId,
                                                                      @RequestParam(defaultValue = "true") Boolean allMatches) {
        return fixtureFacade.getAvailableFixturesInfoByLeagueId(leagueId, allMatches);
    }

    @GetMapping(value = "/{id}")
    public FixtureInfoDtoOut getFixtureInfoById(@PathVariable Long id)
    throws FixtureNotFoundException {
        return fixtureFacade.getFixtureInfoById(id);
    }
}
