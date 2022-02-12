package my.betservice.facade;

import lombok.RequiredArgsConstructor;
import my.betservice.client.FootballClient;
import my.betservice.dto.odd.OddInfoDtoOut;
import my.betservice.exception.ClientFetchException;
import my.betservice.mapper.odd.OddInfoMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OddFacade {
    private final FootballClient footballClient;

    public OddInfoDtoOut getOddInfoByFixture(final Integer fixtureId)
            throws ClientFetchException {
        return OddInfoMapper.mapToOutDto(footballClient.getOddInfoByFixture(fixtureId));
    }
}
