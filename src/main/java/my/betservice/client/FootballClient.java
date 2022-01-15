package my.betservice.client;

import lombok.extern.slf4j.Slf4j;
import my.betservice.dto.fixture.FixtureInfoDto;
import my.betservice.dto.fixture.FixtureInfoPackageDto;
import my.betservice.dto.league.LeagueInfoDto;
import my.betservice.dto.league.LeagueInfoPackageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

@Component
@Slf4j
public class FootballClient {

    private static final String HOST_NAME = "x-rapidapi-host";
    private static final String KEY_NAME = "x-rapidapi-key";
    @Autowired
    private RestTemplate restTemplate;
    @Value("${football.api.key}")
    private String apiKeyValue;
    @Value("${football.api.endpoint}")
    private String apiEndpointValue;
    @Value("${football.api.host}")
    private String apiHostValue;

    public LeagueInfoDto getLeagueInfo(final Long leagueId) {
        HttpEntity request = setHeaders();

        ResponseEntity<LeagueInfoPackageDto> response = restTemplate.exchange(
                apiEndpointValue + "leagues?id=" + leagueId,
                HttpMethod.GET,
                request,
                LeagueInfoPackageDto.class);

        try {
            return Optional.ofNullable(Objects.requireNonNull(response.getBody())
                    .getLeagueInfoDto()[0]).orElseGet(LeagueInfoDto::new);
        } catch (RestClientException e) {
            log.warn(e.getMessage(),e);
            return new LeagueInfoDto();
        }
    }

    public FixtureInfoDto getFixtureInfo(final Long leagueId,
                                         final Integer season) {
        HttpEntity request = setHeaders();

        URI uri = UriComponentsBuilder.fromHttpUrl(apiEndpointValue + "league")
                .queryParam("league", leagueId)
                .queryParam("season", season)
                .build().encode().toUri();

        ResponseEntity<FixtureInfoPackageDto> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                FixtureInfoPackageDto.class);

        try {
            return Optional.ofNullable(Objects.requireNonNull(response.getBody())
                    .getFixtureInfoDto()[0]).orElseGet(FixtureInfoDto::new);
        } catch (RestClientException e) {
            log.warn(e.getMessage(),e);
            return new FixtureInfoDto();
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
