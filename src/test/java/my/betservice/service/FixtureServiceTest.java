package my.betservice.service;

import my.betservice.domain.fixture.FixtureInfo;
import my.betservice.repository.FixtureInfoRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class FixtureServiceTest {
    @InjectMocks
    private FixtureService fixtureService;
    @Mock
    private FixtureInfoRepository fixtureInfoRepository;
    @Nested
    class TestSaveNewFixturesInfo {
        @Test
        void shouldReturnListOfSavedFixturesInfo() {
            //given
            FixtureInfo f1 = FixtureInfo.builder()
                    .leagueId(39)
                    .fixtureId(123)
                    .build();
            List<FixtureInfo> list = List.of(f1);
            given(fixtureInfoRepository.save(f1))
                    .willReturn(f1);
            //when
            List<FixtureInfo> fixtureInfos = fixtureService.saveNewFixturesInfo(list);
            //then
            assertThat(fixtureInfos.size())
                    .isEqualTo(1);
            assertThat(fixtureInfos.get(0).getLeagueId())
                    .isEqualTo(39);
            assertThat(fixtureInfos.get(0).getFixtureId())
                    .isEqualTo(123);
        }
    }
}