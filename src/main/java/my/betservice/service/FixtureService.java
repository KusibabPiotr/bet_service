package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.fixture.FixtureInfo;
import my.betservice.repository.FixtureInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FixtureService {
    private final FixtureInfoRepository fixtureInfoRepository;

    public List<FixtureInfo> saveNewFixturesInfo(final List<FixtureInfo> fixtureInfo) {
        fixtureInfo.forEach(fixtureInfoRepository::save);
        return fixtureInfo;
    }

    public List<FixtureInfo> getAvailableFixturesInfo() {
        return fixtureInfoRepository.findAll();
    }

    public Optional<FixtureInfo> getFixtureInfoById(final Long id) {
        return fixtureInfoRepository.findById(id);
    }
}
