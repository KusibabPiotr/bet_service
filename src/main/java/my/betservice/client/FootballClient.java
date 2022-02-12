package my.betservice.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.betservice.dto.fixture.FixtureInfoDtoIn;
import my.betservice.dto.fixture.FixtureInfoPackageDtoIn;
import my.betservice.dto.league.LeagueInfoDtoIn;
import my.betservice.dto.league.LeagueInfoPackageDtoIn;
import my.betservice.dto.odd.OddInfoDtoIn;
import my.betservice.dto.odd.OddInfoPackageDtoIn;
import my.betservice.exception.ClientFetchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.time.LocalDate;
import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class FootballClient {
    private static final String HOST_NAME = "x-rapidapi-host";
    private static final String KEY_NAME = "x-rapidapi-key";
    private static final Integer WIN_MATCH_BET = 1;
    @Value("${bookmaker_bet365}")
    private Integer bookmakerBet365;
    @Value("${football.api.key}")
    private String apiKeyValue;
    @Value("${football.api.endpoint}")
    private String apiEndpointValue;
    @Value("${football.api.host}")
    private String apiHostValue;
    @Value("${premier_league_id}")
    private Long premierLeagueId;
    @Value("${actual_season}")
    private Integer actualSeason;
    private final RestTemplate restTemplate;


    public LeagueInfoDtoIn getLeagueInfo(final Long leagueId)
            throws ClientFetchException {
        HttpEntity request = setHeaders();

        try {
            ResponseEntity<LeagueInfoPackageDtoIn> response = restTemplate.exchange(
                    apiEndpointValue + "leagues?id=" + leagueId,
                    HttpMethod.GET,
                    request,
                    LeagueInfoPackageDtoIn.class);
            return Optional.ofNullable(Objects.requireNonNull(response.getBody())
                    .getLeagueInfoDtoIn()[0]).orElseGet(LeagueInfoDtoIn::new);
        } catch (RestClientException e) {
            log.warn(e.getMessage(),e);
            throw new ClientFetchException();
        }
    }

    public List<FixtureInfoDtoIn> getFixtureInfo(final Long leagueId,
                                                 final Integer season) {
        HttpEntity request = setHeaders();

        URI uri = UriComponentsBuilder.fromHttpUrl(apiEndpointValue + "fixtures")
                .queryParam("league", leagueId)
                .queryParam("season", season)
                .build().encode().toUri();

        try {
            ResponseEntity<FixtureInfoPackageDtoIn> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    request,
                    FixtureInfoPackageDtoIn.class);
            return response.getBody().getFixtureInfoDtoIn();
        } catch (RestClientException e) {
            log.warn(e.getMessage(),e);
            return new ArrayList<>();
        }
    }

    public List<FixtureInfoDtoIn> updatePremierLeagueFixturesStatus() {
        HttpEntity request = setHeaders();

        URI uri = UriComponentsBuilder.fromHttpUrl(apiEndpointValue + "fixtures")
                .queryParam("league", premierLeagueId)
                .queryParam("season", actualSeason)
                .queryParam("date", LocalDate.now())
                .build().encode().toUri();

        try {
            ResponseEntity<FixtureInfoPackageDtoIn> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    request,
                    FixtureInfoPackageDtoIn.class);
            return response.getBody().getFixtureInfoDtoIn();
        } catch (RestClientException e) {
            log.warn(e.getMessage(),e);
            return new ArrayList<>();
        }
    }

    public OddInfoDtoIn getOddInfoByFixture(final Integer fixtureId) throws ClientFetchException {
        HttpEntity request = setHeaders();

        URI uri = UriComponentsBuilder.fromHttpUrl(apiEndpointValue + "odds")
                .queryParam("bookmaker", bookmakerBet365)
                .queryParam("fixture", fixtureId)
                .queryParam("bet", WIN_MATCH_BET)
                .build().encode().toUri();

        try {
            ResponseEntity<OddInfoPackageDtoIn> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    request,
                    OddInfoPackageDtoIn.class);
            return response.getBody().getOddInfoDtoIns()[0];
        } catch (RestClientException e) {
            log.warn(e.getMessage(),e);
            throw new ClientFetchException();
        }
    }

    private HttpEntity setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(HOST_NAME,apiHostValue);
        headers.set(KEY_NAME,apiKeyValue);

        return new HttpEntity(headers);
    }
}
