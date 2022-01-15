package my.betservice.controller.admin;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.fixture.FixtureInfoDto;
import my.betservice.facade.FixtureFacade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/fetch/fixtures")
@RequiredArgsConstructor
public class NewFixtureController {
    private final FixtureFacade fixtureFacade;

    @GetMapping(value = "/{id}")
    public FixtureInfoDto fetchNewFixtureToApp(@PathVariable Long id,
                                               @RequestParam Integer season ) {
        return fixtureFacade.fetchNewFixtureToApp(id, season);
    }
}
