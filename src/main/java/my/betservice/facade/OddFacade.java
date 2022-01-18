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

    public OddInfoDtoOut getOddInfoByFixtureAndBetId(final Integer fixtureId,
                                                     final Integer betId)
            throws ClientFetchException {
        return OddInfoMapper.mapToOutDto(footballClient.getOddInfoByFixtureAndBetId(fixtureId, betId));
    }
}
