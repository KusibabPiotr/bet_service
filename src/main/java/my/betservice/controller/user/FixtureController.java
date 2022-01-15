package my.betservice.controller.user;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.fixture.FixtureInfoDto;
import my.betservice.exception.FixtureNotFoundException;
import my.betservice.facade.FixtureFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/fixtures")
@RequiredArgsConstructor
public class FixtureController {
    private final FixtureFacade fixtureFacade;

    @GetMapping
    public List<FixtureInfoDto> getAvailableFixturesInfo() {
        return fixtureFacade.getAvailableFixturesInfo();
    }

    @GetMapping(value = "/{id}")
    public FixtureInfoDto getFixtureInfoById(@PathVariable Long id)
    throws FixtureNotFoundException {
        return fixtureFacade.getFixtureInfoById(id);
    }
}
